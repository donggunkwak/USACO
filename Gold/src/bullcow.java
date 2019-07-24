import java.util.*;
public class bullcow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		
		int[][] d= new int[n+1][2];
		d[1][0] =1;
		d[1][1] = 1;
		for(int i=0;i<=k;i++)
		{
			d[i][1] = 1;
		}
		for(int i =2;i<=n;i++)
		{
			d[i][0] = (d[i-1][1]+d[i-1][0])%5000011;
			if(i-k-1<0)
			{
				continue;
			}
			d[i][1] = (d[i-k-1][1]+d[i-k-1][0])%5000011;
		}
		System.out.println((d[n][0]+d[n][1])%5000011);
		
		
	}

}
