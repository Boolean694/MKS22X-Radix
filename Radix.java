public class Radix {
  public static void radixsort(int[] dat) {
    int h = -2147483648;
    for(int q = 0; q < dat.length; q++) {
      if(dat[q] > h) {h = dat[q];}
    }
    int ll = String.valueOf(h).length();
    System.out.println(ll);
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
