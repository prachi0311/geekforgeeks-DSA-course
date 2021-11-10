package codes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class DynamicProgramming {
	int x=0;
	
	 class job implements Comparable<job>{
	        int start;
	        int end;
	        int profit;
	        
	        job(int s,int e,int p){
	            start=s;
	            end=e;
	            profit=p;
	        }
	        
	        public int compareTo(job a){
	            return this.end-a.end;
	        }
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str1 = "cat";
//		String str2 = "cut";
		//int[] arr = {2};
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
		
		//TODO stair climb
		 
		// int ans = coinChange(arr,arr.length,3);
		
		//int ans = editDis(str1,str2,str1.length(),str2.length());
//		
//		int ans = jumpGame(arr);
//		
		// System.out.println("coins req " + ans);
		
//		ArrayList<String> dict = new ArrayList<>();
//		dict.add("i");
//		dict.add("like");
//		dict.add("samsung");
//		dict.add("l");
//		
//		String s = "igo";
//		
//		System.out.println(wordBreak(s,dict,s.length()));
		
		
		
//		int m[][] = {
//				{1,1,0},
//				{1,0,0},
//				{1,0,0}
//		};
//		
//		System.out.println("Maximum square size is" + maxSquare(m));
		 
//		 int[][] matrix = {
//				 {9,9,4},
//				 {6,6,8},
//				 {2,1,1},
//		 };
////		
//		longestIncPath(matrix);
		
//		int[][] arr= {
//				{8,1},
//				{1,2},
//				{4,3},
//				{3,4},
//				{2,6},
//				{6,7},
//				{7,8},
//				{5,5}
//		};
//		
//		System.out.println(nonOverlapBridges(arr));
		
		
		
		//System.out.println(maxCut(3,2,4,2));
//		
//		int[] coins= {2,4};
//	
//		System.out.println(minCoin(4,coins));
		
	//	System.out.println(optimalGame(coins));
		
//		int arr[]= {1,2,3};
//		System.out.println("ans"+coinChange(arr,arr.length,5));
		
//		int[] price= {0,1,5,8,9,10,17,17,20};
//		
//		System.out.println(cuttingRod(price,8));
		
//		int[] arr= {4, 34, 5,12};
//		
//		System.out.println(subsetSum(arr,30));
		
		//System.out.println(superEggDrop(2,6));
		
		//System.out.println(catalan(6));
		
		int[] arr = {10, 20, 30,40};
//		
//		System.out.println(matrixChainMul(arr));
		
		System.out.println(minPages(arr,2));
	}
	
	public static int minPages(int[] arr,int k) {
		
		int len=arr.length;
		
		int[] pref = new int[len+1];
		pref[0]=0;
		pref[1]=arr[0];
		for(int i=2;i<=len;i++) {
			pref[i]=arr[i-1]+pref[i-1];
		}
		
		int[][] dp=new int[k+1][len+1];
		
		for(int i=1;i<=len;i++) {
			dp[1][i]=pref[i-1];
		}
		
		for(int i=2;i<=k;i++) {
			for(int j=1;j<=len;j++) {
				dp[i][j]=Integer.MAX_VALUE;
				for(int l=1;l<j;l++) {
					dp[i][j]=Math.min(dp[i][j],Math.max(dp[i-1][l],pref[j]-pref[l]));
				}
			}
		}
		
		return dp[k][len];
	}
	
	public static int matrixChainMul(int[] arr) {
		
		
		if(arr.length<=2)
			return 0;
		
		if(arr.length==3) {
			return arr[0]*arr[1]*arr[2];
		}
		
		int len=arr.length-1;
		
		int[][] dp = new int[len][len];
		
		for(int gap=1;gap<len;gap++) {
			for(int i=0;i+gap<len;i++) {
				int j=i+gap;
				dp[i][j]=Integer.MAX_VALUE;
				for(int k=i;k<j;k++) {
					dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k+1][j]+(arr[i]*arr[k+1]*arr[j+1]));
				}
			}
		}
			
		return dp[0][len-1];
		
	}
	
	public static int catalan(int n) {
		int catalan[] = new int[n + 1];
		 
        // Initialize first two values in table
        catalan[0] = 1;
        catalan[1] = 1;
 
        // Fill entries in catalan[]
        // using recursive formula
        for (int i = 2; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 1; j <= i; j++) {
                catalan[i]
                    += catalan[j-1] * catalan[i - j ];
            }
        }
        
        return catalan[n];
	}
	
	
	
	public static int superEggDrop(int k, int n) {
        
        if(n==0)
            return 0;
        if(k==1)
            return n;
        
        int[][] dp=new int[n+1][k+1];
        
        for(int i=0;i<=n;i++){
            dp[i][0]=0;
            dp[i][1]=i;
        }
        
        for(int i=0;i<=k;i++){
            dp[0][i]=0;
        }
        
        for(int i=1;i<=n;i++){
            for(int m=2;m<=k;m++){
                dp[i][m]=Integer.MAX_VALUE;
                for(int j=1;j<=i;j++){
                    dp[i][m]=Math.min(dp[i][m],Math.max(dp[j-1][m-1],dp[i-j][m]));
                }
                
                dp[i][m]+=1;
            }     
        }
        
         return dp[n][k];
    }     
	
	public static boolean subsetSum(int[] arr,int sum) {
		
		boolean[][] dp=new boolean[arr.length+1][sum+1];
		
		for(int i=0;i<=sum;i++) {
			dp[0][i]=false;
		}
		for(int i=0;i<=arr.length;i++) {
			dp[i][0]=true;
		}
		
		for(int i=1;i<=arr.length;i++) {
			for(int j=1;j<=sum;j++) {
				if(arr[i-1]>j)
					dp[i][j]=dp[i-1][j];
				else
					dp[i][j]=dp[i-1][j]||dp[i-1][j-arr[i-1]];
			}
		}
		
//		for(int i=0;i<=arr.length;i++) {
//			for(int j=0;j<=sum;j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		return dp[arr.length][sum];
	}
	
	public static int cuttingRod(int[] p,int l) {
		
		int[] dp=new int[l+1];
		
		for(int i=1;i<=l;i++) {
			dp[i]=p[i];
			for(int j=1;j<i;j++) {
				dp[i]=Math.max(dp[i], p[j]+p[i-j]);
			}			
		}
		
		return dp[l];	
		
	}
	
	public static int optimalGame(int[] coins) {
		int n=coins.length;
		int[][] dp=new int[n][n];
		
		for(int i=0;i<n-1;i++){
			dp[i][i]=coins[i];
            dp[i][i+1]=Math.max(coins[i],coins[i+1]);
        }
		
		for(int gap=2;gap<n;gap++) {
			for(int i=0;i+gap<n;i++) {
                int j=gap+i;
				
                dp[i][j]=Math.max(coins[i]+Math.min(dp[i+2][j], dp[i+1][j-1]),coins[j]+Math.min(dp[i][j-2], dp[i+1][j-1]));
					
				
			}
		}
		
		
		return dp[0][n-1];
		
	}
	
	public static int minCoin(int val,int[] coins) {
		
		int[] dp = new int[val+1];
		
		dp[0]=0;
		
		for(int i=1;i<val+1;i++) {
			dp[i]=Integer.MAX_VALUE;
			for(int j=0;j<coins.length;j++) {
				if(i-coins[j]>=0) {
					dp[i]=Math.min(dp[i], dp[i-coins[j]]+1);
				}
			}
		}
		
		
		return dp[val];
		
	}
	
	public static int maxCut(int n,int a,int b,int c) {
		
		if(n==0)
			return 0;
		
		int[] dp=new int[n+1];
		dp[0]=-1;
		int a1=-1;
		int b1=-1;
		int c1=-1;
		
		for(int i=1;i<n+1;i++) {
			if(i-a>=0) {
				a1=dp[i-a]+1;
			}
			if(i-b>=0) {
				b1=dp[i-b]+1;
			}
			if(i-c>=0) {
				c1=dp[i-c]+1;
			}
				
			dp[i]=Math.max(a1,Math.max(b1, c1));
				
		}
		
		return dp[n];
	}
	
	public static int nonOverlapBridges(int[][] arr) {
		int len=arr.length;
		Arrays.sort(arr, Comparator.comparingDouble(o -> o[0]));
		
		int[] dp=new int[len];
		dp[0]=1;
		
		for(int i=1;i<len;i++) {
			for(int j=0;j<i;j++) {
				if(arr[j][1]<arr[i][1])
					dp[i]=Math.max(dp[i], dp[j]+1);
			}
		}
		
		int res = dp[0];
		for(int i=1;i<dp.length;i++) {
			res=Math.max(res, dp[i]);
		}
		
		return res;
		
	}
	
	public static void addedge(ArrayList<ArrayList<Integer>> g,int t, int f,int[] in) {
		g.get(f).add(t);
		in[t]++;
		
	}
	
	 private static void longestIncPath(int[][] matrix) {
		// TODO Auto-generated method stub
		 
		 int total_elem = matrix.length * (matrix[0].length);
	        ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();
	        int[] outdegree = new int[total_elem];
	        int[][] dp = new int[matrix.length][matrix[0].length];
	        int m = matrix[0].length;
	        
	        for(int i=0;i<matrix.length;i++){
	            for(int j=0;j<matrix[0].length;j++){
	            	g.add(new ArrayList<Integer>());
	            }
	        }
	        
	        for(int i=0;i<matrix.length;i++){
	            for(int j=0;j<matrix[0].length;j++){
	                
	                int left=-1;
	                int right=-1;
	                int up=-1;
	                int down=-1;
	                int curr = matrix[i][j];
	                if(j-1>=0)
	                     left = matrix[i][j-1];          
	                if(j+1<matrix[0].length)
	                     right = matrix[i][j+1];
	                if(i-1>=0)
	                    up=matrix[i-1][j];
	                if(i+1<matrix.length)
	                    down=matrix[i+1][j];
	                
	                if(left!=-1 && curr>left)
	                    addedge(g,(m*i+(j-1)),(m*i+j),outdegree);
	                if(right!=-1 && curr>right)
	                    addedge(g,(m*i+(j+1)),(m*i+j),outdegree);
	                if(up!=-1 && curr>up)
	                    addedge(g,(m*(i-1)+j),(m*i+j),outdegree);
	                if(down!=-1 && curr>down)
	                    addedge(g,(m*(i+1)+j),(m*i+j),outdegree);
	                
	                
	            }
	        }
	        
	        Queue<Integer> q = new LinkedList<Integer>();
	        
	        for(int i:outdegree){
	            if(i==0)
	                q.add(i);
	        }
	        
	      
	        while(!q.isEmpty()){
	            int temp = q.poll();
	            int r = temp/m;
	            int c = temp - r*m;
	            int max=0;
	            
	            for(int i:g.get(temp)){
	                int row = i/m;
	                int col = i - r*m;
	                max=Math.max(max,dp[row][col]+1);
	                outdegree[i]--;
	                if(outdegree[i]==0)
	                    q.add(i);
	            }
	            
	            dp[r][c]=max;
	        }
	        
		
	}

	public static int binarySearch(ArrayList<job> arr,int start,int end,int i){
	        
         while(start<=end){
                int mid = start + (end-start)/2;
                
                if(arr.get(mid).end <= arr.get(i).start){
                    
                  if(arr.get(mid+1).end <= arr.get(i).start)
                      start=mid+1;
                  else{ 
                    return mid;
                  }
                }
                
                else{
                    end=mid-1;
                }
            }
        
        return -1;
    }
	 public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
	        ArrayList<job> arr = new ArrayList<>();
	        
	        for(int i=0;i<startTime.length;i++){
	            arr.add(new job(startTime[i],endTime[i],profit[i]));
	        }
	        
	        Collections.sort(arr);
	        
	        // for(job i:arr){
	        //     System.out.println(i.end);
	        // }
	      
	  
	        int[] dp = new int[arr.size()];
	        dp[0]=arr.get(0).profit;
	        System.out.println(dp[0]);
	        for(int i=1;i<arr.size();i++){
	            
	            int temp=binarySearch(arr,0,i-1,i);
	            System.out.println("temp" + temp);
	            int currProfit = arr.get(i).profit;
	            System.out.println("current" + currProfit);
	            if(temp!=-1)
	                currProfit = currProfit + dp[temp];
	                
	                dp[i] = Math.max(currProfit,dp[i-1]);
	                
	                System.out.println(dp[i]);
	            
	        }
	        
	        findSol(arr,dp);
	        
	        return dp[arr.size()-1];
	    }
	 
	 public static void findSol(ArrayList<job> arr, int[] dp) {
//		 int[] ans = new int[];
//		 for(int i=dp.length-1;i>=0;i--) {
//			 if(dp[i-1]>(arr.get(i).profit+dp[binarySearch()]))
//		 }
	 }
	
	public static int maxSquare(int[][] m) {
		if(m.length==0) {
			return 0;
		}
		
		int r = m.length;
		int c = m[0].length;
		int maxSum=0;
		int ansR=-1;
		int ansC=-1;
		
		int[][] sum = new int[r][c];
		
		//Initialise sum[][]
		
		for(int i=0;i<c;i++) {
			sum[0][i]=m[0][i];
		}
		
		for(int i=0;i<r;i++) {
			sum[i][0]=m[i][0];
		}
		
		//Filling sum[][]
		
		for(int i=1;i<r;i++) {
			for(int j=1;j<c;j++) {
				if(m[i][j]==1) {
					sum[i][j]=Math.min(sum[i-1][j], Math.min(sum[i][j-1], sum[i-1][j-1]))+1;
				}
				else {
					sum[i][j]=0;
				}
				if(sum[i][j] > maxSum) {
					maxSum=sum[i][j];
					ansR=i;
					ansC=j;
				}
			}
			
		}
		
		printSquare(m,ansR,ansC,maxSum);
		
		return maxSum;
		
	}
	
	public static void printSquare(int[][] m,int r,int c,int size) {
		int startRow = r-size+1;
		int startCol = c-size+1;
		
		for(int i=startRow;i<=r;i++) {
			for(int j=startCol;j<=c;j++) {
				System.out.print(m[i][j]+",");
			}
			System.out.println();
		}
	}
	
	public static Boolean wordBreak(String s,ArrayList<String> dict,int n) {
		
		Boolean[] dp=new Boolean[n+1];
		Arrays.fill(dp, false);
		dp[0]=true;
//		if(dict.contains(s.substring(0,1))) {
//			dp[1]=true;
//		}
		
		for(int i=1;i<n+1;i++) {
			for(int j=i;j>0;j--) {
				//System.out.println(dp[j-1]+" , "+s.substring(j-1,i));
				if(dp[j-1] && dict.contains(s.substring(j-1,i))) {
					dp[i]= true;
				}
//				else {
//					dp[i]=dp[i] || false;
//				}
			}
		}
		
		return dp[n];
	}
	
	public static int jumpGame(int nums[]) {
		  int dp[] = new int[nums.length+1];
	        dp[nums.length]=0;
	        int min=Integer.MAX_VALUE;
	        int k=nums.length-2;
	        for(int i=nums.length-1;i>0;i--){
	            for(int j=0;j<nums[k];j++){
	            	if(i+j+1<dp.length)
	                min = Math.min(min,dp[i+j+1]);
	            }
	            if(min==Integer.MAX_VALUE)
	            	min=100000;
	            dp[i]=min+1;
	            min=Integer.MAX_VALUE;
	            k--;
	        }
	        
	        return dp[1];
	}
	
	private static int editDis(String str1, String str2, int l1, int l2) {
		// TODO Auto-generated method stub
		int[][] dp = new int[l1+1][l2+1];
		for(int i=0;i<l2+1;i++) {
			dp[0][i]=i;
		}
		for(int i=0;i<l1+1;i++) {
			dp[i][0]=i;
		}
		
		for(int i=1;i<l1+1;i++) {
			for(int j=1;j<l2+1;j++) {
				if(str1.charAt(i-1)==str2.charAt(j-1))
					dp[i][j]=dp[i-1][j-1];
				else {
					dp[i][j]=Math.min(dp[i][j], Math.min(dp[i][j-1], dp[i-1][j]))+1;
				}
			}
		}
		
		return dp[l1][l2];
		
	}

	private static int coinChange(int[] arr,int n, int sum) {
		// TODO Auto-generated method stub
		int[][] dp = new int[n+1][sum+1];
		for(int i=0;i<n+1;i++) {
			dp[i][0]=1;
		}
		for(int i=0;i<sum+1;i++) {
			
			if(i%arr[0]==0)
			dp[0][i]=i/arr[0];
			else
				dp[0][i]=0;
		}
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<sum+1;j++) {
				if(arr[i-1]>j)
					dp[i][j]=dp[i-1][j];
				else
					dp[i][j]=Math.min(dp[i-1][j], dp[i][j-arr[i-1]]+1);
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
	
//	private static int coinChangeTest(int k, int sum) {
//		
//		int arr[]
//		// TODO Auto-generated method stub
//		int[][] dp = new int[n+1][sum+1];
//		for(int i=0;i<n+1;i++) {
//			dp[i][0]=1;
//		}
//		for(int i=0;i<sum+1;i++) {
//			
//			if(i%arr[0]==0)
//			dp[0][i]=i/arr[0];
//			else
//				dp[0][i]=0;
//		}
//		
//		for(int i=1;i<n+1;i++) {
//			for(int j=1;j<sum+1;j++) {
//				if(arr[i-1]>j)
//					dp[i][j]=dp[i-1][j];
//				else
//					dp[i][j]=Math.min(dp[i-1][j], dp[i][j-arr[i-1]]+1);
//			}
//		}
//		
//		return dp[n][sum];
//	}
}



