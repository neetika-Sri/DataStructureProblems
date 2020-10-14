import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FlattenMap {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        // Map is A -> {A1 -> {A2 -> 1 }, A11 -> 11}, B -> 2
        Map<String, String> subMap12 = new HashMap();
        subMap12.put("A2","1");
        Map<String, Object> subMap1 = new HashMap();
        subMap1.put("A1",subMap12);
        subMap1.put("A11","11");
        map.put("A",subMap1);
        map.put("B","2");

        Map<String,String> newMap = map.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> (String)e.getValue()));
        newMap.entrySet().forEach(System.out::println);

    }
}
