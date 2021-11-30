package 周赛;

public class LeetCode5923 {

    public int minimumBuckets(String street) {
        char[] chars = street.toCharArray();
        boolean[] cover = new boolean[chars.length];
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (cover[i]) continue;
            if (chars[i] == 'H') {
                if ((i - 1 < 0 || chars[i - 1] == 'H') && (i + 1 >= chars.length || chars[i + 1] == 'H')) return -1;

                if (i + 2 < chars.length && chars[i + 1] == '.' && chars[i + 2] == 'H') {
                    cover[i + 2] = true;
                    count++;
                } else if ((i - 1 >= 0 && chars[i - 1] == '.') || i + 1 < chars.length && chars[i + 1] == '.') {
                    count++;
                }
            }
        }
        return count;
    }
}
