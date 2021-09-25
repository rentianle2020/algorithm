package 代码随想录.字符串;

public class 剑指offer05 {

    /**
     * 空格替换%20
     */
    public String replaceSpace(String s) {

        int blankCount = 0;
        int originalLength = s.length();

        for (int i = 0; i < originalLength; i++) {
            if(s.charAt(i) == ' '){
                blankCount++;
            }
        }

        int newLength = originalLength + blankCount * 2;
        char[] chars = new char[newLength];

        int oldIndex = 0;
        int newIndex = 0;

        while(oldIndex < originalLength){
            if(s.charAt(oldIndex) == ' '){
                chars[newIndex++] = '%';
                chars[newIndex++] = '2';
                chars[newIndex++] = '0';
                oldIndex++;
            }else{
                chars[newIndex++] = s.charAt(oldIndex++);
            }
        }
        return new String(chars);

    }
}
