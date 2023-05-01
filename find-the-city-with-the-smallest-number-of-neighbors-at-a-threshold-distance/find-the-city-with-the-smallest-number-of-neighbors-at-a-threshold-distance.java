class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int m = edges.length;
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