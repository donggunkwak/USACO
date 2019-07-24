import java.util.*;

public class gspduel {

	public static int n;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int m = in.nextInt();
		ArrayList<edge>[] adj1 = new ArrayList[n+1];
		ArrayList<edge>[] adj2 = new ArrayList[n+1];
		ArrayList<edge>[] v = new ArrayList[n+1];
		for(int i =0;i<=n;i++)
		{
			adj1[i] = new ArrayList<edge>();
			adj2[i] = new ArrayList<edge>();
			v[i] = new ArrayList<edge>();
		}
		for(int i = 0;i<m;i++)
		{
			int a = in.nextInt();
			int b = in.nextInt();
			int p = in.nextInt();
			int q = in.nextInt();
			adj1[b].add(new edge(a,p));
			adj2[b].add(new edge(a,q));
		}
		int[][] dist = new int[3][n+1];
		
		dist[0]=dijkstra(n, adj1);
		dist[1]=dijkstra(n, adj2);
		for (int cur = 1; cur <= n; cur++) {
			for (int j = 0; j < adj1[cur].size(); j++) {
				int nxt = adj1[cur].get(j).e;
				int c = 0;
				int dst1 = adj1[cur].get(j).w, dst2 = adj2[cur].get(j).w;
				if (dist[0][nxt] - dist[0][cur] != dst1) c++;
				if (dist[1][nxt] - dist[1][cur] != dst2) c++;
				v[nxt].add(new edge(cur, c));
			}
		}
		dist[2] = dijkstra(1,v);
		System.out.println(dist[2][n]);	
	}	
	public static int[] dijkstra(int s, ArrayList<edge>[] adj)
	{
		PriorityQueue<edge> pq = new PriorityQueue<edge>();
		pq.add(new edge(s,0));
		int[] d = new int[n+1];
		boolean[] visited = new boolean[n+1];
		Arrays.fill(d, Integer.MAX_VALUE);
		d[s] = 0;
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
		
		return d;
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
