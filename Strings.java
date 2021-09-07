package codes;
import java.util.Arrays;
import java.util.Scanner;

public class Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner s = new Scanner(System.in);
//		String str = s.nextLine();
		
		//System.out.println(leftMost(str));
		//System.out.println(leftMostNonRep(str));
		
		
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
