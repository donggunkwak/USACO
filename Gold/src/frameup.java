import java.util.*;
public class frameup {
	
	public static TreeSet<String> ans;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int h = in.nextInt();
		int w = in.nextInt();
		char[][] grid= new char[h][w];
		in.nextLine();
		HashSet<Character> chars = new HashSet<Character>();
		pos[] toplefts = new pos[26];
		pos[] bottomrights = new pos[26];
		for(int i =0;i<h;i++)
		{
			String next = in.nextLine();
			for(int j = 0;j<w;j++)
			{
				grid[i][j] = next.charAt(j);
				if(grid[i][j]=='.')continue;
				chars.add(grid[i][j]);
				if(toplefts[grid[i][j]-'A']==null)
				{
					toplefts[grid[i][j]-'A']=new pos(i,j);
					bottomrights[grid[i][j]-'A']=new pos(i,j);
				}
				else
				{
					if(i<toplefts[grid[i][j]-'A'].x)
					{
						toplefts[grid[i][j]-'A'] = new pos(i,j);
					}
					else if(i==toplefts[grid[i][j]-'A'].x&&j<toplefts[grid[i][j]-'A'].y)
						toplefts[grid[i][j]-'A'] = new pos(i,j);
						
				}
				if(bottomrights[grid[i][j]-'A']==null)
				{
					toplefts[grid[i][j]-'A']=new pos(i,j);
					bottomrights[grid[i][j]-'A']=new pos(i,j);
				}
				else
				{
					if(i>bottomrights[grid[i][j]-'A'].x)
					{
						bottomrights[grid[i][j]-'A'] = new pos(i,j);
					}
					else if(i==bottomrights[grid[i][j]-'A'].x&&j>bottomrights[grid[i][j]-'A'].y)
						bottomrights[grid[i][j]-'A'] = new pos(i,j);
						
				}
				
			}
		}
		//System.out.println(chars);
		System.out.println(Arrays.toString(toplefts));
		System.out.println(Arrays.toString(bottomrights));
		boolean[][] above = new boolean[chars.size()][chars.size()];
		//System.out.println('A'+25);
		HashMap<Integer,Integer> amtabove = new HashMap<Integer,Integer>();
		
		for(int i =0;i<chars.size();i++)
		{
			if(toplefts[i]==null||bottomrights[i]==null)continue;
			amtabove.put(i, 0);
			for(int j = toplefts[i].x;j<=bottomrights[i].x;j++)
			{
				if(grid[j][toplefts[i].y]-'A'!=(i))
				{
					above[grid[j][toplefts[i].y]-'A'][i]=true;
				}
				if(grid[j][bottomrights[i].y]-'A'!=i)
				{
					above[grid[j][bottomrights[i].y]-'A'][i]=true;
				}
				
			}
			for(int j = toplefts[i].y;j<=bottomrights[i].y;j++)
			{
				if(grid[toplefts[i].x][j]-'A'!=(i))
				{
					above[grid[toplefts[i].x][j]-'A'][i]=true;
				}
				if(grid[bottomrights[i].x][j]-'A'!=(i))
				{
					above[grid[bottomrights[i].x][j]-'A'][i]=true;
				}
			}
		}
		for(int i =0;i<chars.size();i++)
		{
			System.out.println(Arrays.toString(above[i]));
		}
		ans= new TreeSet<String>();
		
		
		
	}
	public static void backtrack(boolean[][] above, HashMap<Integer,Integer> amtabove, String cur)
	{
		if(cur.length()==above.length)
		{
			ans.add(cur);
			return;
		}
		
		
	}
	static class pos
	{
		int x,y;
		public pos(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
		public String toString()
		{
			return x+","+y;
		}
	}

}
