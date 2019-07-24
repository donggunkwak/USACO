import java.util.*;




public class roadblock {
	
	public static int n;
	public static int[] path;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int m = in.nextInt();
		ArrayList<edge>[] adj = new ArrayList[n+1];
		for(int i =0;i<=n;i++)
		{
			adj[i] = new ArrayList<edge>();
		}
		for(int i = 0;i<m;i++)
		{
			int p = in.nextInt();
			int q= in.nextInt();
			int w = in.nextInt();
			adj[p].add(new edge(q,w));
			adj[q].add(new edge(p,w));
		}
		path = new int[n+1];
		int smallest = dijkstra(1,n,true, adj);
		int cur = n;
		int ans = smallest;
		while(cur!=-1)
		{
			int prev = path[cur];
			//for(int i =1;i<=n;i++)
			//{
			//	System.out.println(adj[i].toString());
			//}
			if(prev==-1)
				break;
			for(int i = 0;i<adj[prev].size();i++)
			{
				if(adj[prev].get(i).e==cur)
				{
					int w = adj[prev].get(i).w;
					adj[prev].remove(i);
					adj[prev].add(new edge(cur,w*2));
					break;
				}
			}
			for(int i = 0;i<adj[cur].size();i++)
			{
				if(adj[cur].get(i).e==prev)
				{
					int w = adj[cur].get(i).w;
					adj[cur].remove(i);
					adj[cur].add(new edge(prev,w*2));
					break;
				}
			}
			ans = Math.max(ans, dijkstra(1,n,false,adj));
			int w1 = adj[cur].get(adj[cur].size()-1).w;
			adj[cur].remove(adj[cur].size()-1);
			adj[cur].add(new edge(prev,w1/2));
			w1 = adj[prev].get(adj[prev].size()-1).w;
			adj[prev].remove(adj[prev].size()-1);
			adj[prev].add(new edge(cur,w1/2));
			//System.out.println(prev+" "+ cur+ " "+ans+ " "+ adj[cur].get(adj[cur].size()-1).w);
			cur = prev;
		}
		System.out.println(ans-smallest);
	}
	public static int dijkstra(int s, int e, boolean first, ArrayList<edge>[] adj)
	{
		PriorityQueue<edge> pq = new PriorityQueue<edge>();
		pq.add(new edge(s,0));
		int[] d = new int[n+1];
		if(first)
			path[s] = -1;
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
					//System.out.println(cur+"->"+next+" "+ nextw);
					d[next] = curw+nextw;
					pq.add(new edge(next,d[next]));
					if(first)
						path[next] = cur;
				}
			}
		}
		//System.out.println(Arrays.toString(d));
		
		
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
		public String toString()
		{
			return "("+e+","+w+")";
		}
	}

}
