import java.util.*;
public class tribonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println(tribonacci(in.nextInt()));
	}
	public static long tribonacci(int n)
	{
		long[] d = new long[n];
		d[0] = 0;
		d[1] = 0;
		d[2] = 1;
		for(int i =3;i<n;i++)
		{
			d[i] = d[i-1]+d[i-2]+d[i-3];
		}
		return d[n-1];
	}

}
