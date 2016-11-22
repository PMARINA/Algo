import java.util.LinkedList;
public class MergeSort implements Sorter {
	private static int x;
	private static int y;
	private static int boundry;
	@Override
	public int[] location() {
		if(boundry == 0){
			System.out.println("Boundries have not yet been set");
		}
		if(x>0)x-=1;
		else{
			x = boundry; y-=1;
		}
		return new int[]{x,y};
	}

	@Override
	public LinkedList sort(LinkedList aList) {
		
	}

	@Override
	public void setBoundaries(int side) {
		boundry=side;
		y = x = boundry;
	}
	
}
