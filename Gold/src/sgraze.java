import java.util.*;
public class sgraze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		range[] ranges = new range[n];
		for(int i =0;i<n;i++)
		{
			ranges[i] = new range(in.nextInt(),in.nextInt());
		}
		Arrays.sort(ranges);
		int ans = 1;
		range cur = ranges[0];
		for(int i=1;i<n;i++)
		{
			if(ranges[i].s>=cur.e)
			{
				ans++;
				cur = ranges[i];
			}
		}
		System.out.println(ans);
		
	}
	static class range implements Comparable<range>
	{
		int s, e;
		public range(int s, int e)
		{
			this.s = s;
			this.e = e;
		}
		public int compareTo(range that)
		{
			return this.e - that.e;
		}
	}

}
