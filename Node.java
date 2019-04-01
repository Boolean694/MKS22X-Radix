public class Node {
	private int data;
	private Node next;
	private Node prev;
	public Node(int d, Node n, Node p) {
		data = d;
		next = n;
		prev = p;
	}
	public Integer getData() {
	    return data;
	}
	public Integer setData(Integer i) {
	    Integer wrtn = data;
	    data = i;
	    return wrtn;
	}
	public String toString() {
	    return "" + data;
	}
	public Node next() {
	    return next;
	}
	public Node prev() {
	    return prev;
	}
	public void setNext(Node e) {
		next = e;
	}
	public void setPrev(Node e) {
		prev = e;
	}
}
