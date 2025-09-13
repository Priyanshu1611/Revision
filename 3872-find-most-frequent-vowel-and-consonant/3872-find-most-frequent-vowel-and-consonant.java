class Solution {
    public int maxFreqSum(String s) {
       int hash[] = new int[26];
	       List<Integer> l = Arrays.asList('a'-'a','e'-'a','i'-'a','o'-'a','u'-'a');
	       for(int i = 0;i<s.length();i++) {
	    	   hash[s.charAt(i)-'a']++;
	       }
	       int a = 0;
	       for(int i = 0;i<l.size();i++) {
	    	   a = Math.max(a, hash[l.get(i)]);
	       }
	       int b = 0;
	       for(int i = 0;i<26;i++) {
	    	   if(l.contains(i)) {
	    		   continue;
	    	   }
	    	   b = Math.max(b, hash[i]);
	       }
	       return a+b;
    }
}