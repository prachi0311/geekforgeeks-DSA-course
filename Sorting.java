package codes;

public class Sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {5,4,3,2,1};
		//bubbleSort(arr);
		//fizzBuzz(15);
		//selectionSort(arr);
		//insertionSort(arr);
		
		mergerSort(arr,0,arr.length-1);
		for(int m:arr) {
			System.out.print(m+",");
		}

	}
	
	public static void mergerSort(int arr[],int l,int r) {
		
		if(l<r) {
			
		int m = l+(r-l)/2;
		System.out.println("m="+m);
		mergerSort(arr,l,m);
		mergerSort(arr,m+1,r);
		merge(arr,l,m,r);
		}
	}
	
	public static void merge(int[] arr, int l,int m,int r) {
		
		 int n1 = m - l + 1;
	        int n2 = r - m;
	        
	        System.out.println(m);
	  
	        /* Create temp arrays */
	        int L[] = new int[n1];
	        int R[] = new int[n2];
	  
	        /*Copy data to temp arrays*/
	        for (int i = 0; i < n1; ++i)
	            L[i] = arr[l + i];
	        for (int j = 0; j < n2; ++j)
	        	R[j] = arr[m + 1 + j];
	        
	        int i=0,j=0,k=l;
	        
	        while(i<n1 && j<n2) {
	        	if(L[i]<R[j]) {
	        		arr[k]=L[i];
	        		i++;
	        		k++;
	        	}
	        	else {
	        		arr[k]=R[j];
	        		j++;
	        		k++;
	        	}
	        }
	        
	        if(i<n1) {
	        	while(i!=n1) {
	        		arr[k]=L[i];
	        		i++;
	        		k++;
	        	}
	        }
	        else if(j<n2) {
	        	while(j!=n2) {
	        		arr[k]=R[j];
	        		j++;
	        		k++;
	        	}
	        }
	}
	
	public static void insertionSort(int[] arr) {
		
		for(int i=0;i<arr.length;i++) {
			int key=arr[i];
			int j=i-1;
			while(j>=0 && arr[j]>key) {
				arr[j+1]=arr[j];
				j--;
			}
			
			arr[j+1]=key;
		}
		
		for(int m:arr) {
			System.out.print(m+",");
		}
	}
	
	public static void selectionSort(int arr[]) {
		int min=Integer.MAX_VALUE;
		int k=-1;
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				if(arr[j]<min) {
					min=arr[j];
					k=j;
				}
			}
			
			int temp=arr[i];
			arr[i]=arr[k];
			arr[k]=temp;
			min=Integer.MAX_VALUE;
			k=-1;
		}
		
		for(int m:arr) {
			System.out.print(m+",");
		}
		
	}
	
	public static void fizzBuzz(int n) {
		String res="";
		
		for(int i=1;i<n+1;i++) {
			if(i%3==0 && i%5==0) {
				res=res+"fizzbuzz";
			}
			else if(i%3==0) {
				res=res+"fizz";
			}
			else if(i%5==0) {
				res=res+"buzz";
			}
			else {
				res=res+String.valueOf(i);
			}
		}
		
		System.out.println(res);
	}
	
	public static void bubbleSort(int[] arr) {
		
		for(int i=0;i<arr.length;i++) {
			System.out.println();
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
			
			for(int m:arr) {
				System.out.print(m+",");
			}
			
		}
		
		for(int i:arr) {
			System.out.print(i+",");
		}
	}

}
