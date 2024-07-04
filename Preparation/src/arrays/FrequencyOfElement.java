package arrays;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class FrequencyOfElement {
public static void main(String[] args) {
	int arr[]= {10,1,4,7,10,1,1,1,2,6,2,7,1};
	countFrequency(arr);
	

}
public static void countFrequency(int arr[]) {
	//to store element and frequency
	Map<Integer,Integer> m = new HashMap<Integer, Integer>();//element -> key, frequency ->value
	for (int i : arr) {
		if(m.containsKey(i) ){//if map already has the element as key just increase the value by 1
			m.put(i, m.get(i)+1);
		}
		else {
			m.put(i, 1);//for the first time the frequency is 1
		}
	}
	System.out.println(Arrays.toString(arr));
	for (Entry<Integer, Integer> entry : m.entrySet()) {//entry is both key and value .//entrySet() have all entries in map
		System.out.println(entry.getKey()+"->  "+entry.getValue());
		
		
	}

}
}
