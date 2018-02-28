import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class Bee extends Space {
    Stack<Point> path;

	public Bee(int x, int y, int z){
		super(x, y, z);
		path = new Stack<Point>();
	}

	@Override
    public String toString() {
	    return "Bee @ " + super.toString();
    }

    public void moveToHive(Bee bee, Hive hive, Space[][][] space) {
		int [][][] intSpace = spaceToIntArr(space);

		DFS(bee.getX(), bee.getY(), bee.getZ(), intSpace, new Point(hive.getX(), hive.getY(), hive.getZ()));
	}

	private boolean DFS(int x, int y, int z, int[][][] space, Point target) {
		//one is visited, 0 is unvisited
		space[x][y][z] = 1;

        Queue<Point> ranks = rankByClosest(new Point(x, y, z),space, target);

        for(;;) {

            try {
                Point  p = ranks.remove();
                if(space[p.x][p.y][p.z] == 0 && DFS(p.x, p.y, p.z, space, target)) {
                    path.push(p);
                }
                else if(space[p.x][p.y][p.z] == 2 && (p.x == target.x && p.y == target.y && p.z == target.z)) {
                    path.push(p);
                    return true;
                }
                else {
                    return false;
                }
            } catch (NoSuchElementException e) {
                //if the queue is empty, you're done
                break;
            } catch (ArrayIndexOutOfBoundsException e) {
                //if the point is out of bounds continue to the next one
                continue;
            }
        }

	    return false;
	}

	private Queue<Point> rankByClosest(Point current, int[][][] space, Point target) {
	    Point[] adjPoints = new Point[26];
	    Queue<Point> qP = new LinkedList<Point>();

	    adjPoints[0] = new Point(current.x +1, current.y, current.z);
		adjPoints[1] = new Point(current.x-1, current.y, current.z);
		adjPoints[2] = new Point(current.x, current.y+1, current.z);
		adjPoints[3] = new Point(current.x, current.y-1, current.z);
		adjPoints[4] = new Point(current.x, current.y, current.z+1);
		adjPoints[5] = new Point(current.x, current.y, current.z-1);
		adjPoints[6] = new Point(current.x+1, current.y+1, current.z);
		adjPoints[7] = new Point(current.x-1, current.y+1, current.z);
		adjPoints[8] = new Point(current.x+1, current.y-1, current.z);
		adjPoints[9] = new Point(current.x-1, current.y-1, current.z);
		adjPoints[10] = new Point(current.x, current.y+1, current.z+1);
		adjPoints[11] = new Point(current.x, current.y-1, current.z+1);
		adjPoints[12] = new Point(current.x, current.y+1, current.z-1);
		adjPoints[13] = new Point(current.x, current.y-1, current.z-1);
		adjPoints[14] = new Point(current.x+1, current.y, current.z+1);
		adjPoints[15] = new Point(current.x+1, current.y, current.z-1);
		adjPoints[16] = new Point(current.x-1, current.y, current.z+1);
		adjPoints[17] = new Point(current.x-1, current.y, current.z-1);
		adjPoints[18] = new Point(current.x+1, current.y+1, current.z+1);
		adjPoints[19] = new Point(current.x-1, current.y+1, current.z+1);
		adjPoints[20] = new Point(current.x+1, current.y-1, current.z+1);
		adjPoints[21] = new Point(current.x+1, current.y+1, current.z-1);
		adjPoints[22] = new Point(current.x-1, current.y-1, current.z+1);
		adjPoints[23] = new Point(current.x+1, current.y-1, current.z-1);
		adjPoints[24] = new Point(current.x-1, current.y+1, current.z-1);
		adjPoints[25] = new Point(current.x-1, current.y-1, current.z-1);
		//now I know what true pain is

		int count = 0;
		do{
			for(int i = 0; i < adjPoints.length; i++) {
				if(i < adjPoints.length-1 && (manDis(adjPoints[i], target) < manDis(adjPoints[i+1], target))) {
					count ++;
					Point temp = adjPoints[i];
					adjPoints[i] = adjPoints[i+1];
					adjPoints[i+1] = temp;
				}
			}
		} while(count != 0);

		for(Point p : adjPoints) qP.add(p);

		return qP;
    }

	private int[][][] spaceToIntArr(Space[][][] space) {
		int[][][] intSpace = new int[space.length][space.length][space.length];

		for(int x = 0; x < space.length; x++) {
			for(int y = 0; y < space[0].length; y++) {
				for(int z = 0; z < space[0][0].length; z++) {
					if(space[x][y][z].getClass().toString().equals("class Obstacle")) intSpace[x][y][z] = -1;
					if(space[x][y][z].getClass().toString().equals("class Hive")) intSpace[x][y][z] = 2;
					if(space[x][y][z].getClass().toString().equals("class Bee")) intSpace[x][y][z] = 3;
				}
			}
		}

		return intSpace;
	}

	private int manDis(Point p, Point target) {
		return Math.abs(p.x - target.x) + Math.abs(p.y - target.y) +Math.abs(p.z - target.z);
	}

	public void printPath() {
		while(!path.empty()) System.out.println(path.pop());
	}
}
