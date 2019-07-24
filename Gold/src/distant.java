import java.util.*;
public class distant {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		in.nextLine();
		char[][] grid = new char[n][n];
		for(int i =0;i<n;i++)
		{
			grid[i] = in.nextLine().toCharArray();
		}
		int[][] mat = new int[n*n][n*n];
		//if(n==29)return;
/*
0 1 2
3 4 5
6 7 8
 */
		for(int i =0;i<n*n;i++)
		{
			Arrays.fill(mat[i], Integer.MAX_VALUE);
		}
		for(int i =0;i<n;i++)
		{
			for(int j = 0;j<n;j++)
			{
				int cur = i*n+j;
				if(i!=0)
				{
					int next = (i-1)*n+j;
					if(grid[i][j]!=grid[i-1][j])
					{
						mat[cur][next] = b;
					}
					else
					{
						mat[cur][next]=a;
					}
				}
				if(j!=0)
				{
					int next = i*n +(j-1);
					if(grid[i][j]!=grid[i][j-1])
					{
						mat[cur][next] = b;
					}
					else
					{
						mat[cur][next]=a;
					}
				}
				if(i!=n-1)
				{
					int next = (i+1)*n +j;
					if(grid[i][j]!=grid[i+1][j])
					{
						mat[cur][next] = b;
					}
					else
					{
						mat[cur][next]=a;
					}
				}
				if(j!=n-1)
				{
					int next = i*n +(j+1);
					if(grid[i][j]!=grid[i][j+1])
					{
						mat[cur][next] = b;
					}
					else
					{
						mat[cur][next]=a;
					}
				}
			}
		}
		/*
		for(int i =0;i<n*n;i++)
		{
			System.out.println(Arrays.toString(mat[i]));
		}
		*/
        for (int k = 0; k < n*n; k++) 
        { 
            for (int i = 0; i < n*n; i++) 
            { 
                for (int j = 0; j < n*n; j++) 
                { 
                    // If vertex k is on the shortest path from 
                    // i to j, then update the value of dist[i][j] 
                    if (mat[i][k]!=Integer.MAX_VALUE&&mat[k][j]!=Integer.MAX_VALUE&&mat[i][k] + mat[k][j] < mat[i][j]) 
                        mat[i][j] = mat[i][k] + mat[k][j]; 
                } 
            } 
        } 
        /*
		for(int i =0;i<n*n;i++)
		{
			System.out.println(Arrays.toString(mat[i]));
		}
		*/
        int ans  =0;
        for(int i = 0;i<n*n;i++)
        {
        	for(int j = 0;j<n*n;j++)
        	{
        		if(mat[i][j]==Integer.MAX_VALUE)continue;
        		ans = Math.max(ans, mat[i][j]);
        	}
        }
        System.out.println(ans);
		
		
	}

}
