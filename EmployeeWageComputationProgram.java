//Used Array List
import java.util.ArrayList;

//interface
interface EmployeeWage
{
	public void company(String company, int wage_per_hr, int working_days_per_month, int max_working_hrs);
	public int wageCalculator(CompanyInfo cI);
}

class CompanyInfo
{
	// VARIABLES
	public final String company;
	public final int wage_per_hr;
	public final int working_days_per_month;
	public final int max_working_hrs;
	public int totalWage = 0;

	public CompanyInfo(String company, int wage_per_hr, int working_days_per_month, int max_working_hrs)
	{
		this.company = company;
		this.wage_per_hr = wage_per_hr;
		this.working_days_per_month = working_days_per_month;
		this.max_working_hrs = max_working_hrs;
	}

	public void setTotalWage(int totalWage)
	{
		this.totalWage = totalWage;
	}

	public String toString()
	{
		return "total wage is: "+totalWage;
	}
}

//MAIN CLASS
public class EmployeeWageComputationProgram implements EmployeeWage
{
	// CONSTANTS
	public final int IS_PRESENT = 1;
	public final int IS_FULL_TIME = 1;

	ArrayList<CompanyInfo> totalWageofDiffEmp = new ArrayList<CompanyInfo>();;

	//Object for Company Info method
	CompanyInfo wcc;

		//method to store company employee wage details
		/*
		* Made this method static so that when the method called, we don't need to pass parameters
		*/
		public void company(String company, int wage_per_hr, int working_days_per_month, int max_working_hrs)
		{
			//Adding details to the array list (array list of type 'CompanyInfo')
			wcc = new CompanyInfo(company, wage_per_hr, working_days_per_month, max_working_hrs);

			totalWageofDiffEmp.add(wcc);

			CompanyInfo cI;

			//calling calculator method for every company
			for(int i=0;i<totalWageofDiffEmp.size();i++)
			{
				cI = totalWageofDiffEmp.get(0);

				int totalWage = wageCalculator(cI);
				wcc.setTotalWage(totalWage);

				System.out.println("total wage: "+cI);
			}
		}

		// WAGE CALCULATOR
		public int wageCalculator(CompanyInfo cI)
		{
			// VARIABLES
			int checkPresence;
			int checkEmpType;
			// int empDailyWage = 0; //Used if uncomment the commented code-lines
			int dayOfMonth = 0;
			int totalWage = 0;
			int workingHrs = 0;
			int totalWorkedHrs = 0;

			// Wage calculation
			while (dayOfMonth <= cI.working_days_per_month && totalWorkedHrs <= cI.max_working_hrs)
			{
				checkPresence = (int) (Math.random() * 10) % 2; // Presence check
				checkEmpType = (int) (Math.random() * 10) % 2; // Work Type check
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
				/*
				 * //can show the daily wage empDailyWage = wage_per_hr * workingHrs;
				 * System.out.println("Daily wage of employee: "+empDailyWage);
				 */
				totalWage = (cI.wage_per_hr * totalWorkedHrs);
				/*
				 * //can show wage until the current day if(dayOfMonth <=
				 * working_days_per_month)
				 * System.out.println("till the day "+dayOfMonth+" : "+totalWage);
				 */
			}
			return totalWage;
		}

	public static void main(String[] args)
	{
		EmployeeWage company1 = new EmployeeWageComputationProgram();
		EmployeeWage company2 = new EmployeeWageComputationProgram();
		EmployeeWage company3 = new EmployeeWageComputationProgram();
		EmployeeWage company4 = new EmployeeWageComputationProgram();

		company1.company("company1",20, 20, 100);
		company2.company("company2",25, 15, 150);
		company3.company("company3", 20, 20, 100);
		company4.company("company4", 25, 15, 150);
	}
}

