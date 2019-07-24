import java.util.*;
public class cryptobessie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] words = new String[n+1];
		for(int i =1;i<=n;i++)
		{
			words[i] = in.next();
		}
		int[] A = new int[n+1];
		for(int i =1;i<=n;i++)
		{
			A[i] = in.nextInt();
		}
		String[] changed = new String[n+1];
		for(int i  =1;i<=n;i++)
		{
			changed[i] = words[A[i]];
		}
		System.out.println(Arrays.toString(changed));
		char[] currently = new char[26];
		boolean[] used = new boolean[26];
		Arrays.fill(currently, '0');
		//System.out.println(Arrays.toString(currently));
		for(int i =1;i<=n;i++)
		{
			for(int j = 0;j<words[i].length();j++)
			{
				char a = words[i].charAt(j);
				char b = changed[i].charAt(j);
				used[b-'a'] = true;
				if(currently[a-'a']!='0'&&currently[a-'a']!=b)
				{
					System.out.println("CASE 2");
					System.out.println("IMPOSSIBLE");
					return;
				}
				currently[a-'a']=b;
			}
		}
		int index = 0;
		String ans ="";
		for(int i =0;i<26;i++)
		{
			if(currently[i]!='0')
			{
				ans+=currently[i];
			}
			else
			{
				while(used[index])
				{
					index++;
				}
				used[index] = true;
				ans+=(char)('a'+index);
			}
		}
		System.out.println(ans);
		
	}

}
