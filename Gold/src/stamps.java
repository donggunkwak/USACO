import java.util.*;
public class stamps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		int n = in.nextInt();
		int[] stamps = new int[n+1];
		for(int i =1;i<=n;i++)
			stamps[i] = in.nextInt();
		int[][] d = new int[n+1][1000001];
		for(int i=0;i<=1000000;i++)
		{
			d[0][i]=Integer.MAX_VALUE;
		}
		d[1][0]=0;
		d[0][0]=1;
		
		for(int i =1;i<=n;i++)
		{
			for(int j =1;j<=1000000;j++)
			{
				if(j-stamps[i]<0)
				{
					d[i][j] = d[i-1][j];
					continue;
				}
				d[i][j] = Math.min(d[i-1][j], d[i][j-stamps[i]]+1);
			}
		}
		/*
		for(int i =1;i<=n;i++)
		{
			System.out.println(Arrays.toString(d[i]));
		}
		*/
		for(int i =1;i<=1000000;i++)
		{
			if(d[n][i]>k)
			{
				System.out.println(i-1);
				return;
			}
		}

		
	}

}
