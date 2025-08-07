class Solution {
     //BRUTE FORCE APPROACH:USING(StringBuilder)
    public String reverseWords(String s) {
        String[] S = s.trim().split("\\s+");
        StringBuilder b = new StringBuilder();
        int n = S.length;
        for (int i = n - 1; i >= 0; i--) {
            b.append(S[i]).append(" ");
        }
        return b.toString().trim();
     //This second .trim() is used to remove that extra trailing space introduced by append(" ") after the last word.
    }
}
//Tn = O(n)
//Sc = O(n)

/*
class Solution {
    //BRUTE FORCE APPROACH:USING(String array)
    private void swap(String[] s, int i, int j) {
        //In Java, String[] s defines a String array — an array where each element is a String.
        String ch = s[i];
        s[i] = s[j];
        s[j] = ch;
    }

    public String reverseWords(String s) {
        String[] S = s.trim().split("\\s+");
        int n = S.length;
        for (int i = 0; i < n / 2; i++) {
            swap(S, i, n - 1 - i);
        }
        return String.join(" ", S);//Merges the array back into a single space-separated string.
    }
}
//Tn = O(n)
//Sc = O(n)
*/
