package Java18.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.base.Predicate;

public class UDStream {
	public static void main(String[] args)
	{
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee("Emp04", 525000));
		
		Employee e2 = new Employee("Emp01", 225000);
		Employee e3 = new Employee("Emp05", 25000);
		Employee e4 = new Employee("Emp02", 155000);
		Employee e5 = new Employee("Emp03", 125000);
		Employee e6 = new Employee("Emp07", 251000);
		Employee e7 = new Employee("Emp06", 225000);
		
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		list.add(e6);
		list.add(e7);
		
		List<Employee> empByName = list.stream().sorted((emp1,emp2) -> emp1.getName().compareTo(emp2.getName())).collect(Collectors.toList());
		empByName.forEach(System.out::println);
		
		System.out.println("Sort by Salary");

		
		List<Employee> empBySalary = list.stream().sorted((emp1,emp2) -> emp1.getSalry().compareTo(emp2.getSalry())).collect(Collectors.toList());
		empBySalary.forEach(System.out::println);
		
		System.out.println("print employee frater salary");
		
		
	}
}
