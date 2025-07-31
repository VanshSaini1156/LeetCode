class Solution {
    //OPTIMAL APPROACH:PREFIX-SUFFIX
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int pref = 1;
        int suff = 1;
        int Max = Integer.MIN_VALUE;
        for(int i = 0; i<n;i++){
            if(pref == 0) pref = 1;
            if(suff == 0) suff = 1;
            pref  *= nums[i];
            suff  *= nums[n-i-1];
            Max = Math.max(Max,Math.max(pref,suff));
        }
        return Max;
    }
}
//Tc = O(n)
//Sc = O(1)

/*class Solution {
    //BRUTE FORCE APPROACH:2 Loops
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if( n == 1) return nums[0];
        long productM = 0;
        for (int i = 0; i <n; i++) {
            long product = 1;
            for (int j = i; j <n; j++) {
            product *= nums[j];
            productM = Math.max(productM,product);
            }   
        }
        return (int)productM;
    }
}
//Tc = O(n^2)
//Sc = O(1)*/