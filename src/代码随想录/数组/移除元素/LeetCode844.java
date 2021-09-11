package 代码随想录.数组.移除元素;

/**
 * 844. 比较含退格的字符串
 */
public class LeetCode844 {

    public static void main(String[] args) {
        new LeetCode844().backspaceCompare("a#c","b");
    }

    public boolean backspaceCompare(String s, String t) {
        int sIndex = s.length() - 1;
        int tIndex = t.length() - 1;

        int sSkip = 0;
        int tSkip = 0;


        while(true){
            while(sIndex >= 0){
                if(s.charAt(sIndex) == '#'){
                    sSkip++;
                    sIndex--;
                }else if(sSkip > 0){
                    sSkip--;
                    sIndex--;
                }else{
                    break;
                }
            }
            while(tIndex >= 0){
                if(t.charAt(tIndex) == '#'){
                    tSkip++;
                    tIndex--;
                }else if(tSkip > 0){
                    tSkip--;
                    tIndex--;
                }else{
                    break;
                }
            }

            if(sIndex < 0 && tIndex < 0){ //都没得比了，true!
                return true;
            }else if(sIndex >= 0 && tIndex >= 0){
                if(s.charAt(sIndex) == t.charAt(tIndex)){ //都有的比，就比!
                    sIndex--;
                    tIndex--;
                }else{
                    return false;
                }
            }else{ //其中一个还能比，另一个已经没得比了，false!
                return false;
            }

            if(sIndex >= 0 && tIndex >= 0){ //下标都>=0就比较
                if(s.charAt(sIndex) == t.charAt(tIndex)){
                    sIndex--;
                    tIndex--;
                }else{
                    return false;
                }
            }else return sIndex < 0 && tIndex < 0; //否则必须都小于等于0
        }
    }
}
