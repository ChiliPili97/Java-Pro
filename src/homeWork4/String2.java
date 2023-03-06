package homeWork4;

public class String2 {

    static public String doubleChar(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            result.append(c);
            result.append(c);
        }
        return result.toString();
    }

    //It looks ugly, but I can't think of anything better
    static public boolean bobThere(String str) {
        if (str.length() >= 3){
            if (str.contains("b")){
                return str.charAt(str.indexOf("b") + 2) == 'b';
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    static public String mixString(String a, String b) {
        StringBuilder result = new StringBuilder();
        String shorterStr = "";
        String longerStr = "";

        if (a.length() > b.length()){
            shorterStr = b;
            longerStr = a;
        } else {
            shorterStr = a;
            longerStr = b;
        }

        for (int i = 0; i < shorterStr.length(); i++){
            result.append(a.charAt(i));
            result.append(b.charAt(i));
        }
        result.append(longerStr.substring(shorterStr.length()));
        return result.toString();
    }

    static public boolean prefixAgain(String str, int n) {
        String prefix = str.substring(0, n);
        String withoutPrefix = str.substring(n);
        return withoutPrefix.contains(prefix);
    }

    static public boolean endOther(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        if (a.length() > b.length()){
            return b.equals(a.substring(a.length() - b.length()));
        } else {
            return a.equals(b.substring(b.length() - a.length()));
        }
    }

    public static void main(String[] args) {
        //System.out.println(doubleChar("Hello"));
        //System.out.println(bobThere(""));
        //System.out.println(mixString("Hi", "There"));
        //System.out.println(prefixAgain("abXYabc", 2));
        //System.out.println(endOther("AbC", "HiaBc"));
    }
}
