import java.util.*;




public class jobhunt {
	
	public static int c;
	public static ArrayList<edge>[] adj;
	public static int ans;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int d = in.nextInt();
		int p = in.nextInt();
		c = in.nextInt();
		int f = in.nextInt();
		int s = in.nextInt();
		adj = new ArrayList[c+1];
		for(int i =0;i<=c;i++)
		{
			adj[i] = new ArrayList<edge>();
		}
		for(int i = 0;i<p;i++)
		{
			int a = in.nextInt();
			int b = in.nextInt();
			adj[a].add(new edge(b,-1*d));
		}
		for(int i = 0;i<f;i++)
		{
			int a = in.nextInt();
			int b = in.nextInt();
			int w = in.nextInt();
			adj[a].add(new edge(b,w-d));
		}
		ans = Integer.MAX_VALUE;
		bellmanford(s);
		System.out.println((ans-d)*-1);
		
	}
	public static void bellmanford(int src)
	{
	     int dist[] = new int[c+1]; 
	     for (int i=0; i<=c; i++) 
	    	 dist[i] = Integer.MAX_VALUE; 
	     dist[src] = 0; 
	  

	     for (int i=1; i<c; i++) 
	     { 
	    	 for(int j = 1;j<=c;j++)
	    	 {
	    		 for(int k = 0;k<adj[j].size();k++)
	    		 {
	    			 edge next = adj[j].get(k);
	                 if (dist[j]!=Integer.MAX_VALUE && dist[j]+next.w<dist[next.v]) 
	                         dist[next.v]=dist[j]+next.w; 
	    		 }
	    	 }
	     }
    	 for(int j = 1;j<=c;j++)
    	 {
    		 for(int k = 0;k<adj[j].size();k++)
    		 {
    			 edge next = adj[j].get(k);
                 if (dist[j]!=Integer.MAX_VALUE && dist[j]+next.w<dist[next.v]) 
                 {
                	 ans=1;
                	 return;
                 }
    		 }
    	 }
    	 
	     for(int i = 1;i<=c;i++)
	     {
	    	 ans = Math.min(ans, dist[i]);
	     }
	     
	}
	static class edge
	{
		int v, w;
		public edge(int v, int w)
		{
			this.v = v;
			this.w = w;
		}
	}

}
