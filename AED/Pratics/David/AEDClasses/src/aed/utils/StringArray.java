package aed.utils;

public class StringArray {
    public static String[] add(String newString, String... array) {
        String[] newArray = new String[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = newString;
        return newArray;
    }
}
