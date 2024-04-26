class Solution {
    int[] par;
    int[] size;
    public int earliestAcq(int[][] logs, int n) {
        par = new int[n];
        size = new int[n];
        for(int i=0; i<n; i++){
            par[i] = i;
            size[i] = 1;
        }
        Arrays.sort(logs, (a, b) -> Integer.compare(a[0],b[0]));
        for(int i=0; i<logs.length; i++){
            int time = logs[i][0];
            int u = logs[i][1];
            int v = logs[i][2];
            int parU = findPar(u);
            int parV = findPar(v);
            if(parU == parV) continue;
            if(size[parU] >= size[parV]){
                merge(parU, parV);
                if(size[parU] == n){
                    return time;
                }
            }
            else{
                merge(parV, parU);
                if(size[parV] == n){
                    return time;
                }
            }
        }
        return -1;
    }

    public void merge(int a, int b){
        par[b] = a;
        size[a] += size[b];
    }

    public int findPar(int a){
        if(par[a]==a) return a;
        int ulp = findPar(par[a]);
        par[a] = ulp;
        return par[a];
    }
}