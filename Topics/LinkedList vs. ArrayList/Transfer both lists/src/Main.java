import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

class ListOperations {
    public static void transferAllElements(LinkedList<String> linkedList, ArrayList<String> arrayList) {
        // write your code here
        int size = arrayList.size();
        while (size > 0) {
            arrayList.add(linkedList.removeFirst());
            linkedList.addLast(arrayList.remove(0));
            size--;
        }
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "b");
        map.put("b", "b");
        Set<String> set = map.keySet();
        System.out.println(set);

        Collection<String> values = map.values();
        System.out.println(values);

        Set<Map.Entry<String, String>> entries = map.entrySet();
        System.out.println(entries);

        Set<String> a = Set.of("a", "b", "c");
        Map<Object, Object> of = Map.of("a", a);
        System.out.println(of);
    }
}
