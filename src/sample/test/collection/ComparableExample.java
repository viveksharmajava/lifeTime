package sample.test.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class ComparableExample {
	public static void main(String[] args) {
		
		ArrayList <Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee(5,"Vivek"));
		employeeList.add(new Employee(4,"tom"));
		employeeList.add(new Employee(2,"Yo Yo"));
		employeeList.add(new Employee(2,"Same"));
		
		System.out.println("Employees before sorting employeeList="+employeeList);
		SortEmployee comparator = new SortEmployee();
		Collections.sort(employeeList ,comparator );
		System.out.println("Employees after  sorting Collections.sort(employeeList) ="+employeeList);
		
		HashSet <Employee>employeeSet = new HashSet<Employee>();
		employeeSet.add(new Employee(5,"Vivek"));
		employeeSet.add(new Employee(4,"tom"));
		Employee e1 = new Employee(2,"Yo Yo");
		System.out.println(" first e1 hascode="+e1.hashCode());
		employeeSet.add(e1);

		e1 = new Employee(2,"Yo Yo");
		System.out.println(" second e1 hascode="+e1.hashCode());
		employeeSet.add(e1);
		//check whether it will overider or skil
		System.out.println("Employees in Employees Set ="+employeeSet);
	}

}

class Employee implements Comparable<Employee>{

	Integer empId;
	String  name;
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Employee(Integer empId, String name) {
		super();
		this.empId = empId;
		this.name = name;
	}



	public Integer getEmpId() {
		return empId;
	}


	public void setEmpId(Integer empId) {
		this.empId = empId;
	}


	@Override
	public int compareTo(Employee o) {
		if(this.getEmpId() != o.getEmpId())
		  {
			return this.empId.compareTo(o.getEmpId());
		  }else{
			  return this.getName().compareTo(o.getName());
		  }
	}


/*	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}*/


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + "]";
	}
	
}

class SortEmployee implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {

		
			// return o1.empId.compareTo(o2.getEmpId());//sort by Id 
		 
			  return o1.getName().compareTo(o2.getName());
	}
	
}