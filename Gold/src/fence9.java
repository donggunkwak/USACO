import java.util.*;
public class fence9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int p = in.nextInt();
		double area = p*m/2;
		int b = p+1;	
		b+=gcd(m,n);
		b+=gcd(Math.abs(p-n),m);
		if(area-(int)area==0&&(double)b/2==b/2)
			area++;
		System.out.println((int)(area-(b/2)+1));
		
	}
    public static int gcd(int a, int b) 
    { 
        if (b == 0) 
            return a; 
        return gcd(b, a % b);  
    }

}
