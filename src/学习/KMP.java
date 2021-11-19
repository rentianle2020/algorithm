package 学习;

public class KMP {

    public static void main(String[] args) {
        System.out.println(new KMP().kmp("abbaacaeaaf", "aaf"));
    }

    /**
     * 利用了匹配成功的信息，避免重复匹配
     * 比如模式串aabaac，如果c匹配失败，可以立马把pi移动到b的位置继续匹配，不用重新匹配aa了
     */
    public int kmp(String text, String pattern){
        char[] tSequence = text.toCharArray();
        char[] pSequence = pattern.toCharArray();
        int[] next = next(pSequence);

        int tLength = tSequence.length;
        int pLength = pSequence.length;
        if(tLength < pLength) return -1;

        int pi = 0,ti = 0;
        while(pi < pLength && tLength - ti >= pLength - pi) {
            if(tSequence[ti] == pSequence[pi]){
                pi++;
                ti++;
            }else{
                if(pi > 0){
                    pi = next[pi - 1];
                }else{
                    ti++;
                }
            }
        }

        if(pi == pLength) return ti-pLength;
        return -1;
    }

    /**
     * 根据模式串创建一个next[]数组
     * 第0位冲突不管，其他位置的冲突了，就通过next[pi-1]，得到新的pi
     */
    private int[] next(char[] pSequence) {
        int frontEnd = 0;
        int[] next = new int[pSequence.length];
        for (int backEnd = 1; backEnd < next.length; backEnd++) {
            while(frontEnd > 0 && pSequence[frontEnd] != pSequence[backEnd]){
                frontEnd = next[frontEnd - 1];
            }
            if(pSequence[frontEnd] == pSequence[backEnd]) frontEnd++; //backEnd在这轮循环后也会自动++
            next[backEnd] = frontEnd;
        }
        return next;
    }
}
