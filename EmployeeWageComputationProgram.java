class WageCalculation
{
	// CONSTANTS
	public final int IS_PRESENT = 1;
	public final int IS_FULL_TIME = 1;

	// VARIABLES
	private final String company;
	private final int wage_per_hr;
	private final int working_days_per_month;
	private final int max_working_hrs;

	public WageCalculation(String company, int wage_per_hr, int working_days_per_month, int max_working_hrs)
	{
		this.company = company;
		this.wage_per_hr = wage_per_hr;
		this.working_days_per_month = working_days_per_month;
		this.max_working_hrs = max_working_hrs;
	}

	//method to store company details
	public static int[] company()	/* Made this method static so that when the method called, we don't need to pass parameters*/
	{
		//company details sending to the constructor
		WageCalculation wc1 = new WageCalculation("company1", 20, 20, 100);
		WageCalculation wc2 = new WageCalculation("company2", 10, 30, 110);
		WageCalculation wc3 = new WageCalculation("company3", 15, 10, 120);
		WageCalculation wc4 = new WageCalculation("company4", 30, 25, 130);
		WageCalculation wc5 = new WageCalculation("company5", 50, 15, 140);

		int[] totalWageofDiffEmp = new int[5];
		totalWageofDiffEmp[0] = wc1.wageCalculator(); //storing the values returned
		totalWageofDiffEmp[1] = wc2.wageCalculator();
		totalWageofDiffEmp[2] = wc3.wageCalculator();
		totalWageofDiffEmp[3] = wc4.wageCalculator();
		totalWageofDiffEmp[4] = wc5.wageCalculator();

		return totalWageofDiffEmp;
	}


	// WAGE CALCULATOR
	public int wageCalculator() {
		// VARIABLES
		int checkPresence;
		int checkEmpType;
		// int empDailyWage = 0; //Used if uncomment the commented code-lines
		int dayOfMonth = 0;
		int totalWage = 0;
		int workingHrs = 0;
		int totalWorkedHrs = 0;

		// Wage calculation
		while (dayOfMonth <= working_days_per_month && totalWorkedHrs <= max_working_hrs) {
			checkPresence = (int) (Math.random() * 10) % 2; // Presence check
			checkEmpType = (int) (Math.random() * 10) % 2; // Work Type check
			dayOfMonth++;
			switch (checkPresence) {
			case IS_PRESENT:
				switch (checkEmpType) {
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
			/*
			 * //can show the daily wage empDailyWage = wage_per_hr * workingHrs;
			 * System.out.println("Daily wage of employee: "+empDailyWage);
			 */
			totalWage = (wage_per_hr * totalWorkedHrs);
			/*
			 * //can show wage until the current day if(dayOfMonth <=
			 * working_days_per_month)
			 * System.out.println("till the day "+dayOfMonth+" : "+totalWage);
			 */
		}
		return totalWage;
	}
}

//MAIN CLASS
public class EmployeeWageComputationProgram
{
	public static void main(String[] args)
	{
		// calling instance methods and storing wages of employees in the array
		int[] employeeWages = new int[5]; // declaring array
		employeeWages = WageCalculation.company();

		// printing employee wages stored in the array
		for(int i = 0; i < employeeWages.length; i++)
		{
			System.out.println("Employee monthly wage of company_" + (i + 1) + ": " +employeeWages[i]);
		}
	}
}
