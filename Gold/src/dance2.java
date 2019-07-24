import java.util.*;
public class dance2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n =in.nextInt();
		for(int a = 0;a<n;a++)
		{
			int k = in.nextInt();
			int cur = 0;
			String next = in.next();
			boolean legal = true;
			for(int i =0;i<next.length();i++)
			{
				if(next.charAt(i)=='>')
					cur++;
				else
					cur--;
				if(cur<0)
				{
					legal = false;
					break;
				}
			}
			if(legal&&cur==0)
				System.out.println("legal");
			else
				System.out.println("illegal");
			
		}
		
	}

}
