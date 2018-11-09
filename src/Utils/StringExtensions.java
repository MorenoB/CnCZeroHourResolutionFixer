package Utils;

/**
 * Coming from a C# background I always made some extension classes however Java does not support proper extensions.
 * @author M Bralts
 */
public class StringExtensions {

    /**
     * Checks whether a string is considered to be an integer
     * https://stackoverflow.com/questions/237159/whats-the-best-way-to-check-if-a-string-represents-an-integer-in-java
     * @param str input string
     * @return true if the string is an integer; False otherwise.
     */
    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        if (str.isEmpty()) {
            return false;
        }
        int length = str.length();
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
    
    public static int ToInt(String str)
    {
        if(!isInteger(str))
            return -1;
        
        return Integer.parseInt(str);
    }
}
