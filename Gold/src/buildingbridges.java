import java.util.*;
public class buildingbridges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		bridge[] bridges = new bridge[n];
		for(int i =0;i<n;i++)
		{
			int a = in.nextInt();
			int b  =in.nextInt();
			bridges[i] = new bridge(a,b);
		}
		Arrays.sort(bridges);
		
		int[] d=  new int[n];
		int ans = 0;
		d[0]=1;
		for(int i = 1;i<n;i++)
		{
			int maxindex = 0;
			for(int j =0;j<i;j++)
			{
				if(bridges[j].a<bridges[i].a&&d[j]>d[maxindex])
				{
					maxindex = j;
				}
			}
			d[i] = d[maxindex]+1;
			//System.out.println(i+":"+bridges[maxindex]+" "+bridges[i]);
			ans = Math.max(ans, d[i]);
		}
		System.out.println(ans-1);
		
		
	}
	static class bridge implements Comparable<bridge>
	{
		int a, b;
		public bridge(int a, int b)
		{
			this.a = a;
			this.b = b;
		}
		public int compareTo(bridge that)
		{
			return this.b-that.b;
		}
		public String toString()
		{
			return a+","+b;
		}
	}

}
