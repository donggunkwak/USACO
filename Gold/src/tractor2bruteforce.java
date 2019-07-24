import java.util.*;
public class tractor2bruteforce {
	public static int n;
	public static int ans;
	public static int half;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int[][] grid = new int[n][n];
		for(int i = 0;i<n;i++)
		{
			for(int j = 0;j<n;j++)
			{
				grid[i][j] = in.nextInt();
			}
		}
		half = n*n;
		if(half%2==1)
			half = half/2 +1;
		else
			half = half/2;
	
		ans = Integer.MAX_VALUE;
		for(int i = 0;i<n;i++)
		{
			for(int j =0;j<n;j++)
			{
				dfs(i,j,grid,new boolean[n][n],1,Integer.MAX_VALUE,0);
			}
		}
		System.out.println(ans);
	}
	public static void dfs(int x, int y, int[][] grid, boolean[][] visited, int cur,int min, int max)
	{
		if(x==-1||y==-1||x>=n||y>=n||visited[x][y])
		{
			//System.out.println("broke");
			return;
		}
		visited[x][y]=true;
		min = Math.min(min, grid[x][y]);
		max = Math.max(max, grid[x][y]);
		if(cur>=half)
		{
			ans = Math.min(max-min, ans);
		}
		dfs(x+1,y,grid, visited,cur+1,min,max);

		dfs(x,y+1,grid, visited,cur+1,min,max);
		
		dfs(x-1,y,grid, visited,cur+1,min,max);
		
		dfs(x,y-1,grid, visited,cur+1,min,max);
	}

}
