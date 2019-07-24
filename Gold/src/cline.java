import java.util.*;
public class cline {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		LinkedList<Integer> list = new LinkedList<Integer>();
		int cur = 1;
		for(int i =1;i<=n;i++)
		{
			char com = in.next().charAt(0);
			char dir = in.next().charAt(0);
			//System.out.println(i+":"+list);
			if(com=='A')
			{
				if(dir=='L')
				{
					list.addFirst(cur);
				}
				else
				{
					list.addLast(cur);
				}
				cur++;
			}
			else
			{
				int num = in.nextInt();
				if(dir=='L')
				{
					for(int j = 0;j<num;j++)
					{
						if(list.isEmpty())break;
						list.removeFirst();
					}
				}
				else
				{
					for(int j=0;j<num;j++)
					{
						if(list.isEmpty())break;
						list.removeLast();
					}
				}
			}
		}
		while(!list.isEmpty())
		{
			System.out.println(list.removeFirst());
		}
		
	}

}
