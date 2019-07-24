import java.util.*;
public class irrigation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int c = in.nextInt();
		pos[] positions = new pos[n];
		for(int i =0;i<n;i++)
		{
			positions[i] = new pos(in.nextInt(),in.nextInt());
		}
		long[][] mat = new long[n][n];
		for(int i =0;i<n;i++)
		{
			for(int j = 0;j<n;j++)
			{
				if(dist(positions[i],positions[j])>=c)
				{
					mat[i][j]=dist(positions[i],positions[j]);
				}
			}
		}
		int[] from = new int[n];
		boolean[] mark = new boolean[n];
		Arrays.fill(from, -1);

		int x=0,l=0;
		
		for (int i=0; i<n-1; i++)
		{
			mark[x]=true;

			// expand the vertex and update edges in the queue
			for (int j=0; j<n; j++)
				if (!mark[j])
					if (mat[x][j]!=0)	// if there is (x,j) edge
						if (from[j]==-1 || mat[from[j]][j]>mat[x][j])
							from[j]=x;

			// choose the unused edge with minimum length in the queue
			x=-1;
			for (int j=0; j<n; j++)
				if (!mark[j] && from[j]!=-1)
					if (x==-1 || mat[from[x]][x]>mat[from[j]][j])
						x=j;

			// if graph is not connected
			if (x==-1)
			{
				l=-1;
				break;
			}

			// update total cost of mst
			l+=mat[from[x]][x];
		}
		System.out.println(l);
	}
	public static long dist(pos a, pos b)
	{
		return (long)Math.pow((b.x-a.x),2)+(long)Math.pow((b.y-a.y),2);
	}
	static class pos
	{
		int x, y;
		public pos(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}

}
