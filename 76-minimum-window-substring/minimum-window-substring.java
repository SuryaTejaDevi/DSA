class Solution {
    public String minWindow(String s, String t) {

        int[] need = new int[128];

        for(char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0;
        int missing = t.length();

        int ansLength = Integer.MAX_VALUE;
        int start = 0;

        for(int right = 0; right < s.length(); right++) {

            char curr = s.charAt(right);

            if(need[curr] > 0) {
                missing--;
            }

            need[curr]--;

            while(missing == 0) {

                if(right - left + 1 < ansLength) {
                    ansLength = right - left + 1;
                    start = left;
                }

                char remove = s.charAt(left);

                need[remove]++;

                if(need[remove] > 0) {
                    missing++;
                }

                left++;
            }
        }

        if(ansLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + ansLength);
    }
}