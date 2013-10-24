
public class CSVTest {
	
	public static void main(String[] args)
	{
		CSVManip.gradeRead("grades.csv");
		
		
		
		CSVManip.gradeWrite("grades.csv", "Tom", 90);
		CSVManip.gradeRead("grades.csv");
	}

}
