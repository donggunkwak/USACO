import java.util.*;
public class trough {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		BitSet[] answers = new BitSet[m];
		int[] num = new int[m];
		for(int i =0;i<m;i++)
		{
			answers[i] = new BitSet(20);
			String next = in.next();
			for(int j=0;j<next.length();j++)
			{
				if(next.charAt(j)=='0')continue;
				answers[i].set(next.length()-j);
			}
			num[i] = in.nextInt();
		}
		BitSet a = new BitSet(4);
		BitSet b = new BitSet(4);
		
		int comb = -1;
		for(int i =0;i<Math.pow(2, n);i++)
		{
			//System.out.println(i);
			String change = Integer.toBinaryString(i);
			BitSet cur = new BitSet(20);
			//cur.set(i);
			for(int j=0;j<change.length();j++)
			{
				if(change.charAt(j)=='0')continue;
				cur.set(change.length()-j);
			}
			boolean matches =true;
			//cur.set(i+1);
			for(int j = 0;j<m;j++)
			{
				BitSet together = (BitSet) cur.clone();
				//System.out.println(together+"-"+answers[j]);
				together.and(answers[j]);
				
				//System.out.println(together+" "+ answers[j]);
				if(together.cardinality()!=num[j])
				{
					matches = false;
					break;
				}
			}
			if(matches)
			{
				if(comb==-1) comb=i;
				else 
				{
					System.out.println("NOT UNIQUE");
					return;
				}
			}
			//System.out.println(comb);
		}
		if(comb==-1)System.out.println("IMPOSSIBLE");
		else System.out.println(Integer.toBinaryString(comb));
/*
4 4
1000 1
0110 1
1001 1
0011 1
 */
	}

}
