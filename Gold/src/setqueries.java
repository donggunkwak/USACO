import java.util.*;
public class setqueries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i =0;i<q;i++)
		{
			int y = in.nextInt();
			int x = in.nextInt();
			if(y==1)
			{
				set.add(x);
			}
			else if(y==2)
			{
				set.remove(x);
			}
			else
			{
				if(set.contains(x))System.out.println("Yes");
				else System.out.println("No");
			}
		}
		
	}

}
