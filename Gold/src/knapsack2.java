import java.util.*;
public class knapsack2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int c = in.nextInt();
		int[] s = new int[n+1];
		int[] v = new int[n+1];
		for(int i =1;i<=n;i++)
		{
			s[i] = in.nextInt();
			v[i] = in.nextInt();
		}
		int[][] d= new int[2][c+1];
		for(int i =1;i<=n;i++)
		{
			for(int j =1;j<=c;j++)
			{
				if(j-s[i]<0)
				{
					d[i%2][j] = d[(i-1)%2][j];
					continue;
				}
				d[i%2][j] = Math.max(d[(i-1)%2][j], d[(i-1)%2][j-s[i]]+v[i]);
			}
		}
		System.out.println(d[n%2][c]);
		
		
	}

}
