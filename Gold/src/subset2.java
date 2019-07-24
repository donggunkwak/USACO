import java.util.*;
public class subset2 {
	
	public static int t;
	public static int n;
	public static int[] nums;
	public static boolean[][] d;
	public static boolean doneonce;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		t = in.nextInt();
		nums = new int[n+1];
		for(int i = 1;i<=n;i++)
		{
			nums[i] = in.nextInt();
		}
		d = new boolean[n+1][t+1];
		for(int i =0;i<=n;i++)
		{
			d[i][0] = true;
		}
		for(int i =1;i<=n;i++)
		{
			for(int j =1;j<=t;j++)
			{
				if(j-nums[i]<0)
				{
					d[i][j] = d[i-1][j];
					continue;
				}
				d[i][j] = d[i-1][j]||d[i-1][j-nums[i]];
			}
		}
		
		if(!d[n][t])
		{
			System.out.println("No Solution");
			return;
		}
		/*
		for(int i =0;i<=n;i++)
		{
			System.out.println(Arrays.toString(d[i]));
		}
		*/
		int x = n;
		int y = t;
		backtrack(x,y,new ArrayList<Integer>(), 0);
	}
	public static void backtrack(int x, int y, ArrayList<Integer> cur, int sum)
	{
		if(doneonce)
			return;
		if(sum==t)
		{
			String ans = "";
			Collections.sort(cur);
			for(int i =0;i<cur.size();i++)
			{
				ans+=cur.get(i)+" ";
			}
			System.out.println(ans.substring(0, ans.length()-1));
			doneonce = true;
			return;
		}
		if(x<=0||y<=0)
		{
			return;
		}
		if(d[x-1][y])
		{
			backtrack(x-1,y,cur,sum);
		}
		if(y>=nums[x]&&d[x-1][y-nums[x]])
		{
			cur.add(x);
			backtrack(x-1,y-nums[x],cur,sum+nums[x]);
			cur.remove(cur.size()-1);
		}
	}

}
