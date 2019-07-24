import java.util.*;
public class moomoo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int b = in.nextInt();
		int[] cows = new int[b+1];
		for(int i =1;i<=b;i++)
		{
			cows[i] = in.nextInt();
		}
		int[] v = new int[n];
		int max = 0;
		for(int i = 0;i<n;i++)
		{
			v[i]  =in.nextInt();
			max = Math.max(max, v[i]);
		}
		int[][] d =new int[b+1][max+1];
		for(int i =0;i<=max;i++)
		{
			d[0][i] = 1000000;
		}
		for(int i =0;i<=b;i++)
		{
			d[i][0] = 0;
		}
		for(int i =1;i<=b;i++)
		{
			for(int j =1;j<=max;j++)
			{
				if(j-cows[i]<0)
				{
					d[i][j] = d[i-1][j];
					continue;
				}
				d[i][j] = Math.min(d[i-1][j],d[i][j-cows[i]]+1);
			}
		}
		int[] curvol = new int[n];
		/*
		for(int i =0;i<=b;i++)
			System.out.println(Arrays.toString(d[i]));
		*/
		int count = 0;
		for(int i =0;i<n;i++)
		{
			int next = v[i]-curvol[i];
			if(d[b][next]!=1000000)
			{
				curvol[i] = v[i];
				count+=d[b][next];
				for(int j=1;j<v[i];j++)
				{
					if(i+j>=n)
						break;
					curvol[i+j]=v[i]-j;
				}
			}
			else
			{
				System.out.println(-1);
				return;
			}
		}
		System.out.println(count);
		
	}

}
