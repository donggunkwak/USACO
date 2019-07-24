import java.util.*;
public class crazy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int c = in.nextInt();
		ArrayList<ArrayList<pos>> polygons = new ArrayList<ArrayList<pos>>();
		line[] lines = new line[n];
		for(int i =0;i<n;i++)
		{
			lines[i] = new line(new pos(in.nextInt(),in.nextInt()), new pos(in.nextInt(),in.nextInt()));
		}
		boolean[] used = new boolean[n];
		for(int i =0;i<n;i++)
		{
			if(used[i])
				continue;
			polygons.add(new ArrayList<pos>());
			polygons.get(polygons.size()-1).add(lines[i].a);
			polygons.get(polygons.size()-1).add(lines[i].b);
			//System.out.println(polygons);
			pos next = lines[i].b;
			used[i] = true;
			for(int j =0;j<n;j++)
			{
				if(used[j]||i==j)
					continue;
				//System.out.println(next+"--"+lines[j].a+"---"+lines[j].b);
				if(lines[j].a.myequals(next))
				{
					polygons.get(polygons.size()-1).add(lines[j].b);
					//System.out.println(polygons);
					used[j]=true;
					next = lines[j].b;
					j=0;
				}
				else if(lines[j].b.myequals(next))
				{
					polygons.get(polygons.size()-1).add(lines[j].a);
					//System.out.println(polygons);
					used[j] = true;
					next = lines[j].a;
					j=0;
				}
			}
		}
		//System.out.println(polygons);
		String[] isInside = new String[c];
		for(int i = 0;i<c;i++)
		{
			int x = in.nextInt();
			int y = in.nextInt();
			isInside[i] = "";
			for(int j = 0;j<polygons.size();j++)
			{
				int cross = 0;
				ArrayList<pos> cur  = polygons.get(j);
				for(int k = 0;k<cur.size()-1;k++)
				{
					if(doIntersect(new pos(x,y),new pos(10000000,y+1),cur.get(k),cur.get(k+1)))
					{
						cross++;
					}
				}
				if(cross%2==1)
					isInside[i]+="1";
				else
					isInside[i]+="0";
			}
		}
		int ans = 0;
		//System.out.println(Arrays.toString(isInside));
		for(int i =0;i<c;i++)
		{
			int cur=1;
			for(int j = i+1;j<c;j++)
			{
				if(isInside[i].equals(isInside[j]))
					cur++;
			}
			ans = Math.max(ans, cur);
		}
		System.out.println(ans);
	}
	public static boolean doIntersect(pos p1, pos q1, pos p2, pos q2) 
	{
	    int o1 = orientation(p1, q1, p2); 
	    int o2 = orientation(p1, q1, q2); 
	    int o3 = orientation(p2, q2, p1); 
	    int o4 = orientation(p2, q2, q1); 
	  
	    // General case 
	    if (o1 != o2 && o3 != o4) 
	        return true; 
	  
	    if (o1 == 0 && onSegment(p1, p2, q1)) return true; 
	  
	    if (o2 == 0 && onSegment(p1, q2, q1)) return true; 
	  
	    if (o3 == 0 && onSegment(p2, p1, q2)) return true; 
	  
	    if (o4 == 0 && onSegment(p2, q1, q2)) return true; 
	  
	    return false; // Doesn't fall in any of the above cases 
	} 
	public static int orientation(pos p, pos q, pos r) 
	{
	    int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y); 
	  
	    if (val == 0) return 0; // colinear 
	  
	    return (val > 0)? 1: 2; // clock or counterclock wise 
	} 
	public static boolean onSegment(pos p, pos q, pos r) 
	{ 
	    if (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) && 
	        q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y)) 
	    return true; 
	  
	    return false; 
	}
	static class line
	{
		pos a,b;
		public line(pos a,pos b)
		{
			this.a = a;
			this.b= b;
		}
	}
	static class pos
	{
		int x, y;
		public pos(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
		public boolean myequals(pos that)
		{
			return (this.x==that.x)&&(this.y==that.y);
		}
		public String toString()
		{
			return x+","+y;
		}
	}

}
