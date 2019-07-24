import java.util.*;
public class fpot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int d = in.nextInt();
		rain[] drops = new rain[n];
		for(int i =0;i<n;i++)
		{
			drops[i] = new rain(in.nextInt(),in.nextInt());
		}
		Arrays.sort(drops);
		int r = -1;
		
		int curmin = drops[0].y;
		int curmax = drops[0].y;
		TreeMap<Integer,Integer> amt = new TreeMap<Integer,Integer>();
		
		//System.out.println(Arrays.toString(drops));
		int ans = Integer.MAX_VALUE;
		for(int l = 0;l<n;l++)
		{
			while(r<n-1&&(curmax-curmin<d))
			{
				r++;
				//System.out.println(r+" - "+drops[r]);
				if(!amt.containsKey(drops[r].y))
					amt.put(drops[r].y, 0);
				amt.put(drops[r].y, amt.get(drops[r].y)+1);
				curmin = amt.firstKey();
				curmax = amt.lastKey();
				//System.out.println(curmax+"---"+curmin);
			}
			if(l==r&&d!=0)
			{
				continue;
			}
			if(curmax-curmin<d)continue;
			ans = Math.min(ans, drops[r].x-drops[l].x);
			//System.out.println("ans:"+ ans);
			amt.put(drops[l].y, amt.get(drops[l].y)-1);
			//System.out.println(amt.get(drops[r].y));
			if(amt.get(drops[l].y)==0)
				amt.remove(drops[l].y);
			if(!amt.isEmpty())
			{
				curmin = amt.firstKey();
				curmax = amt.lastKey();
			}
			else
			{
				curmin = drops[r].y;
				curmax = drops[r].y;
			}
			
			
		}
		if(ans==Integer.MAX_VALUE&&d!=0)
			ans=-1;
		System.out.println(ans);
		
	}
	static class rain implements Comparable<rain>
	{
		int x, y;
		public rain(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
		public int compareTo(rain that)
		{
			return this.x - that.x;
		}
		public String toString()
		{
			return "("+x+"," +y+")";
		}
	}

}
