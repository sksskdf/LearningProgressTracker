import java.util.ArrayList;
import java.util.LinkedList;

class ListOperations {
    public static void changeHeadsAndTails(LinkedList<String> linkedList, ArrayList<String> arrayList) {
        // write your code here
        String first_l = linkedList.getFirst();
        String last_l = linkedList.getLast();
        String first_a = arrayList.get(0);
        String last_a = arrayList.get(arrayList.size()-1);

        linkedList.set(0, first_a);
        linkedList.set(linkedList.size()-1, last_a);
        arrayList.set(0, first_l);
        arrayList.set(arrayList.size() - 1, last_l);
    }
}