package homeWork4;

public class String3 {

    static public int countYZ(String str) {
        str = str.toLowerCase();
        char[] chars = str.toCharArray();
        int result = 0;

        for (int i = 0; i < chars.length; i++){
            if (chars[i] == 'y' || chars[i] == 'z'){
                if (i == chars.length - 1){
                    result++;
                } else if (i < chars.length - 1 && !Character.isLetter(chars[i + 1])){
                        result++;
                }
            }
        }
        return result;
    }

    static public boolean gHappy(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'g') {
                if (i > 0 && str.charAt(i-1) == 'g') {
                    continue;
                } else if (i < str.length()-1 && str.charAt(i+1) == 'g') {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(countYZ("fez day"));
        System.out.println(gHappy("xxggxx"));
    }
}
