package chapter1_exercise1to500.section1_exercise1to50;

public class Ex9_PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int reverse = 0;
        int y = x;
        while (y != 0) {
            int r = y % 10;
            reverse = reverse * 10 + r;
            y = y / 10;
        }
        return reverse == x;
    }
}
