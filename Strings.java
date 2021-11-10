package codes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner s = new Scanner(System.in);
//		String str = s.nextLine();
//		String str1="abcabcd";
//		String pat="abcd";
		//System.out.println(leftMost(str));
		//System.out.println(leftMostNonRep(str));
		
		//reverseStringWords("I love coding");
		
		//Naive Method
		//patternSearch(str1,pat);
		
		//KMP
//		String str="aaaa";
//		int[] lps=new int[str.length()];
//		fillLPS(str,lps);
		areSentencesSimilar("my name is haley","my haley");
		
	}
	
	 public static boolean areSentencesSimilar(String sentence1, String sentence2) {
	        
	        if(sentence1.length()>sentence2.length()){
	            areSentencesSimilar(sentence2, sentence1);
	        }
	            
	        String[] s1=sentence1.split(" ");
	        String[] s2=sentence2.split(" ");
	        
	        if((s1.length==1 && s2.length==1) && sentence1!=sentence2)
	            return false;
	        
	        int i=0,j=0,count=0;
	        
	        while(i<s2.length){
	             System.out.println(s2[i]);
	            if(s2[i].equals(s1[j])){
	                s2[i]=",";
	                count++;
	                i++;
	                j++;
	                
	            }
	            else{
	                i++;
	            }
	                
	        }
	        
	        if(count!=s1.length){
	            System.out.println(count);
	            return false;
	        }
	        
	        int res=0;
	        
	        for(int k=0;k<s2.length;k++){
	            if(k!=0 && s2[k].equals(","))
	                res++;
	        }
	        
	        System.out.println("res="+res);
	        
	        if(res==1){
	            return true;
	        }
	        else{
	            return false;
	        }
	            
	    }
	
	
	public static void fillLPS(String str,int[] lps) {
		lps[0]=0;
		int len=0;
		
		for(int i=1;i<str.length();i++) {
			if(str.charAt(i)==str.charAt(len)){
				lps[i]=len+1;
				len=lps[i];
			}
			else {
				if(len==0)
					lps[i]=0;
				else {
					len=lps[len-1];
					i--;
				}
			}
		}
		
		for(int x:lps) {
			System.out.println(x);
		}
	}
	
	public static void patternSearch(String str1,String pat) {
		int i=0,k=0,temp=-1;
		while(i<str1.length()) {
			if(str1.charAt(i)==pat.charAt(k)) {
				if(k==0) {
					temp=i;
				}
				
				k++;
			}
			else {
				k=0;
				i--;
				temp=-1;
			}
			if(k==pat.length()) {
				System.out.println(temp);
				//i=temp;
				temp=-1;
				k=0;
			}
			
			i++;
		}
	}
	
	public static void reverseStringWords(String s) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0);
		String res="";
		for(int i=1;i<s.length();i++) {
			if(s.charAt(i)==' ' && s.charAt(i+1)!=' ')
				list.add(i+1);
		}
		int k = list.size()-1;	
		int temp = list.get(k);
		for(int i=0;i<s.length();i++) {
			if((temp+i)==s.length() || s.charAt(temp+i)==' ' ) {
				k--;
				if(k==-1)
					break;
				res=res+" ";
				temp = list.get(k);
				i=0;
			}
			res = res + s.substring(temp+i,temp+i+1);
		}
		
		System.out.println(res);
	}
	public static double area(int a, int b,int c) {
		double p = (double)(a+b+c)/2;
		System.out.println("p "+p);
		double res = Math.sqrt(p*(p-a)*(p-b)*(p-c));
		
		return res;
	}
	
	public static char leftMostNonRep(String str) {
		int[] chars =new int[255];
		int res=Integer.MAX_VALUE;
		Arrays.fill(chars,-1);
		for(int i=0;i<str.length();i++) {
			char temp=str.charAt(i);
			if(chars[temp]==-1)
				chars[temp]=i;
			else {
				chars[temp]=-2;
			}
		}
		
		for(int i=0;i<255;i++) {
			if(chars[i]>=0)
				res=Math.min(res, chars[i]);
		}
		
		if(res==Integer.MAX_VALUE)
			return (char)-1;
		else
			return str.charAt(res);
	}

	public static char leftMost(String str) {
		int[] chars = new int[122];
		int min_idx=Integer.MAX_VALUE;
		char ans=(char)-1;
		for(int i=0;i<122;i++) {
			chars[i]=-1;
		}
		
		for(int i=0;i<str.length();i++) {
			char temp = str.charAt(i);
			if(chars[temp]==-1) {
				chars[temp]=i;
			}
			else {
				if(chars[temp]<min_idx) {
					min_idx=chars[temp];
					ans = temp;
				}
			}
		}
		//System.out.println(min_idx);
		return ans;
	}
}
