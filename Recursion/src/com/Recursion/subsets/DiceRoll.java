package com.Recursion.subsets;

import java.util.ArrayList;
import java.util.List;

public class DiceRoll {
	public static void main(String[] args) {
        diceRoll("", 4);
         System.out.println( diceRoll1("", 4,new ArrayList<String>()));
	}
	
	static void diceRoll(String p ,int target) {
		if(target==0) {
			System.out.println(p+" ");
			return;
		}
		
		
		for(int i=1;i<=6&&i<=target;i++) {
			
				diceRoll(p+i, target-i);
			 
		}
		
	}
	static List<String> diceRoll1(String p ,int target,List<String> ans) {
		if(target==0) {
			ans.add(p);
			return ans;
		}
		
		
		for(int i=1;i<=6&&i<=target;i++) {
			
		    diceRoll1(p+i, target-i, ans);
			 
		}
		return ans;
		
	}
}
