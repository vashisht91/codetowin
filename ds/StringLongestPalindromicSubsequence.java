package ds;

public class StringLongestPalindromicSubsequence {

	public static void main(String[] args) {
		System.out.println(bruteLongestPalindromeSubseq("dsaf"));
		System.out.println(Integer.MIN_VALUE);
	}

	public static int bruteLongestPalindromeSubseq(String s) {
		return helper(s, 0, s.length() - 1);
	}

	public static int helper(String s, int left, int right) {
		
		if (s.length() == 0 || s == null || left < 0 || right > s.length() || left > right) {
			return 0;
		}

		if (left == right)
			return 1;

		if (s.charAt(left) == s.charAt(right)) {
			return 2 + helper(s, left+1, right-1);
		}

			return Math.max(helper(s, left+1, right), helper(s, left, right-1));
	}
}
