import java.util.*;
public class uglynumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println(ugly(n));
	}
	public static long ugly(int n)
	{
		long[] seq = new long[n];
		seq[0] = 1;
		int i2=0;
		int i3=0;
		int i5=0;
		for(int i =1;i<n;i++)
		{
			long nm2 = seq[i2]*2;
			long nm3 = seq[i3]*3;
			long nm5 = seq[i5]*5;
			seq[i] = Math.min(nm2, Math.min(nm3, nm5));
			if(seq[i]==nm2)i2++;
			if(seq[i]==nm3)i3++;
			if(seq[i]==nm5)i5++;
		}
		return seq[n-1];
	}
	public static boolean isugly(int n)
	{
		while(n%5==0)n/=5;
		while(n%3==0)n/=3;
		while(n%2==0)n/=2;
		return n==1;
	}

}
