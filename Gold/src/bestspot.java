import java.util.*;
public class bestspot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int p = in.nextInt();
		int f = in.nextInt();
		int c = in.nextInt();
		int[] favorites = new int[f];
		for(int i =0;i<f;i++)
		{
			favorites[i] = in.nextInt();
		}
		int[][] mat = new int[p+1][p+1];
		for(int i =0;i<=p;i++)
		{
			Arrays.fill(mat[i], Integer.MAX_VALUE);
		}
		for(int i = 0;i<=p;i++)
		{
			mat[i][i]=0;
		}
		for(int i = 0;i<c;i++)
		{
			int a = in.nextInt();
			int b = in.nextInt();
			int t = in.nextInt();
			mat[a][b] = t;
			mat[b][a]=t;
		}
		for(int i = 1;i<=p;i++)
		{
			for(int s = 1;s<=p;s++)
			{
				for(int d = 1;d<=p;d++)
				{
					if(mat[s][i]!=Integer.MAX_VALUE&&mat[i][d]!=Integer.MAX_VALUE&&mat[s][d]>mat[s][i]+mat[i][d])
					{
						mat[s][d] = mat[s][i]+mat[i][d];
					}
				}
			}
		}
		int min = Integer.MAX_VALUE;
		int ans = -1;
		for(int i = p;i>=1;i--)
		{
			int cur = 0;
			for(int j = 0;j<f;j++)
			{
				cur+=mat[i][favorites[j]];
			}
			//System.out.println(i+":"+cur);
			if(cur<=min)
			{
				min  = cur;
				ans = i;
			}
		}
		System.out.println(ans);
	}

}
