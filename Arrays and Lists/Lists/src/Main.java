import java.util.ArrayList;

public class Main {
    public static ArrayList<Integer> solution() {
        ArrayList<Integer> myList = new ArrayList<>(); // Creates an empty ArrayList

        myList.add(1);
        myList.add(2);
        myList.add(3);

        int firstElement = myList.get(0); // firstElement = 1
        myList.set(0, firstElement + 1); // myList is [2, 2, 3]

        myList.remove(2); // Delete the element at index 2

        return myList;
    }

    public static void main(String[] args) {
        System.out.println(solution());
    }
}