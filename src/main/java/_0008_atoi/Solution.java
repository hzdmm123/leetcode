package _0008_atoi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hzdmm123
 */
public class Solution {

    class AutoMaton {
        final String START = "start";
        final String SINGED = "signed";
        final String IN_NUM = "in_number";
        final String END = "end";
        String state = START;

        Map<String, String[]> map;
        public int sign = 1;
        public long ans = 0;

        public AutoMaton() {
            map = new HashMap<>();
            map.put(START, new String[]{START, SINGED, IN_NUM, END});
            map.put(SINGED, new String[]{END, END, IN_NUM, END});
            map.put(IN_NUM, new String[]{END, END, IN_NUM, END});
            map.put(END, new String[]{END, END, END, END});
        }

        public int getCol(char c) {
            if (c == ' ') {
                return 0;
            }

            if (c == '+' || c == '-') {
                return 1;
            }

            if (c >= '0' && c <= '9') {
                return 2;
            }

            return 3;
        }

        public void get(char c) {
            state = map.get(state)[getCol(c)];
            if (state.equals(IN_NUM)) {
                ans = ans * 10 + c - '0';
                if (sign == 1) {
                    ans = Math.min(ans, Integer.MAX_VALUE);
                } else {
                    ans = Math.min(ans, -(long) Integer.MIN_VALUE);
                }
            } else if (state.equals(SINGED)) {
                sign = c == '+' ? 1 : -1;
            }
        }
    }

    public int myAtoi(String str) {
        AutoMaton autoMaton = new AutoMaton();
        char[] c = str.toCharArray();
        for (char ch : c) {
            autoMaton.get(ch);
        }

        return autoMaton.sign * ((int) autoMaton.ans);
    }
}
