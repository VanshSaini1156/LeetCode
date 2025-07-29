
class Solution {
    //OPTIMAL APPROACH 01:(WITHOUT EXTRA SPACE)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1;
        int right = n - 1;
        int idxT = m + n - 1;//putiing a pointer nums1 array at last 
        while (left >= 0 && right >= 0) {
            if (nums1[left] > nums2[right]) {
               nums1[idxT--] = nums1[left--];
            } else {
                 nums1[idxT--] = nums2[right--];
            }
        }
        while (right >= 0) {
            nums1[idxT--] = nums2[right--];
        }
    }
}
//Tn = O(m + n)
//Sc = O(1)

/*class Solution {
    //BRUTE FORCE APPROACH:(Extra Time )
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = 0;
        int right = 0;
        int[] nums3 = new int[n + m];
        int index = 0;
        while (left < m && right < n) {
            if (nums1[left] <= nums2[right]) {
                nums3[index++] = nums1[left++];
            } else {
                nums3[index++] = nums2[right++];
            }
        }
        while (left < m) {
            nums3[index++] = nums1[left++];
        }
        while (right < n) {
            nums3[index++] = nums2[right++];
        }
        for (int i = 0; i < m + n; i++) {
            if (i < m) {
                nums1[i] = nums3[i];
            } else {
                nums2[i - m] = nums3[i];
            }
        }
        for (int i = 0; i < n + m; i++) {
            nums1[i] = nums3[i];
        }
    }
}
Tn = O(m + n)
Sc = O(m + n)due to nums3*/