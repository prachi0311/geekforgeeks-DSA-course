package codes;

public class visa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] batch= {1};
		int[] time= {25};
		int[] task= {40};
		int[] num=new int[1];
		int tot_time=0;
		
		
		for(int i=0;i<1;i++) {
			if(task[i]%batch[i]!=0)
				num[i]=task[i]/batch[i]+1;
			else
				num[i]=task[i]/batch[i];
			
			tot_time=Math.max(tot_time, num[i]*time[i]);
		}
		System.out.println(tot_time);

	}

}
