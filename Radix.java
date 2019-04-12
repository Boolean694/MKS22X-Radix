import java.lang.Math;
import java.util.*;
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
    //for each digit
    for(int w = 0; w < ll; w++) {
      //into buckets
      System.out.println("digit: " + (w + 1));
      System.out.println("dat: " + Arrays.toString(dat));
      System.out.println("--------------");
      for(int e = 0; e < dat.length; e++) {
        int dig = (dat[e] / (int)(Math.pow(10,w))) % 10;
        //negative case
        System.out.println("boolean: " + (dat[e] < 0 && dat[e] / (int)(Math.pow(10,w + 1)) != 0));
        if(dat[e] < 0 && dat[e] / (int)(Math.pow(10,w + 1)) != 0) {
          dig *= -1;
        }
        System.out.print("e: " + e + ", ");
        System.out.print("num: " + dat[e] + ", ");
        System.out.println("digit: " + dig);
        buckets[dig + 9].add(dat[e]);
      }
      System.out.println("--------------");
      for(int test = 0; test < buckets.length; test++) {
        System.out.println("Bucket " + (test - 9) + ": " + buckets[test]);
      }
      System.out.println("--------------");
      //combine into supermega
      for(int r = 0; r < buckets.length; r++) {
        supermega.extend(buckets[r]);
        System.out.println("r: " + r + ", " + "supermega: " + supermega);
      }
      //into dat
      for(int t = 0; t < dat.length; t++) {
        dat[t] = supermega.removeFirst();
        System.out.println("dat: " + Arrays.toString(dat));
      }
      System.out.println("||||||||||||||||||||||||");
      supermega.reset();
    }
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
