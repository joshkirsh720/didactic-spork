import java.util.Scanner;

public class Driver {
	public static void main(String[]args){
        Space[][][] space;
        Hive[] hiveArr = new Hive[15];

		Scanner scan = new Scanner(System.in);
		System.out.println("Read from file or random? f or r?");
		String input = scan.next();

		if(input.equals("r")) {
			//set up space
			int dim = (int) (Math.random() * 26 + 25);
			space = new Space[dim][dim][dim];

			//start with making everything an empty space
            for(int x = 0; x < dim; x++) {
                for (int y = 0; y < dim; y++) {
                    for(int z = 0; z < dim; z++) {
                        space[x][y][z] = new EmptySpace(x, y, z);
                    }
                }
            }


			//generate hive
            Point start = new Point((int) (Math.random() * dim + 1), (int) (Math.random() * dim + 1), (int) (Math.random() * dim + 1));

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

            for(Hive h : hiveArr) System.out.println(h);


            //now generate the obstacles (30% of total space)
            int numberOfObstacles = (int) (Math.pow(dim, 3) * 0.3);
		}
		else {

		}

	}
}