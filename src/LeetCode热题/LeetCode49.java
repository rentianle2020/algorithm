package LeetCode热题;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 49. 字母异位词分组
 */
public class LeetCode49 {

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String,List<String>> map = new HashMap<>();

        for (String str : strs) {

            char[] chars = str.toCharArray();

            Arrays.sort(chars);

            String key = Arrays.toString(chars);

            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }

            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());

    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        return new ArrayList<>(Stream.of(strs)
                .collect(Collectors.groupingBy(str -> {
                    int[] counter = new int[26];
                    for (int i = 0; i < str.length(); i++) {
                        counter[str.charAt(i) - 'a']++;
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < 26; i++) {
                        // 这里的 if 是可省略的，但是加上 if 以后，生成的 sb 更短，后续 groupingBy 会更快。
                        if (counter[i] != 0) {
                            sb.append((char) ('a' + i));
                            sb.append(counter[i]);
                        }
                    }
                    return sb.toString();
                })).values());
    }

}
