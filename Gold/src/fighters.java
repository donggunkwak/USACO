import java.util.*;
public class fighters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i =0;i<n;i++)
		{
			pq.add(in.nextInt());
		}
		int ans = 0;
		while(pq.size()>1)
		{
			int cur = pq.poll()+pq.poll();
			pq.add(cur);
			ans+=cur;
		}
		System.out.println(ans);
		
	}

}
