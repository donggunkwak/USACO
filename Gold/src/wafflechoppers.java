import java.util.*;
public class wafflechoppers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int r = in.nextInt();
		int c = in.nextInt();
		int h = in.nextInt();
		int v = in.nextInt();
		boolean[][] grid = new boolean[r][c];
		int[] hori =new int[r];
		int[] verti = new int[c];
		int chocolates = 0;
		for(int i =0;i<r;i++)
		{
			String nextline = in.next();
			for(int j =0;j<c;j++)
			{
				char next = nextline.charAt(j);
				if(next=='@')
					grid[i][j] = true;
				if(grid[i][j])
				{
					hori[i]++;
					verti[j]++;
					chocolates++;
				}
			}
		}
		int[] horiend = new int[h+1];
		int[] vertiend = new int[v+1];
		int count = 0;
		int cur = 0;
		int ec = chocolates/(h+1);
		for(int i =0;i<r;i++)
		{
			if(cur>h)
				break;
			count+=hori[i];
			if(count==ec)
			{
				horiend[cur] = i;
				count=0;
				cur++;
			}
			else if(count>ec)
			{
				//System.out.println("CASE 1");
				System.out.println("IMPOSSIBLE");
				return;
			}
		}
		horiend[h] = r-1;
		//
		count = 0;
		cur = 0;
		ec = chocolates/(v+1);
		for(int i =0;i<c;i++)
		{
			count+=verti[i];
			if(cur>v)
				break;
			if(count==ec)
			{
				vertiend[cur] = i;
				count=0;
				cur++;
			}
			else if(count>ec)
			{
			//	System.out.println("CASE 2");
				System.out.println("IMPOSSIBLE");
				return;
			}
		}
		vertiend[v] = c-1;
		//System.out.println(Arrays.toString(horiend));
		//System.out.println(Arrays.toString(vertiend));
		int supposed = chocolates/((v+1)*(h+1));
		//System.out.println(supposed);
		for(int i =0;i<=h;i++)
		{
			int startx = -1;
			if(i!=0)
				startx = horiend[i-1];
			for(int j =0;j<=v;j++)
			{
				int starty = -1;
				if(j!=0)
					starty= vertiend[j-1];
				int nc = 0;
				//System.out.println(startx+"->"+horiend[i]+"--"+starty+"->"+vertiend[j]);
				for(int x = startx+1; x<=horiend[i];x++)
				{
					for(int y= starty+1;y<=vertiend[j];y++)
					{
						//System.out.println(x+", "+y+grid[x][y]);
						if(grid[x][y])
							nc++;
						if(nc>supposed)
						{
							//System.out.println("CASE 3");
							System.out.println("IMPOSSIBLE");
							return;
						}
					}
				}
				//System.out.println(nc);
				if(nc!=supposed)
				{
					//System.out.println("CASE 4");
					System.out.println("IMPOSSIBLE");
					return;
				}
			}
		}
		System.out.println("POSSIBLE");
/*
4 3 1 1
@@@
@.@
@.@
@@@
3 6 1 1
.@@..@
.....@
@.@.@@
 */
	}

}
