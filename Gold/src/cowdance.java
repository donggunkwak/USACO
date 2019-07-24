import java.util.*;
public class cowdance {
	public static int n;
	public static int t;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in =new Scanner(System.in);
		n = in.nextInt();
		t = in.nextInt();
		
		int[] a = new int[n];
		for(int i =0;i<n;i++)
		{
			a[i]=in.nextInt();
			
		}
		System.out.println(bsearch(a));
	}
	public static boolean works(int[] a, int k)
	{
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i =0;i<k;i++)
		{
			pq.add(0);
		}
		for(int i =0;i<n;i++)
		{
			int avail = pq.poll();
			pq.add(avail+a[i]);
			if(avail+a[i]>t)
				return false;
		}
		return true;
	}
	
	public static int bsearch( int[] a)
	{
		int l =0;
		int r = n;
		while(l<=r)
		{
			int mid = (l+r)/2;
			if(works(a, mid))
			{
				r= mid-1;
			}
			else
			{
				l=mid+1;
			}
			
		}
		return l;
	}

}
