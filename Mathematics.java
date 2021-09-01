package codes;

import java.util.Arrays;
import java.util.Scanner;


public class Mathematics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		//int n = scan.nextInt();
		int arr[]= {1,2,3,4,5};	
		int ans = 0;
		int a=4,b=6;
		
		//Sum of first n natural numbers
		//  sumofn(n);
		
		//Rotate array anti clockwise d times
		//  rotatearr(arr,5,2);
		
		//fibonacci solution with space complexity theta(1)
		//int ans = fibonacci(n);
		
		
		//ans = numofdigits(n);
		
		//ans = trailingzeroes(100);
		
		
		//GCD euclidean method 1 
		// ans = GCD1(a,b);
		 
		//GDC euclidean optimized methode
		//  ans = GCD2(a,b);
		  
		//To check if n is prime 
		//System.out.println(checkPrime(n));
		
		//Find prime factors of n
		//primeFactors(n);
		
		//Find all divisors of number
		//allDivisors(7);
		
		//find prime numbers < n
		//primeLessn(25); //write efficiant code
		
		//ans = computePower(3,6);
		
		//ans = modInverse(6,34);
		
		quadraticRoots(752,904,164);
		
		 
		//System.out.println(ans);
		scan.close();

	}
	
	 public static void quadraticRoots(int a, int b, int c) {
	        // code here
	        int d = (b*b) - 4*a*c;
	        double root1=0,root2=0;
	        double sr = Math.sqrt(d);
	        //System.out.println(d);
	        //ArrayList<Integer> sol = new ArrayList<>();
	        
	        if(d<0){
	            root1=-1;
	            root2=-1;
	        }
	        else{
	           root1 = (-b + sr)/(2*a);
	           root2 = (-b - sr)/(2*a);
	        }
	        
//	        sol.add(root1);
//	        sol.add(root2);
//	        
//	        return sol;
	    }
	
	public static int modInverse(int a , int m) {
		
		for(int i = 1; i < m ; i++) {
			if((a*i)%m == 1) {
				return i;
			}
		}
		
			return -1;
	}
	
	public static int computePower(int x,int n) {
		if(n==1) {
			return x;
		}
		
		return x*computePower(x,n/2);
	}
	
	public static void primeLessn(int n) {
		Boolean arr[] = new Boolean[n];
		
		Arrays.fill(arr, Boolean.TRUE);
		
		for(int i=2;i*i<=n;i++) {
			if(arr[i]) {
				for(int k = i*2;k<arr.length;k=k+i) {
					arr[k]=Boolean.FALSE;
				}
			}
		}
		
		for(int i=2;i<arr.length;i++) {
			if(arr[i]) {
				System.out.println(i+",");
			}
		}
	}
	
	public static void allDivisors(int n) {
		
//		for(int i=1 ; i*i <=n ; i++) {
//			if(n%i == 0) {
//				System.out.println(i+","+(n/i));
//			}
//		}
		
		//To print all divisors in increasing order
		int k=0;
		for(k=1;k*k<=n;k++) {
			if(n%k==0) {
				System.out.println(k+",");
			}
		}
		k--;
		for(;k>=1;k--) {
			if(n%k==0) {
				System.out.println(n/k+",");
			}
		}
			
	
	}
	
	public static void primeFactors(int n) {
		
		for(int i=2 ; i*i <= n ;i++) {
			
			while(n%i==0) {
				System.out.print(i+",");
				n=n/i;
			}
		}
		
		if(n>1) {
			System.out.print(n);
		}
	}
	
	public static boolean checkPrime(int n) {
		
		if(n==2 || n==3) {
			return true;
		}
		
		if(n%2==0 || n%3==0) {
			return false;
		}
		else {
			for(int i=5 ; i*i <= n; i=i+6) {
				if(n%i==0 || n%(i+2) ==0) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static int GCD1(int a, int b) {
		
		while(a != b) {
			
			if(a>b) {
				a= a-b;
			}
			else {
				b=b-a;
			}
		}
		return a;	
	}
	
	public static int GCD2(int a, int b) {
		
		if(b==0) {
			return a;
		}
		
		return GCD2(b,a%b);
	}
	
	public static int trailingzeroes(int n) {
		//int num_two=0 // no. of two will be greater than 5 in a factorial
		//time compelxiry = theta(logn , base 5)
	    int num_five=0;
		
		for(int i=5;i<=n;i=i*5) {
			num_five = num_five + n/i;
		}
		
		return num_five;
		
	}
	
	public static int numofdigits(int n) {
		
		return (int) Math.log10((double)n) + 1;
	}
	
	public static int fibonacci(int n) {
		
		if ((n==0) || (n==1)) {
			return n;
		}
		
		int a =0;
		int b=1;
		int c=0;
		
		for(int i=2 ; i<n ;i++) {
			
			c=a+b;
			a=b;
			b=c;
		}
		
		return c;
	}
	
    public static void rotatearr(int[] arr,int n,int d) {
    	int arr1[] = new int[n];
        int temp = 0;
        // add your code here
        for(int i=0;i<n;i++){
        	System.out.println("in loop");
            if(i-d < 0){
                temp = n-(d-i);
                arr1[temp] = arr[i];
            }
            else{
                arr1[i-d] = arr[i];
            }
        }
        
        for(int j=0 ; j< n ; j++) {
        	System.out.print(arr1[j]);
        }
	}
	
	public static void sumofn(int n) {
		int sum = 0;
		sum = n*(n+1)/2;
		System.out.println(sum);
	}
		
	
}


