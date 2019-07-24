import java.util.*;
public class umbrella {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] x = new int[n+1];
		for(int i =1;i<=n;i++)
		{
			x[i] = in.nextInt();
		}
		Arrays.sort(x);
		int[] c = new int[m+1];
		for(int i =1;i<=m;i++)
		{
			c[i] = in.nextInt();
		}
		int[] mingreater = new int[m+1];
		int curmin = Integer.MAX_VALUE;
		for(int i=m;i>=1;i--)
		{
			curmin = Math.min(curmin, c[i]);
			mingreater[i] = curmin;
		}
		
		int[] d = new int[n+1];
		d[1] = c[1];
		for(int i =2;i<=n;i++)
		{
			int min = Integer.MAX_VALUE;
			for(int j =1;j<i;j++)
			{
				//System.out.println(c[1+x[i]-x[j]]);
				/*
				int cur = Math.min(d[j]+c[x[i]-x[j+1]+1], d[j-1]+c[x[i]-x[j]+1]);
				for(int k = x[i]-x[j+1]+1;k<=m;k++)
				{
					cur = Math.min(cur, d[j]+c[k]);
				}
				*/
				//System.out.println(mingreater[x[i]-x[j+1]+1]);
				int cur = Math.min(d[j-1]+mingreater[x[i]-x[j]+1], d[j]+mingreater[x[i]-x[j+1]+1]);
				min = Math.min(min, cur);
			}
			d[i] = min;
		}
		//System.out.println(Arrays.toString(d));
		System.out.println(d[n]);
		
	}

}
