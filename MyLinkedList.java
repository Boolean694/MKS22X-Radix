public class MyLinkedList {
	private int size;
	private Node start;
	private Node end;
	public MyLinkedList() {
	    size = 0;
	    start = null;
	    end = null;
    }
	public int size() {
		return size;
	}
	public boolean add(Integer v) {
	    if(size == 0) {
	        Node nn = new Node(v, null, null);
	        start = nn;
	        end = nn;
			size++;
	        return true;
	    }
		Node nn = new Node(v, null, end);
		end.setNext(nn);
		end = nn;
		size++;
		return true;
	}
	public String toString() {
	    if(size == 0) {return "[]";}
	    if(size == 1) {return "[" + start.getData() + "]";}
		String s = "[" + start.getData() + ",";
		Node c = start.next();
		while(c.next() != null) {
			s += c.getData();
			s += ",";
			c = c.next();
		}
		s += end.getData();
		s += "]";
		return s;
	}
	public Node start() {
		return start;
	}
	public Node end() {
		return end;
	}
	public Integer removeFirst() {
		if(size == 1) {
			Integer ret = start.getData();
			reset();
			return ret;
		}
		Node c = start.next();
		Integer pret = start.getData();
		start = c;
		start.setPrev(null);
		size--;
		return pret;
	}
	public void reset() {
		size = 0;
		start = null;
		end = null;
	}
	public void extend(MyLinkedList other) {
		boolean bool = false;
		if(other.size() == 0) {
			return;
		}
		if(this.size() == 0) {
			this.add(-111111);
			this.add(-111111);
			bool = true;
		}
		Node ente = other.end();
		for(int q = 0; q < other.size(); q++) {
			this.end.setNext(other.start());
			this.end = other.start();
			Node c = other.start.next();
			other.start = c;
			this.size++;
		}
		this.end = ente;
		if(bool) {
			this.removeFirst();
			this.removeFirst();
		}
		other.reset();
	}
	public static void main(String[] wef) {
		MyLinkedList te = new MyLinkedList();
		System.out.println("Original: " + te);
		te.add(56);
		te.add(57);
		te.add(58);
		MyLinkedList tr = new MyLinkedList();
		tr.add(8);
		tr.add(9);
		tr.add(0);
		System.out.println("Combining this with original: " + tr);
		te.extend(tr);
		System.out.println(te);
		te.add(10);
		System.out.println(te);
		MyLinkedList tw = new MyLinkedList();
		tw.add(67);
		tw.add(68);
		tw.add(69);
		System.out.println("Combining this with original: " + tw);
		te.extend(tw);
		System.out.println(te);
		System.out.println(tr);
		System.out.println(tw);
	}
}
