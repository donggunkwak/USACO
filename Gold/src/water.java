import java.util.*;
public class water {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] wells = new int[n];
		for(int i =0;i<n;i++)
		{
			wells[i] = in.nextInt();
		}
		int[][] mat = new int[n][n];
		for(int i =0;i<n;i++)
		{
			for(int j =0;j<n;j++)
			{
				mat[i][j]=in.nextInt();
				
			}
		}
		int[] dist = wells;
		boolean[] visited = new boolean[n];
		
		for(int i =0;i<n;i++)
		{
			//System.out.println(Arrays.toString(dist));
			//System.out.println(Arrays.toString(visited));
			int min = -1;
			for(int j =0;j<n;j++)
			{
				if(!visited[j] && (min==-1||dist[j]<dist[min]))
				{
					min=j;
				}
			}
			//System.out.println(min);
			visited[min] = true;
			for(int j =0;j<n;j++)
			{
				if(mat[min][j]!=0&&!visited[j]&&dist[j]>mat[min][j])
					dist[j]= mat[min][j];
			}
		}
		//System.out.println(Arrays.toString(dist));
		int ans = 0;
		for(int i = 0;i< n;i++)
		{
			ans+=dist[i];
		}
		System.out.println(ans);
		
		/**
		 * 
4
5
4
4
3
0 2 2 2
2 0 3 3
2 3 0 4
2 3 4 0

		 */
	}
	

}
