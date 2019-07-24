import java.util.*;
public class perimeter {
	public static TreeSet<point> object, visited;
	public static int perimeter;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		

		perimeter=0;
		object = new TreeSet<point>();
		visited = new TreeSet<point>();
		for(int i =0;i<n;i++)
		{
			int x = in.nextInt();
			int y = in.nextInt();
			object.add(new point(x,y));
		}
		point first = object.first();
		int x = first.x-1;
		int y = first.y;
		
		
	}
	public static boolean isolated(int x, int y)
	{
	  for (int i=-1; i<=1; i++)
	    for (int j=-1; j<=1; j++)
	      if (object.contains(new point(x+i,y+j))) return false;
	  return true;
	}
	public static void visit(int x, int y)
	{
	  if (object.contains(new point(x,y))) { perimeter++; return; }
	  if (visited.contains(new point(x,y))) return;
	  visited.add(new point(x,y));
	  if (isolated(x,y)) return;
	  visit(x-1,y);
	  visit(x+1,y);
	  visit(x,y-1);
	  visit(x,y+1);
	}
	static class point implements Comparable<point>
	{
		int x,y;
		public point(int x, int y)
		{
			this.x =x;
			this.y =y;
		}
		public int compareTo(point that)
		{
			if(this.x==that.x)
				return this.y-that.y;
			return this.x-that.y;
		}
	}
}
