
public class Client {
	public static void main(String[] args){
		KDTreeST<String> mt = new KDTreeST<String>();
		mt.insert(2,3,"1");
		mt.insert(4,2, "2");
		mt.insert(4, 5,"3");
		mt.insert(3,3,"4");
		mt.insert(1,5, "5");
		mt.insert(4,4, "6");
		System.out.println(mt.size());
		mt.range(new RectHV(1, 2, 4, 4));
		Iterable<Point2D> a = mt.range(new RectHV(1, 2, 4, 4));
		for(Point2D d  :a){
			System.out.println(d.x() + " " + d.y());
		}
	}
}
