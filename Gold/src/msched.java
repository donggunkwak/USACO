import java.util.*;
public class msched {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] time = new int[n+1];
		ArrayList<Integer>[] adj = new ArrayList[n+1];
		for(int i =1;i<=n;i++)
		{
			time[i] = in.nextInt();
			adj[i] = new ArrayList<Integer>();
		}
		int[] ind = new int[n+1];
		for(int i =0;i<m;i++)
		{
			int a = in.nextInt();
			int b = in.nextInt();
			adj[a].add(b);
			ind[b]++;
		}
		int[] st = new int[n+1];
		int[] et = new int[n+1];
		
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i =1;i<=n;i++)
		{
			if(ind[i]==0)
				q.add(i);
		}
		while(!q.isEmpty())
		{
			int cur = q.poll();
			et[cur] = st[cur]+time[cur];
			for(int i = 0;i<adj[cur].size();i++)
			{
				st[adj[cur].get(i)] = Math.max(et[cur], st[adj[cur].get(i)]);
				ind[adj[cur].get(i)]--;
				if(ind[adj[cur].get(i)]==0)
					q.add(adj[cur].get(i));
			}
		}
		int max = 0;
		for(int i =1;i<=n;i++)
		{
			max = Math.max(max,et[i]);
		}
		System.out.println(max);
	}

}
