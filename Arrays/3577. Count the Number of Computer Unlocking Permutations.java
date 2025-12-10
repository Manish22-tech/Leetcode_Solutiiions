class Solution {
    public int countPermutations(int[] complexity) {
       long MOD = 1_000_000_007L;
      int n = complexity.length;
        // if any computer i>0 has complexity <= complexity[0], impossible
        for (int i = 1; i < n; ++i) {
            if (complexity[0] >= complexity[i]) return 0;
        }
        // compute (n-1)! % MOD
        long ans = 1;
        for (int i = 2; i <= n - 1; ++i) {
            ans = (ans * i) % MOD;
        }
        // if n==1, product loop doesn't run; answer should be 1 (only permutation [0])
        return (int) ans;  
    }
}
