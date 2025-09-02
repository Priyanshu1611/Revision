class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] hash = new int[256]; // ASCII map
        int i = 0, j = 0, max = 0;

        while (j < n) {
            char c = s.charAt(j);
            hash[c]++;

            while (hash[c] > 1) { // shrink window if duplicate found
                hash[s.charAt(i)]--;
                i++;
            }

            max = Math.max(max, j - i + 1);
            j++;
        }

        return max;
    }
}
