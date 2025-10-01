class Solution {
    public int minScoreTriangulation(int[] values) {
    int n = values.length;
    int[][] dp = new int[n][n];

    // gap = length of interval
    for (int gap = 2; gap < n; gap++) {   
        for (int i = 0; i + gap < n; i++) {
            int j = i + gap;
            dp[i][j] = Integer.MAX_VALUE;

            
            for (int k = i + 1; k < j; k++) {
                int score = values[i] * values[k] * values[j]
                           + dp[i][k]
                           + dp[k][j];
                dp[i][j] = Math.min(dp[i][j], score);
            }
        }
    }

    return dp[0][n-1];
}

}