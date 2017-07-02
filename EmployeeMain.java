package Session5Assignment3;

import java.util.Scanner;

public class EmployeeMain {
	
public static void main(String[] args)
	{
			System.out.println("Keyin the type of employee: P for permanent ,T for temporary");
			Scanner s=new Scanner(System.in);
		char type_of_employee =s.next().charAt(0);
		if (type_of_employee == 'P')
		{
			manage_permanent_employee();
		}
		else if(type_of_employee =='T')
			{
			manage_temporary_employee();
			} 
		else{
		System.out.println("Invalid type");}
			}
		
// This method generates ,prints payroll and manages the leave status of a Permanent employee		
public static void manage_permanent_employee()
{
	
	permanent_Employee pe = new permanent_Employee();//creates an employee 
	int i=0;//flag to be set to check in while  condition
	
	// Below do-while loop interacts with user to perform various actions like Payroll generation, Avail leave and printing the leave status
	//Loop will be exited when the user chooses option 4.
	//Each action will be checked  and performed using SWITCH statement.
	do{
		Scanner s=new Scanner(System.in);
		System.out.println("choose the action rqrd type 1 for PayRoll");
		System.out.println("                       type 2 for Avail Leave");
		System.out.println("                       type 3 for display leave details");
		System.out.println("                       type 4 for Exit");
	
	char action_rqrd =s.next().charAt(0);//readin the rqrd action.
	//different case will be choosen based the action type read
	
       switch(action_rqrd)//check for each option and calls the appropriate member functions of the Permanent Employee object
       {
        // Display payroll
    	   case '1': 
       
		        i=1;
    		   pe.calculate_salary();
    		   break;
       
       // Manages leave
    	   case '2':

               i=2;
    		   System.out.println("Readin the no of leave rqrd");
		
    		   int no_of_leave=s.nextInt();
		
    		   System.out.println("Keyin the type of leave : S for Sick leave , P for Paid Leave,C for casual leave");
		
    		   char type_of_leave =s.next().charAt(0);
    		   
    		   	if (pe.avail_leave(no_of_leave,type_of_leave)== true)//Available no of days will be sanctioned.
    		   	{
    		   		pe.calculate_balance_leave();
    		   		
    		   	} 
		
    		   	else{
    		   		System.out.println("sorry , leave couldnot be sanctioned");
    		   	}
    		   	pe.print_leave_details();//Prints the current status of leave
    		   	
    		   	break;
    		   	
       			
       case '3' ://prints the current status of leave
    	   i=3;//flag to be set to check in while  condition
				pe.print_leave_details();
				break; 
				
       case '4' : //exit from the loop option
    	   i =4;
    	   break;
	    default :
	    	System.out.println("Invalid action choosen");
	    	i=0;
			}
	}while((i <= 3));
}


//This method generates ,prints payroll and manages the leave status of a temp employee

public static void manage_temporary_employee()
{
temparory_Employee te = new temparory_Employee();// creates an Employee
int i=0;//options in integer form.
//Below do-while loop interacts with user to perform various actions like Payroll generation, Avail leave and printing the leave status
	//Loop will be exited when the user chooses option 4.
	//Each action will be checked  and performed using SWITCH statement.
do{
	
Scanner s=new Scanner(System.in);
	System.out.println("choose the action rqrd type 1 for PayRoll");
	System.out.println("choose the action rqrd type 2 for Avail Leave");
	System.out.println("choose the action rqrd type 3 for display leave details");
	System.out.println("                       type 4 for Exit");
char action_rqrd =s.next().charAt(0);//reads in the option choosen by the user.

	switch(action_rqrd)//check for each option and calls the appropriate member functions of the Temporary Employee object
	{
	// Display payroll
	   case '1': 

	        i=1;//flag to be set to check in while  condition
		   te.calculate_salary();
		   break;


	   case '2'://Manages leave

        i=2;//flag to be set to check in while  condition
		   System.out.println("Readin the no of days leave rqrd");
	
		   int no_of_leave=s.nextInt();
	       char type_of_leave ='D';//No leave type for temporary Employee
	       if (te.avail_leave(no_of_leave,type_of_leave)== true)
		   	{
		   				  
		   		te.print_leave_details();
		   	}
	
		   	else{
		   		System.out.println("Sorry,Your leave is exahusted");
		   		}
	     break;
	   case '3' ://prints the current status of leave
    	   i=3;//flag to be set to check in while  condition
				te.print_leave_details();
				break; 
				
       case '4' :
    	   i =4;//flag to be set to check in while  condition
    	   break;
	   default :
	    	System.out.println("Invalid action choosen");
	    	i=0;//flag to be set to check in while  condition
	}
  }while((i <= 3));
 }
}
