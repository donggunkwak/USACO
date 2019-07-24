import java.util.*;
public class subsetsum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n+1];
		int sum = 0;
		for(int i =1;i<=n;i++)
		{
			arr[i] = i;
			sum+=i;
		}
		if(sum%2!=0)
		{
			System.out.println(0);
			return;
		}
		long[][] d = new long[n+1][sum/2 +1];
		for(int i =0;i<=n;i++)
		{
			d[i][0]	=1;
		}
		for(int i =1;i<=n;i++)
		{
			for(int j =1;j<=sum/2;j++)
			{
				if(j-arr[i]<0)
				{
					d[i][j]+=d[i-1][j];
					continue;
				}
				d[i][j]+=d[i-1][j]+d[i-1][j-arr[i]];
			}
		}
		
		/*
		for(int i =0;i<=n;i++)
		{
			System.out.println(Arrays.toString(d[i]));
		}
		*/
		System.out.println(d[n][sum/2]/2);
	}

}
