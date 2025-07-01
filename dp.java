package Dynamic_Prog;

import java.util.Arrays;

public class dp {
    // Fibonaci code by DP -> Memoization method (Top To Bottom)
    public static int fib(int n, int f[]){
        if(n==0 || n==1){
            return n;
        }
        if(f[n] != 0){
            return f[n];
        }
        f[n] = fib(n-1, f) + fib(n-2, f);
        return f[n]; // Time Comp : O(N)
    }
    // Fibonaci code by DP -> Tabulation method (Bottom To Top)
    public static int fibTab(int n){
        int f[] = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        for(int i=2; i<=n; i++){
            f[i] = fib(-1, f) + fib(n-2, f);
        }
        return f[n]; // Time Comp : O(N)
    }
    // Climing Stairs -> Time Comp: Exponential -> O(2^N)
    public static int climbways(int n){
        if(n==0) return 1;
        if(n< 0) return 0;

        return climbways(n-1) + climbways(n-2);
    }
    // ClimBing Starirs by Memoization -> Time Comp: O(N)
    public static int climbwaysMemo(int n , int ways[]){
        if(n==0) return 1;
        if(n< 0) return 0;

        if(ways[n] != -1){
            return ways[n];
        }
        ways[n] = climbwaysMemo(n-1, ways) + climbwaysMemo(n-2, ways);
        return ways[n];
    }
    //Climbing Stairs By Tabulation -> Time Comp: O(N)
    public static int climbwaysTab(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        for(int i=1; i<=n; i++){
            if(i == 1 ){
                dp[i] = dp[i-1] +0;
            }else{
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
    }
    // Knapsack Question -> By Recrsion method
    public static int knapsack(int val[], int wt[], int w, int n){
        if(w ==0 || n == 0){
            return 0;
        }
        if(wt[n-1] <= w) { // valid condition
            //include
            int ans1 = val[n-1] + knapsack(val, wt, w-wt[n-1], n-1);
            //exclude
            int ans2 = knapsack(val, wt, w, n-1);
            return Math.max(ans1, ans2);
        }else{
            return knapsack(val, wt, w, n-1);
        }
    }
    // Knapsack By Memoization -> Time Comp: O(N)
    public static int knapsackMemo(int val[], int wt[], int w, int n, int dp[][]){
        if(w ==0 || n == 0){
            return 0;
        }
        if(dp[n][w] != -1){
            return dp[n][w];
        }
        if(wt[n-1] <= w) { // valid condition
            //include
            int ans1 = val[n-1] + knapsackMemo(val, wt, w-wt[n-1], n-1, dp);
            //exclude
            int ans2 = knapsackMemo(val, wt, w, n-1, dp);
            dp[n][w] =  Math.max(ans1, ans2);
            return dp[n][w];
        }else{
            dp[n][w] =  knapsackMemo(val, wt, w, n-1, dp);
            return dp[n][w];
        }
    }
    // Knapsack Code by Tabulation -> Time Com. : O(N)
    public static int knapsackTab(int val[], int wt[], int W){
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        for(int i=1; i<n+1; i++){
            for(int j=1; j<W+1; j++){
                int v = val[i-1]; // ith value
                int w = wt[i-1];  // ith wight
                if(w <= j){ // valid
                    int include = v + dp[i-1][j-w];
                    int exclude = dp[i-1][j];
                    dp[i][j] = Math.max(include, exclude);
                } else{ // invalid
                    int exclude = dp[i-1][j];
                    dp[i][j] = exclude;

                }
            }
        }
        return dp[n][W];
    }
    // UnBounded Knapsack Code ->
    public static int unboundedKnap(int val[], int wt[], int W, int dp[][]) {
    int n = val.length;

    for (int i = 1; i <= n; i++) {
        for (int j = 0; j <= W; j++) {
            if (j >= wt[i - 1]) {
                dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
            } else {
                dp[i][j] = dp[i - 1][j];
            }
        }
    }

    return dp[n][W];
}
    // Coin Change Question (Unbounded Knapsack)->
public static int coinChange(int coins[], int sum, int dp[][]){
    // Intilization
    for(int i=0; i<coins.length+1; i++){
        dp[i][0] = 1;
    }
    //code
    for(int i=1; i<coins.length+1; i++){
        for(int j=1; j<sum+1; j++){
            if(coins[i-1]<=j){ // valid / include
                dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
            }else{
                dp[i][j] = dp[i-1][j];
            }
        }
    }
    return dp[coins.length][sum];

}
     // Longest Comman Subsequence (Recursion Code)
    public static int lcs(String s1, String s2, int n, int m){
        if(n==0 || m == 0){
            return 0;
        }
        if(s1.charAt(n-1) == s2.charAt(m-1)){
            return lcs(s1,s2,n-1,m-1);
        }else{
            int ans1 = lcs(s1, s2, n-1, m);
            int ans2 = lcs(s1, s2, n, m-1);
            return Math.max(ans1,ans2);
        }
    }
     // Longest Comman Subsequence (Memoization Code)
    public static int memolcs(String s1, String s2, int n, int m, int dp[][]){
        if(n==0 || m == 0){
            return 0;
        }
        if(dp[n][m] != -1) return dp[n][m];
        if(s1.charAt(n-1) == s2.charAt(m-1)){
            return dp[nl][m] = memolcs(s1,s2,n-1,m-1,dp);
        }else{
            int ans1 = memolcs(s1, s2, n-1, m);
            int ans2 = memolcs(s1, s2, n, m-1);
            return dp[n][m] = Math.max(ans1,ans2);
        }
    }
    // Longest Comman Subsequence (Tabulation Code)
    public static int tablcs(String s1, String s2, int n, int m, int[][] dp) {
    for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= m; j++) {
            if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
            } else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }
    return dp[n][m];
}
    public int memolcss(String s1, String s2){
        int n=s1.length(), m = s2.length();
        int dp[][] = new int[n+1][m+1];
        int ans=0;
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                    ans = Math.max(ans, dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
     //Edit Distance (Memoization)
    public static int editDis(String s1, String s2){
        int n = s1.length(), m = s2.length();
        int dp[][] = new int[n+1][m+1];
        //Initilization...
        for(int i=0; i<n+1; i++){
            for(int j=0; j<m+1; j++){
                if(i==0){
                    dp[i][i] = j;
                }
                if(j==0){
                    dp[i][j] = i;
                }
            }
        }
         for(int i=0; i<n+1; i++){
            for(int j=0; j<m+1; j++){
                if(s1.charAt(i) == s2.charAt(j)){ // same characters
                    dp[i][j] = dp[i-1][j-1];
                }else{  // different characters
                    int add = dp[i][j-1]+1;
                    int del = dp[i-1][j]+1;
                    int rem = dp[i-1][j-1]+1;
                    dp[i][j] = Math.min(add, Math.min(del,rem));
                }
            }
        }
        return dp[n][m];
    }
   
    public static void main(String[] args) {
        int n=5;
        int f[] = new int[n+1];
        // System.out.println(fib(n, f));
        // System.out.println(climbways(5));
        int ways[ ] = new int[n+1];
        Arrays.fill(ways, -1);
        // System.out.println(climbwaysMemo(n, ways));
        // System.out.println(climbwaysTab(n));
        int w=7;
        int val[] = {15,14,10,45,30};
        int wt[] ={2,5,1,3,4};
        int dp[][] = new int[val.length+1][w+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j]= -1;
            }
        }
        // System.out.println("Tab "+knapsackTab( val, wt, w));
        System.out.println(unboundedKnap(val, wt, w, dp));
        //System.out.println(knapsack(val, wt, w, val.length));
        // System.out.println(knapsackMemo(val, wt, w, val.length, dp));
    }
}
