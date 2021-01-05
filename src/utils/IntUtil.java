package utils;

public class IntUtil {
    public static boolean isInteger(String str) {
    	boolean isNum = str.matches("[1-9]+"); 
    	return isNum;
    }
}
