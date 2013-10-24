import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class CSVManip {
	
	
	public static void gradeRead(String filename)
	{
		try{
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			
			String fileLines;
			String[] parts;
			
			
			while(br.ready())
			{
				fileLines = br.readLine();
				
				parts = fileLines.split(",");
				
				System.out.println(parts[0] + " " + parts[1]);
			}
			
			br.close();
			} 
			catch(IOException e)
			{
				System.out.println("Couldnt Read file");
			}
	}
	
	public static void gradeWrite(String filename, String name, int grade)
	{
		try
		{
			FileWriter fw = new FileWriter(filename, true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.newLine();
			bw.write(name + "," + grade);
			bw.close();
		}
		catch(IOException e)
		{
			System.out.println("Couldnt Write file");
		}
	}
	
	/**Returns arraylist of type User read from file*/
	public static ArrayList<User> readUser()
	{
		ArrayList<User> userList = new ArrayList<User>();
		try{
		FileReader fr = new FileReader("user.csv");
		BufferedReader br = new BufferedReader(fr);
		
		String fileLines;
		String[] parts;
		
		
		while(br.ready())
		{
			int id;
			boolean manager;
			fileLines = br.readLine();
			
			parts = fileLines.split(",");
			
			id = Integer.parseInt(parts[0]);
			
			if(parts[2].equals("Manager"))
			{
				manager = true;
			}
			else
			{
				manager = false;
			}
			userList.add(new User(id, parts[1], manager));
			
		}
		br.close();
		} 
		catch(IOException e)
		{
			System.out.println("Couldnt Read file");
		}
		
		return userList;
	}
	
	/**Writes arraylist of type User to file*/
	public static void writeUser(ArrayList<User> list)
	{
		try
		{
			FileWriter fw = new FileWriter("user.csv");
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(User u: list)
			{
				String manager;
				if(u.isManage())
				{
					manager = "Manager";
				}
				else
				{
					manager = "Not Manager";
				}
				
				bw.write(u.getId() + "," + u.getPassword() + "," + manager);
				bw.newLine();
			}
			
			bw.close();
		}
		catch(IOException e)
		{
			System.out.println("Couldnt Write file");
		}
	}
}
