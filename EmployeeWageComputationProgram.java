class WageCalculation
{
	//CONSTANTS
	static final int IS_PRESENT = 1;
	static final int IS_FULL_TIME = 1;

	//method to store company details
	public static void company()
	{
		wageCalculator ("company1", 20, 20, 100);
		wageCalculator ("company2", 10, 30, 110);
		wageCalculator ("company3", 15, 10, 120);
		wageCalculator ("company4", 30, 25, 130);
		wageCalculator ("company5", 50, 15, 140);
	}

	//WAGE CALCULATOR
	public static void wageCalculator(String company, int wage_per_hr, int working_days_per_month, int max_working_hrs)
	{
		//VARIABLES
		int checkPresence;
		int checkEmpType;
		//int empDailyWage = 0; //Used if uncomment the commented code-lines
		int dayOfMonth = 0;
		int totalWage = 0;
		int workingHrs = 0;
		int totalWorkedHrs = 0;

		//Wage calculation
		while (dayOfMonth <= working_days_per_month && totalWorkedHrs <= max_working_hrs)
		{
			checkPresence = (int) (Math.random()*10)%2; //Presence check
			checkEmpType = (int) (Math.random()*10)%2;  //Work Type check
			dayOfMonth++;
			switch (checkPresence)
			{
				case IS_PRESENT:
					switch (checkEmpType)
					{
						case IS_FULL_TIME:
							workingHrs = 8;
							totalWorkedHrs += workingHrs;
							break;
						default:
							workingHrs = 4;
							totalWorkedHrs += workingHrs;
					}
					break;
				default:
					totalWorkedHrs += 0;
			}
			/*//can show the daily wage
			 * empDailyWage = wage_per_hr * workingHrs;
			 * System.out.println("Daily wage of employee: "+empDailyWage);
			 */
			totalWage = (wage_per_hr * totalWorkedHrs);
			/* //can show wage until the current day
			 * if(dayOfMonth <= working_days_per_month)
			 * System.out.println("till the day "+dayOfMonth+" : "+totalWage);
			 */
		}
		System.out.println("Employee Monthly Wage: "+totalWage);
	}
}

//MAIN CLASS
public class EmployeeWageComputationProgram
{
	public static void main(String[] args)
	{
		//calling static method
		WageCalculation.company();
	}
}
