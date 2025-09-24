import java.util.*;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder sb = new StringBuilder();

        // Handle sign correctly
        if ((numerator < 0) ^ (denominator < 0)) {
            sb.append("-");
        }

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Integer part
        sb.append(num / den);
        long rem = num % den;

        // If no remainder, return
        if (rem == 0) return sb.toString();

        sb.append(".");

        // Map remainder → position in sb
        Map<Long, Integer> map = new HashMap<>();

        while (rem != 0) {
            // If we have seen this remainder before, it's a repeat
            if (map.containsKey(rem)) {
                int pos = map.get(rem);
                sb.insert(pos, "(");
                sb.append(")");
                break;
            }

            // Store remainder with current index
            map.put(rem, sb.length());

            rem *= 10;
            sb.append(rem / den);
            rem = rem % den;
        }

        return sb.toString();
    }
}

