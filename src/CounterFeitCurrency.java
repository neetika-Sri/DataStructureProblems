import java.util.*;
import java.util.regex.Pattern;

public class CounterFeitCurrency {
    private static  final Map<String, Integer> denominations = createDenominationMap();
    private static final Pattern YEAR_PATTERN = Pattern.compile("^19\\d\\d$|^20[0|1][0-9]$");

    private static Map<String, Integer> createDenominationMap(){
        Map<String, Integer> denominations = new HashMap<>();
        denominations.put("10",10);
        denominations.put("20",20);
        denominations.put("50",50);
        denominations.put("100",100);
        denominations.put("200",200);
        denominations.put("500",500);
        denominations.put("1000",1000);
        return Collections.unmodifiableMap(denominations);
    }

    public static void main(String[] args) {
       // System.out.println(validateDistinctInUpper("ABA"));
       /* System.out.println(validateYears("19AA"));
        System.out.println(validateYears("1900"));
        System.out.println(validateYears("1999"));
        System.out.println(validateYears("2000"));
        System.out.println(validateYears("2028"));
        System.out.println(validateYears("19000000"));
        List<String> list = Arrays.asList("AVG190420T","QWER201850G","DRV1984500Y");
       // List<String> list = Arrays.asList("QWER201850G");
        System.out.println(counterFiet(list));*/
        System.out.println(isUpperCase('\u00ea'));
        System.out.println(isUpperCase('a'));
        System.out.println(isUpperCase('A'));

    }
    public static int counterFiet(List<String> serialNumber){
        return serialNumber.parallelStream()
                .map(c -> validCurrencyValue(c))
                .reduce(0, Integer::sum);
    }
    private static int validCurrencyValue(String serialNo){

        boolean valid = true;
        // length check - 10-12 character
        valid = valid && (serialNo.length() >= 10 && serialNo.length() <= 12);

        valid = valid && validateDistinctInUpper(serialNo.substring(0,3));

        valid = valid && validateYears(serialNo.substring(3,7));

        valid = valid && isUpperCase(serialNo.charAt(serialNo.length() - 1));

        return valid ?
                denominations.getOrDefault(serialNo.substring(7,serialNo.length() - 1),0)
                : 0;

    }
    private static boolean validateDistinctInUpper(String str){
        int checkPos = 0;
        for(int i = 0; i < str.length(); i++){
           if(!isUpperCase(str.charAt(i))){
               return false;
           }
           int bitAtPos = 1 << (str.charAt(i) - 'A');
           if((checkPos & bitAtPos) > 0){
               return false;
           }
           checkPos = checkPos | bitAtPos;
       }
        return true;
    }

    private static boolean validateYears(String year){
       /* String regex = "^19\\d\\d$|^20[0|1][0-9]$";
        return str.matches(regex);*/
        return YEAR_PATTERN.matcher(year).matches();
    }

    // validate UTF-8 characters only
    // e.g. - isUpperCase('\u00ea') returns false
    //        isUpperCase('a') returns false
    //        isUpperCase('A') returns true
    private static boolean isUpperCase(char c){
        return c >= 'A' && c <= 'Z';
    }


}
