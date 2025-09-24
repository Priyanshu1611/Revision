class Solution {
    public String fractionToDecimal(int n, int d) {
        if (n == 0) return "0";

        StringBuilder result = new StringBuilder();
        // Handle sign
        if ((n < 0) ^ (d < 0)) result.append("-");

        long numerator = Math.abs((long)n);
        long denominator = Math.abs((long)d);

        // Integer part
        result.append(numerator / denominator);
        long remainder = numerator % denominator;

        if (remainder == 0) return result.toString();

        result.append(".");
        Map<Long, Integer> map = new HashMap<>();
        StringBuilder frac = new StringBuilder();

        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                int idx = map.get(remainder);
                frac.insert(idx, "(");
                frac.append(")");
                result.append(frac.toString());
                return result.toString();
            }
            map.put(remainder, frac.length());
            remainder *= 10;
            frac.append(remainder / denominator);
            remainder %= denominator;
        }

        result.append(frac.toString());
        return result.toString();
    }
}
