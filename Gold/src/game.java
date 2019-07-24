import java.util.*;
public class game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String slav1 = in.next();
		String mirk = in.next();
		
		int[] amtu = new int[3];
		int[] amtl = new int[3];
		for(int i =0;i<mirk.length();i++)
		{
			amtl[mirk.charAt(i)-'a']++;
		}
		for(int i =0;i<slav1.length();i++)
		{
			amtu[slav1.charAt(i)-'a']++;
		}
		String slav = "";
		for(int i = 0;i<mirk.length();i++)
		{
			char cur = mirk.charAt(i);
			if(cur=='a')
			{
				amtl[0]--;
				if(amtu[1]>0&&amtl[2]<amtu[0]+amtu[1])
				{
					amtu[1]--;
					slav+='b';
				}
				else
				{
					amtu[2]--;
					slav+='c';
				}
			}
			else if(cur=='b')
			{
				amtl[1]--;
				if(amtu[0]>0&&amtl[2]<amtu[0]+amtu[1])
				{
					amtu[0]--;
					slav+='a';
				}
				else
				{
					amtu[2]--;
					slav+='c';
				}
			}
			else
			{
				amtl[2]--;
				if(amtu[0]>0&&amtl[1]<amtu[0]+amtu[2])
				{
					amtu[0]--;
					slav+='a';
				}
				else
				{
					amtu[1]--;
					slav+='b';
				}
			}
		}
		System.out.println(slav);
		
	}

}
