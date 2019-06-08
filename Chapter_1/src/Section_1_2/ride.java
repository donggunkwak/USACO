package Section_1_2;
/*
ID: donggun1
LANG: JAVA
TASK: ride
*/
import java.util.*;
import java.io.*;
public class ride {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
	    BufferedReader in = new BufferedReader(new FileReader("ride.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
		char[] comet =  in.readLine().toCharArray();
		char[] group = in.readLine().toCharArray();
		long c = 1;
		long g = 1;
		for(int i = 0;i<comet.length;i++)
		{
			c*= comet[i]-'A'+1;
		}
		for(int i = 0;i<group.length;i++)
		{
			g*=group[i]-'A'+1;
		}
		c=c%47;
		g=g%47;
		if(c==g)
			out.println("GO");
		else
			out.println("STAY");
		out.close();
	    
	}

}
