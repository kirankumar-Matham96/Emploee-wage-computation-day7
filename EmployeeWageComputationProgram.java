//main class
public class EmployeeWageComputationProgram
{
	public static void main(String[] args)
	{
		//CONSTANTS
		final int IS_PRESENT = 1;
		final int WAGE_PER_HR = 20;
		final int WORKING_HRS = 8;
		int checkPresence;
		int empWage = 0;

		//CHECKING EMPLOYEE PRESENCE
		checkPresence = (int) (Math.random()*10)%2;
		if(checkPresence == IS_PRESENT)
		{
			empWage = WAGE_PER_HR * WORKING_HRS;
		}
		else
		{
			System.out.println("Absent!");
		}
		System.out.println("Employee Wage: "+empWage);
	}
}
