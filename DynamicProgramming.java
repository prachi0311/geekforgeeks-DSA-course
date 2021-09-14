package codes;

public class DynamicProgramming {
	int x=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "xyy";
		String str2 = "xy";
		int[] arr = {1,2,3};
		//Naive solution
		//int ans = LCS(str1,str2,str1.length(),str2.length());
		
		//By DP tabulation
		//int ans = LCSDP(str1,str2,str1.length(),str2.length());
		
		//Longest Palindromic subsequence
		//int ans = longestPalindromicSubsequence("geeksforgeeks");
		
		//TODO
		//longestRepeatingSubsequence("abc");**************
		
		//TODO optimized DP solution
		 //int ans = optimizedLCS(str1,str2,str1.length(),str2.length());
		
		//TODO print LCS
		//printLCS(str1,str2,str1.length(),str2.length());
		 
		 int ans = coinChange(arr,arr.length,4);
		
		 System.out.println(ans);
		
		

	}
	
	private static int coinChange(int[] arr,int n, int sum) {
		// TODO Auto-generated method stub
		int[][] dp = new int[n+1][sum+1];
		for(int i=0;i<n+1;i++) {
			dp[i][0]=1;
		}
		for(int i=0;i<sum+1;i++) {
			dp[0][i]=0;
		}
		dp[0][0]=1;
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<sum+1;j++) {
				dp[i][j]=dp[i-1][j];
				if(j-arr[i-1]>=0) {
					dp[i][j]=dp[i][j]+dp[i][j-arr[i-1]];
				}
					
			}
		}
		
		return dp[n][sum];
	}

	public static void printLCS(String s1,String s2,int l1,int l2) {
		String LCS="";
		int[][] arr = new int[2][l2+1];
		for(int i=0;i<l2;i++) {
			arr[0][i]=0;
		}
		
		for(int i=0;i<l1;i++) {
			for(int j=0;j<l2;j++) {
				if(s1.charAt(i)==s2.charAt(j)) {
					arr[1][j+1]=arr[0][j]+1;
					if(arr[1][j+1]!=arr[0][j+1])
					LCS=LCS+s1.charAt(i);
				}
				else {
					arr[1][j+1]=Math.max(arr[0][j+1], arr[1][j]);
				}
			}
			for(int k=0;k<l2+1;k++) {
				arr[0][k]=arr[1][k];
			}
		}
		
		System.out.println(LCS);
	}
	
	public static int optimizedLCS(String s1,String s2,int l1,int l2) {
		int[][] arr = new int[2][l2+1];
		for(int i=0;i<l2;i++) {
			arr[0][i]=0;
		}
		
		for(int i=0;i<l1;i++) {
			for(int j=0;j<l2;j++) {
				if(s1.charAt(i)==s2.charAt(j)) {
					arr[1][j+1]=arr[0][j]+1;
				}
				else {
					arr[1][j+1]=Math.max(arr[0][j+1], arr[1][j]);
				}
			}
			for(int k=0;k<l2+1;k++) {
				arr[0][k]=arr[1][k];
			}
		}
		
		return arr[1][l2];
	}
	
	private static void longestRepeatingSubsequence(String string) {
		// TODO Auto-generated method stub
		
	}

	private static int longestPalindromicSubsequence(String str1) {
		// TODO Auto-generated method stub
		StringBuilder str2 = new StringBuilder(str1);
		str2.reverse().toString();
		String strtemp = str2.toString(); 
		return LCSDP(str1,strtemp,str1.length(),str1.length());
	}

	public static int LCSDP(String s1,String s2,int l1,int l2) {
		int[][] table = new int[l1+1][l2+1];
		for(int i=0;i<l1+1;i++) {
			table[i][0]=0;
		}
		for(int i=0;i<l2+1;i++) {
			table[0][i]=0;
		}
		
		for(int i=1;i<l1+1;i++) {
			for(int j=1;j<l2+1;j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					table[i][j]=table[i-1][j-1]+1;
				}
				else {
					table[i][j]=Math.max(table[i-1][j], table[i][j-1]);
				}
			}
		}
		
		return table[l1][l2];
	}

	public static int LCS(String s1,String s2,int l1,int l2) {
		int ans=0;
		if(l1==0 || l2==0)
			return 0;
		if(s1.equals(s2)) {
			return s1.length();
		}
		for(int i=0;i<l1;i++) {
			for(int j=0;j<l2;j++) {
				if(s1.charAt(i)==s2.charAt(j)) {
					return 1+LCS(s1.substring(i+1),s2.substring(j+1),l1-i-1,l2-j-1);
			}
			
			}
			
			
		}
		
		return 0;
	}
}
