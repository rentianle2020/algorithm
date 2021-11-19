package 学习;

/**
 * 串 蛮力算法
 */
public class BruteForce {

    public static void main(String[] args) {
        System.out.println(new BruteForce().indexOf1("aabaaf", "aaf"));
    }


    public int indexOf1(String text, String pattern){
        char[] tSequence = text.toCharArray();
        char[] pSequence = pattern.toCharArray();

        int tLength = tSequence.length;
        int pLength = pSequence.length;
        int pi = 0,ti = 0;
        if(tLength < pLength) return -1;

        while(pi < pLength && tLength - ti >= pLength - pi) {
            if(tSequence[ti] == pSequence[pi]){
                ti++;
                pi++;
            }else{
                ti = ti - pi + 1;
                pi = 0;
            }
        }

        if(pi == pLength) return ti-pLength;
        return -1;
    }

    /**
     * 在文本串中找到模式串，返回起始下标
     */
    public int indexOf2(String text, String pattern){
        char[] tSequence = text.toCharArray();
        char[] pSequence = pattern.toCharArray();

        int tLength = tSequence.length;
        int pLength = pSequence.length;
        int end;

        if(tLength < pLength){
            return -1;
        }else{
            end = tLength - pLength;
        }

        for (int i = 0; i <= end; i++) {
            int j = 0;
            for (; j < pLength; j++) {
                if(pSequence[j] != tSequence[i + j]) break; //不相等直接进入下一轮
            }
            if(j == pLength) return i; //判断一下这一轮，有没有完全匹配，完全匹配则不再i++进入下一轮，直接返回
        }
        return -1;
    }
}
