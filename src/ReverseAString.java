import javax.xml.soap.SOAPPart;

public class ReverseAString {
    public static void main(String[] args) {
        String inp = " SOmeString ";

        char[] chars = inp.toCharArray();
        int i = 0;
        int j = chars.length -1;
        while(i < j){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }

        System.out.println(new String(chars));

    }
}
