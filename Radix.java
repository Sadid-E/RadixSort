public class Radix {

  public static int nth(int n, int col) {
    String number = "" + n;
    return Integer.parseInt(number.substring(number.length()-col-1, number.length()-col));
  }

  public static int length(int n) {
    String number = "" + n;
    int size = number.length();
    if (number.charAt(0) == '-') {
      size -= 1;
    }
    return size;
  }

  public static void merge(SortableLinkedList original, SortableLinkedList[] buckets) {
    for (int i = 0; i <= 10; i++) {
      original.extend(buckets[i]);
    }
  }

}
