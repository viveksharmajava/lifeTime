package generics;

public class GenericsTestMain {

	public static void main(String[] args) {
		Box<Number> integerBox = new Box<>();
        integerBox.set(new Integer(10));
        integerBox.inspect(234l); // error: this is still String!
	}

}
class Box<T> {

    private T t;          

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public <U extends Number> void inspect(U u){
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
    }

}