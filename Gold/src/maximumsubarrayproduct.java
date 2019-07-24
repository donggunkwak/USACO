import java.util.*;
public class maximumsubarrayproduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n =in.nextInt();
		int[] v = new int[n];
		for(int i =0;i<n;i++)
		{
			v[i] = in.nextInt();
		}
		int[] min = new int[n];
		int[] max = new int[n];
		int ans = 0;
		min[0] = v[0];
		max[0] = v[0];
		for(int i =1;i<n;i++)
		{
			min[i] = Math.min(v[i], Math.min(max[i-1]*v[i], min[i-1]*v[i]));
			max[i] = Math.max(v[i], Math.max(max[i-1]*v[i], min[i-1]*v[i]));
			ans = Math.max(ans, max[i]);
		}
		System.out.println(ans);
		
	}

}
