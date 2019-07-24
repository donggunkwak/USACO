import java.util.*;

public class pwrfail {

	public static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int w = in.nextInt();
		double m = in.nextDouble();
		pos[] a = new pos[n+1];
		for(int i =1;i<=n;i++)
		{
			a[i] = new pos(in.nextInt(),in.nextInt());
		}
		double[][] mat = new double[n+1][n+1];
		HashSet<Integer> already = new HashSet<Integer>();
		for(int i = 0;i<w;i++)
		{
			int pi = in.nextInt();
			int pj = in.nextInt();
			mat[pi][pj] = distance(a[pi],a[pj]);
			mat[pj][pi] = distance(a[pi],a[pj]);
			already.add(pi);
			already.add(pj);
		}
		for(int i = 1;i<=n;i++)
		{
			for(int j =1;j<=n;j++)
			{
				if(distance(a[i],a[j])<=m)
					mat[i][j] =distance(a[i],a[j]);
			}
			//System.out.println(Arrays.toString(mat[i]));
		}
		System.out.println((int)(dijkstra(1,n,mat,already)*1000));
	}
	public static double dijkstra(int s, int e, double[][] mat, HashSet<Integer> already)
	{
		
		
		double[] d = new double[n+1];
		boolean[] visited = new boolean[n+1];
		int[] path = new int[n+1];
		path[s] = -1;
		Arrays.fill(d, Integer.MAX_VALUE);
		d[s] = 0;
		for(int i =1;i<=n;i++)
		{
	        double min = Integer.MAX_VALUE;
	        int min_index=-1; 
	        
	        for (int v = 1; v <=n; v++) 
	        {
	            if (visited[v] == false && d[v] <= min) 
	            { 
	                min = d[v]; 
	                min_index = v; 
	            } 
	        }
	        if(visited[min_index])continue;
			visited[min_index] = true;
			for(int v=1;v<=n;v++)
			{
                if (!visited[v] && mat[min_index][v]!=0.0 && d[min_index] != Integer.MAX_VALUE 
                		&& d[min_index]+mat[min_index][v] < d[v]) 
                {
                    d[v] = d[min_index] + mat[min_index][v];
                    path[v] = min_index;
                }
			}
		}
			
		//System.out.println(Arrays.toString(d));
		//System.out.println(Arrays.toString(path));
		int cur = e;
		double ans = 0;
		if(path[cur]==0)
		{
			ans=-0.001;
			return ans;
		}
		while(cur!=-1)
		{
			if(cur==0)
			{
				ans=-.001;
				break;
			}
			if(already.contains(cur)&&already.contains(path[cur]))
			{
				cur = path[cur];
				continue;
			}
			//System.out.println(cur);
			if(cur==s)
			{
				cur=-1;
				continue;
			}
			ans+=d[cur]-d[path[cur]];
			//System.out.println(ans);
			cur = path[cur];
		}
		return ans;
	}
	static class pos
	{
		int x,y;
		public pos(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	public static double distance(pos a, pos b)
	{
		return Math.sqrt(Math.pow(a.x-b.x, 2)+Math.pow(a.y-b.y, 2));
	}

}
