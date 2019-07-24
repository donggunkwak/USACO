import java.util.*;
public class editdistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String a = "0"+in.next();
		String b = "0"+in.next();
		int[][] d=  new int[a.length()][b.length()];
		for(int i =0;i<b.length();i++)
		{
			d[0][i]=i;
		}
		for(int i =0;i<a.length();i++)
		{
			d[i][0]=i;
		}
		for(int i =1;i<a.length();i++)
		{
			for(int j=1;j<b.length();j++)
			{
				int rc = 1;
				if(a.charAt(i)==b.charAt(j))
					rc =0;
				d[i][j] = Math.min(d[i-1][j-1]+rc, Math.min(d[i-1][j]+1, d[i][j-1]+1));
			}
		}
		System.out.println(d[a.length()-1][b.length()-1]);
		
	}

}
