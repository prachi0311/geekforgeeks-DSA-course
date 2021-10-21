package codes;

import java.util.ArrayList;

public class MyStack {
	
	    ArrayList<Integer> stack = new ArrayList<>();
	    ArrayList<Integer> minTillNow = new ArrayList<>();
	    int top;
	    int min;
	    MyStack(){
	         min = Integer.MAX_VALUE;
	         top=-1;
	     }
	    
	    int pop(){
	    	if(top<0)
	    		return -1;
	        minTillNow.remove(top);
	        System.out.println("arr size" + minTillNow.size());
	        int temp = stack.remove(top);
	        top--;
	        
	        if(top>=0)
	        min = minTillNow.get(top);
	        
	        return temp;
	    }
	    
	    int peek() {
	    	if(top<0) {
	    		return -1;
	    	}
	    	return stack.get(top);
	    }
	    
	    public void push(int val){
	        top++;
	        stack.add(top,val);
	        if(val<min){
	        	min=val;
	            minTillNow.add(min);
	        }
	        else{
	            minTillNow.add(min);
	        }  
	        System.out.println("arr size" + minTillNow.size());
	    }
	    
	    int getMin(){
	    	
	    	if(minTillNow.size()==0) {
	    		min=Integer.MAX_VALUE;
	    		return -1;
	    	}
	        return minTillNow.get(top);
	    }
	    
	    void printMinArray() {
	    	for(int i=0;i<minTillNow.size();i++) {
	    		System.out.println(minTillNow.get(i));
	    	}
	    }
	  
	}

