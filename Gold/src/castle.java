import java.util.*;
public class castle {
	
	public static int n;
	public static int m;
	public static int[][] roomno;
	public static int[] roomsize;
	public static int[][] rooms;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		rooms = new int[m][n];
		for(int i =0;i<m;i++)
		{
			for(int j =0;j<n;j++)
			{
				rooms[i][j] = in.nextInt();
			}
		}
		roomno = new int[m][n];
		roomsize = new int[n*m +1];
		int curno = 1;
		for(int i =0;i<m;i++)
		{
			for(int j =0;j<n;j++)
			{
				if(roomno[i][j]!=0)continue;
				dfs(i,j,curno);
				curno++;
			}
		}
		///for(int i =0;i<m;i++)
		//{
		//	System.out.println(Arrays.toString(roomno[i]));
		//}
		System.out.println(curno-1);
		int largestroom =0;
		for(int i =1;i<curno;i++)
		{
			largestroom=Math.max(largestroom,roomsize[i]);
		}
		System.out.println(largestroom);
		int maxbreak =0;
		for(int i =0;i<m;i++)
		{
			for(int j =0;j<n;j++)
			{
				if(i+1<m&&roomno[i+1][j]!=roomno[i][j])
				{
					maxbreak=Math.max(maxbreak, roomsize[roomno[i+1][j]]+roomsize[roomno[i][j]]);
				}
				if(i-1>=0&&roomno[i-1][j]!=roomno[i][j])
				{
					maxbreak=Math.max(maxbreak, roomsize[roomno[i-1][j]]+roomsize[roomno[i][j]]);
				}
				if(j+1<m&&roomno[i][j+1]!=roomno[i][j])
				{
					maxbreak=Math.max(maxbreak, roomsize[roomno[i][j+1]]+roomsize[roomno[i][j]]);
				}
				if(j-1>=0&&roomno[i][j-1]!=roomno[i][j])
				{
					maxbreak=Math.max(maxbreak, roomsize[roomno[i][j-1]]+roomsize[roomno[i][j]]);
				}
			}
		}
		System.out.println(maxbreak);
	}
	public static void dfs(int x, int y, int roomnum)
	{
		if(x<0||x>=m||y<0||y>=n||roomno[x][y]!=0)
			return;	
		roomno[x][y]=roomnum;
		roomsize[roomnum]++;
		String curroom = Integer.toBinaryString(rooms[x][y]);
		while(curroom.length()<4)
			curroom="0"+curroom;
		//System.out.println(curroom+":"+rooms[x][y]);
		if(curroom.charAt(0)=='0')//s
		{
			dfs(x+1,y,roomnum);
		}
		if(curroom.charAt(1)=='0')//e
		{
			dfs(x,y+1,roomnum);
		}
		if(curroom.charAt(2)=='0')//n
		{
			dfs(x-1,y,roomnum);
		}
		if(curroom.charAt(3)=='0')//w
		{
			dfs(x,y-1,roomnum);
		}
		
	}

}
