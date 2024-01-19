package javabasics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationExamaple {

	public static void main(String[] args) throws Exception {
     
	 FileOutputStream fs = new FileOutputStream("serieal.txt");
	 ObjectOutputStream os = new ObjectOutputStream(fs);
	 Person p = new Person(35, "Vivek");
	 os.writeObject(p);
	 os.flush();
	 os.close();
	 System.out.println("deserialization ");
	 FileInputStream fis = new FileInputStream("serieal.txt");
	 ObjectInputStream ois = new ObjectInputStream(fis);
	 Person pRead = (Person) ois.readObject();
	 System.out.println(pRead);
	}

}


class Person implements Serializable {
	
	 private int age;
	 private String name;
	 Person(){
		 
	 }
	 Person(int a , String s){
		 this.age = a;
		 this.name = s;
		 System.out.println("constructor called");
	 }
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
		 System.out.println("setAge called");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		 System.out.println("setName called");
	}
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	
	 
}