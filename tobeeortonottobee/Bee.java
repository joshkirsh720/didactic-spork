import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;

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
		intSpace[bee.getX()][bee.getY()][bee.getZ()] = 0;
		//DFS(bee.getX(), bee.getY(), bee.getZ(), intSpace, new Point(hive.getX(), hive.getY(), hive.getZ()));
		BFS(bee.getX(), bee.getY(), bee.getZ(), intSpace, new Point(hive.getX(), hive.getY(), hive.getZ()), space);
	}


	private boolean DFS(int x, int y, int z, int[][][] space, Point target) {

		if(x == target.x && y == target.y && z == target.z) {
			path.push(new Point(x, y, z));
			return true;
		}
		else if(space[x][y][z] == 0) {
			space[x][y][z] = 1;

			Point[] ranks = rankByClosest(new Point(x, y, z), space, target, null);

			for(Point p : ranks) {
				try {
					if (DFS(p.x, p.y, p.z, space, target)) {
						path.push(new Point(x, y, z));
						return true;
					}
				} catch(ArrayIndexOutOfBoundsException e) {
					return false;
				}
			}
		}

		return false;
	}

	private void BFS(int x, int y, int z, int[][][] space, Point target, Space[][][] realSpace) {
		LinkedList<Point> adjPoints = new LinkedList<Point>();

		Point[] ranks = rankByClosest(new Point(x, y, z), space, target, new Point(x, y, z));

		for(Point p : ranks) adjPoints.add(p);

		while(!adjPoints.isEmpty()) {
			Point searching = adjPoints.remove();

            try {
                if (space[searching.x][searching.y][searching.z] != 0) continue;
                if (searching.x == target.x && searching.y == target.y && searching.z == target.z)
                    System.out.println("reached hive");
                System.out.println(searching);
                space[searching.x][searching.y][searching.z] = 1;
                Point[] searchingRanks = rankByClosest(searching, space, target, searching);
                for(Point p : searchingRanks) adjPoints.add(p);

            } catch(ArrayIndexOutOfBoundsException e) {
                continue;
            }
		}
	}

	private Point[] rankByClosest(Point current, int[][][] space, Point target, Point parent) {
	    Point[] adjPoints = new Point[26];

	    adjPoints[0] = new Point(current.x +1, current.y, current.z, parent);
		adjPoints[1] = new Point(current.x-1, current.y, current.z, parent);
		adjPoints[2] = new Point(current.x, current.y+1, current.z, parent);
		adjPoints[3] = new Point(current.x, current.y-1, current.z, parent);
		adjPoints[4] = new Point(current.x, current.y, current.z+1, parent);
		adjPoints[5] = new Point(current.x, current.y, current.z-1, parent);
		adjPoints[6] = new Point(current.x+1, current.y+1, current.z, parent);
		adjPoints[7] = new Point(current.x-1, current.y+1, current.z, parent);
		adjPoints[8] = new Point(current.x+1, current.y-1, current.z, parent);
		adjPoints[9] = new Point(current.x-1, current.y-1, current.z, parent);
		adjPoints[10] = new Point(current.x, current.y+1, current.z+1, parent);
		adjPoints[11] = new Point(current.x, current.y-1, current.z+1, parent);
		adjPoints[12] = new Point(current.x, current.y+1, current.z-1, parent);
		adjPoints[13] = new Point(current.x, current.y-1, current.z-1, parent);
		adjPoints[14] = new Point(current.x+1, current.y, current.z+1, parent);
		adjPoints[15] = new Point(current.x+1, current.y, current.z-1, parent);
		adjPoints[16] = new Point(current.x-1, current.y, current.z+1, parent);
		adjPoints[17] = new Point(current.x-1, current.y, current.z-1, parent);
		adjPoints[18] = new Point(current.x+1, current.y+1, current.z+1, parent);
		adjPoints[19] = new Point(current.x-1, current.y+1, current.z+1, parent);
		adjPoints[20] = new Point(current.x+1, current.y-1, current.z+1, parent);
		adjPoints[21] = new Point(current.x+1, current.y+1, current.z-1, parent);
		adjPoints[22] = new Point(current.x-1, current.y-1, current.z+1, parent);
		adjPoints[23] = new Point(current.x+1, current.y-1, current.z-1, parent);
		adjPoints[24] = new Point(current.x-1, current.y+1, current.z-1, parent);
		adjPoints[25] = new Point(current.x-1, current.y-1, current.z-1, parent);
		//now I know what true pain is

		//sort those bois by closest to target
		int count = 0;
		do{
			count = 0;
			for(int i = 0; i < adjPoints.length; i++) {
				if(i < adjPoints.length-1 && (manDis(adjPoints[i], target) > manDis(adjPoints[i+1], target))) {
					count ++;
					Point temp = adjPoints[i];
					adjPoints[i] = adjPoints[i+1];
					adjPoints[i+1] = temp;
				}
			}
		} while(count != 0);

		return adjPoints;
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
		return Math.abs(p.x - target.x) + Math.abs(p.y - target.y) + Math.abs(p.z - target.z);
	}

	public int printPath() {
		int size = path.size();
		while(!path.empty()) System.out.println(path.pop());
		return size;
	}
}
