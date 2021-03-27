class WageCalculation
{
	//CONSTANTS
	final int IS_PRESENT = 1;
	final int IS_FULL_TIME = 1;
	final int WAGE_PER_HR = 20;
	final int WORKING_DAYS_PER_MONTH = 20;
	final int MAX_WORKING_HRS = 100;

	//WAGE CALCULATOR
	public void wageCalculator()
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
		while (dayOfMonth <= WORKING_DAYS_PER_MONTH && totalWorkedHrs <= MAX_WORKING_HRS)
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
			 * empDailyWage = WAGE_PER_HR * workingHrs;
			 * System.out.println("Daily wage of employee: "+empDailyWage);
			 */
			totalWage = (WAGE_PER_HR * totalWorkedHrs);
			/* //can show wage until the current day
			 * if(dayOfMonth <= WORKING_DAYS_PER_MONTH)
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
		//object creation and invoking the WAGE CALCULATOR constructor
		WageCalculation wc = new WageCalculation();
		wc.wageCalculator();
	}
}
