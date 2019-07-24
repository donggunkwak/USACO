package Section_1_3;
/*
ID: donggun1
LANG: JAVA
TASK: milk2
 */
//package Section_1_3;
import java.io.*;
import java.util.*;

public class milk2 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new FileReader(new File("milk2.in")));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
		int n = in.nextInt();
		HashSet<Integer> allnums = new HashSet<Integer>();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i = 0;i<n;i++)
		{
			int s = in.nextInt();
			int e = in.nextInt();
			min = Math.min(min, s);
			max = Math.max(max, e);
			for(int j = s;j<e;j++)
			{
				allnums.add(j);
			}
		}
		String turn = "";
		for(int i =min;i<max;i++)
		{
			if(allnums.contains(i))
			{
				turn+="1";
			}
			else
			{
				turn+="0";
			}
		}
		//System.out.println(turn);
		String[] ones = turn.split("0");
		String[] zeroes = turn.split("1");
		int continuous = 0;
		int idle = 0;
		for(int i = 0;i<ones.length;i++)
		{
			continuous = Math.max(continuous,ones[i].length());
		}
		for(int i = 0;i<zeroes.length;i++)
		{
			idle = Math.max(idle, zeroes[i].length());
		}
		out.println(continuous+" "+ idle);
		out.close();
		
		
		
	}

}
