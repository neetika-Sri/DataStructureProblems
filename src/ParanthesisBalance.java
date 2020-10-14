import java.util.Stack;

public class ParanthesisBalance {
    /*

Input: 3[a]bc4[d]
output : aaabcdddd

Input: abc3[ab4[d]]
ouput: abcabddddabddddabdddd
*/

    /*

    3[a]bc4[d]

    Stack : 3a
    Prev: 3
    StringBuffer a = a multply(str, 3) => aaa
        output = aaa
    */
        public static void main(String[] args){
         //String st = flattenString("abc3[ab4[d]]");
         //String st = flattenString("3[a]bc4[d]");
         String st = flattenString("yyyy3[abc");
            System.out.println(st);


        }
        private static boolean isDigit(String c){

            return (c.length() == 1) && c.charAt(0) >= '0' && c.charAt(0) <= '9';
        }

        private static String multiply(String s, int n){
            String temp = "";
            for(int i = 0 ; i < n; i++){
                temp = temp + s;
            }
            return temp;
        }
        public static String flattenString(String input){
            Stack<String> st = new Stack<String>();
            StringBuffer out = new StringBuffer();
            int i = 0;
            while(i < input.length()){
                if(isDigit(String.valueOf(input.charAt(i)))){
                    st.push(String.valueOf(input.charAt(i)));
                    i++;

                }
                else if(!st.isEmpty()){
                    if(input.charAt(i) == ']'){
                        StringBuilder temp = new StringBuilder();
                        while(!st.isEmpty()  &&  !isDigit(st.peek())){
                            temp.insert(0, st.pop());
                        }
                        int n = Integer.parseInt(st.pop());
                        String s = multiply(temp.toString(), n);
                        if(st.isEmpty()){
                            out.append(s);
                        }
                        else {
                            st.push(s);
                        }

                    }
                    else {
                        st.push(String.valueOf(input.charAt(i)));
                    }
                }
                else {
                    out.append(input.charAt(i));
                }
                i++;

            }
//            while(!st.isEmpty()){
//                String temp = "";
//                while(!st.isEmpty()  &&  !isDigit(st.peek())){
//                    temp = st.pop() + temp;
//                }
//                int n = Integer.parseInt(st.pop());
//                String s = multiply(temp, n);
//                out.append(s);
//            }
            return out.toString();
        }
    }

