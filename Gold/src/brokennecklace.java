import java.util.*;
public class brokennecklace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		String str = in.nextLine();
		str+=str;
		int[] rl = new int[str.length()];
		int[] bl = new int[str.length()];
		if(str.charAt(0)=='r')
		{
			rl[0] =1;
		}
		else if(str.charAt(0)=='b')
		{
			bl[0] = 1;
		}
		else
		{
			rl[0]=1;
			bl[0]=1;
		}
		for(int i = 1;i<str.length();i++)
		{
			if(str.charAt(i)=='r')
			{
				rl[i]=rl[i-1]+1;
				bl[i]=0;
			}
			else if(str.charAt(i)=='b')
			{
				rl[i]=0;
				bl[i]=bl[i-1]+1;
			}
			else
			{
				rl[i]=rl[i-1]+1;
				bl[i]=bl[i-1]+1;
			}
		}
		int[] rr = new int[str.length()];
		int[] br = new int[str.length()];
		if(str.charAt(str.length()-1)=='r')
		{
			rr[str.length()-1] =1;
		}
		else if(str.charAt(str.length()-1)=='b')
		{
			br[str.length()-1] = 1;
		}
		else
		{
			rr[str.length()-1]=1;
			br[str.length()-1]=1;
		}
		for(int i = str.length()-2;i>=0;i--)
		{
			if(str.charAt(i)=='r')
			{
				rr[i]=rr[i+1]+1;
				br[i]=0;
			}
			else if(str.charAt(i)=='b')
			{
				rr[i]=0;
				br[i]=br[i+1]+1;
			}
			else
			{
				rr[i]=rr[i+1]+1;
				br[i]=br[i+1]+1;
			}
		}
		//System.out.println(Arrays.toString(str.toCharArray()));
		//System.out.println(Arrays.toString(rl));
		//System.out.println(Arrays.toString(bl));
		//System.out.println(Arrays.toString(rr));
		//System.out.println(Arrays.toString(br));
		int max = 0;
		for(int i =0;i<str.length()-1;i++)
		{
			max = Math.max(max, Math.max(rl[i], bl[i])+Math.max(rr[i+1], br[i+1]));
		}
		if(max>str.length()/2)max = str.length()/2;
		System.out.println(max);
/*
29
wwwbbrwrbrbrrbrbrwrwwrbwrwrrb
 */
	}

}
