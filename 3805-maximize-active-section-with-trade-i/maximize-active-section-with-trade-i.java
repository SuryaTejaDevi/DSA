class Solution {
    public int maxActiveSectionsAfterTrade(String s) {

        int ones = 0;
        int prevZero = Integer.MIN_VALUE;
        int maxGain = 0;

        int i = 0;

        while (i < s.length()) {

            int j = i;

            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
            }

            int len = j - i;

            if (s.charAt(i) == '1') {
                ones += len;
            } else {
                maxGain = Math.max(maxGain, prevZero + len);
                prevZero = len;
            }

            i = j;
        }

        return ones + maxGain;
    }
}