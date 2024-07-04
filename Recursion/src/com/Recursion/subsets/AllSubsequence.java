package com.Recursion.subsets;

import java.util.ArrayList;

public class AllSubsequence {
	public static void main(String[] args) {
        findAll("", "abc");
        System.out.println();
        findAllAscii("", "abc");
        System.out.println();
        System.out.println( findAll1("", "abc"));
        System.out.println( findAll2("", "abc",new ArrayList<String>()));
	}
	static void findAll(String p,String up) {
	   if(up.isEmpty()) {
		   if(!p.isEmpty()) {
		   System.out.print(p+" ");
		   }
		   return ;
	   }
	   findAll(p, up.substring(1));	
	   findAll(p+up.charAt(0), up.substring(1));	
		
		
	}
	static void findAllAscii(String p,String up) {
		if(up.isEmpty()) {
			System.out.print(p+" ");
			return ;
		}
		findAllAscii(p+up.charAt(0), up.substring(1));
		findAllAscii(p, up.substring(1));
		findAllAscii(p+(up.charAt(0)+0), up.substring(1));
	}
	static ArrayList<String> findAll1(String p,String up) {
		if(up.isEmpty()) {
			ArrayList<String> ans = new ArrayList<String>();
			ans.add(p);
			return ans;
		}
               
		 ArrayList<String> left = findAll1(p, up.substring(1));
		 ArrayList<String> right = findAll1(p+up.charAt(0), up.substring(1));
		  
	     left.addAll(right);
	     return left;
	}

	static ArrayList<String> findAll2(String p,String up,ArrayList<String> ans) {
		if(up.isEmpty()) {
			ans.add(p);
			return ans;
		}
               
		  findAll2(p, up.substring(1),ans);
		 return findAll2(p+up.charAt(0), up.substring(1),ans);
		  
	    
	}

}
 