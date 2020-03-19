package chapter1_exercise1to500.section1_exercise1to50;

public class Ex6_ZigZagConversion_2 {
    public String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = numRows; i > 0; i--) {
            int next = numRows - i;
            boolean down = true;
            while (next < s.length()) {
                builder.append(s.charAt(next));
                if (1 < i && i < numRows) {
                    if (down) {
                        next += (i - 1) * 2;
                    } else {
                        next += (numRows - i) * 2;
                    }
                    down = !down;

                } else {
                    next += (numRows - 1) * 2;
                }
            }
        }

        return builder.toString();
    }
}
