package 剑指50_第一个只出现一次的字符_哈希表;

import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class Solution {

    // LinkedHashMap的优化
    public char firstUniqChar4(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            // 用是否已经在哈希表里作为值
            dic.put(c, !dic.containsKey(c));
        for(Map.Entry<Character, Boolean> d : dic.entrySet()){
            if(d.getValue()) return d.getKey();
        }
        return ' ';
    }


    // HashMap插入和读取无序， LinkedHashMap有序
    public char firstUniqChar2(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        if (s.length() == 0){
            return ' ';
        }
        for (int i =0;i<s.length();i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                int cur = map.get(s.charAt(i)) + 1;
                map.put(s.charAt(i), cur);
            }
        }

        // 建立迭代器来遍历HashMap
        Iterator<Character> keys = map.keySet().iterator();
        while (keys.hasNext()) {
            Character key = keys.next();
            Integer value = map.get(key);
            if (value == 1){
                return key;
            }
        }

            return ' ';
    }

    //用bool的哈希表，为什么这样就有序？因为遍历是按照字符串遍历的
    public char firstUniqChar3(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(char c : sc)
            if(dic.get(c)) return c;
        return ' ';
    }



    // HashSet获取元素的时候是无序的(好像是按照编码顺序)，这样取出来不一定是第一个
    public char firstUniqChar(String s) {
        HashSet<Character> charSet = new HashSet<>();

        if (s.length() == 0){
            return ' ';
        }

        for (int i =0;i<s.length();i++){
            if (!charSet.add(s.charAt(i))){
                charSet.remove(s.charAt(i));
            }
        }

        if (charSet.size() == 0){
            return ' ';
        }else {
            //Character[] newText = (Character[])charSet.toArray(new Character[0]);
            return charSet.toArray(new Character[0])[0];
        }

    }

    public static void main(String[] args){
        Solution s = new Solution();
        String ss = "ddddbdadddc";

        System.out.println(s.firstUniqChar3(ss));
    }
}
