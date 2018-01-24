import java.io.IOException;
import java.util.ArrayList;

public class DriverClass {
	private static ArrayList<Person> students = new ArrayList<Person>();
	
	public static void main (String [] args) throws IOException{
		
		System.out.println(ReadIn.ReadFile("Untitled.txt"));
		ArrayList<String> input2 = ReadIn.ReadFile("Untitled.txt");
		System.out.println(ReadIn.splitInfo(input2)[1][2]);
		
		String[][] splittedArray = ReadIn.splitInfo(input2);
		for(String[] person: splittedArray){
			
			RegisterPersons(person);
		}
for(String[] person: splittedArray){
			
	enterClassesAndGrades(person);
		}
		
		
		
		//so its 2 d, with each row being a new person. 1st column is the names, 2nd colum is SSN
		
		
		
	}
	//Person temp = new Person((listOfPeople[i][1]), Integer.parseInt(listOfPeople[i][2]), listOfPeople[i][0]);

	public static void RegisterPersons(String[] SplitPerson){
		boolean exists = false;
		if(students.isEmpty()){
			Person temp = new Person((SplitPerson[1]), Integer.parseInt(SplitPerson[2]), SplitPerson[0]);
			students.add(temp);
			System.out.println(temp.getName());
			
		}else{
			for(Person stu : students){
				if(stu.getName().equals(SplitPerson[0])){
					exists = true;
					//alrady is in the system
				}
				
			}
			if(exists == false){
				Person temp = new Person((SplitPerson[1]), Integer.parseInt(SplitPerson[2]), SplitPerson[0]);
				students.add(temp);
				System.out.println(temp.getName());

			}
			
			
		}
			
	}
	public static void enterClassesAndGrades(String[] SplitPerson){
		Class tempClass = new Class(SplitPerson[3], Double.parseDouble(SplitPerson[4]));
		Person toModify = extractPersonViaName(SplitPerson[0]);
		toModify.addClass(tempClass);
		
		
	}
	public static Person extractPersonViaName(String Name){
		for(Person stu : students){
			if(stu.getName().equals(Name)){

				return stu;
			}
			
		}
		return null;
		
		
	}
	

}
