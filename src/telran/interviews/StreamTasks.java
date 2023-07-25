package telran.interviews;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamTasks {
      static public void displayOccurrences(String strings[]) {
    	  Arrays.stream(strings)
    	  .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
    	  .entrySet().stream().sorted((e1, e2) -> {
    		  int res = Long.compare(e2.getValue(), e1.getValue());
    		  return res != 0 ? res : e1.getKey().compareTo(e2.getKey());
    	  })
    	  .forEach(e -> System.out.printf("%s -> %s\n", e.getKey(), e.getValue()));
      }
      static public long sumGroups(int [][] groups) {
    	  return Arrays.stream(groups)
    			  .flatMapToInt(g -> Arrays.stream(g)).asLongStream()
    			  .sum();
      }
      static public void displayOddEvenGrouping(int nNumbers) {
    	  new Random().ints(nNumbers, 0, Integer.MAX_VALUE ).boxed()
    	  .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "even" : "odd",
    			  Collectors.summingLong(x -> x)))
    	  .forEach((k, v) -> System.out.printf("%s -> %d\n", k, v));
      }
      
      static public void printDigitStatistics() {
    	  int MILLION = 1_000_000;
    	  int MAX = Integer.MAX_VALUE;
    	  HashMap<Integer, Integer> mapOfDigits = new HashMap<>();
    	  
    	  new Random().ints(MILLION, 0, MAX).boxed()
    	  
    	  .forEach(n -> {
    			while(n > 0) {
     				int key = n % 10;
    				mapOfDigits.merge(key, 1, Integer::sum);			
    				n /= 10;
    			}
    		  
    	  });
    	  
    	  mapOfDigits.entrySet().stream().sorted((e1, e2) -> {
    		  int res = Long.compare(e2.getValue(), e1.getValue());
    		  return res != 0 ? res : e1.getKey().compareTo(e2.getKey());
    	  })
    	  .forEach(e -> System.out.printf("%s -> %s\n", e.getKey(), e.getValue())); 
    	  
      }

}
