import java.util.*;
public class pathfind {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] adj = new int[n+1][n+1];
		for(int i =1;i<=n;i++)
		{
			for(int j =1;j<=n;j++)
			{
				adj[i][j]=in.nextInt();
			}
		}
		Queue<Integer> q =new LinkedList<Integer>();
		q.add(m);
		int[] hop = new int[n+1];
		for(int i =0;i<=n;i++)hop[i]= -1;
		boolean[] visited = new boolean[n+1];
		hop[m]=0;
		while(!q.isEmpty())
		{
			int cur = q.poll();
			visited[cur] = true;
			//System.out.println(Arrays.toString(visited));
			for(int i =1;i<=n;i++)
			{
				if(!visited[i]&&adj[cur][i]!=0)
				{
					visited[i] = true;
					q.add(i);
					
					hop[i] = hop[cur]+1;
				}
			}
			
		}
		//System.out.println(Arrays.toString(hop));
		for(int i =0;i<=n;i++)
		{
			boolean hasNext = false;
			for(int j =1;j<=n;j++)
			{
				if(hop[j]==i)
				{
					System.out.print(j+" ");
					hasNext = true;
				}
			}
			System.out.println();
			//if(!hasNext)break;
		}
		
	}

}
