import java.util.*;
public class divgold {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] nums = new int[n+1];
		int sum = 0;
		for(int i =1;i<=n;i++)
		{
			nums[i]= in.nextInt();
			sum+=nums[i];
		}
		int[][] dif = new int[n+1][sum/2+1];
		int[][] ways = new int[n+1][sum/2+1];
		for(int i =0;i<=n;i++)
			ways[i][0] = 1;
		for(int i =1;i<=n;i++)
		{
			for(int j =1;j<=sum/2;j++)
			{
				if(j-nums[i]<0)
				{
					dif[i][j] = dif[i-1][j];
					ways[i][j]+=ways[i-1][j];
					continue;
				}
				dif[i][j] = Math.max(dif[i-1][j],dif[i][j-nums[i]]+nums[i]);
				ways[i][j] += ways[i-1][j]+ways[i-1][j-nums[i]]%1000000;
				ways[i][j]=ways[i][j]%1000000;
			}
		}
		System.out.println(sum-(dif[n][sum/2]*2));
		System.out.println(ways[n][sum/2]%1000000);
		
		
	}

}
