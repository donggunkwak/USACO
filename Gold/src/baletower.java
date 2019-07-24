import java.util.*;
public class baletower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		box[] boxes = new box[n];
		for(int i =0;i<n;i++)
		{
			boxes[i] = new box(in.nextInt(),in.nextInt());
		}
		Arrays.sort(boxes);
		int[] d = new int[n];
		Arrays.fill(d, 1);
		int ans = 0;
		for(int i =0;i<n;i++)
		{
			for(int j =0;j<i;j++)
			{
				if(boxes[j].w<boxes[i].w&&boxes[j].b<boxes[i].b&&d[j]+1>d[i])
				{
					d[i] = d[j]+1;
				}
			}
			ans = Math.max(ans, d[i]);
		}
		//System.out.println(Arrays.toString(d));
		System.out.println(ans);
		
		
	}
	static class box implements Comparable<box>
	{
		int w, b;
		public box(int w, int b)
		{
			this.w = w;
			this.b = b;
		}
		public int compareTo(box that)
		{
			return this.w-that.w;
		}
	}
}
