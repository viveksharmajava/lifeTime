package sample.test.jdbc;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class JdbcExample {

	  public static void main(String args[]) throws Exception
	  {
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ECOMDB", "buy", "buy_123");//jdbc:oracle:thin:@localhost:1521:ECOMDB
	                                           // replace Statement with CallableStatement
	    CallableStatement cst=con.prepareCall("{ ? = call calculate(?,?) }");

	    cst.registerOutParameter(1, Types.INTEGER);     
	                                           // return type also must be registered
	    cst.registerOutParameter(3, Types.INTEGER);      
	                                           // OUT parameter
	    cst.setInt(2, 10);                     // IN parameter

	    cst.execute();

	    int k = cst.getInt(1);                 // retrieving return value
	    int m = cst.getInt(3);                 // retrieving OUT parameter value

	    System.out.println("The return value is " + k);
	    System.out.println("The out value is " + m);

	    cst.close();
	    con.close();
	  }
}
