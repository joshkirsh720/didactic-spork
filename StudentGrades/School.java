import java.util.ArrayList;

public class School {
	 ArrayList<Person> students = new ArrayList<Person>();
	public School(ArrayList<Person> su){
		students = su;
		
	}
	public  double determineAverageGrade(int grade){
		double av = 0;
		double count = 0;
		for (Person s : students){
			if ( s.getSchoolYear() == grade) {
			av += s.getAverageGrade();
			count += 1;
			}
			
		}
		av /= count;
		return av;
		
		
	}
	public int numberOfFailing( int grade){
		int count = 0;
		for (Person s: students){
			if (s.getAverageGrade() < 60 && s.getSchoolYear() == grade){
			count += 1;
			}
		}
		return count;
		
		
	}
	
	

}
