//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class Main {

    	public static void main (String[] args) throws IOException{
    	    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    
		    //taking size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int L[] = new int[n];
		    int R[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to array L
		    for(int i=0; i<n; i++){
		        L[i]=Integer.parseInt(inputLine[i]);
		    }
		    inputLine = br.readLine().trim().split(" ");
		    int maxx = Integer.MIN_VALUE;
		    
		    //adding elements to array R
		    for(int i=0; i<n; i++){
		        R[i]=Integer.parseInt(inputLine[i]);
		        if(R[i] > maxx){
		            maxx=R[i];
		        }
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling maxOccured() function
		    System.out.println(obj.maxOccured(L, R, n, maxx));
		}
	}
	
}



// } Driver Code Ends
// L[] and R[] are input ranges
// n : size of array
// maxx: maximum element in R[]
// arr[]: declared globally with size equal to 1000000

class Solution{
    //Function to find the maximum occurred integer in all ranges.
    public static int maxOccured(int L[], int R[], int n, int maxx){
          int diffArr[] = new int[maxx+2];
	    for(int i=0;i<n;i++)
	    {
	        diffArr[L[i]]++;
	        diffArr[R[i]+1]--;
	    }
	    
	    int PrefixSum[] = new int[maxx+2];
	    for(int i=0;i<=maxx;i++)
	        PrefixSum[i]= i==0 ? diffArr[i] : PrefixSum[i-1] + diffArr[i];
	    
	    int maxCount=-1,index=0;
	    
	    for(int i=0;i<=maxx;i++)
        {
            if(PrefixSum[i]>maxCount)
            {
                maxCount=PrefixSum[i];
                index=i;
            }
        }
	    return index;
        
        
    }
    
}

//{ Driver Code Starts.

// } Driver Code Ends