public class Radix {

  public static int nth(int n, int col) {
    return (int) (n/(Math.pow(10,col)) % 10);
  }

  public static int length(int n) {
    if (n == 0) {
      return 1;
    }
    return (int) (Math.log10(n) + 1);
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

  public static void radixSort(SortableLinkedList data) {
    // SortableLinkedList negatives = new SortableLinkedList();
    // int size = data.size();
    // for (int i = 0; i < size; i++) {
    //   int num = data.remove(0);
    //   if (num < 0) {
    //     negatives.add(Math.abs(num));
    //   } else {
    //     data.add(num);
    //   }
    // }
    // radixSortSimple(data);
    // radixSortSimple(negatives);
    // int size1 = negatives.size();
    // for (int j = 0; j < size1; j++) {
    //   int num = negatives.remove(0);
    //   negatives.add(0-num);
    // }
    // negatives.extend(data);
    // data.extend(negatives);
  }

}
