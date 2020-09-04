package ds;
import java.util.*;

public class StringMostCommonWord {

	public static void main(String[] args) {
		String paragraph = "a, a, a, a, b,b,b,c, c";
		String[] banned = {"a"};
		System.out.println(mostCommonWord(paragraph, banned));
		
	}

	public static String mostCommonWord(String paragraph, String[] banned) {
        String paragraph1 = paragraph.replaceAll("[!?';.,']", " ");
        String[] para = paragraph1.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
		Map<String, Integer> map = new HashMap<>();
		String word = "";
		int count = 0;

		for (String s : para) {
			boolean match = false;
			for (String t : banned) {
				if (t.equalsIgnoreCase(s)) {
					match = true;
					break;
				}
			}
			if (match)
				continue;
			else {
				map.put(s, map.getOrDefault(s, 0) + 1);

				if (map.get(s) > count) {
					word = s;
					count = map.get(s);
				}
			}
		}
		return word;

	}

}
