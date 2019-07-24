import java.util.*;
public class marathon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k =in.nextInt();
		int[] xcoords = new int[n+1];
		int[] ycoords = new int[n+1];
		for(int i =1;i<=n;i++)
		{
			xcoords[i] = in.nextInt();
			ycoords[i] = in.nextInt();
		}
		int[][] mat = new int[n+1][n+1];
		for(int i =1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				mat[i][j] = dist(xcoords[i],ycoords[i],xcoords[j],ycoords[j]);
			}
		}
		int[][] d = new int[n+1][k+1];
		for(int i =n-1;i>=0;i--)
		{
			for(int j =k;j>=0;j--)
			{
				int min = Integer.MAX_VALUE;
				for(int a = 0;a<=k;a++)
				{
					if(j-a<0)
						break;
					if(i+a+1>n)
						break;
					min = Math.min(min, d[i+a+1][j-a]+mat[i][i+a+1]);
				}
				d[i][j] = min;
			}
		}
		System.out.println(d[1][k]);
		
	}
	
	public static int dist(int x1, int y1, int x2, int y2)
	{
		return Math.abs(x1-x2)+Math.abs(y1-y2);
	}

}
