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
	    if(size == 0) {
	        return 0;
	    }
	    if(start == end) {return 1;}
		int g = 2;
		Node c = start.next();
		while(c.next() != null) {
			g++;
			c = c.next();
		}
		return g;
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
	public Integer get(int i) {
	    if(i < 0 || i >= size) {throw new IndexOutOfBoundsException();}
	    if(i == 0) {return start.getData();}
	    Node c = start.next();
	    int q = 1;
	    while(q < i) {
	        c = c.next();
	        q++;
	    }
	    return c.getData();
	}
	public Integer set(int i, Integer v) {
	    if(i < 0 || i >= size) {throw new IndexOutOfBoundsException();}
	    Node c = start.next();
	    int q = 1;
	    while(q < i) {
	        c = c.next();
	        q++;
	    }
		int f = c.getData();
		c.setData(v);
		return f;
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
	public boolean contains(Integer v) {
        if(size == 0) {return false;}
        if(size == 1) {return start.getData() == v;}
		boolean b = false;
		if(start.getData() == v || end.getData() == v) {b = true;}
		Node c = start.next();
		for(int q = 1; q < this.size - 1; q++) {
			if(b) {return true;}
			if(c.getData() == v) {b = true;}
			c = c.next();
		}
		return b;
	}
	public int indexOf(Integer v) {
		if(start.getData() == v) {return 0;}
		if(end.getData() == v) {return size - 1;}
		Node c = start.next();
		for(int q = 1; q < size - 1; q++) {
			if(c.getData() == v) {return q;}
			c = c.next();
		}
		return -1;
	}
	public void add(int i, Integer v) {
		if(i < 0 || i >= size) {throw new IndexOutOfBoundsException();}
		else if(i == 0) {
			Node nn = new Node(v, start, null);
			start.setPrev(nn);
			start = nn;
			size++;
		}
		else if(i == size - 1) {
			add(v);
			size++;
		}
		else {
			Node c = start.next();
			for(int q = 1; q < i; q++) {
				c = c.next();
			}
			Node nn = new Node(v, c, c.prev());
			c.prev().setNext(nn);
			c.setPrev(nn);
			size++;
		}
	}
	public Integer remove(int i) {
		if(i < 0 || i >= size) {throw new IndexOutOfBoundsException();}
		if(i == 0) {
			Integer te = start.getData();
			start = start.next();
			start.setPrev(null);
			size--;
			return te;
		}
		if(i == size - 1) {
			Integer yw = end.getData();
			end = end.prev();
			end.setNext(null);
			size--;
			return yw;
		}
		Node c = start.next();
		for(int q = 1; q < i; q++) {
			c = c.next();
		}
		Integer tr = c.getData();
		c.next().setPrev(c.prev());
		c.prev().setNext(c.next());
		size--;
		return tr;
	}
	public Integer removeFirst() {
		Node c = start.next();
		Integer pret = start.getData();
		start = c;
		start.setPrev(null);
		size--;
		return pret;
	}
	public boolean remove(Integer v) {
		if(!this.contains(v)) {return false;}
		int d = indexOf(v);
		this.remove(d);
		size--;
		return true;
	}
/*	public static void main(String[] wef) {
		MyLinkedList te = new MyLinkedList();
		te.add(4);
		te.add(3);
		System.out.println(te);
		System.out.println("num removed: " + te.removeFirst());
		System.out.println(te);
	} */
}
