import java.util.*;
public class bestcowline {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String original ="";
		for(int i =0;i<n;i++)
		{
			original +=in.next();
		}
		String ans ="";
		while(original.length()>0&&ans.length()<n)
		{
			//System.out.println(ans.length());
			//System.out.println(original);
			if(ans.length()==n)
				break;
			if(original.length()==1)
			{
				ans+=original.charAt(0);
				break;
			}
			if(original.charAt(0)<original.charAt(original.length()-1))
			{
				ans+=original.charAt(0);
				original = original.substring(1);
			}
			else if(original.charAt(0)>original.charAt(original.length()-1))
			{
				ans+=original.charAt(original.length()-1);
				original = original.substring(0, original.length()-1);
			}
			else
			{
				for(int i =1;i<=original.length()/2;i++)
				{
					if(original.charAt(i)<original.charAt(original.length()-1-i))
					{
						ans+=original.charAt(0);
						original = original.substring(1);
						break;
					}
					else if(original.charAt(i)>original.charAt(original.length()-1-i))
					{
						ans+=original.charAt(original.length()-1);
						original = original.substring(0, original.length()-1);
						break;
					}
					if(i>=original.length()/2-1)
					{
						ans+=original.charAt(0);
						original = original.substring(1);
					}
				}
				
			}
		}
		String cur="";
		for(int i =0;i<ans.length();i++)
		{
			if(i!=0&&i%80==0)
			{
				System.out.println(cur);
				cur="";
			}
			cur+=ans.charAt(i);
		}
		if(cur.length()!=0)
			System.out.println(cur);
	}

}
