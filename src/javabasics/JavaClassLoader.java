package javabasics;

import java.sql.DriverManager;
import java.util.ArrayList;

public class JavaClassLoader {

	public static void main(String[] args) throws ClassNotFoundException {
		printClassLoaders();
	}
	public static void printClassLoaders() throws ClassNotFoundException {

	    System.out.println("Classloader of this class:"
	        + JavaClassLoader.class.getClassLoader());

	    System.out.println("Classloader of DriverManager:"
	        + DriverManager.class.getClassLoader());

	    System.out.println("Classloader of ArrayList:"
	        + ArrayList.class.getClassLoader());
	}
}
