/*
ID: donggun1
LANG: JAVA
TASK: ariprog
*/

import java.io.*;
import java.util.*;

public class ariprog {

    static Scanner in;
    static PrintWriter out;
    static int n;
    static int m;

    public static void main(String[] args) {
        try {
            in = new Scanner(new File("ariprog.in"));
            out = new PrintWriter(new File("ariprog.out"));
            init();
            //out.println(solve());
            solve();
            in.close();
            out.close();
        } 
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    static void init(){
    	n = in.nextInt();
    	m = in.nextInt();
    }

    static void solve() {
    	boolean[] bis = new boolean[(int)Math.pow(m, 2)*2+1];
    	
    	for(int p = 0;p<=m;p++)
    	{
    		for(int q = 0;q<=m;q++)
    		{
    			bis[(int)Math.pow(p, 2)+(int)Math.pow(q, 2)]=true;
    		}
    	}
    	/*
    	System.out.println(Arrays.toString(bis));
    	for(int i =0;i<=(int)Math.pow(m, 2)*2;i++)
    	{
    		if(bis[i])
    			System.out.println(i);
    	}
    	*/
    	boolean has = false;
    	for(int b = 1;b<=(int)Math.pow(m, 2)*2;b++)
    	{
    		for(int a = 0;a<=(int)Math.pow(m, 2)*2;a++)
    		{
    			if(a+b*(n-1)>(int)Math.pow(m, 2)*2)
    				break;
    			boolean works = true;
    			for(int i = 0;i<n;i++)
    			{
    				if(!bis[a+b*i])
    				{
    					works=false;
    					break;
    				}
    			}
    			if(works)
    			{
    				has = true;
    				out.println(a+" "+b);
    			}
    		}
    	}
    	if(!has)
    		out.println("NONE");
    	
    	
    	
    }

}