import java.util.*;
public class piggyback {
	
	public static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int b  = in.nextInt();
		int e = in.nextInt();
		int p = in.nextInt();
		n = in.nextInt();
		int m = in.nextInt();
		ArrayList<Integer>[] adj = new ArrayList[n+1];
		for(int i =0;i<=n;i++)
			adj[i] = new ArrayList<Integer>();
		for(int i =0;i<m;i++)
		{
			int start = in.nextInt();
			int end = in.nextInt();
			adj[start].add(end);
			adj[end].add(start);
		}
		int[] bes = BFS(1,adj);
		int[] els = BFS(2,adj);
		int[] barn = BFS(n,adj);
		//System.out.println(Arrays.toString(bes));
		//System.out.println(Arrays.toString(els));
		//System.out.println(Arrays.toString(barn));
		/*
4 4 5 8 8
1 4
2 3
3 4
4 7
2 5
5 6
6 8
7 8
		 */
		int ans = Integer.MAX_VALUE;
		for(int i =1;i<=n;i++)
		{
			ans = Math.min(ans, bes[i]*b + els[i]*e + barn[i]*p);
		}
		System.out.println(ans);
		
	}
	public static int[] BFS(int start, ArrayList<Integer>[] adj)
	{
		Queue<Integer> q=  new LinkedList<Integer>();
		q.add(start);
		int[] ans = new int[n+1];
		Arrays.fill(ans, Integer.MAX_VALUE);
		ans[start] =0;
		boolean[] visited = new boolean[n+1];
		while(!q.isEmpty())
		{
			int next = q.poll();
			if(visited[next])continue;
			visited[next] = true;
			for(int i =0;i<adj[next].size();i++)
			{
				if(!visited[adj[next].get(i)]&&ans[next]+1<ans[adj[next].get(i)])
				{
					ans[adj[next].get(i)] = ans[next]+1;
					q.add(adj[next].get(i));
				}
			}
		}
		return ans;
		
	}

}
