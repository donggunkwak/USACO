import java.util.*;
public class increasingsubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] nums = new int[n];
		for(int i =0;i<n;i++)
			nums[i] = in.nextInt();
		
		//int[] d = new int[n];
		//int ans = 0;
		TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
		// curnum - length
		for(int i =0;i<n;i++)
		{
			if(i==0)
				map.put(nums[i], 1);
			if(map.lastKey()<nums[i])
			{
				map.put(nums[i], map.get(map.lastKey())+1);
			}
			int curkey = map.ceilingKey(nums[i]);
			if(nums[i]<curkey)
			{
				map.put(nums[i], map.get(curkey));
				map.remove(curkey);
			}
			
			//d[i] = d[maxindex]+1;
			//ans = Math.max(ans, d[i]);
			
		}
		System.out.println(map.get(map.lastKey()));
		
	}

}
