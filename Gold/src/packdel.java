import java.util.*;

public class packdel {
	public static int n;
	public static ArrayList<edge>[] adj;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int m = in.nextInt();
		adj = new ArrayList[n+1];
		for(int i =0;i<=n;i++)
			adj[i] = new ArrayList<edge>();
		for(int i = 0;i<m;i++)
		{
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			adj[a].add(new edge(b,c));
			adj[b].add(new edge(a,c));
		}
		System.out.println(dijkstra(1,n));
		
		
	}
	public static int dijkstra(int s, int e)
	{
		PriorityQueue<edge> pq = new PriorityQueue<edge>();
		pq.add(new edge(s,0));
		int[] d = new int[n+1];
		boolean[] visited = new boolean[n+1];
		Arrays.fill(d, Integer.MAX_VALUE);
		while(!pq.isEmpty())
		{
			edge curedge = pq.poll();
			int cur = curedge.e;
			int curw = curedge.w;
			visited[cur] = true;
			for(int i =0;i<adj[cur].size();i++)
			{
				edge nextedge = adj[cur].get(i);
				int next = nextedge.e;
				int nextw = nextedge.w;
				if(!visited[next]&&curw+nextw<d[next])
				{
					d[next] = curw+nextw;
					pq.add(new edge(next,d[next]));
				}
			}
			
		}
		
		return d[e];
	}
	static class edge implements Comparable<edge>
	{
		int e, w;
		public edge(int e, int w)
		{
			this.e = e;
			this.w = w;
		}
		public int compareTo(edge that)
		{
			return this.w-that.w;
		}
	}
}
