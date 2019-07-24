import java.util.*;
public class lineup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n= in.nextInt();
		HashSet<Integer> ids = new HashSet<Integer>();
		cow[] cows = new cow[n];
		for(int i =0;i<n;i++)
		{
			int pos = in.nextInt();
			int id = in.nextInt();
			ids.add(id);
			cows[i] = new cow(pos,id);
		}
		Arrays.sort(cows);
		//System.out.println(Arrays.toString(cows));
		int r = -1;
		int ans =Integer.MAX_VALUE;
		HashMap<Integer,Integer> cnt = new HashMap<Integer,Integer>();
		for(int l = 0;l<n;l++)
		{
			while(r<n-1&&cnt.size()<ids.size())
			{
				r++;
				if(!cnt.containsKey(cows[r].id))
					cnt.put(cows[r].id, 0);
				cnt.put(cows[r].id, cnt.get(cows[r].id)+1);
			}
			//System.out.println(l+" "+r);
			//System.out.println(cnt);
			if(cnt.size()<ids.size())continue;
			ans =Math.min(ans, cows[r].x-cows[l].x);
			//System.out.println(ans);
			cnt.put(cows[l].id, cnt.get(cows[l].id)-1);
			if(cnt.get(cows[l].id)==0)
			{
				cnt.remove(cows[l].id);
				if(r==n-1)
					break;
			}
			
		}
		System.out.println(ans);
		
	}
	static class cow implements Comparable<cow>
	{
		int x, id;
		public cow(int x, int id)
		{
			this.x = x;
			this.id = id;
		}
		public int compareTo(cow that)
		{
			return this.x-that.x;
		}
		public String toString()
		{
			return x+"-"+id;
		}
	}

}
