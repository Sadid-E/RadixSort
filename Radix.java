public class Radix {

  public static int nth(int n, int col) {
    String number = "" + n;
    if (col >= number.length()) {
      return 0;
    }
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
    for (int i = 0; i < 10; i++) {
      original.extend(buckets[i]);
    }
  }

  public static void radixSortSimple(SortableLinkedList data) {
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    for (int i = 0; i < 10; i++) {
      SortableLinkedList bucket = new SortableLinkedList();
      buckets[i] = bucket;
    }
    int times = 1;
    int size = data.size();
    for (int j = 0; j < times; j++) {
      for (int k = 0; k < size; k++) {
        int num = data.remove(0);
        int digit = nth(num,j);
        buckets[digit].add(num);
        if (length(num) > times) {
          times = length(num);
        }
      }
      merge(data,buckets);
    }
  }

}
