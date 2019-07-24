import java.util.*;
public class cowcross2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int b = in.nextInt();
		int[] amtbreaks = new int[n+1];
		boolean[] hasbreak = new boolean[n+1];
		for(int i = 0;i<b;i++)
		{
			hasbreak[in.nextInt()] = true;
		}
		for(int i =1;i<=n;i++)
		{
			if(hasbreak[i])
				amtbreaks[i] = amtbreaks[i-1]+1;
			else
				amtbreaks[i] = amtbreaks[i-1];
		}
		//System.out.println(Arrays.toString(amtbreaks));
		int ans = Integer.MAX_VALUE;
		for(int i =1;i<=n-k;i++)
		{
			ans = Math.min(ans, amtbreaks[i+k]-amtbreaks[i]);
		}
		System.out.println(ans);
		/**
10 6 5
2
10
1
5
9
		 */
	}

}
