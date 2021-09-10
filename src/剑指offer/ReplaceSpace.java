package 剑指offer;

/**
 * 剑指offer 05
 */
public class ReplaceSpace {

    public static void main(String[] args) {
        String s = new ReplaceSpace().replaceSpace("123 456 778");
        System.out.println(s);
    }

    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        int oldLength = chars.length;
        int newLength = chars.length;
        for (char aChar : chars) {
            if(aChar == ' '){
                newLength += 2;
            }
        }
        char[] newChar = new char[newLength];
        for (int i =  oldLength - 1; i >= 0; i--) {
            if (chars[i] == ' '){
                newChar[--newLength] = '0';
                newChar[--newLength] = '2';
                newChar[--newLength] = '%';
            }else{
                newChar[--newLength] = chars[i];
            }
        }
        return String.valueOf(newChar);
    }
}
