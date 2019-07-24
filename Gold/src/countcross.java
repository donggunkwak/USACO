import java.io.*;
import java.util.*;
public class countcross {

    static Set<State>[][] thing;
    static int n, k, r;

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        k = input.nextInt();
        r = input.nextInt();
        thing = new Set[n][n];

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                thing[i][j] = new HashSet<State>();
            }
        }

        for(int i = 0; i < r; i++)
        {
            int x1 = input.nextInt() - 1;
            int y1 = input.nextInt() - 1;
            int x2 = input.nextInt() - 1;
            int y2 = input.nextInt() - 1;

            thing[x1][y1].add(new State(x2, y2));
            thing[x2][y2].add(new State(x1, y1));
        }

        State[] otherThing = new State[k];
        int anotherThing = 0;

        for(int i = 0; i < k; i++)
        {
            int x = input.nextInt() - 1;
            int y = input.nextInt() - 1;

            otherThing[i] = new State(x, y);
            boolean[][] reachable = new boolean[n][n];
            dfs(reachable, x, y);

            for(int j = 0; j < i; j++)
            {
                if(!reachable[otherThing[j].x][otherThing[j].y])
                {
                    anotherThing++;
                }
            }
        }

        System.out.println(anotherThing);
    }

    static int[] dx = new int[]{-1,0,1,0};
    static int[] dy = new int[]{0,1,0,-1};

    public static void dfs(boolean[][] reachable, int x, int y)
    {
        if(x < 0 || x >= reachable.length || y < 0 || y >= reachable[x].length || reachable[x][y])
        {
            return;
        }

        reachable[x][y] = true;
        for(int k = 0; k < dx.length; k++)
        {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(!thing[x][y].contains(new State(nx, ny)))
            {
                dfs(reachable, nx, ny);
            }
        }
    }

    static class State
    {
        int x, y;

        public State(int x, int y)
        {
            super();
            this.x = x;
            this.y = y;
        }

        public int hashCode()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + x;
            result = prime * result + y;
           return result;
        }

        public boolean equals(Object obj)
        {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            State other = (State) obj;
            if (x != other.x)
                return false;
            if (y != other.y)
                return false;
            return true;
        }

    }
}