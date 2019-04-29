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
      for(int e = 0; e < dat.length; e++) {
        int dig = (dat[e] / (int)(Math.pow(10,w))) % 10;
        //negative case
        if(dat[e] < 0 && dat[e] / (int)(Math.pow(10,w + 1)) != 0) {
          dig *= -1;
        }
        buckets[dig + 9].add(dat[e]);
      }
      //combine into supermega
      for(int r = 0; r < buckets.length; r++) {
        supermega.extend(buckets[r]);
      }
      //into dat
      for(int t = 0; t < dat.length; t++) {
        dat[t] = supermega.removeFirst();
      }
      supermega.reset();
    }
  }
  public static void main(String[] sdjf) {
    int[] test = {-730,-155,739,-419,84,-72,945,3,-9,14,-435};
    radixsort(test);
  }
}
