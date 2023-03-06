package homeWork4;

public class String1 {

    static public String helloName(String name) {
        return "Hellow " + name + "!";
    }

    static public String minCat(String a, String b) {
        if (a.length() > b.length()){
            return a.substring(a.length() - b.length()) + b;
        } else {
            return a + b.substring(b.length() - a.length());
        }
    }

    static public String right2(String str) {
        return str.substring(str.length() - 2) + str.substring(0, str.length() - 2);
    }

    static public String without2(String str) {
        if (str.substring(0, 2).equals(str.substring(str.length() - 2))){
            return str.substring(2);
        }else {
            return str;
        }
    }

    static public String lastTwo(String str) {
        if (str.length() < 2) {
            return str;
        } else {
            char last = str.charAt(str.length() - 1);
            char secondLast = str.charAt(str.length() - 2);
            return str.substring(0, str.length() - 2) + last + secondLast;
        }
    }

    static public String extraEnd(String str) {
        String end = str.substring(str.length() - 2);
        return end + end + end;
    }

    static public String twoChar(String str, int index) {
        if (index + 2 <= str.length()){
            return str.substring(index, index + 2);
        }else {
            return str.substring(0, 2);
        }
    }

    static public String firstTwo(String str) {
        if (str.length() >= 2){
            return str.substring(0, 2);
        } else {
            return str;
        }
    }

    static public String extraFront(String str) {
        if (str.length() >= 2) {
            String front = str.substring(0, 2);
            return front + front + front;
        } else {
            return str + str + str;
        }
    }

    static public String atFirst(String str) {
        if (str.length() >= 2){
            return str.substring(0, 2);
        } else if (str.length() >= 1){
            return str.charAt(0) + "@";
        } else {
            return "@" + "@";
        }
    }

    public static void main(String[] args) {
        System.out.println(helloName("Andrey"));
        System.out.println(minCat("Hi", "Hello"));
        System.out.println(right2("Hello"));
        System.out.println(without2("HelloHe"));
        System.out.println(lastTwo("HelloHe"));
        System.out.println(extraEnd("HelloHe"));
        System.out.println(twoChar("Hello", 3));
        System.out.println(firstTwo("Hello"));
        System.out.println(extraFront("Hello"));
        System.out.println(atFirst("Hello"));
    }
}
