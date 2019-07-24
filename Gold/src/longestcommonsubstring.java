import java.util.*;
public class longestcommonsubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in =new Scanner(System.in);
		String x = "0"+in.next();
		String y = "0"+in.next();
		int[][] d =new int[x.length()][y.length()];
		int ans =0;
		for(int i =1;i<x.length();i++)
		{
			for(int j =1;j<y.length();j++)
			{
				if(x.charAt(i)==y.charAt(j))
				{
					d[i][j] = d[i-1][j-1]+1;
					ans = Math.max(d[i][j], ans);
				}
			}
		}
		System.out.println(ans);
		
	}

}
