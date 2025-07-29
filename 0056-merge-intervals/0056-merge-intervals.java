class Solution {
    //OPTIMISE APPROACH :Way 02
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();
        //Single Iteration->
        for (int[] interval : intervals) {
            if (ans.isEmpty() || interval[0] > ans.get(ans.size() - 1)[1]) {
                ans.add(interval);
            } else {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], interval[1]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
//Tc = O(Nlogn)
//Sc = O(N)

/*class Solution {
    //BRUTE FORCE APPROACH:Way 01
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1))
                continue;
            for (int j = i + 1; j < n; j++) {
                if (intervals[j][0] <= end) {
                    end = Math.max(end, intervals[j][1]);
                } else {
                    break;
                }
            }
            ans.add(Arrays.asList(start, end));
        }
        int[][] temp = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            temp[i][0] = ans.get(i).get(0);
            temp[i][1] = ans.get(i).get(1);

        }
        return temp;
    }
}
//Tn = O(N log N + N^2) = O(N^2)
//Sc = O(N)*/