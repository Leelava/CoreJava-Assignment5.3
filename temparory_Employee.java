package Session5Assignment3;

import java.util.Scanner;

//The temporary employee is also inherited from employee class with specific properties like hourly wages .

public class temparory_Employee extends Employee{
 double hourly_wages; // Salary is based on the hourly wages
	
//Constructor reads in and populates both parent class fields like employee id, name  , total_leaves and
 //subclass fields hourly_wages.Based on this it calculates the total salary
 
 public temparory_Employee() {
		Scanner s=new Scanner(System.in);
		
		System.out.println("Readin the empid");
		
		this.empid=s.nextInt();
		
		System.out.println("Readin the empname");
		
		this.empname=s.next();
		
		System.out.println("Readin hourly wages");//Fix the hourlyWages
		
		double hourly_Wages= s.nextDouble();
		
		System.out.println("Readin the total leaves");
		
		this.total_leaves =s.nextInt();// there is no PL,CL and SL for temporary employee . It is only consolidated number of days/
		
		this.total_salary = hourly_Wages *30 *8; //Total salary is the product of Hourlywages, 8 hours and 30 days.
		
		
		// TODO Auto-generated constructor stub
	}

	@Override
	void calculate_balance_leave() {
		// No action is required for temporary employee as there are no PL,CL,SL
		System.out.println();
		
	}

	// Returns true if the requested number of leave is available else  returns false. Updates the total_leaves.
	@Override
	boolean avail_leave(int no_of_leave, char type_of_leave) {
		
		
		if (no_of_leave <=this.total_leaves)
		{
			this.total_leaves = this.total_leaves - no_of_leave;//update the balance leave if requested  number of available
			System.out.println("The requested no of days leave has been sanctioned" );
			return true;
		}
		if (this.total_leaves !=0)
		{
		
			System.out.println(" The leave available is " +this.total_leaves + " Same has been sanctioned");
			this.total_leaves =0;
			return true;
		}
		return false;
	}

	
	// As the salary calculation happens in the constructor, this method displays the payroll of an employee
	@Override
	void calculate_salary() {
		System.out.println("The Employee details are as follows " );
		System.out.println("The Employee-id : " +this.empid);
		System.out.println("The Employee-name : " +this.empname);
		System.out.println("The Employee pay roll is " );
		System.out.println("Total salary is "+this.total_salary);
		System.out.println("Total leave is "+this.total_leaves);
		
		
		
	}
	
	//Displays the leave status with Employee details
	void print_leave_details(){
	
	System.out.println("The current leave details are as follows " );
	System.out.println("The Employee-id    : " +this.empid);
	System.out.println("The Employee-name  : " +this.empname);
	System.out.println("Total leave is "+this.total_leaves);
	}
}
