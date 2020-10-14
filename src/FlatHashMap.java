import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FlatHashMap {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();
        Map<String, Object> map3 = new HashMap<>();
        map3.put("G","GG");
        map2.put("D","DD");
        map2.put("F","FF");
        map2.put("E",map3);

        map.put("A","A");
        map.put("C","C");
        map.put("B",map2);

        flattenMap(map).entrySet().forEach(System.out::println);
    }
     public static Map<String, String> flattenMap(Map<String, Object> input){
        Map<String, String> flattenMap = new HashMap<>();
       // DFS(input,"",flattenMap);
         BFS(input,flattenMap);
        return flattenMap;

     }
     private static void DFS(Map<String,Object> input, String pre, Map<String, String> output){
        if(input == null)
            return;
        for(String k : input.keySet()){
            if(input.get(k) instanceof String){
                output.put(pre + k, (String)input.get(k));
            }
            else if(input.get(k) instanceof Map){
                DFS((HashMap<String, Object>) input.get(k), pre + k + ".", output);
            }

        }

     }
     private static void BFS(Map<String,Object> input, Map<String, String> output){
         Queue<PrefixAndMap> queue = new LinkedList<>();
         PrefixAndMap st = new PrefixAndMap(input, "");
         queue.add(st);
         while(!queue.isEmpty()){
             PrefixAndMap elem = queue.poll();
             Map<String, Object> map = elem.map;
             if(map != null){

                 for(String k : map.keySet()) {
                     if(map.get(k) instanceof String){
                         output.put(elem.pre + k, (String)map.get(k));
                     }
                     else if(map.get(k) instanceof Map){
                         queue.add(new PrefixAndMap((Map<String, Object>)map.get(k),elem.pre + k +"."));
                     }
                 }
             }
         }
     }
}
class PrefixAndMap{
    String pre;
    Map<String, Object> map;

    public PrefixAndMap(Map<String, Object> map, String pre) {
        this.map = map;
        this.pre = pre;
    }
}
