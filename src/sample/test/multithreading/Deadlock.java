package sample.test.multithreading;

public class Deadlock {
    static class Friend {
        private final String name;
        public Friend(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        public synchronized void welcome(Friend other) {
            System.out.format("%s"
                + "  has Welcomed to : %s!%n", 
                this.name, other.getName());
            other.welcomeBack(this);
        }
        public synchronized void welcomeBack(Friend myself) {
            System.out.format("%s"
                + " has welcomed back to : %s!%n",
                this.name, myself.getName());
        }
    }

    public static void main(String[] args) {
        final Friend alphonse =
            new Friend("Alphonse");
        final Friend gaston =
            new Friend("Gaston");
        new Thread(new Runnable() {
            public void run() { alphonse.welcome(gaston); }
        }).start();
        new Thread(new Runnable() {
            public void run() { gaston.welcome(alphonse); }
        }).start();
    }
}