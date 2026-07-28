class Solution {
    public String smallestPalindrome(String s) {
        int len = s.length();
        int part = len/2;

        char[] chars = s.toCharArray();
        Arrays.sort(chars,0,part);

        for(int i =0 ;i< part;i++){
            chars[len -1 - i] = chars[i];
        }
        return new String(chars);
        
    }
}