import java.util.ArrayList;
import java.util.List;

public class KDTreeST<Value> {
	private static Node2LL node;

	public boolean isEmpty() {
		return getNode() == null;
	}

	public int size() {
		if (!isEmpty()) {
			if (getNode().getLeft() == null && getNode().getRight() == null)
				return 1;
			else if (getNode().getLeft() == null) {
				return getLengthBranch(getNode().getRight()) + 1;
			} else if (getNode().getRight() == null)
				return getLengthBranch(getNode().getLeft()) + 1;
			return getLengthBranch(getNode().getLeft()) + getLengthBranch(getNode().getRight()) + 1;
		} else
			return 0;
	}

	private int getLengthBranch(Node2LL<Value> a) {
		if (a.getLeft() == null && a.getRight() == null)
			return 1;
		else if (a.getLeft() == null)
			return getLengthBranch(a.getRight());
		else if (a.getRight() == null)
			return getLengthBranch(a.getLeft());
		else
			return getLengthBranch(a.getRight()) + getLengthBranch(a.getLeft());
	}

	public void insert(Point2D p, Value val) {
		if (getNode() == null) {
			setNode(new Node2LL<Value>(p.x(), p.y(), 0, null, null, val));
		} else {
			Node2LL<Value> t = new Node2LL<Value>(p.x(), p.y(), -1, null, null, val);
			putter(getNode(), t);
		}
	}

	@SuppressWarnings("unchecked")
	private void putter(Node2LL<Value> n, Node2LL<Value> t) {
		if (n.useXAxis == 0) {
			// use y axis
			if (n.y > t.y) {
				if (n.getLeft() == null) {
					t.useXAxis = 1;
					n.setLeft(t);
				} else {
					putter(n.getLeft(), t);
				}
			}
			if (n.y == t.y) {
				if (n.x > t.x) {
					if (n.getLeft() == null) {
						t.useXAxis = 1;
						n.setLeft(t);
					} else {
						putter(n.getLeft(), t);
					}
				}
				if (n.x < t.x) {
					if (n.getRight() == null) {
						t.useXAxis = 1;
						n.setRight(t);
					} else {
						putter(n.getRight(), t);
					}
				}
				if (n.x == t.x) {
					n.v = t.v;
				}
			}
			if (n.y < t.y) {
				if (n.getRight() == null) {
					t.useXAxis = 1;
					n.setRight(t);
				} else {
					putter(n.getRight(), t);
				}
			}
		}
		if (n.useXAxis == 1) {
			// use x axis
			if (n.x > t.x) {
				if (n.getLeft() == null) {
					t.useXAxis = 0;
					n.setLeft(t);
				} else {
					putter(n.getLeft(), t);
				}
			}
			if (n.x == t.x) {
				if (n.y > t.y) {
					if (n.getLeft() == null) {
						t.useXAxis = 0;
						n.setLeft(t);
					} else {
						putter(n.getLeft(), t);
					}
				}
				if (n.y < t.y) {
					if (n.getRight() == null) {
						t.useXAxis = 0;
						n.setRight(t);
					} else {
						putter(n.getRight(), t);
					}
				}
				if (n.y == t.y) {
					n.v = t.v;
				}
			}
			if (n.x < t.x) {
				if (n.getRight() == null) {
					t.useXAxis = 0;
					n.setRight(t);
				} else {
					putter(n.getRight(), t);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public Value get(Point2D p) {
		if (!isEmpty()) {
			Node2LL<Value> t = new Node2LL<Value>(p.x(), p.y(), -1, null, null, null);
			return (Value) getter(getNode(), t);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private Value getter(Node2LL<Value> n, Node2LL<Value> t) {
		if (n.useXAxis == 0) {
			// use y axis
			if (n.y > t.y) {
				if (n.getLeft() == null) {
					return null;
				} else {
					getter(n.getLeft(), t);
				}
			}
			if (n.y == t.y) {
				if (n.x > t.x) {
					if (n.getLeft() == null) {
						return null;
					} else {
						getter(n.getLeft(), t);
					}
				}
				if (n.x < t.x) {
					if (n.getRight() == null) {
						return null;
					} else {
						getter(n.getRight(), t);
					}
				}
				if (n.x == t.x) {
					return (Value) n.v;
				}
			}
			if (n.y < t.y) {
				if (n.getRight() == null) {
					return null;
				} else {
					getter(n.getRight(), t);
				}
			}
		}
		if (n.useXAxis == 1) {
			// use x axis
			if (n.x > t.x) {
				if (n.getLeft() == null) {
					return null;
				} else {
					getter(n.getLeft(), t);
				}
			}
			if (n.x == t.x) {
				if (n.y > t.y) {
					if (n.getLeft() == null) {
						return null;
					} else {
						getter(n.getLeft(), t);
					}
				}
				if (n.y < t.y) {
					if (n.getRight() == null) {
						return null;
					} else {
						getter(n.getRight(), t);
					}
				}
				if (n.y == t.y) {
					return (Value) n.v;
				}
			}
			if (n.x < t.x) {
				if (n.getRight() == null) {
					return null;
				} else {
					getter(n.getRight(), t);
				}
			}
		}
		return null;
	}

	public boolean contains(Point2D p) {
		return get(p) == null;
	}

	public Iterable<Node2LL> points() {
		return get(node);
	}

	private List<Node2LL> get(Node2LL foo) {
		if (foo.getLeft() == null && foo.getRight() == null) {
			List<Node2LL> a = new ArrayList<Node2LL>();
			a.add(foo);
			return a;
		} else if (foo.getRight() == null) {
			List<Node2LL> a = new ArrayList<Node2LL>();
			a.add(foo);
			return combineR(get(foo.getLeft()), a);
		} else if (foo.getLeft() == null) {
			List<Node2LL> a = new ArrayList<Node2LL>();
			a.add(foo);
			return combineR(get(foo.getRight()), a);
		} else {
			return combineR(get(foo.getLeft()), get(foo.getRight()));
		}
	}

	private List<Node2LL> combineR(List<Node2LL> list, List<Node2LL> a) {
		list.addAll(a);return list;
	}

	@SuppressWarnings("unused")
	private List<Point2D> combine(List<Point2D> list, List<Point2D> list2){
		List<Point2D> ret = new ArrayList<Point2D>();
		if(list == null){
			return list2;
		}
		else if(list2 == null){
			return list;
		}
		else if(list == null && list2 == null){
			System.out.println("both null");
		}
		else{
			ret.addAll(list);
			ret.addAll(list2);
			return ret;
		}
		return null;
	}

	public Iterable<Point2D> range(RectHV rect) {
		// List<Point2D> all = get(node);
		// List<Point2D> ret = new ArrayList<Point2D>();
		// for(Point2D a: all){
		// if(rect.contains(a))ret.add(a);
		// }
		// return ret;
		return getRange(rect, node);
	}
	public Point2D nearest(Point2D p){
		List<Node2LL> a = (List<Node2LL>) points();
		Point2D champ = new Point2D(node.x,node.y);
		double dist = Double.MAX_VALUE;
		for(Node2LL b: a){
			if(b.pt.distanceTo(champ)<dist){
				dist = b.pt.distanceTo(p);
				champ = b.pt;
			}
		}
		return champ;
	}
	@SuppressWarnings("unused")
	private Iterable<Point2D> getRange(RectHV rect, Node2LL node2) {
		if (node2 == null)
			return null;
		boolean xAligned = node2.useXAxis == 1;
		boolean useLeft = false;
		boolean useRight = false;
		boolean isContained = rect.contains(new Point2D(node2.x, node2.y));
		if (xAligned) {
			if (node2.y < rect.ymax())
				useLeft = true;
			if (node2.y > rect.ymin())
				useRight = true;
		} else {
			if (node2.y < rect.xmax())
				useLeft = true;
			if (node2.y > rect.xmin())
				useRight = true;
		}
		if (useLeft && useRight) {
			List<Point2D> x = new ArrayList<Point2D>();
			if (isContained) {
				x.add(new Point2D(node2.x, node2.y));
			}
			return combine(combine(x, (List<Point2D>) getRange(rect, node2.getLeft())),
					(List<Point2D>) getRange(rect, node2.getRight()));
		} else {
			if (useLeft) {
				return getRange(rect, node2.getLeft());
			} else if (useRight) {
				return getRange(rect, node2.getRight());
			}
		}
		return null;
	}


	private Point2D mkPt(Node2LL node1) {
		if (node1 == null)
			return null;
		return new Point2D(node1.x, node1.y);
	}

	private double distance(Point2D p, Point2D x) {
		return p.distanceTo(x);
	}
	public void draw(){
		StdDraw.setPenColor();
		List<Node2LL> a = (List<Node2LL>) points();
		for(Node2LL cd:a){
			cd.pt.draw();
		}
	}

	public static void main(String[] args) {
		System.out.println("Test");
		(new KDTreeST<String>()).draw();
	}

	public static Node2LL getNode() {
		return node;
	}

	public static void setNode(Node2LL node) {
		KDTreeST.node = node;
	}

	public void insert(double i, double j, Value string) {
		insert(new Point2D(i,j), string);
	}
}