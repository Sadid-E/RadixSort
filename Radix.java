public class Radix {

  public static int nth(int n, int col) {
    String number = "" + n;
    return Integer.parseInt(number.substring(number.length()-col-1, number.length()-col));
  }

}
