import java.util.*;
public class longestcommonsubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String a = "0" +in.next();
		String b = "0" +in.next();
		int[][] d= new int[a.length()][b.length()];
		for(int i =1;i<a.length();i++)
		{
			for(int j = 1;j<b.length();j++)
			{
				if(a.charAt(i)==b.charAt(j))
					d[i][j] = d[i-1][j-1]+1;
				else
					d[i][j] = Math.max(d[i-1][j], d[i][j-1]);
			}
		}
		System.out.println(d[a.length()-1][b.length()-1]);
		
	}

}
