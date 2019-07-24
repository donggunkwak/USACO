import java.util.*;
public class ttime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int Q = in.nextInt();
		boolean[][] adj = new boolean[n+1][n+1];
		for(int i =0;i<m;i++)
		{
			int a = in.nextInt();
			int b = in.nextInt();
			adj[a][b] = true;
			adj[b][a]= true;
		}
		boolean[][] cango = new boolean[n+1][n+1];
		for(int a =1;a<=n;a++)
		{
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(a);
			boolean[] visited = new boolean[n+1];
			while(!q.isEmpty())
			{
				int cur = q.poll();
				visited[cur] = true;
				//System.out.println(Arrays.toString(visited));
				for(int i =1;i<=n;i++)
				{
					if(!visited[i]&&adj[cur][i]!=false)
					{
						visited[i] = true;
						q.add(i);
						
					}
				}
			}
			cango[a] = visited; 
		}
		for(int i =0;i<Q;i++)
		{
			if(cango[in.nextInt()][in.nextInt()])System.out.println("Y");
			else System.out.println("N");
		}
		
	}

}
