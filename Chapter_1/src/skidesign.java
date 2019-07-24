/*
ID: donggun1
LANG: JAVA
TASK: skidesign
*/

import java.io.*;
import java.util.*;

public class skidesign {

    static Scanner in;
    static PrintWriter out;
    static int n;
    static int[] hills;
    
    public static void main(String[] args) {
        try {
            in = new Scanner(new File("skidesign.in"));
            out = new PrintWriter(new File("skidesign.out"));
            init();
            out.println(solve());
            in.close();
            out.close();
        } 
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    static void init(){
    	n = in.nextInt();
    	hills = new int[n];
    	for(int i =0;i<n;i++)
    	{
    		hills[i] = in.nextInt();
    	}
    }

    static int solve() {
        Arrays.sort(hills);
       // System.out.println(Arrays.toString(hills));
        int min = Integer.MAX_VALUE;
        for(int i=0;i<=hills[n-1];i++)
        {
        	//System.out.println(i+":");
        	int cur = 0;
        	for(int j =0;j<n;j++)
        	{
        		if(hills[j]>=i&&hills[j]<=i+17)
        		{}
        		else
        		{
        			if(hills[j]<i)
        			{
        				cur+=Math.pow(i-hills[j], 2);
        			}
        			else if(hills[j]>i+17)
        			{
        				cur+=Math.pow(hills[j]-(i+17), 2);
        			}
        			//System.out.println(hills[j]+"-"+cur);
        		}
        	}
        	//System.out.println(cur);
        	min = Math.min(cur, min);
        }
        
        return min;
    }

}