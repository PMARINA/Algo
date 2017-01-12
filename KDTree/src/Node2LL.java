
public class Node2LL<Value> {
	private Node2LL<?> left;
	private Node2LL<?> right;
	double x;
	double y;
	int useXAxis;
	Value v;
	Point2D pt;
	public Node2LL(double x, double y, int useXAxis, Node2LL left, Node2LL right, Value v){
		this.setLeft(left);
		this.setRight(right);
		this.useXAxis = useXAxis;
		this.x = x;
		this.y = y;
		this.v = v;
		this.pt = new Point2D(x,y);
	}
	public Node2LL getRight() {
		return right;
	}
	public void setRight(Node2LL right) {
		this.right = right;
	}
	public Node2LL getLeft() {
		return left;
	}
	public void setLeft(Node2LL left) {
		this.left = left;
	}
}