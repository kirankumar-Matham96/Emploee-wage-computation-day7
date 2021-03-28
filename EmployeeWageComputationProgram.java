import java.util.ArrayList;
import java.util.HashMap;

//interface
interface EmployeeWage
{
	public void company(String company, int wage_per_hr, int working_days_per_month, int max_working_hrs);
	public ArrayList<Integer> wageCalculator(CompanyInfo cI);
	public void getByName(String name);
}

//CLASS TO STORE COMPANY DETAILS
class CompanyInfo
{
	// VARIABLES
	public final String company;
	public final int wage_per_hr;
	public final int working_days_per_month;
	public final int max_working_hrs;
	private int totalWage;
	public ArrayList<Integer> dailyWage;

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

	public void setDailyWage(ArrayList<Integer> daily_wage)
	{
		this.dailyWage = daily_wage;
	}

	public ArrayList<Integer> getDailyWages()
	{
		return dailyWage;
	}

	public int getTotalWage()
	{
		return totalWage;
	}

	public String toString()
	{
		System.out.println("Company: "+company);
		return "DailyWage: "+dailyWage+"\n"+"Total Wage: "+totalWage;
	}
}

//MAIN CLASS
public class EmployeeWageComputationProgram implements EmployeeWage
{
	// CONSTANTS
	public final int IS_PRESENT = 1;
	public final int IS_FULL_TIME = 1;

	ArrayList<CompanyInfo> totalWageofDiffEmp = new ArrayList<CompanyInfo>();;
	HashMap<String,Integer> map = new HashMap<String,Integer>();

	//Object for Company Info method
	CompanyInfo wcc;

	//method to take-parameters/assign to CompanyInfo class/Create ArrayLists and assign
	public void company(String company, int wage_per_hr, int working_days_per_month, int max_working_hrs)
	{
		//Adding details to the array list (array list of type 'CompanyInfo')
		wcc = new CompanyInfo(company, wage_per_hr, working_days_per_month, max_working_hrs);

		totalWageofDiffEmp.add(wcc);

		CompanyInfo cI;

		ArrayList<Integer> al2;

		//calling calculator method for every company
		for(int i=0;i<totalWageofDiffEmp.size();i++)
		{
			cI = totalWageofDiffEmp.get(0);

			al2 = wageCalculator(cI);
			int totalWage = al2.get(al2.size()-1);
			wcc.setDailyWage(al2);
			wcc.setTotalWage(totalWage);
			map.put(company, totalWage);//<-----------NULL POINTER EXCEPTION*

//			System.out.println(cI);// To print all the data
		}
	}

	// WAGE CALCULATOR
	public ArrayList<Integer> wageCalculator(CompanyInfo cI)
	{
		// VARIABLES
		int checkPresence;
		int checkEmpType;
		int empDailyWage = 0;
		int dayOfMonth = 0;
		int totalWage;
		int workingHrs = 0;
		int totalWorkedHrs = 0;

		//array-list
		ArrayList<Integer> al1 = new ArrayList<Integer>();

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

			empDailyWage = cI.wage_per_hr * workingHrs;
			al1.add(empDailyWage);

			totalWage = (cI.wage_per_hr * totalWorkedHrs);

			al1.add(totalWage);
		}
		return al1;
	}

	//METHOD TO GET TOTAL WAGE BY NAME
	public void getByName(String name)
	{
		System.out.println("total wage from get method: "+wcc.getTotalWage());
		System.out.println("total wage from map: "+map.get(name));
	}

	//MAIN METHOD
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

		company2.getByName("company2");
		company3.getByName("company3");
	}
}
