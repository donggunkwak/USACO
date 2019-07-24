import java.util.*;
public class paint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		
		TreeMap<Integer,Integer> events = new TreeMap<Integer,Integer>();
		int curp=0;
		for(int i =0;i<n;i++)
		{
			int unit = in.nextInt();
			char dir = in.next().charAt(0);
			if(dir=='R')
			{
				if(!events.containsKey(curp))
					events.put(curp, 0);
				if(!events.containsKey(curp+unit))
					events.put(curp+unit, 0);
				events.put(curp, events.get(curp)+1);
				events.put(curp+unit, events.get(curp+unit)-1);
				curp+=unit;
			}
			else
			{
				if(!events.containsKey(curp))
					events.put(curp, 0);
				if(!events.containsKey(curp-unit))
					events.put(curp-unit, 0);
				events.put(curp, events.get(curp)-1);
				events.put(curp-unit, events.get(curp-unit)+1);
				curp-=unit;
			}
		}
		//System.out.println(events);
		int cl = events.firstKey();
		int currentsum = events.remove(cl);
		int ans = 0;
		while(events.size()>0)
		{
			int next = events.firstKey();
			int val = events.remove(events.firstKey());
			if(currentsum>=k)
			{
				ans+=next-cl;
			}
			currentsum+=val;
			cl=next;
		}
		System.out.println(ans);
	}

}
