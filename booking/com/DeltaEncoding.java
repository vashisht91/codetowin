package src.booking.com;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/*Sample Input
25626
25757
24367
24267
16
100
2
7277

Sample Output
25626
-128
131
-128
-1390
-100
-128
-24251
84
-98
-128
7275
*/

class Result {

    /*
     * Complete the 'delta_encode' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY numbers as parameter.
     */

    public static List<Integer> delta_encode(List<Integer> numbers) {
    // Write your code here
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 1;
        result.add(0, numbers.get(0));
        for (i = 1; i < numbers.size(); i++, j++) {
            if (((numbers.get(i) - numbers.get(i - 1) < -127)) || ((numbers.get(i) - numbers.get(i - 1)) > 127)) {
                result.add(j, -128);
                result.add(++j, numbers.get(i) - numbers.get(i - 1));
            } else {
                result.add(j, numbers.get(i) - numbers.get(i - 1));
            }
        }
        return result;

    }

}

public class DeltaEncoding {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int numbersCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> numbers = IntStream.range(0, numbersCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.delta_encode(numbers);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

