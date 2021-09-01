package codes;

import java.util.ArrayList;
import java.util.Scanner;

public class recurssion {
	
	public static int counter = 2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
    	String str = "a";
    	char t1='A',t2='B',t3='C';
    	int[] arr =  {10,15,20};
//		
		//System.out.println(palindrome(str));
		
		//int ans = sumOfDig(1235);
		
		//int ans = ropeCut(9,2,2,2);
		
		//subset(str,"",str.length());
    	
    	//towerOfHanoi(4,t1,t2,t3);
    	
    	//long ans = powerN(361,163);
    	
    	//int ans = josephusProb(n,k);
    	
    	//int ans = subsetSum(arr,0,0);
    	
    	//Tail recursive factorial
    	//int ans = factorial(5,1);
		
		//System.out.println(ans);
    	
    	System.out.println(luckyNum(74));
		//864354781f
		

	}
	
	public static boolean luckyNum(int n) {
		if(counter > n) {
			return true;
		}
		if(n%counter == 0) {
			return false;
		}
		
		int new_pos = n-(n/counter);
		counter++;
		return luckyNum(new_pos);
	}

	private static int factorial(int i, int j) {
		// TODO Auto-generated method stub
		if(i==0 || i==1) {
			return j;
		}
		
		return factorial(i-1,j*i);		
	}

	public static int subsetSum(int[] arr,int sum,int n) {
		if(n==arr.length) {
			if(sum==0)
			return 1;
			else
			return 0;
		}
		
		return subsetSum(arr,sum,n+1) + subsetSum(arr,sum-arr[n],n+1);
		
	}
	
	public static int josephusProb(int n,int k) {
		
		if(n==1) {
			
		}
		
		
		
		return josephusProb(n-1,k);
	}
	
	public static long powerN(long n, long r) {
		if(r == 1) {
			return n;
		}
		
		return (n*powerN(n,r-1))%1000000007;
	}
	
	public static void towerOfHanoi(int n,char t1,char t2,char t3) {
		
		if(n==0) {
			return;
		}
		towerOfHanoi(n-1,t1,t3,t2);
		System.out.println("move disc " + n + " from "+t1+" to "+t3);
		towerOfHanoi(n-1,t2,t1,t3);
	}
	
	public static void subset(String str,String curr,int n) {
		
		if(n==0) {
			System.out.println(curr);
			return;
		}
		
		subset(str.substring(1),curr,n-1);
		subset(str.substring(1),curr+str.charAt(0),n-1);
			
	}
	
	public static int ropeCut(int n,int a,int b,int c) {

	    if(n==0) {
			return 0;
		}
		else if(n<0) {
			return -1;
		}
		
		int res = Math.max(Math.max(ropeCut(n-a,a,b,c),ropeCut(n-b,a,b,c)),ropeCut(n-c,a,b,c));
		
		if(res==-1) {
			return -1;
		}
		
		return res+1;
		
	}
	
	public static int sumOfDig(int n) {
		
		if(n==0) {
			return 0;
		}
		
		return n%10 + sumOfDig(n/10);
	}
	
	public static Boolean palindrome(String s) {
		Boolean ans = false;
		if(s=="" || s.length()==1) {
			return true;
		}
		ans = s.charAt(0) == s.charAt(s.length()-1);
		if(s.length()-2>=1) {
			ans = ans & palindrome(s.substring(1,s.length()-1));
		}
		
		return ans;
	}
	
	public static int trysubsum(int[] arr,int sum,int n) {
		
		
		
		return trysubsum(arr,sum,n+1) + trysubsum(arr,sum-arr[n],n+1);	}

}
