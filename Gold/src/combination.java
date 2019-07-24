import java.util.*;
public class combination {
	
	public static int[][] d;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		d = new int[n+1][k+1];
		System.out.println(choose(n,k));
	}
	public static int choose(int n, int k)
	{
		if(n==k||k==0)
			d[n][k] = 1;
		if(d[n][k]==0)
			d[n][k] = choose(n-1,k-1)+choose(n-1,k);
		return d[n][k];
	}

}
