import java.util.*;



public class cowrouting {
	
	public static ArrayList<edge>[] adj;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int n = in.nextInt();
		adj = new ArrayList[1001];
		for(int i = 0;i<=1000;i++)
		{
			adj[i] = new ArrayList<edge>();
		}
		for(int i = 0;i<n;i++)
		{
			int cost = in.nextInt();
			int num = in.nextInt();
			int[] stuff = new int[num];
			for(int j = 0;j<num;j++)
			{
				stuff[j] = in.nextInt();
			}
			for(int j =0;j<num;j++)
			{
				for(int k = j+1;k<num;k++)
				{
					adj[stuff[j]].add(new edge(stuff[k],cost,k-j));
				}
			}
		}
		//for(int i = 0;i<=1000;i++)
		//{
			//if(adj[i].size()==0)continue;
			//System.out.println(i+":"+ adj[i].toString());
		//}
		dijkstra(a,b);
		
	}
	public static void dijkstra(int s, int e)
	{
		PriorityQueue<edge> pq = new PriorityQueue<edge>();
		pq.add(new edge(s,0,0));
		long[] d = new long[1001];
		boolean[] visited = new boolean[1001];
		pair[] path = new pair[1001];
		path[s]=new pair(-1,0);
		Arrays.fill(d, Long.MAX_VALUE);
		while(!pq.isEmpty())
		{
			edge curedge = pq.poll();
			int cur = curedge.e;
			if(visited[cur])continue;
			long curw = curedge.w;
			visited[cur] = true;
			for(int i =0;i<adj[cur].size();i++)
			{
				edge nextedge = adj[cur].get(i);
				int next = nextedge.e;
				long nextw = nextedge.w;
				int nextf = nextedge.f;
				if(!visited[next]&&curw+nextw<d[next])
				{
					d[next] = curw+nextw;
					pq.add(new edge(next,d[next],nextf));
					path[next] = new pair(cur,nextf);
				}
				else if(!visited[next]&&curw+nextw==d[next]&&path[next].f>nextf)
				{
					d[next] = curw+nextw;
					pq.add(new edge(next,d[next],nextf));
					path[next] = new pair(cur,nextf);
				}
			}
			
		}
		int length = 0;
		if(path[e]==null)
		{
			length = -1;
			d[e]=-1;
		}
		else
		{
			int cur = e;
			while(cur!=-1)
			{
				length+=path[cur].f;
				cur=path[cur].parent;
			}
		}
		System.out.println(d[e]+" " + length);
	}
	static class pair
	{
		int parent, f;
		public pair(int parent, int f)
		{
			this.parent = parent;
			this.f = f;
		}
	}
	static class edge implements Comparable<edge>
	{
		int e; 
		long w;
		int f;
		public edge(int e, long w, int f)
		{
			this.e = e;
			this.w = w;
			this.f = f;
		}
		public int compareTo(edge that)
		{
			if(this.w<that.w)
				return -1;
			else if(this.w>that.w)
				return 1;
			return 0;
		}
		public String toString()
		{
			return "("+e+","+w+"):"+f;
		}
	}

}
