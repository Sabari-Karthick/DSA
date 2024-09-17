package com.binary;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * 
 * https://leetcode.com/problems/time-based-key-value-store/
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class TimeBased_KV_Store {
   
	public static void main(String[] args) {
		TreeMap<String, String> map = new TreeMap<>();
		map.floorKey(null);
	}
}
class TimeMap1 { // Linear Search
	 
    private Map<Integer,Map<String,String>> map;
 
   public TimeMap1() {
        map = new HashMap<>();
   }

   public void set(String key, String value, int timestamp) {
       map.put(timestamp,Map.of(key,value));
   }
   
   public String get(String key, int timestamp) {
           if(map.containsKey(timestamp)) return map.get(timestamp).get(key);
           

           while(!map.containsKey(timestamp)){
               timestamp--;
           }
           
           return map.get(timestamp).get(key);
   }
}
class TimeMap2 {
	 
    private TreeMap<Integer,Map<String,String>> map; // A  Structure Faulty Some What working approach
    // A Key have different value at different time stamp
    // so key is searched then the value based on time stamp is searched
    public TimeMap2() {
         map = new TreeMap<>();
    }
 
    public void set(String key, String value, int timestamp) {
        map.put(timestamp,Map.of(key,value));
    }
    
    public String get(String key, int timestamp) {
            if(map.containsKey(timestamp)) return map.get(timestamp).get(key);
            
            Integer floorTimestamp = map.floorKey(timestamp);
            
            if(floorTimestamp == null) return "";
            
            return map.get(floorTimestamp).getOrDefault(key,"");
    }
}
class TimeMap3 {
	 
    private Map<String,TreeMap<Integer,String>> map; // A Slow Working solution with just map
  
    public TimeMap3() {
         map = new TreeMap<>();
    }
 
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, v -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
            if(!map.containsKey(key))  return "";

            TreeMap<Integer, String> timeValueMap = map.get(key);

            Integer searchKey =  timeValueMap.floorKey(timestamp);
                
            
            return (searchKey == null) ? "" : timeValueMap.get(searchKey);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
