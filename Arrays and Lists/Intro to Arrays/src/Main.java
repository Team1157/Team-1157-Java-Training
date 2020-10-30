import java.util.Arrays;

public class Main {
   public static int[] solution() {
      int[] myArr = {1, 3, 2};

      myArr[0] = 4;
      myArr[2] = myArr[1];

      return myArr;
   }

   public static void main(String[] args) {
      System.out.println(Arrays.toString(solution()));
   }
}