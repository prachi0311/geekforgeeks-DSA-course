package codes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Temp {
	
	public static class address{
		int row;
		int col;
		
		address(int r,int c){
			row=r;
			col=c;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] arr = {
//				{1}			
//		};
//		
//		matrix(arr,1);
		//int[] arr = { 2, 1, 1, 5, 6, 2, 3, 1 };
		
//		int numCourses = 4;
//		int[][] prerequisites = {
//				{1,0},
//				{2,0},
//				{3,1},
//				{3,2}
//		};
//		
		
		//int[] prices = {1,3,2,8,4,9};
//		MyStack s = new MyStack();
//		s.push(1);
//		s.push(2);
//		s.pop();
//		s.pop();
//		System.out.println(s.getMin());
//		s.push(10);
//		System.out.println(s.getMin());
//		s.printMinArray();
		
		//int ans = minRemoval(arr);
		
		//int ans = maxProfit(prices,2);
		
		//System.out.println(oneEditDis("cad","cade"));
		
		//findOrder(numCourses,prerequisites);
		
		//int[] nums= {};
		
		//O(nlogn)
		//System.out.println(LIS(nums));
//		
//		String t=",right now,";
//		
//		String[] test = t.split(",");
//		System.out.println(test.length);
//		for(String s:test)
//			System.out.println(s);
		
		int[] arr= {2,1,5};
		System.out.println(coin(arr,11));
		
		
		
		
}
	public static int LongestIncSum(int[] arr) {
		int len=arr.length;
		if(len==0)
			return 0;
		
		ArrayList<Integer> dp=new ArrayList<Integer>();
		
		
		dp.add(arr[0]);
		int sum=arr[0];
		int max=arr[0];
		
		for(int i=1;i<len;i++) {
			if(arr[i]>dp.get(dp.size()-1)) {
				dp.add(arr[i]);
				sum+=arr[i];
				max=sum;
			}
			else {
				int temp=binarySearch(dp,arr[i],0,dp.size()-1);
				if((sum-arr[temp]+arr[i])>max) {
					dp.set(temp, arr[i]);
				}
					
			}
			
		}
		return -1;
	}
	public static int binarySearch(ArrayList<Integer> dp,int elem,int s,int e){
        
        int start=s;
        int end=e;
        
        while(start<end){
            int mid=start+(end-start)/2;
            
            if(dp.get(mid)>=elem)
                	end=mid;
                else
                    start = mid+1;
                
            
        }
        
        return end;
    }
    
    public static int LIS(int[] nums) {
        int len = nums.length;
       ArrayList<Integer> dp=new ArrayList<>();
        
        dp.add(nums[0]);
        
        for(int i=1;i<nums.length;i++){
            if(dp.get(dp.size()-1)<nums[i])
                dp.add(nums[i]);
            else{
                int temp=binarySearch(dp,nums[i],0,dp.size()-1);
               // System.out.println(temp);
                dp.set(temp,nums[i]);
            }

        }
        
        return dp.size();
    }
	
	public static boolean oneEditDis(String s1,String s2) {
		if(s1.equals(s2))
			return false;
		
		int l1=s1.length();
		int l2=s2.length();
		
		if(l2<l1)
			oneEditDis(s2,s1);
		
		if(l2-l1 > 1)
			return false;
		
		for(int i=0;i<l1;i++) {
			if(s1.charAt(i)!=s2.charAt(i)) {
				if(l1==l2)
					return s1.substring(i+1).equals(s2.substring(i+1));
				else
					return s1.substring(i).equals(s2.substring(i+1));
			}
		}
	
		return (l1+1 == l2);
	
	}
	
	 public static int[] findOrder(int numCourses, int[][] prerequisites) {
	        
	        ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>(numCourses);
	        
	        int s=-1;
	        
	        int[] res = new int[numCourses];
	        
	        for(int i=0;i<numCourses;i++){
	            g.add(new ArrayList<Integer>());
	        }
	        
	        for(int i=0;i<prerequisites.length;i++)
	            addEdge(g,prerequisites[i]);
	        
	        for(int i=0;i<numCourses;i++){
	            if(g.get(i).size()!=0){
	                s=i;
	                break;
	            }
	                
	        }
	        
	        bfs(res,g,numCourses,s);
	        
	        return res;
	        
	    }
	    
	    public static void addEdge(ArrayList<ArrayList<Integer>> adj,int[] nodes){
	        adj.get(nodes[1]).add(nodes[0]);
	    }
	    
	    public static void bfs(int[] res,ArrayList<ArrayList<Integer>> adj,int v,int s){
	        Boolean[] visited = new Boolean[v];
	        Arrays.fill(visited, false);
	        int k=0;
	        Queue<Integer> q = new LinkedList<>();
	        
	        q.add(s);
	        visited[s]=true;
	        
	        while(!q.isEmpty()){
	            int temp = q.poll();
	            res[k]=temp;
	            k++;
	            for(int i:adj.get(temp)){
	                if(visited[i]==false){
	                    visited[i]=true;
	                    q.add(i);
	                }
	            }
	        }
	        
	    }
	
	private static int maxProfit(int[] prices, int fee) {
		 if(prices.length <=0){
	            return 0;
	        }
	        
	        int[][] dp = new int[prices.length][2];
	        dp[0][0]=0;
	        dp[0][1]= -prices[0]-fee;
	        
	        for(int i=1;i<prices.length;i++){
	            dp[i][0] = Math.max(dp[i-1][1]+prices[i],dp[i-1][0]);
	            dp[i][1] = Math.max(dp[i-1][0]-prices[i]-fee,dp[i-1][1]);
	        }
	        
	        return dp[prices.length-1][0];
	}

	public static int minRemoval(int[] arr) {
		int result = 0;
        if (arr.length < 3) {
            return -1;
        }
 
        // Stores length of increasing
        // subsequence from [0, i-1]
        int[] leftIncreasing
            = new int[arr.length];
 
        // Stores length of increasing
        // subsequence from [i + 1, n - 1]
        int[] rightIncreasing = new int[arr.length];
 
        // Iterate for each position up to
        // N - 1 to find the length of subsequence
        for (int i = 1; i < arr.length; i++) {
 
            for (int j = 0; j < i; j++) {
 
                // If j is less than i, then
                // i-th position has leftIncreasing[j]
                // + 1 lesser elements including itself
                if (arr[j] < arr[i]) {
 
                    // Check if it is the maximum
                    // obtained so far
                    leftIncreasing[i]
                        = Math.max(
                            leftIncreasing[i],
                            leftIncreasing[j] + 1);
                }
            }
        }
 
        // Search for increasing subsequence from right
        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    rightIncreasing[i]
                        = Math.max(rightIncreasing[i],
                                   rightIncreasing[j] + 1);
                }
            }
        }
 
        // Find the position following the peak
        // condition and have maximum leftIncreasing[i]
        // + rightIncreasing[i]
        for (int i = 0; i < arr.length; i++) {
            if (leftIncreasing[i] != 0
                && rightIncreasing[i] != 0) {
                result = Math.max(
                    result, leftIncreasing[i]
                                + rightIncreasing[i]);
            }
        }
 
        return arr.length - (result + 1);
	}
	
	public static void matrix(int m[][],int k) {
		int sum=0,max_sum=0,res=0,r=0,c=0,count=0;;
		HashMap<address,Integer> map=new HashMap<>();
		HashSet<Integer> set = new HashSet<>();
		while(r+k<=m.length) {
			for(int i=r;i<r+k;i++) {
				for(int j=c;j<c+k;j++) {
					sum=sum+m[i][j];
				}
			}
			
			map.put(new address(r,c),sum);
			System.out.println(r+","+c);
			max_sum=Math.max(max_sum, sum);
			sum=0;
			
			if(c+k==m[0].length) {
				r++;
				c=0;
			}
			else {
				c++;
			}
		}
		
		for(Map.Entry<address,Integer> e:map.entrySet()) {
			if(e.getValue()==max_sum) {
				count++;
				int row = e.getKey().row;
				int col = e.getKey().col;
				for(int i=row;i<row+k;i++) {
					for(int j=col;j<col+k;j++) {
						if(!set.contains(m[i][j])) {
							set.add(m[i][j]);
							res=res+m[i][j];
						}
					}
					
				}
			}
		}
		System.out.println("count "+count);
		System.out.println(res);
	}
	
	public static int coin(int[] coins, int amount) {
		 if (amount == 0) {
	            return 0;
	        }
	        if (coins == null || coins.length == 0 || amount < 0) {
	            return -1;
	        }

	        int[] dp = new int[amount + 1];
	        Arrays.fill(dp, Integer.MAX_VALUE);
	        dp[0] = 0;

	        for (int c : coins) {
	            for (int i = c; i <= amount; i++) {
	                if (dp[i - c] != Integer.MAX_VALUE) {
	                    dp[i] = Math.min(dp[i-1], dp[i - c] + 1);
	                }
	            }
	        }
	        
	        if(dp[amount]==0)
	        	return -1;
	        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
	    }
		 
	}


