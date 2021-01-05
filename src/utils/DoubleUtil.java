package utils;

public class DoubleUtil {
    public static boolean isDouble(String str) {
    	boolean isNum = str.matches("[0-9]+\\.[0-9]+"); 
    	return isNum;
    }
}
