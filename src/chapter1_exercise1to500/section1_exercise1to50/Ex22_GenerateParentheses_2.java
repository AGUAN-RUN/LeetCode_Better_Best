package chapter1_exercise1to500.section1_exercise1to50;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex22_GenerateParentheses_2 {
    List<String> resultList = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        backTracking(0, 0, n,sb);
        return resultList;
    }

    private void backTracking(int left, int right, int max, StringBuilder sb) {
        if (left + right == max * 2) {
            resultList.add(sb.toString());
            return;
        }
        if (left < max) {
            sb.append("(");
            backTracking(left + 1, right, max, sb);
            sb.deleteCharAt(sb.length() -1);
        }
        if (right < left) {
            sb.append(")");
            backTracking(left, right + 1, max, sb);
            sb.deleteCharAt(sb.length() -1);
        }
    }
}
