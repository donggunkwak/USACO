import java.util.*;
public class profits {
	public static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		n =in.nextInt();
		int[] nums = new int[n];
		int maxsofar = Integer.MIN_VALUE;
		for(int i =0;i<n;i++)
		{
			nums[i] = in.nextInt();
		}
		int maxendinghere = 0;
		for(int i = 0;i<n;i++)
		{
            maxendinghere = maxendinghere + nums[i]; 
            if (maxsofar < maxendinghere) 
                maxsofar = maxendinghere; 
            if (maxendinghere < 0) 
                maxendinghere = 0; 
		}
		
		
		System.out.println(maxsofar);
	}
}
