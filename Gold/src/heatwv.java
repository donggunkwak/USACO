import java.util.*;
public class heatwv {
	public static int t;
	public static ArrayList<edge>[] adj;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		t = in.nextInt();
		int c = in.nextInt();
		int start = in.nextInt();
		int end = in.nextInt();
		adj = new ArrayList[t+1];
		for(int i =0;i<=t;i++)
		{
			adj[i] = new ArrayList<edge>();
		}
		for(int i = 0;i<c;i++)
		{
			int p = in.nextInt();
			int q= in.nextInt();
			int w = in.nextInt();
			adj[p].add(new edge(q,w));
			adj[q].add(new edge(p,w));
		}
		System.out.println(dijkstra(start,end));
	}
	public static int dijkstra(int s, int e)
	{
		PriorityQueue<edge> pq = new PriorityQueue<edge>();
		pq.add(new edge(s,0));
		int[] d = new int[t+1];
		boolean[] visited = new boolean[t+1];
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
