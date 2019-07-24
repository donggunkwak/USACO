import java.util.*;
public class mincostpath {

	public static void main(String[] args){
		Scanner in  = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] grid = new int[n+1][m+1];
		int[][] d = new int[n+1][m+1];
		for(int i =0;i<=n;i++)
		{
			d[i][0] = Integer.MAX_VALUE;
			d[0][i] = Integer.MAX_VALUE;
		}
		for(int i =1;i<=n;i++)
		{
			for(int j =1;j<=m;j++)
			{
				grid[i][j] = in.nextInt();
			}
		}
		d[1][1]= grid[1][1];
		for(int i =1;i<=n;i++)
		{
			for(int j =1;j<=m;j++)
			{
				if(i==1&&j==1)
					continue;
				d[i][j] = Math.min(d[i-1][j-1], Math.min(d[i-1][j], d[i][j-1]))+grid[i][j];
			}
		}
		System.out.println(d[n][m]);
		
/*
3 3
1 2 3
4 8 2
1 5 3
 */
	}
}
