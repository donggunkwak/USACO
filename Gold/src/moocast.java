import java.util.*;
public class moocast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		cow[] a = new cow[n];
		for(int i =0;i<n;i++)
		{
			a[i] = new cow(in.nextInt(),in.nextInt(),in.nextInt());
		}
		boolean[][] cango = new boolean[n][n];
		for(int i =0;i<n;i++)
		{
			cango[i][i]= true;
			for(int j=0;j<n;j++)
			{
				//System.out.println(distance(a[i].x,a[j].x,a[i].y,a[j].y)+" - "+a[i].pp);
				if(distance(a[i].x,a[j].x,a[i].y,a[j].y)<=a[i].pp)
				{
					
					cango[i][j]=true;
				}
			}
		}
		for (int k = 0; k < n; k++) 
        { 
            // Pick all vertices as source one by one 
            for (int i = 0; i < n; i++) 
            { 
                // Pick all vertices as destination for the 
                // above picked source 
                for (int j = 0; j < n; j++) 
                {
                	if(cango[i][k]&&cango[k][j])
                		cango[i][j] = true;
                } 
            } 
        } 
		int max = 0;
		for(int i =0;i<n;i++)
		{
			int cur = 0;
			//System.out.println(Arrays.toString(cango[i]));
			for(int j =0;j<n;j++)
			{
				
				if(cango[i][j])
					cur++;
			}
			max = Math.max(cur, max);
		}
		System.out.println(max);
	}
	static class cow
	{
		int x,y,pp;
		public cow(int x, int y, int pp)
		{
			this.x = x;
			this.y = y;
			this.pp = pp;
		}
	}
	public static double distance(int x1,int x2, int y1,int y2)
	{
		return Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
	}

}
