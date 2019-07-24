import java.util.*;
public class egroup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] cows = new int[n];
		int[] cowsreverse = new int[n];
		int[] curcows = new int[n];
		for(int i =0;i<n;i++)
		{
			cows[i] = in.nextInt();
			cowsreverse[n-i-1] = cows[i];
		}
		int[] d = new int[n];
		d[0] = 0;
		int ans = Integer.MAX_VALUE;
		curcows = cows.clone();
		for(int i =1;i<n;i++)
		{
			if(curcows[i]<curcows[i-1])
			{
				int changeall = 0;
				for(int j =0;j<i;j++)
				{
					if(cows[j]>cows[i])
						changeall++;
				}
				if(changeall<=d[i-1]+1)
				{
					d[i] = changeall;
				}
				else
				{
					curcows[i] = curcows[i-1];
					d[i] = d[i-1]+1;
				}
			}
			else
				d[i] = d[i-1];
		}
		System.out.println(Arrays.toString(curcows));
		System.out.println(Arrays.toString(d));
		ans = Math.min(ans, d[n-1]);
		d = new int[n];
		curcows = cowsreverse.clone();
		d[0] = 0;
		for(int i =1;i<n;i++)
		{
			if(curcows[i]<curcows[i-1])
			{
				int changeall = 0;
				for(int j =0;j<i;j++)
				{
					if(cowsreverse[j]>cowsreverse[i])
						changeall++;	
				}
				if(changeall<=d[i-1]+1)
				{
					d[i] = changeall;
				}
				else
				{
					curcows[i] = curcows[i-1];
					d[i] = d[i-1]+1;
				}
			}
			else
				d[i] = d[i-1];
		}
		System.out.println(Arrays.toString(curcows));
		System.out.println(Arrays.toString(d));
		System.out.println(Math.min(ans,d[n-1]));
	}

}
