//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] adj = new int[m][3];

            for (int i = 0; i < m; i++) {

                for (int j = 0; j < 3; j++) {
                    adj[i][j] = sc.nextInt();
                }
            }

            int dist = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.findCity(n, m, adj, dist);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
      int findCity(int n, int m, int[][] edges,int distanceThreshold)
      {
          //code here
          int matrix[][] = new int[n][n];
          for(int i=0; i<n; i++)
          {
              for(int j=0; j<n; j++)
              {
                  if(i==j)
                  {
                      matrix[i][j] = 0;
                  }
                  else
                  {
                      matrix[i][j] = (int)(1e9);
                  }
                  
              }
          }
          
          for(int i=0; i<m; i++)
          {
              int u = edges[i][0];
              int v = edges[i][1];
              int w = edges[i][2];
              matrix[u][v] = w;
              matrix[v][u] = w;
          }
          
          for(int k=0; k<n; k++)
          {
              for(int i=0; i<n; i++)
              {
                  for(int j=0; j<n; j++)
                  {
                      matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                  }
              }
          }
          int city = 0;
          int minCount = n;
          for(int i=0; i<n; i++)
          {
              int count = 0;
              for(int j=0; j<n; j++)
              {
                  if(matrix[i][j] == (int)(1e9) || (matrix[i][j] > distanceThreshold))
                  {
                      continue;
                  }
                  else
                  {
                      count++;
                  }
              }
              if(count <= minCount)
              {
                  minCount = count;
                  city = i;
              }
          }
          return city;
      }
}
