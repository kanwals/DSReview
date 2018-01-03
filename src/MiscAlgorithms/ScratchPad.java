package MiscAlgorithms;

import java.util.*;

public class ScratchPad {
    public int calculate(String s) {
        int len;
        if(s==null || (len = s.length())==0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for(int i=0;i<len;i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10+s.charAt(i)-'0';
            }
            if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
                if(sign=='-'){
                    stack.push(-num);
                }
                if(sign=='+'){
                    stack.push(num);
                }
                if(sign=='*'){
                    stack.push(stack.pop()*num);
                }
                if(sign=='/'){
                    stack.push(stack.pop()/num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int re = 0;
        for(int i:stack){
            re += i;
        }
        return re;
    }

    List<String> anagrams (String input){
        char[] inp = input.toCharArray();
        List<String> result = new ArrayList();
        backtrack(inp,result,inp.length,"");
        return result;
    }
    void backtrack(char[] input,List result,final int size,String str) {
        if(str.length()==size){  // or can be input.length
            result.add(new String(str));
        }
        else{
            for(int i =0 ;i<input.length;i++){
                if(str.contains(""+input[i])){
                    continue;
                }
                String newStr = str + input[i];
                System.out.println(newStr);
                backtrack(input,result,size,newStr);
            }
        }
    }

    List<String> casePermutations(String s){
        char[] chars = s.toCharArray();
        List<String> list = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        permute(chars, list, sb, 0);
        return list;
    }

    void permute(char[] s, List<String> list, StringBuilder sb, int start){
        if(sb.length()>s.length) return;
        if(sb.length()==s.length){
            list.add(sb.toString());
            return;
        }
        for(int i=start; i<s.length; i++){
            for(int j=0; j<=1; j++){
                sb.append((char)(s[i]-j*32));
                permute(s,list,sb,i+1);
                sb.setLength(sb.length()-1);
            }
        }
    }
    public String minWindow(String s, String t) {
        if(t.length()> s.length()) return "";
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        int counter = map.size();

        int begin = 0, end = 0;
        int head = 0;
        int len = Integer.MAX_VALUE;

        while(end < s.length()){
            char c = s.charAt(end);
            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) counter--;
            }
            end++;

            while(counter == 0){
                char tempc = s.charAt(begin);
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);
                    if(map.get(tempc) > 0){
                        counter++;
                    }
                }
                if(end-begin < len){
                    len = end - begin;
                    head = begin;
                }
                begin++;
            }

        }
        if(len == Integer.MAX_VALUE) return "";
        return s.substring(head, head+len);
    }

    public boolean wordBreak(String s, List<String> dict) {

        boolean[] f = new boolean[s.length() + 1];

        f[0] = true;

        //Second DP
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }

        System.out.println(f[s.length()]);
        return f[s.length()];
    }

    boolean oneOrZeroEditAway(String s1, String s2){
        if(Math.abs(s1.length()-s2.length())>1) return false;
        int edits = 0;

        if(oneCharRemovedOrAdded(s1, s2))
            edits++;

        if(oneCharReplaced(s1, s2))
            edits++;

        return edits<2;

    }

    boolean oneCharRemovedOrAdded(String s1, String s2){
        if(s1.length()==s2.length()) return false;
        int mismatch = 0;
        boolean s1LargerThanS2 = s1.length()>s2.length();
        for(int i=0, j=0; i<s1.length() && j<s2.length(); i++, j++){
            if(s1.charAt(i) != s2.charAt(j)){
                if(s1LargerThanS2)
                    i++;
                else
                    j++;

                mismatch++;
                if(mismatch>1)
                    return false;
            }
        }
        return mismatch==1;
    }

    boolean oneCharReplaced(String s1, String s2){
        if(s1.length()!=s2.length())
            return false;
        int mismatch = 0;
        for(int i=0, j=0; i<s1.length() && j<s2.length(); i++, j++){
            if(s1.charAt(i) != s2.charAt(j)){
                mismatch++;
                if(mismatch>1)
                    return false;
            }
        }
        return mismatch==1;
    }
    public static void main(String[] args) {
        ScratchPad scratchPad = new ScratchPad();
//        scratchPad.wordBreak("leetcode", new ArrayList<>(Arrays.asList("leet","co","de")));
        System.out.println(scratchPad.oneOrZeroEditAway("pale","ppple"));
    }
}
