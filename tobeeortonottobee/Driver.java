import java.util.Scanner;

public class Driver {
	public static void main(String[]args){
        Space[][][] space;

		Scanner scan = new Scanner(System.in);
		System.out.println("Read from file or random? f or r?");
		String input = scan.next();

		if(input.equals("r")) {
			//set up space
			int dim = (int) (Math.random() * 26 + 25);
			space = new Space[dim][dim][dim];

			//generate hive
            Point start = new Point((int) (Math.random() * dim + 1), (int) (Math.random() * dim + 1), (int) (Math.random() * dim + 1));
            int indexOut;


            for(int i = 0; i < 15; i++) {
                try{
                    //NEEDS TO BE CHANGED BECAUSE HIVE CAN'T GO DIAGONALLY
                    space[start.x + i][start.y + i][start.z + i] = new Hive(start.x + i, start.y + i, start.z + i);
                } catch(ArrayIndexOutOfBoundsException e) {
                    if(indexOut == 0) indexOut = i;
                    space[start.x ][start.y + i][start.z + i] = new Hive(start.x + i, start.y + i, start.z + i);
                }
            }

		}
		else {

		}

	}
}