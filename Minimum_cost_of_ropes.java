//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Minimum_cost_of_ropes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            long[] a = new long[input.length];

            for (int i = 0; i < input.length; i++) {
                a[i] = Long.parseLong(input[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.minCost(a));
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    // Function to return the minimum cost of connecting the ropes.
    public long minCost(long[] arr) {
        // code here
        int n = arr.length;
        if(n==1)
            return (long)0;
        Arrays.sort(arr);
        List<Long> temp = new ArrayList<>();    
        int i=2;
        long ans =arr[0]+arr[1];
        temp.add(ans);
        while(i<n || temp.size()>1)
        {
            long x=0;
            if(i<n && arr[i]<temp.get(0))
            {
                x = arr[i];
                i++;
            }
            else
            {
                x = temp.get(0);
                temp.remove(0);
            }
            if(temp.size()>0)
            {
                if(i<n && arr[i]<temp.get(0))
                {
                    x += arr[i];
                    i++;
                }
                else
                {
                    x += temp.get(0);
                    temp.remove(0);
                }
            }else
            {
                x+=arr[i];
                i++;
            }
            temp.add(x);
            ans +=x;
        }
        return ans;
    }
}