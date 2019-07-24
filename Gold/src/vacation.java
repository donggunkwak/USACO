import java.util.*;
public class vacation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		int q = in.nextInt();
		long[][] mat = new long[n+1][n+1];
		for(int i =0;i<=n;i++)
		{
			Arrays.fill(mat[i], Integer.MAX_VALUE);
		}
		for(int i = 0;i<=n;i++)
		{
			mat[i][i]=0;
		}
		for(int i = 0;i<m;i++)
		{
			mat[in.nextInt()][in.nextInt()] = in.nextInt();
		}
		for(int i = 1;i<=n;i++)
		{
			for(int s = 1;s<=n;s++)
			{
				for(int d = 1;d<=n;d++)
				{
					if(mat[s][d]>mat[s][i]+mat[i][d])
					{
						mat[s][d] = mat[s][i]+mat[i][d];
					}
				}
			}
		}
		//mat[s][i]!=Integer.MAX_VALUE&&mat[i][d]!=Integer.MAX_VALUE&&
		//&&(i<=k||s<=k||d<=k)
		//for(int i =1;i<=n;i++)
		//{
		//	System.out.println(Arrays.toString(mat[i]));
		//}
		int cnt = 0;
		long sum = 0;
		for (int i=0; i<q; i++)
		{
			int u = in.nextInt();
			int v = in.nextInt();
			long cost=Integer.MAX_VALUE;
			for (int j=1; j<=k; j++)
				cost=Math.min(cost,mat[u][j]+mat[j][v]);
			if (cost!=Integer.MAX_VALUE) 
			{
				cnt++;
				sum+=cost;
			}
		  }
		System.out.println(cnt);
		System.out.println(sum);
		
	}

}
