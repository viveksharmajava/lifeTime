package sample.test.fundamental;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import com.sun.javafx.util.Logging;

public class ClassLoadersTest {

	public static void main(String[] args) {

		System.out.println("Classloader of this class:"
		        + ClassLoadersTest.class.getClassLoader());

		    System.out.println("Classloader of Logging:"
		        + Logging.class.getClassLoader());

		    System.out.println("Classloader of ArrayList:"
		        + ArrayList.class.getClassLoader()); 
	}

}

 class CustomClassLoader extends ClassLoader {


    @Override
    public Class findClass(String name) throws ClassNotFoundException {
        byte[] b = loadClassFromFile(name);
        return defineClass(name, b, 0, b.length);
    }

    private byte[] loadClassFromFile(String fileName)  {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(
                fileName.replace('.', File.separatorChar) + ".class");
        byte[] buffer;
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        int nextValue = 0;
        try {
            while ( (nextValue = inputStream.read()) != -1 ) {
                byteStream.write(nextValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        buffer = byteStream.toByteArray();
        return buffer;
    }
}
