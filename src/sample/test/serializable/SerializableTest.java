package sample.test.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		FileOutputStream fos = new FileOutputStream("D:\\serializedObjects.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        A a  = new A();
        System.out.println(" value before persistiong x="+a.x +"\t  y="+a.y+"\t z ="+a.z);
      //  oos.writeObject(a);
        //a  = new A();
      //  a.x = 30;
      //  a.y = 30;
     //   a.z = 30;
      //  oos.writeObject(a);
     // oos.writeBytes(a.name);
        oos.writeInt(a.x);
        oos.writeInt(a.z);
     
       oos.writeInt(a.y);
        oos.close();
        
        FileInputStream fis = new FileInputStream("D:\\serializedObjects.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        String s = "";
        Integer x ;
        Integer z ;
        Integer y;
        while(ois.available()> 0){
        	x = ois.readInt();
        	z = ois.readInt();
        	y = ois.readInt();
        	System.out.println(" value after de-serialization x ="+x+"\t y="+y+"\t z="+z);
        }
        ois.close();
	}

}

class B {
	
	int z ;
	B(){
		z = 100;
		System.out.println(" B Constructor get called");
	}
}

class A  extends B implements Serializable{
	final transient int y = 10;
	int x = 30;
	String name ="vivek";
	A(){
		System.out.println("Constructor get called");
		x = 4;
	}
	
	A(String name , int m){
		x = m;
		this.name = name;
		
	}
}