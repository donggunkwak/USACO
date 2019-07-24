import java.util.*;
public class quad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int lim = (n-1)/2;
		int[][] d= new int[n+1][5];
		for(int i = 1;i<=n;i++)
		{
			if(i>lim)
				d[i][1]=0;
			else
				d[i][1]=1;
		}
		for(int i = 1;i<=n;i++)
		{
			for(int j=1;j<=4;j++)
			{
				if(d[i][j]!=0)
					continue;
				if(i<j)
				{
					d[i][j]=0;
					continue;
				}
				for(int k = 1;k<=lim;k++)
				{
					if(i-k<0)
						break;
					d[i][j]+=d[i-k][j-1];
				}
			}
		}
		/*
		for(int i =0;i<=n;i++)
			System.out.println(Arrays.toString(d[i]));
			*/
		System.out.println(d[n][4]);
		
	}

}
