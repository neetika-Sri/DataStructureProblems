import java.util.*;

public class topKFrequent {
    public static void main(String[] args) {
        fetchTopFrequentK(Arrays.asList("1","1","1","3","3","4","2","1","4","4","4"),2);

    }
    public static void fetchTopFrequentK(List<String> inp, int k){
        SortedSet<ValAndFreq> sortedSet = new TreeSet<ValAndFreq>((v1,v2) -> {
            if(v1.freq == v2.freq)
                return v2.val.compareTo(v1.val);
            return ((Integer)v2.freq).compareTo((Integer) v1.freq);
        });
        HashMap<String, Integer> freqMap = new HashMap<>();
        int i = 1;
        for(String a : inp){
            int currFreq = freqMap.getOrDefault(a,0);
            ValAndFreq curr = new ValAndFreq(a,currFreq);
            ValAndFreq newVal = new ValAndFreq(a,currFreq + 1);
            if(sortedSet.contains(curr)){
                sortedSet.remove(curr);
                sortedSet.add(newVal);
            }
            else if(sortedSet.size() == k && sortedSet.last().freq < (currFreq + 1)){
                ValAndFreq last =  sortedSet.last();
                sortedSet.remove(last);
                sortedSet.add(newVal);
            }
            else if(sortedSet.size() < k){
                sortedSet.add(newVal);
            }
            freqMap.put(a,currFreq + 1);
            System.out.print("At "+i++ + "  top "+k+" frequent values are ");
            sortedSet.forEach(s ->System.out.print(s.val + " "));
            System.out.println();
        }
    }

}
class ValAndFreq {
    String val;
    int freq;

    public ValAndFreq(String val, int freq) {
        this.val = val;
        this.freq = freq;
    }
}
