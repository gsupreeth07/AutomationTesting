package Java18.Stream;

public class Employee {;

	
String name;
int salary;
public Employee(String name, int salary)
{
	this.name = name;
	this.salary = salary;
}
public String getName()
{
	return name;
}
public void setName(String name)
{
	this.name = name;
}
public Integer getSalry()
{
	return salary;
}
public void setSalry(int salry)
{
	this.salary = salry;
}

@Override
public String toString()
{
	// TODO Auto-generated method stub
	return "Employee Name " + this.name + " and Salary " + this.salary;
}

}
