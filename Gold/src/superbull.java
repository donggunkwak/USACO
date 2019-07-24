import java.util.*;
public class superbull {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ids = new int[n];
		int[][] mat = new int[n][n];
		for(int i = 0;i<n;i++)
		{
			ids[i] = in.nextInt();
		}
		for(int i = 0;i<n;i++)
		{
			for(int j = 0;j<n;j++)
			{
				mat[i][j] = -1*(ids[i]^ids[j]);
				//System.out.prlong(mat[i][j]+" ");
			}
			//System.out.prlongln();
		}
		int[] dist = new int[n];
		boolean[] visited = new boolean[n];
		for(int i =0;i<n;i++)
		{
			dist[i] = 0;
		}
		dist[0] = 0;
		
		for(int i =0;i<n;i++)
		{
			//System.out.prlongln(Arrays.toString(dist));
			//System.out.prlongln(Arrays.toString(visited));
			int min = -1;
			for(int j =0;j<n;j++)
			{
				if(!visited[j] && (min==-1||dist[j]<dist[min]))
				{
					min=j;
				}
			}
			//System.out.prlongln(min);
			visited[min] = true;
			for(int j =0;j<n;j++)
			{
				 if (mat[min][j] != 0 && visited[j] == false && mat[min][j] < dist[j])
					dist[j]= mat[min][j];
			}
		}
		//System.out.prlongln(Arrays.toString(dist));
		long ans = 0;
		for(int i = 0;i< n;i++)
		{
			ans+=dist[i];
		}
		System.out.println(ans*-1);
	}

}
