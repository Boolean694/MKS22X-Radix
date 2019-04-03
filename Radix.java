import java.lang.Math;
public class Radix {
  public static void radixsort(int[] dat) {
    int h = -2147483648;
    for(int q = 0; q < dat.length; q++) {
      if(dat[q] > h) {h = dat[q];}
    }
    int ll = String.valueOf(h).length();
    //MyLinkedList[] buckets = new MyLinkedList[ll];
    for(int w = 0; w < ll; w++) {

    }
  }
  private static void sortdig(int[] dat, int dig) {
    for(int q = 0; q < dat.length; q++) {
      int sm = 9;
      int smind = 0;
      for(int w = q; w < dat.length; w++) {
        if((dat[q] / ((int)Math.pow(10, dig))) % 10 < sm) {sm = (dat[q] / ((int)Math.pow(10, dig))) % 10; smind = w;}
      }
      int mtf = dat[smind];
      for(int w = smind - 1; w >= q; w--) {
        dat[w] = dat[w - 1];
      }
      dat[q] = dat[smind];
    }
  }
  public static void main(String[] sdjf) {
    int[] test = {170, 45, 75, 90, 802, 24, 2, 66};
    radixsort(test);
    System.out.print("[");
    for(int q = 0; q < test.length; q++) {
      System.out.print(test[q] + ", ");
    }
    System.out.print("]");
  }
}
