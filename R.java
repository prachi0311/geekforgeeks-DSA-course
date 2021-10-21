package codes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

//3
//4
//5
//deposit,1,100
//withdraw,2,100
//transfer,1,2,100
//transfer,1,3,100
//deposit,2,100



public class R {
	
		public static class  Account{
	        int id;
	        int balance;
	        int total_trans;
	        int flag;
	        
	        
	        public Account(int id){
	            this.id=id;
	            balance=0;
	            total_trans=0;
	            flag=0;
	        }
	        //getters
	        int getId() {
	        	return this.id;
	        }
	        int getbalance(){
	            return this.balance;
	        }     
	        int getTran(){
	            return this.total_trans;
	        }
	       int getFlag(){
	            return this.flag;
	        }
	       
	       //setters
	       void setTran(){
	            this.total_trans++;
	        }
	        
	        void setFlag(){
	            flag++;
	        }
	        
	        void widraw(int amount){
	            this.balance = this.balance-amount;
	        }
	        void deposit(int amount){
	            this.balance = this.balance+amount;
	        }
	            
	        void reset(){
	            this.balance=0;
	            this.total_trans=0;
	        }
	        
	    }
	    public static void main(String args[] ) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
	        HashMap<Integer,Account> map = new HashMap<>();
	        ArrayList<Integer> arr = new ArrayList<>();
	        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	        String line;
//	        Scanner s = new Scanner(System.in);
	        int batch=0;
	        int limit=0;
	        int window=0;
	      
	        try {
	         batch = Integer.valueOf(stdin.readLine());
	         limit = Integer.valueOf(stdin.readLine());
	         window = Integer.valueOf(stdin.readLine());
	        }
	        catch(Exception e) {
	        	
	        }
	        
//	        String str=s.nextLine();
	        System.out.println(batch);
	        int i=0;
	        
	        

	        
	        try {
				while((line=stdin.readLine())!=null && line.length()!=0){
				    String[] temp =   line.split(",");
				    if(temp[0].equals("deposit")){
				    	int ID = Integer.valueOf(temp[1]);
				        if(!map.containsKey(ID)){
				            map.put(ID,new Account(ID));
				        }
				       
				             map.get(ID).deposit(Integer.valueOf(temp[2]));
				             map.get(ID).setTran();
				        
				    }
				    else if(temp[0].equals("withdraw")){
				    	int ID = Integer.valueOf(temp[1]);
				        if(!map.containsKey(ID)){
				            map.put(ID,new Account(ID));
				        }
				       
				             map.get(ID).widraw(Integer.valueOf(temp[2]));
				             map.get(ID).setTran();
				    }
				    else{
				    	int ID1 = Integer.valueOf(temp[1]);
				    	int ID2 = Integer.valueOf(temp[2]);
				    	
				        if(!map.containsKey(ID1)){
				            map.put(ID1,new Account(ID1));
				            
				        }
				        else if(!map.containsKey(ID2)){
				            map.put(ID2,new Account(ID2));
				        }
				        
				        map.get(ID1).widraw(Integer.valueOf(temp[3]));
				        map.get(ID2).deposit(Integer.valueOf(temp[3]));
				        map.get(ID1).setTran();
				        map.get(ID2).setTran();
				        
				    }
				    window--;
				    i++;
				       
				    if(window==0){
				    	for(Map.Entry<Integer,Account> e : map.entrySet()) {
				    		if(e.getValue().getTran()>=limit && e.getValue().getFlag()==0) {
				    			arr.add(e.getKey());
				    			e.getValue().setFlag();
				    		}
				    	}
				    }
				    if(i==batch){
				        for(Map.Entry<Integer,Account> e : map.entrySet()){
				        	if(e.getValue().getTran()>0)
				        		System.out.println(e.getKey()+","+e.getValue().getbalance());
				            e.getValue().reset();
				        }
				        if(arr.size()==0) {
				        	System.out.println("EMPTY");
				        }
				        else {
				        for(int j=0;j<arr.size();j++){
				            System.out.println(arr.get(j)+",");
				        }
				        }
				        
				        i=0;
				        arr.clear();
				    }
				    
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        for(Map.Entry<Integer,Account> e : map.entrySet()){
	        	if(e.getValue().getTran()>0)
	        		System.out.println(e.getKey()+","+e.getValue().getbalance());
	        }
	        if(arr.size()==0) {
	        	System.out.println("EMPTY");
	        }
	        else {
	        for(int j=0;j<arr.size();j++){
	            System.out.println(arr.get(j)+",");
	        }
	        }
	    
}
}
