import java.util.*;
public class lookup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		cow[] h = new cow[n+1];
		for(int i =1;i<=n;i++)
		{
			h[i] =new cow(in.nextInt(),i);
		}
		Stack<cow> s = new Stack<cow>();
		int[] looksup = new int[n+1];
		for(int i =1;i<=n;i++)
		{
			cow next = h[i];
			while(!s.isEmpty()&&next.h>s.peek().h)
			{
				cow cur = s.pop();
				looksup[cur.index]=i;
			}
			s.add(next);
		}
		for(int i =1;i<=n;i++)
		{
			System.out.println(looksup[i]);
		}
		
	}
	static class cow
	{
		int h, index;
		public cow(int h, int index)
		{
			this.h = h;
			this.index = index;
		}
	}
}
