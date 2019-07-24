import java.util.*;

public class daisy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		ArrayList<Integer>[] adj = new ArrayList[n+1];
		
		for(int i =0;i<=n;i++) adj[i] = new ArrayList<Integer>();
		for(int i =0;i<m;i++)
		{
			int c1 = in.nextInt();
			int c2 = in.nextInt();
			adj[c1].add(c2);
			adj[c2].add(c1);
		}
		boolean[] connected = new boolean[n+1];
		boolean[] visited = new boolean[n+1];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		while(!q.isEmpty())
		{
			int cur = q.poll();
			if(visited[cur]) continue;
			visited[cur] = true;
			connected[cur] =true;
			for(int i =0;i<adj[cur].size();i++)
			{
				q.add(adj[cur].get(i));
			}
		}
		boolean doneany = false;
		for(int i =1;i<=n;i++)
		{
			if(!connected[i])
			{
				System.out.println(i);
				doneany = true;
			}
		}
		if(!doneany)System.out.println(0);
		
		
	}

}
