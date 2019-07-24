import java.util.*;
public class change {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int c = in.nextInt();
		int n = in.nextInt();
		int[] coins = new int[n+1];
		for(int i =1;i<=n;i++)
		{
			coins[i] = in.nextInt();
		}
		Arrays.sort(coins);
		int[][] d = new int[n+1][c+1];
		for(int i =0;i<=c;i++)
		{
			d[0][i] = Integer.MAX_VALUE;
		}
		for(int i =0;i<=n;i++)
		{
			d[i][0] = 0;
		}
		for(int i =1;i<=n;i++)
		{
			for(int j =1;j<=c;j++)
			{
				if(j-coins[i]<0)
				{
					d[i][j] = d[i-1][j];
					continue;
				}
				d[i][j] = Math.min(d[i-1][j],d[i][j-coins[i]]+1);
			}
		}
		/*
		for(int i =0;i<=n;i++)
		{
			System.out.println(Arrays.toString(d[i]));
		}
		*/
		System.out.println(d[n][c]);
		
	}

}
