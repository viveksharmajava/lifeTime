package sample.test.designPatterns.creational.prototype;

import java.util.List;

import sample.test.designPatterns.model.Employees;

public class PrototypePatternTest {

	public static void main(String[] args) throws CloneNotSupportedException {

		 Employees emp = new Employees();
		 emp.loadData();
		 
		 Employees new1 = (Employees) emp.clone();
		 Employees new2 = (Employees) emp.clone();
		 
		 List<String> list = new1.getEmpList();
		 list.add("Vivek");
		 
		 List <String> list2 = new2.getEmpList();
		 list2.remove("David");
		 
		 System.out.println("emp list"+emp.getEmpList());
		 System.out.println("new1 employess="+new1.getEmpList());
		 System.out.println("new2 employess="+new2.getEmpList());
			
	}

}
