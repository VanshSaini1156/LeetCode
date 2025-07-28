class Solution {
    //OPTIMISE APPROACH:4POINTER
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n-3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < n-2; j++) {
                if(j>(i+1) && nums[j] == nums[j-1]) continue;
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];//We cast just one of the integers 
                    //(e.g., nums[i]) to long to promote the entire expression to long.
                    if (sum < target) {
                        k++;
                    } else if (sum > target) {
                        l--;
                    } else {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        ans.add(temp);
                        k++;
                        l--;
                        while (k < l && nums[l] == nums[l + 1])
                            l--;
                        while (k < l && nums[k] == nums[k - 1])
                            k++;

                    }
                }
            }
        }
        return ans;
    }
}
//Tn = O(n^3 )
//Sc = O(m) m :No of unique quad
//Extra space is used to return the answer.

/*class Solution {
    //BRUTE FORCE APPROACH:4LOOPS->SORT->SET->ARRAYLIST
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                      long sum = nums[i] + nums[j];
                        sum += nums[k];
                        sum += nums[l];
                        if (sum == target) {
                           List<Integer> ans = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            Collections.sort(ans);
                            set.add(ans);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}
//Tn = O(n^4 )
//Sc = O(n^4)

class Solution {
    //BETTER APPROACH:HASHING
    public List<List<Integer>> fourSum(int[] nums, int target){
        int n = nums.length;
        Set<List<Integer>> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Integer> set = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    int fourth = target - (nums[i] + nums[j] + nums[k]);//ATTENTION! WE HAVE A TARGET NOT ALL SUM == 0 OKAY
                    if (set.contains(fourth)) {
                        List<Integer> ans = Arrays.asList(nums[i], nums[j], nums[k], fourth);
                        Collections.sort(ans);
                        st.add(ans);
                    }
                    set.add(nums[k]);
                }
            }
        }
        return new ArrayList<>(st);
    }
}
//Tn = O(n^3 * logk)
//Sc = O(n+m) m :No of unique quad


*/