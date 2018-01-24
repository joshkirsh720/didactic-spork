import java.util.ArrayList;

public class Person implements Comparable<Person> {
	private int SchoolYear;
	private double averageGrade;
	private char determineLetter;
	private String name, SSN;
	
	private  ArrayList<Class> classes = new ArrayList <Class>();
	public Person(String SSNi, int SchoolYeari, String namei  ){
		name = namei;
		SSN = SSNi;
		SchoolYear = SchoolYeari;
		
		
		
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String sSN) {
		SSN = sSN;
	}
	public int getSchoolYear() {
		return SchoolYear;
	}
	public void setSchoolYear(int schoolYear) {
		SchoolYear = schoolYear;
	}
	public int getNumberOfClasses() {
		return classes.size();
	}
	
	public double getAverageGrade() {
		return determineAverageGrade();
	}
	public void setAverageGrade(double averageGrade) {
		this.averageGrade = averageGrade;
	}
	public char getDetermineLetter() {
		return determineLetter;
	}
	public void setDetermineLetter(char determineLetter) {
		this.determineLetter = determineLetter;
	}
	public void addClass(Class c){
		classes.add(c);
		
		
	}
	public double determineAverageGrade(){
		double av = 0;
		for(Class c : classes){
			av += c.getGrade();
			
		}
		av /= this.getNumberOfClasses();
		return av;
		
	}
	public char determineLetterGrade(){
		int av = (int)this.determineAverageGrade();
		if(av > 90){
			return 'A';

			
		}else if (av > 80){
			
			return 'B';

		}else if (av > 70){
			
			return 'C';

		}else if (av > 60){
			return 'D';

			
		}else{
			
			return 'F';
		}
	}
	public String toString(){
		return this.getName() + this.getSSN() + " " + this.getNumberOfClasses() + " classes" + " " + this.determineLetter;
		
		
	}
	
	
	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		if(o.determineAverageGrade() > this.determineAverageGrade()){
			return -1;
		}else{
			if (this.determineAverageGrade() > o.determineAverageGrade()){
				
				return 1;
			}
			
		}
		
		return 0;
	}

}
