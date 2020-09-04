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
breakfast beach citycenter location metro view staff price
not
5
1
2
1
1
2
5
This hotel has a nice view of the citycenter. The location is perfect.
The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.
Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.
They said I couldn't take my dog and there were other guests with dogs! That is not fair.
Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter.

Sample Output 
2
1
*/

public class SortHotelList {



    // Complete the sort_hotels function below.
    static List<Integer> sort_hotels(String keywords, String nKeywords, List<Integer> hotel_ids, List<String> reviews) {
    	
    	
    	String[] words = keywords.split(" ");

        Set<String> wordSet = new HashSet<>();
        for(String word : words) {
            wordSet.add(word);
        }

        String[] nWords = nKeywords.split(" ");
        Set<String> nWordSet = new HashSet<>();
        for(String word : nWords) {
            nWordSet.add(word);
        }
        
        Map<Integer, Integer> hotelCount = new HashMap<>();
        for(int i=0 ; i<reviews.size() ; i++) {

        	
            int id = hotel_ids.get(i);
            if(!hotelCount.containsKey(id)){
                hotelCount.put(id, 0);
            }

            String[] reviewWords = reviews.get(i).split(" ");
            for(String word : reviewWords) {
                if(wordSet.contains(word)) {
                    hotelCount.put(id, hotelCount.get(id)+3);
                }
                else if (nWordSet.contains(word)) {
                    hotelCount.put(id, hotelCount.get(id)-1);
                }
            }
/*            for(String word : reviewWords) {
                if(nWordSet.contains(word)) {
                    hotelCount.put(id, hotelCount.get(id)-1);
                }
            }*/
        }
        
        List<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>(hotelCount.entrySet());
        Collections.sort(sortedList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return o1.getKey() - o2.getKey();
                } else {
                    return o2.getValue() - o1.getValue();
                }
            }
        });

        List<Integer> result = new ArrayList<>();
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : sortedList) {
            result.add(count++, entry.getKey());
            System.out.println(entry.getValue());
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String keywords = bufferedReader.readLine();
        String nKeywords = bufferedReader.readLine();
        
        int hotel_idsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> hotel_idsTemp = new ArrayList<>();

        IntStream.range(0, hotel_idsCount).forEach(i -> {
            try {
                hotel_idsTemp.add(bufferedReader.readLine().replaceAll("\\s+$", ""));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> hotel_ids = hotel_idsTemp.stream()
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int reviewsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> reviews = new ArrayList<>();

        IntStream.range(0, reviewsCount).forEach(i -> {
            try {
                reviews.add(bufferedReader.readLine());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> res = sort_hotels(keywords, nKeywords, hotel_ids, reviews);
        
        System.out.println(res);

     /*   bufferedWriter.write(
            res.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );
*/
        bufferedReader.close();
//        bufferedWriter.close();
    }
}

