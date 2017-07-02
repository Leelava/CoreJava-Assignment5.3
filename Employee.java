package Session5Assignment3;

// Employee can be permanent or temporary. But both the types have common properties like id, name no of leaves and salary.So employee is the 
//parent class with  abstract functions like salary calculation and balance leave calculation.
public abstract class Employee {
	
	int empid;//Employee id.
	String empname;// Name of the employee
	int total_leaves;//Total number of leaves
	double total_salary;//total salary
	
	
	abstract void calculate_balance_leave();
	abstract boolean avail_leave(int no_of_leave,char type_of_leave);
	abstract void calculate_salary();
	

}
