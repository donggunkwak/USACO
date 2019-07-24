import java.util.*;
public class horizon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		building[] builds = new building[n*2];
		for(int i =0;i<n;i++)
		{
			long a = in.nextLong();
			long b = in.nextLong();
			long h = in.nextLong()*-1;
			builds[i*2]=new building(a,h,0);
			builds[i*2+1]=new building(b,h,1);
		}
		Arrays.sort(builds);
		//System.out.prlongln(Arrays.toString(builds));
		long ans= 0;
		PriorityQueue<Long> pq = new PriorityQueue<Long>();
		pq.add(builds[0].h);
		for(int i =1;i<2*n;i++)
		{
			if(!pq.isEmpty())ans+=(builds[i].p-builds[i-1].p)*pq.peek();
			if(builds[i].t==0)
			{
				pq.add(builds[i].h);
			}
			else
			{
				pq.remove(builds[i].h);
			}
		}
		System.out.println(ans*-1);
		
	}
	static class building implements Comparable<building>
	{
		long p,h,t;
		public building(long p, long h, long t)
		{
			this.p =p;
			this.h=h;
			this.t= t;
		}
		public int compareTo(building that)
		{
			if(this.p==that.p)
			{
				if(that.h<this.h)
					return -1;
				else
					return 1;
			}
			//return this.p-that.p;
			if(this.p<that.p)
				return-1;
			else
				return 1;
		}
		public String toString()
		{
			return p+":"+h+" - "+t;
		}
	}

}
