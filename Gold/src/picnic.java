import java.util.*;
public class picnic {
	
	public static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		n = in.nextInt();
		int m = in.nextInt();
		int[] cows = new int[k];
		boolean[] cango = new boolean[n+1];
		Arrays.fill(cango, true);
		for(int i =0;i<k;i++)
		{
			cows[i] = in.nextInt();
		}
		ArrayList<Integer>[] adj = new ArrayList[n+1];
		for(int i =0;i<=n;i++)
			adj[i] = new ArrayList<Integer>();
		for(int i = 0;i<m;i++)
		{
			int a = in.nextInt();
			int b = in.nextInt();
			adj[a].add(b);
		}
		for(int i = 0;i<k;i++)
		{
			boolean[] cur = BFS(cows[i],adj);
			for(int j = 0;j<=n;j++)
			{
				cango[j] = cur[j]&cango[j];
			}
		}
		int ans = 0;
		for(int i = 0;i<=n;i++)
		{
			if(cango[i])ans++;
		}
		System.out.println(ans);
		
		
	}
	public static boolean[] BFS(int start, ArrayList<Integer>[] adj)
	{
		Queue<Integer> q=  new LinkedList<Integer>();
		q.add(start);
		boolean[] visited = new boolean[n+1];
		while(!q.isEmpty())
		{
			int next = q.poll();
			if(visited[next])continue;
			visited[next] = true;
			for(int i =0;i<adj[next].size();i++)
			{
				if(!visited[adj[next].get(i)])
				{
					q.add(adj[next].get(i));
				}
			}
		}
		return visited;
		
	}

}
