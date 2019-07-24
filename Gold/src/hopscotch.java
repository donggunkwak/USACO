import java.util.*;
public class hopscotch {

	public static int[][] d;
	public static int[][] grid;
	public static int r;
	public static int c;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		r = in.nextInt();
		c = in.nextInt();
		int k = in.nextInt();
		grid = new int[r][c];
		for(int i =0;i<r;i++)
		{
			for(int j = 0;j<c;j++)
			{
				grid[i][j] = in.nextInt();
			}
		}
		d = new int[r][c];
		d[0][0] = 1;
		for(int x=0;x<r;x++)
		{
			for(int y = 0;y<c;y++)
			{
				if(d[x][y]==0)
					continue;
				for(int i =x+1;i<r;i++)
				{
					for(int j = y+1;j<c;j++)
					{
						if(grid[i][j]!=grid[x][y])
						{
							d[i][j]+=d[x][y]%1000000007;
							d[i][j]=d[i][j]%1000000007;
						}
					}
				}
			}
		}
		System.out.println(d[r-1][c-1]%1000000007);
	}
	
	
}
