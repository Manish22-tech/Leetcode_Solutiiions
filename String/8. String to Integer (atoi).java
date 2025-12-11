class Solution {
    public int myAtoi(String s) {
           if (s == null || s.isEmpty()) return 0;

    int i = 0, n = s.length();
    // Step 1: Skip leading whitespace
    while (i < n && s.charAt(i) == ' ') {
        i++;
    }

    // Step 2: Check for sign
    int sign = 1;
    if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
        sign = (s.charAt(i) == '-') ? -1 : 1;
        i++;
    }

    // Step 3: Convert digits to number
    long result = 0;
    while (i < n && Character.isDigit(s.charAt(i))) {
        result = result * 10 + (s.charAt(i) - '0');

        // Step 4: Clamp result if it goes out of 32-bit signed integer range
        if (sign == 1 && result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (sign == -1 && -result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        i++;
    }

    return (int) (sign * result);
    }
}
