import java.lang.Math;
public class Radix {
  public static void radixsort(int[] dat) {
    int h = -2147483648;
    for(int q = 0; q < dat.length; q++) {
      if(dat[q] > h) {h = dat[q];}
    }
    int ll = String.valueOf(h).length();
    MyLinkedList[] buckets = new MyLinkedList[20];
    for(int q = 0; q < buckets.length; q++) {
      buckets[q] = new MyLinkedList();
    }
    MyLinkedList supermega = new MyLinkedList();
    for(int q = 0; q < dat.length; q++) {
      supermega.add(dat[q]);
      System.out.println("Supermega: " + supermega);
    }
    System.out.println("Supermega length: " + supermega.size());
    for(int w = 0; w < ll; w++) {
      for(int e = 0; e < supermega.size() - 1; e++) {
        //System.out.println("Supermega: " + supermega + " , length: " + supermega.size());
        System.out.println("e: " + e);
        System.out.println(supermega.get(e));
        if(supermega.get(e) < 0) {
          if(w == ll - 1) {
            buckets[((supermega.get(e) / ((int)Math.pow(10,w))) % 10) + 10].add(dat[e]);
          }
          else {
            buckets[(((supermega.get(e) * -1) / ((int)Math.pow(10,w))) % 10) + 10].add(dat[e]);
          }
        }
        else {
          buckets[((supermega.get(e) / ((int)Math.pow(10,w))) % 10) + 10].add(dat[e]);
        }
      }
      //supermega.reset();
      /*
      for(int r = 0; r < buckets.length; r++) {
        System.out.print(buckets[r] + " ");
        System.out.println("");
      }
      */
      for(int r = 0; r < buckets.length; r++) {
        supermega.extend(buckets[r]);
      }
    }
    //System.out.println(supermega);
  }
  public static void main(String[] sdjf) {
    int[] test = {170, 45, 75, 90, 802, 24, 2, 66, -84, -103, 26};
    radixsort(test);
    /*System.out.print("[");
    for(int q = 0; q < test.length; q++) {
      System.out.print(test[q] + ", ");
    }
    System.out.print("]");*/
  }
}
