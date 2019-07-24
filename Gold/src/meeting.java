import java.util.*;
public class meeting {
	  public static int[][] bessieGrid;
	  public static int[][] elsieGrid;

	  public static boolean[] bessieCan;
	  public static boolean[] elsieCan;

	  static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int m = in.nextInt();
	    bessieGrid = new int[n][n];
	    elsieGrid = new int[n][n];
		for(int i =0;i<m;i++)
		{
			int a = in.nextInt()-1;
			int b = in.nextInt()-1;
			int c = in.nextInt();
			int d = in.nextInt();
		    bessieGrid[a][b] = c;
		    elsieGrid[a][b] = d;
		}
		bessieCan = new boolean[20000];
	    elsieCan = new boolean[20000];
		int ans = Integer.MAX_VALUE;
	    dfs(bessieGrid, bessieCan, 0, 0);
	    dfs(elsieGrid, elsieCan, 0, 0);
	    for(int i =0;i<bessieCan.length;i++)
	    {
	        if(bessieCan[i] && elsieCan[i]) 
	        {
	            ans = i;
	            break;
	          }
	    }
		if(ans==Integer.MAX_VALUE)
		{
			System.out.println("IMPOSSIBLE");
			return;
		}
		System.out.println(ans);
		
	}
	  public static void dfs(int[][] dist, boolean[] can, int currV, int currD) {
		  if(currV == n-1)
		  {
			  
		      can[currD] = true;
		      return;
		  }
		  for(int a = currV+1; a < n; a++) 
		  {
		      if(dist[currV][a] > 0) 
		      {
		    	  dfs(dist, can, a, currD + dist[currV][a]);
		      }
		  }
	  }

}
