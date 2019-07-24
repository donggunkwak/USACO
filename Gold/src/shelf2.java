import java.util.*;
public class shelf2 {
	
	public static int min;
	public static int b;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		b = in.nextInt();
		int[] h = new int[n];
		int all = 0;
		for(int i =0;i<n;i++)
		{
			h[i] = in.nextInt();
			all+=h[i];
		}
		min = Integer.MAX_VALUE;
		backtrack(all,new boolean[n],h);
		System.out.println(min);
	}
	public static void backtrack(int cur, boolean[] offstack, int[] h)
	{
		if(cur<b)
		{
			return;
		}
		min = Math.min(min, cur-b);
		for(int i =0;i<h.length;i++)
		{
			if(offstack[i]) continue;
			
			offstack[i] = true;
			backtrack(cur-h[i],offstack,h);
			offstack[i] = false;
		}
		
		
	}

}
