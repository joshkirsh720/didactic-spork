public class Obstacle extends Space {
	public Obstacle(int x, int y, int z){
		super(x, y, z);

	}

	@Override
	public String toString() {
		return "Obstacle @ " + super.toString();
	}
}
