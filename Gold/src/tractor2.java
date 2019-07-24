import java.util.*;
public class tractor2 {
	
	public static int n;
	public static int[] roomsize;
	public static int[][] rooms;
	public static int[][] colors;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		rooms = new int[n][n];
		for(int i =0;i<n;i++)
		{
			for(int j = 0;j<n;j++)
			{
				rooms[i][j] = in.nextInt();
			}
			//System.out.println(Arrays.toString(rooms[i]));
		}
		roomsize = new int[n*n +1];
		colors = new int[n][n];
		int[] colortoheight = new int[n*n+1];
		Arrays.fill(colortoheight, -1);
		int color = 1;
		for(int i =0;i<n;i++)
		{
			for(int j =0;j<n;j++)
			{
				if(colors[i][j]!=0)continue;
				//System.out.println(rooms[i][j]);
				dfs(i,j,rooms[i][j],color);
				colortoheight[color] = rooms[i][j];
				color++;
				
				
			}
		}
		//int minheight =Integer.MAX_VALUE;
		//System.out.println(Arrays.toString(roomsize));
		//System.out.println(Arrays.toString(colortoheight));
		//System.out.println(color);
		boolean[][] cango = new boolean[color][color];
		for(int i =0;i<n;i++)
		{
			for(int j =0;j<n;j++)
			{
				if(i+1<n&&colors[i+1][j]!=colors[i][j])
				{
					cango[colors[i][j]][colors[i+1][j]]=true;
				}
				if(i-1>=0&&colors[i-1][j]!=colors[i][j])
				{
					cango[colors[i][j]][colors[i-1][j]]=true;
				}
				if(j+1<n&&colors[i][j+1]!=colors[i][j])
				{
					cango[colors[i][j]][colors[i][j+1]]=true;
				}
				if(j-1>=0&&colors[i][j-1]!=colors[i][j])
				{
					cango[colors[i][j]][colors[i][j-1]]=true;
				}
			}
			
		}
		
		for(int a =1;a<color;a++)
		{
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(a);
			boolean[] visited = new boolean[color];
			while(!q.isEmpty())
			{
				int cur = q.poll();
				visited[cur] = true;
				//System.out.println(Arrays.toString(visited));
				for(int i =1;i<color;i++)
				{
					if(!visited[i]&&cango[cur][i]!=false)
					{
						visited[i] = true;
						q.add(i);
						
					}
				}
			}
			cango[a] = visited; 
		}
		//for(int i = 0;i<color;i++)
	//	{
		//	System.out.println(Arrays.toString(cango[i]));
		//}
		
		int half = n*n;
		if(half%2==1)
			half = half/2 +1;
		else
			half = half/2;
		int ans = Integer.MAX_VALUE;
		//System.out.println(half);
		for(int i =1;i<color;i++)
		{
			if(colortoheight[i]==-1) continue;
			int curmax = colortoheight[i];
			int curmin = colortoheight[i];
			int cursize = roomsize[i];
			for(int j = i+1;j<color;j++)
			{
				if(cursize>=half)
				{
					//System.out.println(curmax+" "+ curmin+" "+ cursize);
					ans = Math.min(ans, curmax-curmin);
					//break;
				}
				if(cango[i][j]&&colortoheight[j]!=-1)
				{
					//System.out.println(colortoheight[j]);
					curmax = Math.max(curmax, colortoheight[j]); 
					curmin = Math.min(curmin, colortoheight[j]); 
					cursize+=roomsize[j];
				}
				
			}
		}
		System.out.println(ans);
	}
	public static void dfs(int x, int y, int roomnum, int color)
	{
		
		if(x==-1||y==-1||x>=n||y>=n||colors[x][y]!=0||rooms[x][y]!=roomnum)
		{
			//System.out.println("broke");
			return;
		}
		colors[x][y] = color;
		roomsize[color]++;
		dfs(x+1,y,roomnum,color);

		dfs(x,y+1,roomnum,color);
		
		dfs(x-1,y,roomnum,color);
		
		dfs(x,y-1,roomnum,color);
		
		
	}

}
