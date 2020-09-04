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
1
3
2
1481122000 1481122020
1481122000 1481122040
1481122030 1481122035

Sample Output
1

*/
public class CustomerServiceCapacity {



    // Complete the howManyAgentsToAdd function below.
    static int howManyAgentsToAdd(int noOfCurrentAgents, List<List<Integer>> callsTimes) {
        int[] startTimes = new int[callsTimes.size()];
        int[] endTimes = new int[callsTimes.size()];
        
        for (int i = 0; i < callsTimes.size(); i++) {
            startTimes[i] = callsTimes.get(i).get(0);
            endTimes[i] = callsTimes.get(i).get(1);
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int agents = 1, maxAgents = 1, time = startTimes[0];
        int i=1, j=0;

        while(i< callsTimes.size() && j < callsTimes.size()){
            if(startTimes[i] <= endTimes[j]) {
                agents++;
                if(agents > maxAgents) {
                    maxAgents = agents;
                    time = startTimes[i];
                }
                i++;
            }
            else {
                agents--;
                j++;
            }           
        }

        if(maxAgents > noOfCurrentAgents) {
            return maxAgents - noOfCurrentAgents;
        }
        else {
            return 0;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int noOfCurrentAgents = Integer.parseInt(bufferedReader.readLine().trim());

        int callsTimesRows = Integer.parseInt(bufferedReader.readLine().trim());
        int callsTimesColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> callsTimes = new ArrayList<>();

        IntStream.range(0, callsTimesRows).forEach(i -> {
            try {
                callsTimes.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int res = howManyAgentsToAdd(noOfCurrentAgents, callsTimes);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

