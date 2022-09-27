public class Palindrome {
    public static boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--) {
            builder.append(s.charAt(i));
        }
        return builder.toString().equals(s);
    }
}
