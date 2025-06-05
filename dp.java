package Dynamic_Prog;

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
    // Climing Stairs 
    public static int climbways(int n){
        if(n==0) return 1;
        if(n< 0) return 0;

        return climbways(n-1) + climbways(n-2);
    }
    public static void main(String[] args) {
        int n=8;
        int f[] = new int[n+1];
        // System.out.println(fib(n, f));
        System.out.println(climbways(5));
    }
}
