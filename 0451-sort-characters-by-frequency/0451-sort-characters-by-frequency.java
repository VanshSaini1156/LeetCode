class Solution {
    //BETTER APPROACH:HASHMAP+ARRAYLIST(Sorting)
    public String frequencySort(String s) {
        int n = s.length();
        StringBuilder b = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        List<Character> ans = new ArrayList<>(map.keySet());
        ans.sort((obj1, obj2) -> map.get(obj2) - map.get(obj1));//Sorting the array

        //You  We can absolutely use Collections.sort() instead of the lambda ans.sort(...),  because they're functionally similar.
        for (char ch : ans) {
            //"ans" tell us which char came first(means order of the char) but we again iterate the        map to take that particular char freq then put it into the SB.
            int freq = map.get(ch);
            for (int i = 0; i < freq; i++) {
                b.append(ch);
            }
        }
        return b.toString();
    }
}
//T(n) = O(n log k) → worst O(n log n)
//Sc = O(n)

//NOTE:-
//Collections.sort(ans);
//Then Java will use the default natural order of characters — which is ascending lexicographical (alphabetical) order.