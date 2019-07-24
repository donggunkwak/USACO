import java.util.*;
public class amount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] h = new int[n];
		for(int i =0;i<n;i++)
		{
			h[i] = in.nextInt();
		}
		int[] ls = new int[n];
		for(int i =1;i<n;i++)
		{
			if(h[i]>=h[i-1])
				ls[i] = ls[i-1]+1;
			else
				ls[i] = 0;
		}
		int[] rs = new int[n];
		for(int i =n-2;i>=0;i--)
		{
			if(h[i]>=h[i+1])
				rs[i] = rs[i+1]+1;
			else
				rs[i] = 0;
		}
		int ans = 0;
		for(int i =0;i<n;i++)
		{
			ans = Math.max(ans, ls[i]+rs[i]);
		}
		System.out.println(ans+1);
	}

}
