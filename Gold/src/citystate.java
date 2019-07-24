import java.util.*;
public class citystate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		for(int i =0;i<n;i++)
		{
			String first = in.next();
			String second = in.next();
			String key = first.substring(0,2)+second;
			if(!map.containsKey(key))
			{
				map.put(key, 0);
			}
			map.put(key, map.get(key)+1);
		}
		Iterator<String> it = map.keySet().iterator();
		int ans=0;
		while(it.hasNext())
		{
			String next = it.next();
			String backwards = next.substring(2)+next.substring(0, 2);
			if(map.containsKey(backwards))
				ans+=map.get(next)*map.get(backwards);
		}
		System.out.println(ans/2);
		
	}

}
