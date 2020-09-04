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
/*
Sample Input
3
5
4

Sample Output
2

Sample Input
3
3
3

Sample Output
1
*/

public class Triangle {



    // Complete the triangle function below.
    static int triangle(int a, int b, int c) {
        if (a < 1 || b < 1 || c < 1) {
            return 0;
        }

        if (((a + b) > c) && ((a + c) > b) && ((b + c) > a)) {
            if (a == b && b == a) {
                return 1;
            } else {
                return 2;
            }
        } else {
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int a = Integer.parseInt(bufferedReader.readLine().trim());

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        int c = Integer.parseInt(bufferedReader.readLine().trim());

        int res = triangle(a, b, c);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

