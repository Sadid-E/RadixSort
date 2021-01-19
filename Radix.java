public class Radix {

  public static int nth(int n, int col) {
    return (int) (Math.abs(n)/(Math.pow(10,col)) % 10);
  }

  public static int length(int n) {
    if (n == 0) {
      return 1;
    }
    return (int) (Math.log10(Math.abs(n)) + 1);
  }

  public static void merge(SortableLinkedList original, SortableLinkedList[] buckets) {
    for (int i = 0; i < buckets.length; i++) {
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

  public static void radixSort(SortableLinkedList data) {
    SortableLinkedList[] bucketsNegative = new SortableLinkedList[10];
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    for (int i = 0; i < 10; i++) {
      SortableLinkedList bucket = new SortableLinkedList();
      SortableLinkedList bucket2 = new SortableLinkedList();
      buckets[i] = bucket;
      bucketsNegative[i] = bucket2;
    }
    int times = 1;
    int size = data.size();
    for (int j = 0; j < times; j++) {
      for (int k = 0; k < size; k++) {
        int num = data.remove(0);
        int digit = nth(num,j);
          if (num < 0) {
            bucketsNegative[9-Math.abs(digit)].add(num);
          } else {
            buckets[digit].add(num);
          }
          if (length(num) > times) {
            times = length(num);
          }
      }
      merge(data,bucketsNegative);
      merge(data,buckets);
    }
  }

}
