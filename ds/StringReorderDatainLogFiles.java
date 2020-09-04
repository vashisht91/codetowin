package ds;

import java.util.*;
import java.util.regex.Pattern;

public class StringReorderDatainLogFiles {

	public static void main(String[] args) {
//		String[] banned = { "1 n u", "r 527", "j 893", "6 14", "6 82" };
		
		String[] banned = { "1 123 u", "r 527", "j 893", "6 14", "6 82" };
		
		System.out.println(reorderLogFiles(banned));
	}

	public static String[] reorderLogFiles(String[] logs) {

		Arrays.sort(logs, new Comparator<String>() {
			public int compare(String a, String b) {
				
				
				int idxA = a.indexOf(" ");
				int idxB = b.indexOf(" ");
				return a.charAt(idxA + 1) - b.charAt(idxB + 1) ;
				
				/*
				if (a.charAt(idxA + 1) <= '9') {
					if (b.charAt(idxB + 1) <= '9')
						return 0;
					else
						return 1;
				}
				if (b.charAt(idxB + 1) <= '9')
					return -1;

				String newA = a.substring(idxA, a.length());
				String newB = b.substring(idxB, b.length());

				return (newA.compareTo(newB) != 0 ? newA.compareTo(newB)
						: a.substring(0, a.indexOf(" ")).compareTo(b.substring(0, b.indexOf(" "))));
*/
			}
		});

		return logs;
	}

	/*public static String[] reorderLogFiles(String[] logs) {
		List<String> letter = new ArrayList<>();
		List<String> digit = new ArrayList<>();

		for (String log : logs) {
			if (Pattern.matches("\\d+", log.split(" ")[1])) {
				digit.add(log);
			} else {
				letter.add(log);
			}
		}

		Collections.sort(letter, new Comparator<String>() {
			public int compare(String a, String b) {
				String newA = a.substring(a.indexOf(" "), a.length());
				String newB = b.substring(b.indexOf(" "), b.length());

				return (newA.compareTo(newB) != 0 ? newA.compareTo(newB)
						: a.substring(0, a.indexOf(" ")).compareTo(b.substring(0, b.indexOf(" "))));

			}
		});
		int count = 0;
		for (String s : letter) {
			logs[count++] = s;
		}

		for (String s : digit) {
			logs[count++] = s;
		}

		return logs;
	}*/

}
