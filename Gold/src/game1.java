import java.util.*;
public class game1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] board = new int[n];
		for(int i =0;i<n;i++)
		{
			board[i] = in.nextInt();
		}
		int[][] d = new int[n][n];
		for(int i=0;i<n;i++)
		{
			d[i][i] = board[i];
			if(i==n-1)
				continue;
			d[i][i+1] = Math.max(board[i],board[i+1]);
		}
		
		for(int i=0;i<n;i++)
		{
			for(int j =i;j<n;j++)
			{
				
			}
		}
		
	}

}
