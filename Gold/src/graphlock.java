import java.util.*;


public class graphlock {

	public static int n;
	public static int m;
	public static int t;
	public static char[][] time;
	public static int ans;
	public static int[] d;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		t = in.nextInt();
		time = new char[n+1][t];
		for(int i =1;i<=n;i++)
		{
			String next = in.next();
			for(int j =0;j<t;j++)
			{
				time[i][j] = next.charAt(j);
			}
		}
		boolean[][] mat = new boolean[n+1][n+1];
		for(int i =0;i<m;i++)
		{
			int p = in.nextInt();
			int q = in.nextInt();
			mat[p][q] = true;
			mat[q][p] = true;
		}
		for(int i =1;i<=n;i++)
		{
			for(int s=1;s<=n;s++)
			{
				if(mat[s][i])
					for(int e =1;e<=n;e++)
					{
						if(mat[i][e])
						{
							mat[s][e] = true;
						}
					}
			}
		}
		d = new int[n+1];
		Arrays.fill(d, Integer.MAX_VALUE);
		//BFS
		BFS(mat, 1, 0);
		//System.out.println(Arrays.toString(d));
		if(d[n]==Integer.MAX_VALUE)
			ans=0;
		else
			ans=d[n];
		System.out.println(ans-1);
	}
	
	public static void BFS(boolean[][] mat, int cur, int curtime)
	{
		//System.out.println(Arrays.toString(d));
		if(cur==n)
		{
			d[cur] = curtime;
			return;
		}
		if(curtime>d[cur])
		{
			return;
		}
		d[cur] = curtime;
		//System.out.println(cur+" "+curtime);
		for(int i = 1;i<=n;i++)
		{
			if(mat[cur][i]&&time[i][curtime%t]==time[cur][curtime%t])
			{
				BFS(mat,i,curtime+1);
			}
		}
	}
	

}
