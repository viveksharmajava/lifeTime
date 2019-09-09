package sample.test.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectInputValidation;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class SerializableTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		FileOutputStream fos = new FileOutputStream("/Users/viveksharma/Documents/vivek/serailize.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        A a  = new A();
        a.x= 50;
        a.cobj.m = 45;
        a.name ="Andy";
        System.out.println(" value before persisting x="+a.x +"\t  y="+a.y+"\t z ="+a.z+"\t name="+a.name+"\t c value="+a.cobj.m);
         oos.writeObject(a);
        //a  = new A();
      //  a.x = 30;
      //  a.y = 30;
     //   a.z = 30;
      //  oos.writeObject(a);
     // oos.writeBytes(a.name);
       /* oos.writeInt(a.x);
        oos.writeInt(a.z);
     
        oos.writeInt(a.y);*/
        oos.close();
        
        FileInputStream fis = new FileInputStream("/Users/viveksharma/Documents/vivek/serailize.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        String s = "";
        Integer x ;
        Integer z ;
        Integer y;
       /* while(ois.available()> 0){
        	x = ois.readInt();
        	z = ois.readInt();
        	y = ois.readInt();
        	System.out.println(" value after de-serialization x ="+x+"\t y="+y+"\t z="+z);
        }*/
        //while((a = (A) ois.readObject()) !=null){
        	A b = (A) ois.readObject();
        	System.out.println(" value after de-serialization x ="+b.x+"\t y="+b.y+"\t z="+b.z+"\t name="+b.name+"\t c value="+b.cobj.m);
      //  }
        
        ois.close();
	}

}

class B {
	int z =12 ;
	B(){
		z = 100;
		System.out.println(" B Constructor get called z="+z);
	}
	B(int zz){
		z = zz;
	}
}
class Cat{
public	int m = 10;
public void setM(int s){
	m = s;
}
}
class A  extends B implements Serializable,ObjectInputValidation{
	private static final long serialVersionUID = 47L;
	final transient int y = 10;
	int x = 30;
	transient Cat cobj = new Cat(); 
	
	String name ="vivek";
	A(){
		super(300);
		System.out.println("A Constructor get called");
		x = 4;
	}
	
	A(String name , int m){
		super(100);
		x = m;
		this.name = name;
		
	}
	
	private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(this.z);
        out.writeInt(cobj.m);
    }
    private void readObject(ObjectInputStream in) throws IOException,ClassNotFoundException {
        in.defaultReadObject();
        System.out.println("before registerValidation");
        in.registerValidation(this, 0);
        this.z = in.readInt();
        this.cobj = new Cat();
        this.cobj.m = in.readInt();
    }
    Object writeReplace() throws ObjectStreamException{
    	System.out.println("writeReplace called !!!");
    	return this;
    	
    }
    //https://docs.oracle.com/javase/8/docs/technotes/guides/serialization/examples/symbol/index3.html
    Object readResolve() throws ObjectStreamException{
    	System.out.println("readResolve called !!!");
    	return this;
    	
    }

	@Override
	public void validateObject() throws InvalidObjectException {
		System.out.println(" In validateObject !!!");
	}
}