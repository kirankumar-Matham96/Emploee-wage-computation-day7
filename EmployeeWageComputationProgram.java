//main class
public class EmployeeWageComputationProgram
{
	public static void main(String[] args)
	{
//CONSTANTS
		final int IS_PRESENT = 1;
		final int IS_FULL_TIME = 1;
		final int WAGE_PER_HR = 20;
		final int FULL_TIME_WORKING_HRS = 8;
		final int PART_TIME_WORKING_HRS = 4;
		final int WORKING_DAYS_PER_MONTH = 20;

		//VARIABLES
		int checkPresence;
		int checkEmpType;
		int empWage = 0;
		int dayOfMonth = 0;
		int totalWage = 0;

		while (dayOfMonth <= WORKING_DAYS_PER_MONTH)
		{
			checkPresence = (int) (Math.random()*10)%2;
			checkEmpType = (int) (Math.random()*10)%2;
			dayOfMonth++;
			switch (checkPresence)
			{
				case IS_PRESENT:
					switch (checkEmpType)
					{
					case IS_FULL_TIME:
						empWage = WAGE_PER_HR * FULL_TIME_WORKING_HRS;
						break;
					default:
						empWage = WAGE_PER_HR * PART_TIME_WORKING_HRS;
					}
					break;
				default:
				empWage= 0;
			}
			totalWage += empWage;
		}
		System.out.println("Employee Monthly Wage: "+totalWage);
	}
}
