package com.Recursion.String;

public class SkipCharAndStrings {
	public static void main(String[] args) {
       removeChar("","baaaacda");
       System.out.println(skip("baaaacda"));
       System.out.println(skipab("babaabcda"));
       System.out.println(skipabNotabbb("babbbaabcdab"));
	}

	 static void removeChar(String s1, String s2) {
		 if(s2.isEmpty()) {
			 System.out.println(s1);
			 return;
		 }
		 
		 if(s2.charAt(0)=='a') {
			 removeChar(s1, s2.substring(1));
		 }else {
			 
			 removeChar(s1+s2.charAt(0), s2.substring(1));
		 }
		 
	}
	 
	 static String skip(String s) {
		 if(s.isEmpty()) {
			 return "";
		 }
		 
		 if(s.charAt(0)=='a') {
			return  skip(s.substring(1));
		 }else {
			 
			 return s.charAt(0)+skip(s.substring(1));
		 }
		 
	}
	 

	 static String skipab(String s) {
		 if(s.isEmpty()) {
			 return "";
		 }
		 
		 if(s.startsWith("ab")) {
			return  skipab(s.substring(2));
		 }else {
			 
			 return s.charAt(0)+skipab(s.substring(1));
		 }
		 
	}
	
	 static String skipabNotabbb(String s) {
 		 if(s.isEmpty()) {
			 return "";
		 }
		 
		 if(s.startsWith("ab") && !s.startsWith("abbb")) {
			return  skipabNotabbb(s.substring(2));
		 }else {
			 
			 return s.charAt(0)+skipabNotabbb(s.substring(1));
		 }
		 
	}
	
	
	
}
