package Session5Assignment3;

import java.util.Scanner;

// Permanent employee class inherited from Employee class exhibits specific properties like all the types of leave (SL,PL,CL)and 
//the well defined salary related properties(HRA,BASIC and PFA)
public class permanent_Employee extends Employee{
	
	
	int paid_leave, sick_leave, casual_leave;//  The status of sick leave, paid leave and casual leave 
	double basic, hra,pfa;//basic salary, HRA and PF.
	
	
	// Constructor reads in and populates both parent class fields like employee id, name  and the subclass fields like basic salary.
	//Calculates the HRA and PF using the basic salary
	//Initializes the PL,SL,CL
	// calculates and populates total salary and total leave of a permanent employee
	public permanent_Employee()
	{
		
		Scanner s=new Scanner(System.in);
		
		System.out.println("Readin the empid");
		
		this.empid=s.nextInt();
		
		System.out.println("Readin the empname");
		
		this.empname=s.next();
		
		System.out.println("Readin the basic salary");
		
		this.basic= s.nextDouble();
		
		this.hra = (double)(50*basic)/100.0;// HRA calculation
		
		this.pfa = (double)(12*basic)/100.0;//PF to be deducted
		
		this.total_salary = this.basic + this.hra-this.pfa;// total salary
		
		this.paid_leave = 10;// Initial PL
		
		this.casual_leave =11;//Initial CL
		
		this.sick_leave=10;//Initial SL
		
		this.total_leaves= 31;// Total leave
				
	}
	// calculates the leave balance
	@Override
	void calculate_balance_leave()
	{
		this.total_leaves = this.paid_leave + this.sick_leave + this.casual_leave;//total leave at any point of time is sum of the PL,SL and CL
	
	}
	
	//checks the leave availability based on the type of leave. Returns true if the available leave(Pl,CL,SL) is not zero else returns false
	@Override
	boolean avail_leave(int no_of_leave, char type_of_leave) 
	{
		if (type_of_leave == 'P')
		{
				if(no_of_leave <=this.paid_leave) // if rqrd number of PL is available , then reduce the PL , return true
				{
					this.paid_leave = this.paid_leave-no_of_leave;
					System.out.println("The requested no of PL has been sanctioned" );
					return true;
				}
				else if (this.paid_leave != 0)// If the available PL is less than rqrd no of leave then balance paid leave becomes 0.Returns true.
				{
					
					System.out.println("The available PL is only " +this.paid_leave +" .Sanctioned the same " );
					
					this.paid_leave = 0;
					
					return true;
				}else
				{
					System.out.println(" Your PL is exhasuted");
				 return false;
				}
					
				
			}
		else if (type_of_leave == 'C')
		{
			if (no_of_leave <=this.casual_leave)// if rqrd number of CL is available , then reduce the CL by rqrd number of leave , return true
       		{
				this.casual_leave = this.casual_leave-no_of_leave;
				System.out.println("The requested no of CL has been sanctioned" );
				return true;
       		}
			else if (this.casual_leave != 0)// If the available CL is less than rqrd no of leave then balance casual leave becomes 0
			{
				
				System.out.println("The available CL is only " +this.casual_leave +" .Sanctioned the same " );
				
				this.casual_leave = 0;
				
				return true;
			}
			else
			{
				System.out.println(" Your CL is exhasuted");
				return false;
			}
				
		}
		else if (type_of_leave == 'S')
		{
			if(no_of_leave <= this.sick_leave)// if rqrd number of SL is available , then reduce the SL by rqrd number of leave , return true
       			{
    	   			this.sick_leave = this.sick_leave-no_of_leave;
    	   			System.out.println("The requested no of SL has been sanctioned" );
    	   			return true;
       			}
		    else if (this.sick_leave != 0)// If the available SL is less than rqrd no of leave then balance paid leave becomes 0
				{
				
				System.out.println("The available SL is only " +this.sick_leave +" .Sanctioned the same " );
				this.sick_leave = 0;
				return true;
				}
				else{
					System.out.println(" Your SL is exhasuted");
					return false;
					}
		}
       return false;
	}
	
	// As the salary calculation happens in the constructor, this method displays the payroll of an employee
	@Override
	void calculate_salary() {
		// the salary is calculated at the time of constructing the employee object itself.
		System.out.println("The Employee details are as follows " );
		System.out.println("The Employee-id : " +this.empid);
		System.out.println("The Employee-name : " +this.empname);
		System.out.println("The Employee pay roll is " );
		System.out.println(" Basic  : " +this.basic);
		System.out.println(" HRA : " +this.hra);
		System.out.println(" PFA: " +this.pfa);
		System.out.println(" HRA : " +this.hra);
		System.out.println(" Total Salary: " +this.total_salary);
		System.out.println("Total leaves :  " +this.total_leaves );
  
	}
	
	//Displays the leave status with Employee details
	void print_leave_details()
	{
		System.out.println("The updated leave details are as follows " );
		System.out.println("The Employee-id    : " +this.empid);
		System.out.println("The Employee-name  : " +this.empname);
		System.out.println("No of Paidleaves   : " +this.paid_leave );
		System.out.println("No of casual leaves: " +this.casual_leave );
		System.out.println("No of Sick leaves  : " +this.sick_leave );
		System.out.println("No of Total leaves : " +this.total_leaves );
	}

}
