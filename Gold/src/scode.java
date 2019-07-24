import java.util.*;
public class scode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String s = in.next();
		
		int[][] d = new int[s.length()][s.length()];
		
		for(int i =0;i<s.length();i++)
		{
			for(int j =i+2;j<s.length();j++)
			{
				if(j==i+2)
				{
					d[i][j]=1;
				}
				
			}
		}
	}

}
