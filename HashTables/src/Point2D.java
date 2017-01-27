import java.util.Arrays;
public class Point2D{
	private final int x,y,z;
	public Point2D(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public int hashCode(){
		return Arrays.hashCode(new int[]{x,y,z});
	}

	public boolean equals(Point2D other){
		return this.x==other.x && this.y==other.y && this.z==other.z;
	}

	public static void main(String[] args){
		Point2D a = new Point2D(1,2,3);
		Point2D b = new Point2D(1,2,3);
		Point2D c = new Point2D(2,3,4);
		System.out.println("a: " + a.hashCode() + "\nb: " + b.hashCode() + "\nc: " + c.hashCode());
		System.out.println("a==b: " + a.equals(b) + "\nb==c: " + b.equals(c)); 
	}
}
