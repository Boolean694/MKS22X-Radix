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
    for(int w = 0; w < ll; w++) {
      for(int e = 0; e < dat.length; e++) {
        buckets[((dat[e] / ((int)Math.pow(10,w))) % 10) + 10].add(dat[e]);
      }
      for(int rf = 0; rf < buckets.length; rf++) {
        System.out.print(buckets[rf]);
      }
      System.out.println("----------");
    }
  }
  public static void main(String[] sdjf) {
    int[] test = {170, 45, 75, 90, 802, 24, 2, 66};
    radixsort(test);
    /*System.out.print("[");
    for(int q = 0; q < test.length; q++) {
      System.out.print(test[q] + ", ");
    }
    System.out.print("]");*/
  }
}
