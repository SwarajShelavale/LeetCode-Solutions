//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-->0){
            String s1[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[9][9];
            for(int i = 0;i < 81;i++)
                mat[i/9][i%9] = Integer.parseInt(s1[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.isValid(mat));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int isValid(int board[][]){
       Set<String> s = new HashSet<>();
        int n =board.length, m = board[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]!=0) 
                {
                    String rowPosition = (String)(i+"row"+board[i][j]);
                    String colPosition = (String)(j+"col"+board[i][j]);
                    String boxPosition = (String)(i/3+""+j/3+"box"+board[i][j]);
                    
                    if(s.contains(rowPosition) || s.contains(colPosition)  || s.contains(boxPosition) )
                    {
                        return 0;
                    }
                    s.add(rowPosition);
                    s.add(colPosition);
                    s.add(boxPosition);
                }
            }
        }
        return 1;
    }
}