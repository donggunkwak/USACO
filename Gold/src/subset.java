import java.util.*;
public class subset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int t = in.nextInt();
		int[] nums = new int[n+1];
		for(int i = 1;i<=n;i++)
		{
			nums[i] = in.nextInt();
		}
		boolean[][] d = new boolean[n+1][t+1];
		for(int i =0;i<=n;i++)
		{
			d[i][0] = true;
		}
		for(int i =1;i<=n;i++)
		{
			for(int j =1;j<=t;j++)
			{
				if(j-nums[i]<0)
				{
					d[i][j] = d[i-1][j];
					continue;
				}
				d[i][j] = d[i-1][j]||d[i-1][j-nums[i]];
			}
		}
		if(d[n][t])
			System.out.println("True");
		else
			System.out.println("False");
	}

}
