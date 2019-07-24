import java.util.*;
public class contest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		boolean[][] mat = new boolean[n+1][n+1];
		int start = 0;
		for(int i =1;i<=n;i++)
			mat[i][i] =true;
		for(int i = 0;i<m;i++)
		{
			int a = in.nextInt();
			int b = in.nextInt();
			mat[a][b] = true;
		}
		/*
		for(int i =1;i<=n;i++)
		{
			System.out.println(Arrays.toString(mat[i]));
		}
		*/
	    for (int k = 1; k <= n; k++) 
	    { 
	    	for (int i = 1; i <= n; i++) 
	        {
	    		if(mat[i][k])
	    		{
		    		for (int j = 1; j <= n; j++) 
		            { 
		    			if (mat[k][j]) 
		    				mat[i][j] = true; 
		            }
	    		}
	        } 
	    } 
	    int ans = 0;
	    //
		for(int i =1;i<=n;i++)
		{
			//System.out.println(Arrays.toString(mat[i]));
			boolean cango = true;
			for(int j =1;j<=n;j++)
			{
				if(!mat[i][j]&&!mat[j][i])
				{
					cango=false;
					break;
				}
			}
			if(cango) ans++;
		}
		System.out.println(ans);
	}

}
