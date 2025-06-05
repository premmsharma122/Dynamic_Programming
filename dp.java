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
    public static void main(String[] args) {
        int n=5;
        int f[] = new int[n+1];
        // System.out.println(fib(n, f));
        // System.out.println(climbways(5));
        int ways[ ] = new int[n+1];
        Arrays.fill(ways, -1);
        // System.out.println(climbwaysMemo(n, ways));
        System.out.println(climbwaysTab(n));
    }
}
