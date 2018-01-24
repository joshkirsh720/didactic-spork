import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadIn {
	
	public static ArrayList<String> ReadFile(String fileName) throws IOException{
		ArrayList<String> list = new ArrayList<String>();

		try {
		File f = new File(fileName);
		BufferedReader bufferedRead = new BufferedReader(new FileReader(f));
		String readLine = "";

        while ((readLine = bufferedRead.readLine()) != null) {
        	
            	list.add(readLine);
            
        }
		
		}catch (FileNotFoundException e){
			
			
		}
		return list;
		
		
		
	}
	public static String[][] splitInfo(ArrayList<String> input){
		String[][] splat = new String[input.size()][5];
		for(int i = 0; i < input.size(); i++){
			splat[i] = input.get(i).split("\\t");
			
		}
		
		
		return splat;
	}
}
//put file under thge JRE SYstem Library

