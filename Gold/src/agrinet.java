import java.util.*;
public class agrinet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] mat = new int[n][n];
		for(int i = 0;i<n;i++)
		{
			for(int j =0;j<n;j++)
			{
				mat[i][j] = in.nextInt();
			}
		}
		int[] dist = new int[n];
		boolean[] visited = new boolean[n];
		for(int i =0;i<n;i++)
		{
			dist[i] = Integer.MAX_VALUE;
		}
		dist[0] = 0;
		
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
				if(mat[min][j]!=0&&dist[j]>mat[min][j])
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
		
	}

}
