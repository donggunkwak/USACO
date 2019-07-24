import java.util.*;
public class banner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int w = in.nextInt();
		int h = in.nextInt();
		int l1 = in.nextInt();
		int l2 = in.nextInt();
		l1*=l1;
		l2*=l2;
		long ans = 0;
		if(l1==1)
		{
			ans+=(w+1)*h;
			ans+=(h+1)*w;
		}
		for(int i =1;i<=w;i++)
		{
			for(int j=1;j<=h;j++)
			{
				int dist = dist(i,0,0,j);
				if(gcd(i,j)==1&&dist>=l1&&dist<=l2)
				{
					ans+=(w-i+1)*(h-j+1)*2;
				}
			}
		}
		
		System.out.println(ans);
	}
    public static int gcd(int a, int b) 
    { 
        if (b == 0) 
            return a; 
        return gcd(b, a % b);  
    }
	public static int dist(int x1, int y1, int x2, int y2)
	{
		return (int)Math.pow(x1-x2, 2)+(int)Math.pow(y1-y2, 2);
	}

}
