import java.util.*;
public class photo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] ufc = new int[k*2];
		HashMap<Integer,Integer> ufp = new HashMap<Integer,Integer>();
		for(int i =0;i<k;i++)
		{
			int a = in.nextInt();
			int b = in.nextInt();
			ufp.put(a, b);
			ufp.put(b, a);
			ufc[i*2]=a;
			ufc[i*2 +1]=b;
		}
		Arrays.sort(ufc);
		int ans = 0;
		HashSet<Integer> curphoto = new HashSet<Integer>();
		for(int i =0;i<2*k;i++)
		{
			int next = ufc[i];
			if(curphoto.contains(ufp.get(next)))
			{
				ans++;
				//System.out.println(curphoto);
				curphoto.clear();
			}
			curphoto.add(next);
		}
		if(!curphoto.isEmpty())ans++;
		System.out.println(ans);
/*
7 3
1 3
2 4
5 6
 */
	}
	

}
