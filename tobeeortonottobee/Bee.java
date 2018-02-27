import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.Queue;

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
                else if(space[p.x][p.y][p.z] == 2) { //MIGHT NEED TO BE CHANGED TO INCLUDE A CHECK IF IT'S THE CORRECT HIVE OF THE 15
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
	    //TODO
	    return null;
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
}
