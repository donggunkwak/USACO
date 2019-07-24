import java.util.*;
public class badhair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Stack<Integer> s = new Stack<Integer>();
		long ans = 0;
		for(int i =0;i<n;i++)
		{
			int next = in.nextInt();
			if(s.isEmpty())
			{
				s.add(next);
				continue;
			}
			while(!s.isEmpty()&&next>=s.peek())
				s.pop();
			s.add(next);
			//System.out.println(s);
			ans+=s.size()-1;
		}
		System.out.println(ans);
		
	}

}
