class Solution {
    HashSet<String> hs = new HashSet<>();
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<>();
        if(p.length()>s.length())
            return list;

        permutation("",p);

        Iterator<String> itr = hs.iterator();
        while(itr.hasNext()){
            String word = itr.next();
            System.out.println(word);
            if(word.length() > s.length())
                continue;
            else if (s.indexOf(word)!=-1) {
                int begin = 0;
                while((s.indexOf(word,begin)!=-1)){
                    System.out.println("Found at "+s.indexOf(word,begin));
                    list.add(s.indexOf(word,begin));
                    begin = s.indexOf(word,begin)+1;
                }
            }
        }
        return list;
    }
    private void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) hs.add(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }
}