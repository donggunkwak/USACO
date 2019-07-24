import java.util.*;
public class landscaping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n =in.nextInt();
		int x = in.nextInt();
		int y = in.nextInt();
		int z = in.nextInt();
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		a.add(0);
		b.add(0);
		for(int i = 0;i<n;i++)
		{
			int nexta = in.nextInt();
			int nextb = in.nextInt();
			for(int j=0;j<nexta;j++)
			{
				a.add(i);
			}
			for(int j =0;j<nextb;j++)
			{
				b.add(i);
			}
		}
		int[][] d = new int[a.size()][b.size()];
		for(int i =0;i<b.size();i++)
		{
			d[0][i]=i*x;
		}
		for(int i =0;i<a.size();i++)
		{
			d[i][0]=i*y;
		}
		//System.out.println(a+", "+ b);
		for(int i =1;i<a.size();i++)
		{
			for(int j=1;j<b.size();j++)
			{
				d[i][j] = Math.min(d[i-1][j-1]+z*Math.abs(a.get(i)-b.get(j)), Math.min(d[i-1][j]+y, d[i][j-1]+x));
			}
		}
		/*
		for(int i=0;i<a.length();i++)
		{
			System.out.println(Arrays.toString(d[i]));
		}
		*/
		System.out.println(d[a.size()-1][b.size()-1]);
		
		
	}

}
