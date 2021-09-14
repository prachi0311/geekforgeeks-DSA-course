package codes;

import java.util.ArrayList;

public class ArrayQues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {6,4,2,-5,2,-9,10,-1,4};
		ArrayQues obj = new ArrayQues();
		
		//recap(arr,arr.length,3);
		
		//equillibrium_alt(arr,arr.length);
		
		//int ans = largestNum(arr,arr.length);
		
		//removeDup(arr,arr.length);
		
		//zeroesToEnd(arr,arr.length);
		
		//leftrotate(arr,arr.length);
		
		//leftRotD(arr,arr.length,2);
		
		//leaderInArr(arr,arr.length);
		
		//maxDiff(arr,arr.length);
		
		//freq(arr,arr.length);
		
		//int ans = consecutiveOnes(arr,arr.length);
		
		//int ans = stockBuySell(arr,arr.length);
		
		
		//int ans = trapRainWater(arr,arr.length);
		
		int ans=maxSumSubarray(arr,arr.length);
		
		//int ans = evenOdd(arr,arr.length);
		
		//int ans = maxCirSubarraySum(arr,arr.length);
		
	    //minGroupFlips(arr,arr.length);//Implement more efficient method
		
	    //WINDOW SLIDING TECH
	    //1. Max sum of subarray of size k
		
		 //int ans = maxSumK(arr,arr.length,2);
		 
		//2. Find if there exists a subarray with given sum
		 
		//findSumSubarray(arr,arr.length,21);
		
		//To Do
	    //prefix sum, perform sum(i,j) int O(1)
		
		//int ans = equillibrium(arr,arr.length);
		
		//To Do
		//1.Find duplicate in unsorted array  using hashmap and w/ hashmap
		
		//rearrange(arr,arr.length);
		
		//int ans = maxIndex(arr,arr.length);
		
		//stockBuyAndSell(arr,arr.length);
	    
		
        System.out.println(ans);

	}
	
	//Another way to do Equillibrium problem in space O(1)
	
	public static void equillibrium_alt(int[] arr,int n) {
		int total_sum=0,l_sum=0;
		
		for(int i=0;i<n;i++) {
			total_sum=total_sum+arr[i];
		}
		
		for(int i=0;i<n;i++) {
			l_sum=l_sum+arr[i];
			if(i==0) {
				if(total_sum-arr[i]==0) {
					System.out.println("Equillibriumm exists at "+arr[i]);
				}
			}
			else {
				if((l_sum-arr[i])==(total_sum-l_sum)) {
					System.out.println("Equillibrium exists at "+arr[i]);
				}
			}
		}
	}
	
	public static ArrayList<ArrayList<Integer> > stockBuyAndSell(int A[], int n) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int k=0,start=0,i=0;
        
        if(n == 1){
            return res;
        }
        
        for(i=1;i<n;i++){
            if(A[i] > A[i-1]){
                if(start==0) {
                	ArrayList<Integer> obj = new ArrayList<>();
                	obj.add(i-1);
                	res.add(obj);
                }
                
                
             start++;
             
            }
            else{
            	if(start!=0) {
                res.get(k).add(i-1);
                k++;
                start=0;
            	}
            }
        }
        
        if(!res.get(k).isEmpty()) {
        	res.get(k).add(i-1);
        }
        
     return res;
        
    }
	
	public static int maxIndex(int[] arr,int n) {
		int lmin[] = new int[n];
		int[] rmax = new int[n];
		
		lmin[0]=arr[0];
		rmax[n-1]=arr[n-1];
		
		for(int i=1;i<n;i++) {
			lmin[i]=Math.min(lmin[i-1], arr[i]);
		}
		
		for(int i=n-2;i>=0;i--) {
			rmax[i]=Math.max(rmax[i+1], arr[i]);
		}
		
		int i=0,j=0,max_diff=0;
		while(i<n && j<n) {
			if(lmin[i]<rmax[j]) {
				max_diff=Math.max(max_diff, j-i);
				j++;
			}
			else {
				i++;
			}
		}
		
		return max_diff;
	}
	
	public static void rearrange(int[] arr,int n) {
 int min=0,max=n-1;
         
         int max_elem = arr[max]+1;
         for(int i=0;i<n;i++){
           
             if(i%2==0){
                 arr[i]=arr[i]+(arr[max]%max_elem)*max_elem;
                 max -= 1;
             }
             else{
                 arr[i] = arr[i]+(arr[min]%max_elem)*max_elem;
                 min +=1;
             }
         }
         
         for(int i=0;i<n;i++){
             arr[i]=arr[i]/max_elem;
         }
            
 }
	
	
	public static int equillibrium(int[] arr,int n) {
			
		int[] prefix = new int[n];
		int i=0;
		prefix[0] = arr[0];
		for(i=1;i<n;i++) {
			prefix[i] = arr[i]+prefix[i-1];
		}
		
		for(i=0;i<n;i++) {
			
			if(i==0) {
				if((prefix[n-1]-prefix[i])==0) {
					return arr[i];
				}
//				System.out.println("equillbrium exists at index "+i);
//				break;}
			}
			
			else{
				
				if(prefix[i-1] == (prefix[n-1]-prefix[i])) {
					return arr[i];
//					System.out.println("equillibrium exists at index "+i);
//					break;
				}
			}
		}
		
		return -1;
//	if(i==n) {
//		
//		System.out.println("equillibrium does not exists");
//	}
		
	}
	
	public static void findSumSubarray(int[] arr,int n,int sum) {
		
		int tempSum=0,k=0,i=0;
		
		for(i=0;i<2*n;i++) {
			if(tempSum<sum) {
				tempSum=tempSum+arr[k];
				k++;
			}
			else if(tempSum > sum) {
				tempSum=tempSum-arr[i-k];
			}
			
			else {
				System.out.println("exist");
				break;
			}
		}
		
		if(i==2*n) {
			System.out.println("does not exist");
		}
		
	}
	
	public static int maxSumK(int[] arr,int size,int k) {
		int sum=0,max=0;
		for(int i=0;i<k;i++) {
			sum=sum+arr[i];
		}
		max=sum;
		
		for(int i=k;i<size;i++) {
			sum = sum + (arr[i]-arr[i-k]);
			
			if(sum>max) {
				max=sum;
			}
		}
		
	  return max;
	}
	
	public static int trapRainWater(int[] arr,int n) {
		int[] left_max=new int[n];
		left_max[0]=arr[0];
		int[] right_max=new int[n];
		right_max[n-1]=arr[n-1];
		int totalWater=0;
		
		for(int i=1;i<n;i++) {
			left_max[i]=Math.max(arr[i], left_max[i-1]);
		}
		
		for(int i=n-2;i>=0;i--) {
			right_max[i]=Math.max(arr[i],right_max[i+1]);
		}
		
		for(int i=1;i<n-1;i++) {
			totalWater=totalWater + (Math.min(left_max[i], right_max[i])-arr[i]);
		}
		
		return totalWater;
	}
	
	
	public static int stockBuySell(int[] arr,int n) {
		
		int profit=0;
		
		for(int i=1;i<n;i++) {
			if(arr[i]>arr[i-1]) {
				profit=profit+(arr[i]-arr[i-1]);
				//System.out.println(profit);
			}
		}
		
		return profit;
	}
	
	public static void minGroupFlips(int[] arr,int n) {
		int count=0,i=0;
		for(i=1;i<n;i++) {
			if(arr[i]!=arr[0] ) {
				if(count == 0)
				System.out.print("flip from "+i+" to ");
				
				count++;
			}
			else {
				if(count != 0) {
					System.out.println(i-1);
					count=0;
				}
			}
			
		}
		
		if(count!=0) {
			System.out.println(i-1);
		}
	}
	
	public static void flip(int[] arr,int n,int flip) {
		int cnt=0;
		for(int i=0;i<n;i++) {
			if(arr[i]==flip) {
				cnt++;
				if(cnt==1)
				System.out.print("flip from "+i);
				
			}
			else {
				
				if(cnt!=0)
					System.out.println(" to "+(i-1));
				cnt=0;
			}
			
			
		}
	}
	
	public static int maxCirSubarraySum(int[] arr,int n) {
		int temp[] = new int[n];
		temp[0]=arr[0];
		int maxSum=0,totalSum=0,minSum=0,cirMax=0;
		for(int i=1;i<temp.length;i++) {
			
			temp[i]=Math.max(arr[i], arr[i]+temp[i-1]);
			
			if(temp[i]>maxSum) {
				maxSum=temp[i];
			}
		}
		
		for(int i=0;i<n;i++) {
			totalSum=totalSum+arr[i];
		}
		
		for(int i=1;i<temp.length;i++) {
			
			temp[i]=Math.min(arr[i], arr[i]+temp[i-1]);
			
			if(temp[i]<minSum) {
				minSum=temp[i];
			}
		}
		
		cirMax=totalSum - minSum;
		
		if(cirMax > maxSum) {
			maxSum = cirMax;
		}
			
		return maxSum;
		

	}
	
	public static int evenOdd(int[] arr,int size) {
		int count=1,max=0;
		
		for(int i=1;i<size;i++) {
			if(arr[i]%2==0 && arr[i-1]%2!=0) {
				count++;
			}
			else if(arr[i]%2!=0 && arr[i-1]%2==0){
				count++;
			}
			else {
				if(count>max)
					max=count;
				
				count=0;
			}
		}
		
		if(count>max) {
			max=count;
		}
		
		return max;

	}
	
	public static int maxSumSubarray(int[] arr,int n) {
		
		int[] res=new int[n];
		res[0]=arr[0];
		int max=res[0];
		
		for(int i=1;i<n;i++) {
			res[i]=Math.max(arr[i], arr[i]+res[i-1]);
			System.out.print(res[i]+", ");
			if(res[i]>max) {
				max=res[i];
			}
		}
		
		System.out.println();
		
		return max;
	}
	
	public static int consecutiveOnes(int[] arr,int n) {
		int count=0,max=0;
		
		for(int i=0;i<n;i++) {
			if(arr[i]==1) {
				count++;
			}
			else {
				if(count>max)
					max=count;
				
				count=0;
			}
		}
		if(count>max)
			max=count;
		
		return max;
	}
	
	/*public static int trapWater(int[] arr,int n) {
		int max=Math.max(arr[0],arr[1]),sum=0;
		
		for(int i=0;i<n;i++) {
			)
		}
		
		
		
	}*/
	
	public static void freq(int[] arr,int n) {
		int count=1;
		
		for(int i=1;i<n;i++) {
			if(arr[i]==arr[i-1]) {
				//System.out.println(i);
				count++;
			}
			else {
				
				System.out.println(arr[i-1]+": "+count);
				count=1;
				
			}
			
		}
		
		System.out.println(arr[n-1]+": "+count);
		
	}
	
	public static void maxDiff(int[] arr,int n) {
		int max=arr[1]-arr[0],minVal=arr[0];
		
		for(int i=0;i<n;i++) {
			max=Math.max(max, arr[i]-minVal);
			minVal=Math.min(arr[i], minVal);
		}
		
		System.out.println(max);
	}
	
	public static void leaderInArr(int[] arr,int n) {
		int temp=n-1;
		System.out.print(arr[temp]+", ");
		for(int i=n-1;i>=0;i--) {
			if(arr[i]>arr[temp]) {
				temp=i;
				System.out.print(arr[i]+", ");
			}
		}
		
	}
	
	public static void leftRotD(int[] arr,int size,int d) {
		//Reversal Method
		reverse(arr,0,d-1);
		for(int i=0;i<size;i++) {
			System.out.print(arr[i]+", ");
		}
		System.out.println();
		reverse(arr,d,size-1);
		for(int i=0;i<size;i++) {
			System.out.print(arr[i]+", ");
		}
		System.out.println();
		reverse(arr,0,size-1);
		
		for(int i=0;i<size;i++) {
			System.out.print(arr[i]+", ");
		}
		
	}
	
	public static void reverse(int[] arr,int beg,int end) {
		int temp=0;
		System.out.println("beg="+beg+" end="+end);
		while(beg<end) {
			temp = arr[beg];
			arr[beg]=arr[end];
			arr[end]=temp;
			beg++;
			end--;
		}
		
		
		
	}
	
	public static void leftrotate(int[] arr,int size) {
		int first = arr[0];
		
		for(int i=1;i<size;i++) {
			arr[i-1]=arr[i];
		}
		
		arr[size-1]=first;
		
		for(int i=0;i<size;i++) {
			System.out.print(arr[i]+", ");
		}
	}
	
	public static void zeroesToEnd(int[] arr, int size) {
		int res=0;
		
		for(int i=0;i<size;i++) {
			if(arr[i]!=0) {
				int temp = arr[res];
				arr[res]=arr[i];
				arr[i]=temp;
				res++;
			}
		}
		
		for(int i=0;i<size;i++) {
			System.out.print(arr[i]+", ");
		}
	}
	
	public static void removeDup(int[] arr,int size) {
		int res=0;
		
		for(int i=1;i<size;i++) {
			if(arr[i]!=arr[res]) {
				arr[res+1]=arr[i];
				res++;
			}
			
			
		}
		
		for(int i=0;i<size;i++) {
			System.out.print(arr[i]+", ");
		}
	}
		
	
	public static int largestNum(int[] arr,int n) {
		int max=0,sec_max=-1,ans=0;
		
		for(int i=0; i<n ;i++) {
			if(arr[i]>arr[max]) {	
				sec_max=max;
				max=i;
			}
			
			else if(arr[i]!= arr[max]) {
				if(sec_max ==-1 || arr[i]>arr[sec_max]) {
					sec_max=i;
				}
			}
			
	}
		return sec_max+1;
}
	
public static void recap(int[] arr,int n,int k) {
	int[] pref = new int[n];
	pref[0]=arr[0];
	
	for(int i=1;i<n;i++) {
		pref[i]=pref[i-1]+arr[i];
	}
	
	for(int i=0;i<n;i++) {
		if(i==0) {
			if(pref[n-1]-arr[i]==0) {
				System.out.println(arr[i]+" is equillibrium ");
			}
		}
		else {
			if(pref[i-1]==(pref[n-1]-pref[i])) {
				System.out.println(arr[i]+" is equillibrium ");
			}
					}
	}
}

	
	
	
}
