import java.util.*;
public class LIFO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String line = in.next();
		Stack<Character> s = new Stack<Character>();
		boolean valid = true;
		for(int i = 0;i<line.length();i++)
		{
			//System.out.println(line.charAt(i)+":"+s);
			if(line.charAt(i)=='{')
			{
				s.add(line.charAt(i));
			}
			else if(line.charAt(i)=='[')
			{
				s.add(line.charAt(i));
			}
			else if(line.charAt(i)=='(')
			{
				s.add(line.charAt(i));
			}
			else if(line.charAt(i)=='}')
			{
				if(s.isEmpty())
				{
					valid=false;
					break;
				}
				if(s.peek()=='{')
					s.pop();
				else
				{
					valid=false;
					break;
				}
			}
			else if(line.charAt(i)==']')
			{
				if(s.isEmpty())
				{
					valid=false;
					break;
				}
				if(s.peek()=='[')
					s.pop();
				else
				{
					valid=false;
					break;
				}
			}
			else
			{
				if(s.isEmpty())
				{
					valid=false;
					break;
				}
				if(s.peek()=='(')
					s.pop();
				else
				{
					valid=false;
					break;
				}
			}
		}
		if(valid)
			System.out.println("Valid");
		else
			System.out.println("Not valid");
		
	}

}
