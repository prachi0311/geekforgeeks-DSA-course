package codes;

import java.util.ArrayList;

public class Searching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {10,20,10,30};
		int arr1[]= {2,4,6};
		//binarySearch(arr,1);
		
		//int ans = binaryRec(arr,0,arr.length-1,5);
		
		//firstOcc(arr,5);
		
		//int ans = firstOccRec(arr,0,arr.length-1,20);
		
		//int ans = lastOcc(arr,20);
		
		//To Do
		
		//1.Find occurenced in sorted array
		
		//int ans = totalOccurence(arr,6);
		
		//2.Find occurence of 1 in sorted binary array
		
		//int ans = OccurenceofOne(arr);
		
		//3.find square root using binary
		
		//int ans = sqrt(4);
		
		//4.unbounded binary search
		 
		//int ans = unboundedBinary(arr,20);
		
		//Find element in sorted rotated array in O(logn)
		
		//int ans=sortedRotatedBinary(arr,5);
		
		//segragate(arr);
		
		//int ans = missingNum(arr,arr.length);
		
		//sum of pair = x in sorted array
		
		//System.out.println(sumPair(arr,1));
		
		//To Do Try to understant this again.
		//findMedian(arr,arr1);
		
		//To Do
		//findMajority
		
		//To Do
		//Do the repeating element problem with loop method
		//int ans = repeatingElem(arr,arr.length);
		
		int ans = allocateMinPage(arr,2);
		
		//int ans = findStud(arr,50);
		
		System.out.println(ans);
	}
	
	public static int allocateMinPage(int[] arr,int k) {
		int max=0,min=0,beg=0,end=0,res=0;
		
		for(int i=0;i<arr.length;i++) {
			max = max+arr[i];
		}
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>min) {
				min=arr[i];
			}
		}
		
		beg=min;
		end=max;
		
		while(beg<=end) {
			int mid = (beg+end)/2;
			
			if(findStud(arr,mid) == k) {
				res=mid;
				end=mid-1;
			}
			else {
				beg=mid+1;
			}
		}
		
		return res;
	}
	
	public static int findStud(int[] arr,int max) {
		int stud=0,sum=0;
		
		for(int i=0;i<arr.length;i++) {
			int x = sum+arr[i];
			if(x<=max) {
				sum=x;
			}
			else {
				sum=0;
				i=i-1;
				stud++;
			}
		}
		
		if(sum>0) {
			stud++;
		}
		
		return stud;
	}
	
	public static int repeatingElem(int[] arr,int n) {
		
		for(int i=0;i<n;i++) {
			int x = Math.abs(arr[i]);
			
			if(x < n) {
				
				if(arr[x] > 0) {
					arr[x]=-arr[x];
				}
				else if(arr[x]==0) {
					arr[x]=-n;
				}
				else {
					return x;
				}
			}
		}
		
		return 0;
	}
	
	public static void mergeSorted(int[] arr1,int[] arr2) {
		int len = arr1.length + arr2.length,p1=0,p2=0,i=0;
		int[] res = new int[len];
		float median =0;
		
		for(i=0;i<len;i++) {
			if(p1 < arr1.length && p2<arr2.length) {
			if(arr1[p1]<arr2[p2]) {
				res[i]=arr1[p1];
				p1++;
			}
			else {
				res[i]=arr2[p2];
				p2++;
			}
			}
			else {
				break;
			}
			
		}
		
		if(p1<arr1.length) {
			for(;i<len;i++) {
				res[i]=arr1[p1];
				p1++;
			}
		}
		else {
			for(;i<len;i++) {
				res[i]=arr2[p2];
				p1++;
			}
		}
		
		if(len%2 == 0) {
			int num1 = res[(len-1)/2], num2 = res[len/2];
			median = (float)(num1+num2)/2;
			
		}
		else {
			median = res[len/2];
		}
		
		System.out.println(median);
		
	}
	
	public static boolean sumPair(int[] arr,int num) {
		int beg=0,end=arr.length-1;
		
		if(arr.length==1 ) {
			if(arr[0]==num)
				return true;
		}
		
		while(beg<end) {
			int sum = arr[beg] + arr[end];
			if(sum == num) {
				return true;
			}
			else if(sum > num) {
				end--;
			}
			else {
				beg++;
			}
		}
		
		return false;
	}
	
	public static int missingNum(int[] arr,int size) {
		
		  int shift = segragate(arr);
		  
		  int[] arr2 = new int[shift];
	
	        for(int i=0;i<shift;i++){
	          arr2[i] = arr[i];
	        }
	          
	       return findMissingPos(arr2,arr2.length);
	}
	
	public static int findMissingPos(int[] arr,int size) {
		
		int res=0,i=0,k=0;
		ArrayList<Integer> zero = new ArrayList<>();
		
		if(size==1 && arr[0] == 0){
		    return 1;
		}
		
		for(i=0;i<size;i++) {
			int x = Math.abs(arr[i]);
			
			if(x-1<size && x-1>=0 && arr[x-1]>0) {
//				if(arr[x-1]==0)
//			    zero.add(x-1);
				arr[x-1]=-arr[x-1];
			}
		}
		
//		for(int m=0;m<zero.size();m++){
//		    int test = zero.get(m);
//		    arr[test]=-1;
//		}
		
		for(i=0;i<size;i++) {
			if(arr[i]>0) {
				return i+1;
			}
		}
		
		return size+1;
		
	}
	
	 public static int segragate(int[] arr){
	        int temp=0,swap=0;
	        
	        for(int i=0;i<arr.length;i++){
	            if(arr[i]>0){
	            	swap = arr[temp];
	                arr[temp]=arr[i];
	                arr[i]=swap;
	                temp++;
	            }
	        }
	        
	        return temp;
	    }
	
	public static int unboundedBinary(int[] arr,int num) {
		int beg=0,end=0,mid=0,pos=1;
		if(arr[0] == num) {
			return 0;
		}
		while(arr[pos]<=num) {
			pos=pos*2;
		}

		beg = pos/2;
		return binaryRec(arr,beg,pos,num);
	}
	
	public static int sqrt(int num) {
		
		int beg=1,end=num-1,mid=0,res=0;
		//System.out.println(end);
		while(beg<=end) {
			//System.out.println(end);
			mid=(end+beg)/2;
		    //System.out.println(beg+" "+end);
			if((mid*mid) == num) {
				res = mid;
				break;
			}
			else if(mid*mid > num)
				end = mid-1;
			else {
				beg=mid+1;
				res = mid;
			}		
		}
		
		return res;
	}
	public static int OccurenceofOne(int[] arr) {
		if(firstOcc(arr,1)!=-1) {
			return arr.length-firstOcc(arr,1);
		}
		else {
			return 0;
		}
	}
	
	public static int totalOccurence(int[] arr,int num) {
		
		if(firstOcc(arr,num)!=-1)
			return (lastOcc(arr,num) - firstOcc(arr,num))+1;
		else
			return 0;
	}
	
	public static int sortedRotatedBinary(int[] arr,int num) {
		int start=0,end=arr.length-1,mid=0;
		
		while(start<end) {
			
			mid=(end+start)/2;
			if(arr[mid]==num) {
				return mid;
			}
			
			if(arr[start]<=arr[mid]) {
				if(num>=arr[start] && num<arr[mid]) {
					end=mid-1;
				}
				else {
					start=mid+1;
				}
			}
			else {
				if(num>arr[mid] && num<=arr[end]) {
					start=mid+1;
				}
				else {
					end=mid-1;
				}
			}
		}
		
		return -1;
		
	}
	
	public static int lastOcc(int arr[],int n) {
		int beg=0,end=arr.length-1,mid=0;
		while(beg<=end) {
			mid=(end+beg)/2;
			if(n>arr[mid]) {
				beg=mid+1;
			}
			else if(n<arr[mid]){
				
				end=mid-1;
			}	
			else {
				
				if(mid==arr.length-1 || arr[mid]!=arr[mid+1]){
					return mid;
				}
				else {
					beg = mid+1;
					//System.out.println(beg+","+end);
				}
			}
		}
		
		return -1;
	}
	public static int firstOcc(int arr[],int n) {
		int beg=0,end=arr.length-1,mid=0;
		while(beg<=end) {
			mid=(end+beg)/2;
			
			if(n>arr[mid]) {
				beg=mid+1;
			}
			else if(n<arr[mid]){
				end=mid-1;
			}	
			else {
				if(mid==0 || arr[mid-1]!=n){
					return mid;
				}
				else {
					end = mid-1;
				}
			}
		}
		
		return -1;
		
	}
	
	public static int firstOccRec(int arr[],int beg,int end,int n) {
		if(beg>end) {
			return -1;
		}
		int mid = (end+beg)/2;
		if(arr[mid]==n) {
			if(mid!=0 && arr[mid-1]==n) {
				return firstOccRec(arr,beg,mid-1,n);
			}
			else {
				return mid;
			}
		}
		
		if(n>arr[mid]) {
			return binaryRec(arr,mid+1,end,n);
		}
		else {
			return binaryRec(arr,beg,mid-1,n);
		}
		
		
	}
	
	public static int binaryRec(int arr[],int beg,int end,int n) {
		if(end<beg) {
			return -1;
		}
		int mid = (end+beg)/2;
		if(arr[mid]==n) {
			return mid;
		}	
		if(n>arr[mid]) {
			return binaryRec(arr,mid+1,end,n);
		}
		else {
			return binaryRec(arr,beg,mid-1,n);
		}
		
		
	}
	
	public static void binarySearch(int arr[],int n) {
		int beg=0,end=arr.length-1,mid=0;
		while(beg<=end) {
			 mid=(end+beg)/2;
			 System.out.println(mid);
		if(arr[mid] == n) {
			System.out.println("element found");
			break;
		}
		else {
			if(n>arr[mid]) {
				beg=mid+1;
			}
			else {
				end=mid-1;
			}
		}
		}	
		if(beg>end) {
			System.out.println("not found");
		}
	}

}
