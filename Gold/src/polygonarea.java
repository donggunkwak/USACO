import java.util.*;
public class polygonarea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in =new Scanner(System.in);
		int n = in.nextInt();
		double ans = 0;
		for(int i =0;i<n;i++)
		{
			int p = in.nextInt();
			double[] x = new double[p];
			double[] y = new double[p];
			for(int j = 0;j<p;j++)
			{
				x[j] = in.nextInt();
				y[j] = in.nextInt();
			}
			ans = Math.max(ans, polygonArea(x,y,p));
		}
		System.out.println((int)ans);
	}
    public static double polygonArea(double X[], double Y[],int n) 
    {
		double area = 0.0; 
		int j = n - 1; 
		for (int i = 0; i < n; i++) 
		{ 
			area += (X[j] + X[i]) * (Y[j] - Y[i]); 
			j = i;  
		}
		return Math.abs(area / 2.0); 
	} 	

}
