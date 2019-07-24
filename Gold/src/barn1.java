import java.util.*;
public class barn1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int s = in.nextInt();
		int c = in.nextInt();
		int[] a = new int[c];
		for(int i =0;i<c;i++)
		{
			a[i] = in.nextInt();
		}
		int[] dif = new int[c-1];
		for(int i=0;i<c-1;i++)
		{
			dif[i] = a[i+1]-a[i]-1;
		}
		Arrays.sort(dif);
		int ans=a[c-1]-a[0]+1;
		//System.out.println(ans);
		//System.out.println(Arrays.toString(dif));
		for(int i =1;i<m;i++)
		{
			ans-=dif[c-1-i];
		}
		System.out.println(ans);
		
	}

}
