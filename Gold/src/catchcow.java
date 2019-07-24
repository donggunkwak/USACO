import java.util.*;
public class catchcow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		//5 17
		int n = in.nextInt();
		int k = in.nextInt();
		int ans = 0;
		while(n!=k)
		{
			//System.out.println(n);
			if(k>n)
			{
				if(Math.abs(k-n)<Math.abs(k-(2*(n-1))))
				{
					n++;
				}
				else if(Math.abs(k-n)<Math.abs(k-(2*n)))
				{
					n++;
				}
				else
				{
					if(Math.abs(k-(8*(n+2)))<Math.abs(k-(2*(n-1))))
					{
						n+=2;
						ans+=2;
					}
					if(Math.abs(k-(2*(n-1)))<Math.abs(k-(2*n)))
					{
						n--;
						n*=2;
						ans++;
					}
					else
					{
						n*=2;
					}
				}
				ans++;
			}
			else
			{
				n--;
				ans++;
			}
		}
		System.out.println(ans);
		
	}

}
