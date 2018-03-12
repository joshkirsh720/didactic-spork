import java.util.Scanner;
import java.io.*;

public class Driver {
	public static void main(String[]args) throws FileNotFoundException{

        Space[][][] space = null;
        Hive[] hiveArr = new Hive[15];
        Bee[] beeArr = new Bee[15];

		Scanner scan = new Scanner(System.in);
		System.out.println("Read from file or random? f or r?");
		String input = scan.next();

		if(input.equals("r")) {
			//set up space
			//int dim = (int) (Math.random() * 26 + 25);
			int dim = 25;
            space = new Space[dim][dim][dim];


			//generate hive
            Point start = new Point((int) (Math.random() * dim), (int) (Math.random() * dim), (int) (Math.random() * dim));

            int indexOut = -1;

            //determines which way the hive will go
            //whichever one is set to one, that's the axis the hive will be on
            int xMult=0, yMult=0, zMult=0;
            double multDecider = Math.random();
            if(multDecider < 0.33) xMult = 1;
            else if(multDecider >= 0.33 && multDecider <= 0.66) yMult = 1;
            else zMult = 1;

            for(int i = 0; i < 15; i++) {
                try{
                    //sets a space in the array to a hive at location start + index (so that the hive is formed in a line
                    //i is multiplied by x/y/zMult so that only one axis is added to
                    hiveArr[i] = new Hive(start.x + (xMult * i), start.y + (yMult * i), start.z + (zMult * i));
                    space[hiveArr[i].getX()][hiveArr[i].getY()][hiveArr[i].getZ()] = hiveArr[i];
                } catch(ArrayIndexOutOfBoundsException e) {
                    if(indexOut == -1) indexOut = i-1;


                    //quick maffs to move hive backwards from the starting location if the method above goes out of bounds
                    //one is subtracted so that the first hive created this way is not on the same space as the very first one
                    hiveArr[i] = new Hive(start.x - (xMult * (i - indexOut)) , start.y - (yMult * (i - indexOut)), start.z - (zMult * (i - indexOut)));
                    space[hiveArr[i].getX()][hiveArr[i].getY()][hiveArr[i].getZ()] = hiveArr[i];
                }
            }

            //now generate the obstacles (30% of total space)
            int numberOfObstacles = (int) (Math.pow(dim, 3) * 0.3);

            for(int i = 0; i < numberOfObstacles; i++) {
                int x = (int) (Math.random() * dim);
                int y = (int) (Math.random() * dim);
                int z = (int) (Math.random() * dim);

                if(space[x][y][z] == null) {
                    space[x][y][z] = new Obstacle(x, y, z);
                }
                else {
                    numberOfObstacles++;
                    continue;
                }
            }

            //generate bees
            int numBees = 15;
            for(int i = 0; i < numBees; i++) {
                int x = (int) (Math.random() * dim);
                int y = (int) (Math.random() * dim);
                int z = (int) (Math.random() * dim);

                if(space[x][y][z] == null) {
                    beeArr[i] = new Bee(x, y, z);
                    space[x][y][z] = beeArr[i];
                }
                else {
                    i--;
                    continue;
                }
            }

            //end with filling in everything else with empty spaces
            for(int x = 0; x < dim; x++) {
                for (int y = 0; y < dim; y++) {
                    for(int z = 0; z < dim; z++) {
                        if(space[x][y][z] == null) space[x][y][z] = new EmptySpace(x, y, z);
                    }
                }
            }
		}
		else if(input.equals("f")){
            System.out.println("Which file?");
		    int num = scan.nextInt();
		    File file = new File("C:\\Users\\joshu\\Desktop\\Computer Science Projects\\Bee Project\\src\\beesetup" + num + ".txt");
            Scanner fReader = new Scanner(file);

            int dim = Integer.parseInt(fReader.nextLine().split(",")[0]);
            space = new Space[dim][dim][dim];

            //do the hive
            for(int i = 0; i < hiveArr.length; i++) {
                String[] coords = fReader.nextLine().split(",");
                int x = Integer.parseInt(coords[0]);
                int y = Integer.parseInt(coords[1]);
                int z = Integer.parseInt(coords[2]);

                hiveArr[i] = new Hive(x, y, z);
                space[x][y][z] = hiveArr[i];
            }

            //place the bees
            for(int i = 0; i < beeArr.length; i++) {
                String[] coords = fReader.nextLine().split(",");
                int x = Integer.parseInt(coords[0]);
                int y = Integer.parseInt(coords[1]);
                int z = Integer.parseInt(coords[2]);

                beeArr[i] = new Bee(x, y, z);
                space[x][y][z] = beeArr[i];
            }

            //skips number that contains obstacle lines
            fReader.nextLine();

            //does the obstacles
            while(fReader.hasNextLine()) {
                String[] coords = fReader.nextLine().split(",");
                int x = Integer.parseInt(coords[0]);
                int y = Integer.parseInt(coords[1]);
                int z = Integer.parseInt(coords[2]);

                space[x][y][z] = new Obstacle(x, y, z);
            }

            //end with filling in everything else with empty spaces
            for(int x = 0; x < dim; x++) {
                for (int y = 0; y < dim; y++) {
                    for(int z = 0; z < dim; z++) {
                        if(space[x][y][z] == null) space[x][y][z] = new EmptySpace(x, y, z);
                    }
                }
            }

            fReader.close();
		}

        System.out.println("Space generation complete");


		//start doing the actual thing here

        for(int i = 0; i < beeArr.length; i++) {
		    beeArr[i].moveToHive(beeArr[i], hiveArr[i], space);
        }


        int sumMoves = 0;
        for(int i = 0; i < beeArr.length; i++) {
            System.out.println("Bee #" + (i+1) + ": ");
            sumMoves += beeArr[i].printPath();
            System.out.println("\n\n\n");
        }

        System.out.println("The sum of all moves is " + sumMoves);
	}
}