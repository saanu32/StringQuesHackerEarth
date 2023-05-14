import java.io.BufferedReader;
import java.io.InputStreamReader;

class StringCompatibility {
    public static void main(String args[]) throws Exception {
        // BufferedReader for input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the first string
      //  String str1 = br.readLine();
        String str1 ="bba";         //"abaca";


        // Read the second string
       // String str2 = br.readLine();
        String str2 = "aaa";

        // Check compatibility
        boolean compatible = areStringsCompatible(str1, str2);

        // Print the result
        if (compatible) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static boolean areStringsCompatible(String str1, String str2) {
        // If the strings are equal, they are compatible
        if (str1.equals(str2)) {
            return true;
        }

        // If the lengths are different, they cannot be made equal
        if (str1.length() != str2.length()) {
            return false;
        }
     else{
         for(int i =0; i <str1.length(); i++){
             if(str1.charAt(i) > str2.charAt(i)){
                 return false;
             }
         }
        }
       return true;
    }
}
