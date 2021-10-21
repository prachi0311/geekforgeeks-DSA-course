package codes;
import java.util.*;

public class Hashing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {1,1,1,1,0};
		int[] arr1 = {87,2,4};
		
		int ans=0;
		HashMap<Integer,Integer> map =new HashMap<>();
		map.put(1, 1);
		test(map);
		
		//ans = new Hashing().findDistinct(arr,arr.length);
		//ans = arrIntersection(arr,arr1);
		
		//isPair(arr,50);
		
		//subArrZero(arr);
		
		//ans = longestSubArr(arr,5);
		
		//Longest subarray with equal number of zeros and one
		//ans = longestBinary(arr,arr.length);
		
		//Longest subarray with common sum
		//ans = maxCommon(arr,arr1,arr.length,arr1.length);
		
		//Longest consequtive sunsequence
		//ans = longSubseq(arr,arr.length);
		
		//Count distinct numbers in every window
		//countDistinct(arr,4);
		
		//seperateChaining(arr);
		
		//equalOneZero(arr);
		
		//System.out.println(ans);

	}
	
	private static void equalOneZero(int[] arr) {
		// TODO Auto-generated method stub
		Map<Integer,Integer> map = new HashMap<>();
        int count=0,prefix=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                arr[i]=-1;
            }
        }
        map.put(0,1);
        for(int i=0;i<arr.length;i++){
            
            prefix+=arr[i];
            
            if(map.containsKey(prefix)){
                count=count+map.get(prefix);
                map.put(prefix,map.get(prefix)+1);
            }
            else{
                map.put(prefix,1);
            }
            
        }
        
        System.out.println(count);
		
	}
	
	public static void test(HashMap<Integer,Integer> map) {
		System.out.println(map.size());
	}

	private static void test(int[] arr, int[] arr1) {
		// TODO Auto-generated method stub
		
		HashSet<Integer> set = new HashSet<Integer>();
        for(int i:arr){
            set.add(i);
        }
        HashSet<Integer>set2 = new HashSet<Integer>();
        for(int i:arr1){
            set2.add(i);
        }
        int count=0;
       
       for(Integer i:set2){
           if(set.contains(i)){
               count++;
           }
       }
       
       System.out.println(count);
		
	}

	private static void seperateChaining(int[] arr) {
		// TODO Auto-generated method stub
		int hashSize=10;
		 ArrayList<ArrayList<Integer>> hash = new ArrayList<>(hashSize);
		 for(int i=0;i<hashSize;i++) {
			 hash.add(new ArrayList<Integer>());
		 }
	        
	        for(int i=0;i<arr.length;i++){
	            int index = arr[i]%hashSize;
	            hash.get(index).add(arr[i]);
	            //System.out.println(hash.get(index));
	        }
	        
	        for(int i=0;i<hashSize;i++) {
				 System.out.println(hash.get(i));
			 }
		
	}

	public static void countDistinct(int[] arr, int w) {
		// TODO Auto-generated method stub
		Set<Integer> set = new HashSet<>();
		int prev=0;
		for(int i=0;i<w;i++) {
			set.add(arr[i]);
			}
		prev = set.size();
		System.out.println(prev+" , ");

		for(int i=1;i<=arr.length-w+1;i++) {
			set.remove(arr[i-1]);
			if(prev==w) {
				prev=prev-1;
			}
			if(set.add(arr[i+w-1])==true){
				prev=prev+1;
				System.out.print(prev+" , ");
			}
			else {
				
				System.out.print(prev+" , ");
			}
			
		}
		
		
	}

	public static int longSubseq(int[] arr, int length) {
		// TODO Auto-generated method stub
		Set<Integer> set = new HashSet<Integer>();
		int curr=1,res=0,k=1;
		
		for(int i : arr) {
			set.add(i);
		}
		
		for(int i : set) {
			if(!set.contains(i-1)) {
				while(set.contains(i+curr)) {
					curr++;
				}
				
				res = Math.max(res, curr);
				curr=1;
			}
		}
		
		return res;
	}

	public static int maxCommon(int[] arr1,int[] arr2,int n1,int n2) {
		int[] diff = new int[n1];
		for(int i=0;i<n1;i++) {
			diff[i] = arr1[i]-arr2[i];
		}
		
		 return longestSubArr(diff,0);
		
	}
	
	public static int longestBinary(int[] arr, int n) {
		
		for(int i=0;i<n;i++) {
			if(arr[i]==0) {
				arr[i]=-1;
			}
		}
		
		return longestSubArr(arr,0);
	}
	
	public static int longestSubArr(int[] arr,int sum) {
		Map<Integer,Integer> map = new HashMap<>();
		int presum=0,max=0;
		for(int i=0;i<arr.length;i++) {
			presum = presum+arr[i];
			
			if(presum==sum) {
				max = i+1;
			}
			
			if(!map.containsKey(presum)) {
				map.put(presum, i);
			}
			if(map.containsKey(presum-sum)) {
				if((i-map.get(presum-sum)) > max) {
					max = i-map.get(presum-sum);
				}
			}			
		}
			
		return max;
			
	}
	
	public static void subArrZero(int[] arr) {
		Set<Integer> set=new HashSet<>();
		int presum = 0;
		for(int i=0;i<arr.length;i++) {
			presum = presum+arr[i];
			if(set.contains(presum)) {
				System.out.println("exits");
				return;
			}
			if(presum==0) {
				System.out.println("exits");
				return;
			}
			else {
				set.add(presum);
			}
		}
		
		System.out.println("Does not exist");
	}
	
	public static void isPair(int[]  arr,int k) {
		Set<Integer> set = new HashSet<>();
		
		for(int i:arr) {
			if(set.contains(k-i)) {
				System.out.println("True");
				return;
			}
			else {
				set.add(i);
			}
		}
		
		System.out.println("False");
	}
	
	public static int arrIntersection(int[] arr,int[] arr1) {
		HashMap<Integer,Integer> map = new HashMap<>();
		int count=0;
		for(int i:arr) {
			map.put(i,map.getOrDefault(i, 1));
		}
		
		for(int i:arr1) {
			if(map.containsKey(i) && map.get(i)==1) {
				count++;
				map.put(i, map.get(i)+1);
			}
		}
		
		return count;
	}
	
	public int findDistinct(Integer[] arr,int n) {
		
		HashSet<Integer> set = new HashSet<>(Arrays.asList(arr));
		
		return set.size();
	}
	
	public static void freq(int[] arr,int n) {
		
		Map<Integer,Integer> map=new HashMap<>();
		for(int i:arr) {
			map.put(i, map.getOrDefault(i, 0)+1);
		}
		
		for(Map.Entry<Integer, Integer> e: map.entrySet()) {
			System.out.println(e.getKey() +" : "+e.getValue());
		}
	}

}
