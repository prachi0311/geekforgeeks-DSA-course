package codes;

public class Bitwise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int ans=0,n=32767;
		int arr[] = {4,8,2,16};
		int arr1[] = {1,1,0,1};
		int arr2[] = {0,1,0,1};
		
		//System.out.println(kthBitSet(15,3));
		
		//ans = countSetBits(n);
		
		//System.out.println(checkPowOfTwo(8));
		
		//Find the only odd number of time occurring number in an array
		  //ans = oddNum(arr);
		
		//Find two odd appearing number in an array
		 
		//  twoOddNum(arr);
		
		//subsetOfString("abcd");
		
		//Given two arrays of numbers a1, a2, a3,...an and b1, b2, .. bn where each number is 0 or 1, the fastest algorithm to find the largest span(i, j) such that ai + ai+1, ....aj = bi + bi+1, .. bj. or report that there is not such span,
		
		//ans = maxCommonSpan(arr1,arr2);
		
		//Count total set bits in all numbers from 1 to n
		//ans = countSetBitsn(3);
		
		//ans = maxAND(arr,4);
		
		//Print Binary of Decimal
		printBinary(4);
		
		//System.out.println(ans);

	}
	
	public static void printBinary(int n) {
		
		if(n==0) {
			return;
		}
		
		printBinary(n/2);
		
		System.out.print(n%2);
		
	}
	
	public static int maxAND(int[] arr,int n) {
		
		 int k=32,patt = (int) Math.pow(2,k),value=0,count=0;
	        
	        while((int)Math.pow(2, k) >= 1){
	            int i=0;
	            for(i=0;i< n;i++){
	                if((arr[i] & patt) == patt){
	                	System.out.print(patt+",");
	                    count++;
	                }
	            }
	            
	            if(count>=2){
	                value = value + (int)Math.pow(2,k);
	                System.out.print("value=" + value);
	            }
	            
	            k=k-1;
	            
	            patt = value + (int)Math.pow(2,k);
	            
	            System.out.println("pattern="+patt);
	            count=0;
	            
	        }
	        
	        return value;
	}
	
	public static int countSetBitsn(int n) {
		int res = 0;
		double i =0;
		n=n+1;
		while(Math.pow(2, i) < n) {
			System.out.print(Math.pow(2, i)+",");
			int temp = (int) (n/Math.pow(2,i));
			System.out.print("temp="+temp+",");
			res = res + (int)(temp/2 * Math.pow(2, i));
			if( temp%2 != 0){
				System.out.print("in,");
				res = (int) (res + (n%Math.pow(2, i)));
			}
		   System.out.println(res);
			
			i++;
		}
		
		return res;
	}
	
	public static int maxCommonSpan(int[] arr1, int[] arr2) {
		
		int max_count = 0, zero_count=0, j=0;
		
		
		int xor[] = new int[arr1.length];
		for(int i=0;i<xor.length;i++) {
			xor[i] = arr1[i] ^ arr2[i];
			//System.out.println(xor[i]+",");
		}
		
		
		for(j=0;j<xor.length;j++) {
			
			if(xor[j] == 0) {
				zero_count++;
				//System.out.println(zero_count);
			}
			
			else {
				if(zero_count > max_count) {
					max_count = zero_count;
					//System.out.println(max_count);
				}
				
				zero_count=0;
			}
			
			//System.out.println(max_count);
		}
		
		if(j >= xor.length) {
			if(zero_count > max_count) {
				max_count = zero_count;
			}
		}
		
		return max_count;
		
	}
	
	public static void subsetOfString(String s) {
		
		double temp = Math.pow(2,(double)s.length());
		String res = "";
		int rot_cnt = 0;
		
		for(int i = 0 ; i < temp ;i++ ) {
			
			for(int j =0 ; j < s.length() ; j++) {
				
				if((i & (1<<j)) != 0) {
					res = res + s.charAt(j);
				}
			}
			
			System.out.print(res+",");
			res = "";
			
		/*	int tem = i;
			while(tem>0) {
				if(tem%2 != 0) {
					res = res + s.charAt(rot_cnt);
				}
				tem = tem>>1;
				rot_cnt++;
			}
			
			System.out.print(res + ",");
			res = "";
			rot_cnt = 0;*/
		}
	}
	
	public static void twoOddNum(int[] arr) {
		
		int Xor = 0, sn=0, res1=0, res2=0;
		
		for(int i=0;i<arr.length;i++) {
			Xor = Xor ^ arr[i];
		}
		
		sn = (Xor & (~(Xor-1))) ; // statement to find the last set bit in the Xor
		
		for(int i=0; i <arr.length ; i++) {
			
			if((sn ^ arr[i]) != 0) {
				res1 = res1 ^ arr[i];
			}
			
			else {
				res2 = res2 ^ arr[i];
			}
		}
		
		System.out.print(res1 + "," + res2);
			
	}
	
	public static int oddNum(int[] arr) {
		
		int ans=0;
		
		for(int i=0;i<arr.length;i++) {
			ans = ans ^ arr[i];
		}
		
		return ans;
	}
	
	public static Boolean checkPowOfTwo(int n) {
		
		if(n == 0) {
			return false;
		}
		
		return ((n & (n-1)) == 0);
	}
	
	public static int countSetBits(int n) {
	//theta(bit system 32/64)	
		int count =0;
		
	/*	while(n>0) {
		
			count = count + (n&1);
			n=n>>1;
		}*/
		
	//Method-2 Brian kerningam's algo --> theta(no. of set bits)
		
	/*	while(n>0) {
			n=n&(n-1);
			count++;
		} */
		
	//Method-3 Lookup table method
		
		int lookup[] = new int[256];
		
		for(int i=1 ; i <= 255; i++) {
			lookup[i] = (1&i) + lookup[i/2];
		}
		
		count = count + lookup[n&255];
		
		n = n>>8;
		
		count = count + lookup[n&255];
		
		n = n>>8;
		
		count = count + lookup[n&255];
		
		n = n>>8;
		
		count = count + lookup[n&255];
		
		return count;
	}
	
	public static Boolean kthBitSet(int n, int k) {
		
		/*n = n >> (k-1);
		
		if((n&1) == 1) {
			return true;
		}
		
		else {
			return false;
		}*/
		
		/***********OR****************/
		
	  if((n & (1<<(k-1))) != 0) {
		  return true;
	  }
	  else {
		  return false;
	  }
		
	
	}

}
