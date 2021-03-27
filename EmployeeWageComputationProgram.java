//main class
public class EmployeeWageComputationProgram
{
	public static void main(String[] args)
	{
		//CONSTANTS
		final int IS_PRESENT = 1;

		//CHECKING EMPLOYEE PRESENCE
		int checkPresence = (int) (Math.random()*10)%2;
		if(checkPresence == IS_PRESENT)
		{
			System.out.println("Present");
		}
		else
		{
			System.out.println("Absent!");
		}

	}
}
