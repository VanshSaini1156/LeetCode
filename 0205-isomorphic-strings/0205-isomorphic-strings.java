
class Solution {
    //OPTIMAL APPROACH:USING(HASHMAP)
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> Mapping = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char original = s.charAt(i);
            char replacement = t.charAt(i);
            if (!Mapping.containsKey(original)) {
                if (!Mapping.containsValue(replacement)) {
                    Mapping.put(original, replacement);
                } else {
                    return false;
                }
            } else {
                char MarkedCharacter = Mapping.get(original);
                //mapping.get(key) returns the value associated with that key.
                if (MarkedCharacter != replacement) {//we check here value of MarkedCharacter is same as replacement?
                    return false;
                }
            }
        }
        return true;
    }
}
//T(n) = O(n)
//Sc = O(1)

/*
lass Solution {
    //OPTIMAL APPROACH:USING(HASHMAP+HASHSET)
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n != m)
            return false;
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            char original = s.charAt(i);
            char replacement = t.charAt(i);
            if (map.containsKey(original)) {
                if (map.get(original) != replacement)
                    return false;
            } else {
                if (set.contains(replacement))
                    return false;
                map.put(original, replacement);
                set.add(replacement);
            }
        }
        return true;
    }
}
//T(n) = O(n)
//Sc = O(1)

class Solution {
    //BRUTE FORCE APPROACH:HIT & TRIAL
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (m != n)
            return false;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((s.charAt(i) == s.charAt(j)) != (t.charAt(i) == t.charAt(j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
//T(n) = O(n^2)
//Sc = O(1)

*/