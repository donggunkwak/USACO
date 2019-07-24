import java.util.*;
public class boxstacking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		box[] boxes = new box[3*n];
		for(int i =0;i<n;i++)
		{
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			if(b>c)
				boxes[i*3] = new box(a,c,b);
			else
				boxes[i*3] = new box(a,b,c);
			if(a>c)
				boxes[i*3+1] = new box(b,c,a);
			else
				boxes[i*3+1] = new box(b,a,c);
			if(a>b)
				boxes[i*3+2]=new box(c,b,a);
			else
				boxes[i*3+2]=new box(c,a,b);
		}
		Arrays.sort(boxes);
		//System.out.println(Arrays.toString(boxes));
		int[] d = new int[3*n];
		for(int i =0;i<3*n;i++)
			d[i] = boxes[i].h;
		int ans = 0;
		for(int i =1;i<3*n;i++)
		{
			for(int j =0;j<i;j++)
			{
				if(boxes[j].w>boxes[i].w&&boxes[j].l>boxes[i].l&&d[j]+boxes[i].h>d[i])
				{
					d[i] = d[j] + boxes[i].h;
				}
			}
			ans = Math.max(ans, d[i]);
		}
		System.out.println(ans);
		
		
	}
	static class box implements Comparable<box>
	{
		int h,w,l;
		public box(int h, int w, int l)
		{
			this.h = h;
			this.w = w;
			this.l =l;
		}
		public int compareTo(box that)
		{
			return (that.w*that.l)-(this.w*this.l);
		}
		public String toString()
		{
			return h+","+w+","+l;
		}
		
	}

}
