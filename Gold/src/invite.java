import java.util.*;
public class invite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int g = in.nextInt();
		HashSet<Integer>[] a = new HashSet[g];
		ArrayList<Integer>[] ingroup = new ArrayList[1000001];
		for(int i =0;i<1000001;i++)
		{
			ingroup[i] = new ArrayList<Integer>();
		}
		for(int i = 0;i<g;i++)
		{
			a[i] = new HashSet<Integer>();
			int amount = in.nextInt();
			
			for(int j =0;j<amount;j++)
			{
				int next = in.nextInt();
				a[i].add(next);
				ingroup[next].add(i);
			}
		}
		for(int i = 0;i<1000001;i++)
		{
			if(ingroup[i].size()==0)continue;
			//System.out.println(i+":"+ingroup[i]);
		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		HashSet<Integer> all = new HashSet<Integer>();
		while(!q.isEmpty())
		{
			int cur=q.poll();
			all.add(cur);
			for(int i =0;i<ingroup[cur].size();i++)
			{
				if(a[ingroup[cur].get(i)].contains(cur))
					a[ingroup[cur].get(i)].remove(cur);
				//System.out.println(cur+":"+a[ingroup[cur].get(i)]);
				if(a[ingroup[cur].get(i)].size()==1)
				{
					int temp = a[ingroup[cur].get(i)].iterator().next();
					q.add(temp);
				}
			}
		}
		//System.out.println(all);
		System.out.println(all.size());
		
	}

}
