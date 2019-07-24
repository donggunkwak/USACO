import java.util.*;
public class FIFO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Integer>[] desks = new ArrayList[n+1];
		for(int i =1;i<=n;i++)desks[i] = new ArrayList<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		while(true)
		{
			//System.out.println(q);
			char a = in.next().charAt(0);
			int num = in.nextInt();
			if(a=='C')
			{
				q.add(num);
			}
			else if(a=='D')
			{
				desks[num].add(q.poll());
			}
			else
			{
				break;
			}
			if(q.isEmpty())break;
		}
		for(int i =1;i<=n;i++)
		{
			for(int j =0;j<desks[i].size();j++)
			{
				System.out.print(desks[i].get(j)+" ");
			}
			System.out.println();
		}
		
	}

}
