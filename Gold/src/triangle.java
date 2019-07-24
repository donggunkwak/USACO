import java.util.*;
public class triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] grid = new int[n][n];
		for(int i =0;i<n;i++)
		{
			for(int j = 0;j<=i;j++)
			{
				grid[i][j] = in.nextInt();
			}
		}
		int[][] d = new int[n][n];
		d[0][0] = grid[0][0];
		for(int i =1;i<n;i++)
		{
			for(int j =0;j<=i;j++)
			{
				if(j!=0)
					d[i][j] = Math.max(d[i-1][j], d[i-1][j-1])+grid[i][j];
				else
					d[i][j] = d[i-1][j]+grid[i][j];
			}
		}
		int ans = 0;
		for(int i =0;i<n;i++)
		{
			ans = Math.max(ans, d[n-1][i]);
		}
		System.out.println(ans);
/*
5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5
 */
	}

}
