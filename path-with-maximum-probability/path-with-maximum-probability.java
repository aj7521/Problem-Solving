class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        //making of Adj_list
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double p = succProb[i];
            adj.get(u).add(new Pair(v, p));
            adj.get(v).add(new Pair(u, p));
        }

        //reverse djikstra
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
           public int compare(Pair a, Pair b){
               if(a.p>b.p){
                  return -1;
               }
               else{
                  return 1;
               }
           }
        });
        double prob[] = new double[n];
        for(int i=0; i<n; i++){
            prob[i] = (int)(-1e9);
        }
        prob[start] = 0.0;
        pq.offer(new Pair(start, 1.0));
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            double prb = pair.p;
            int node = pair.v;
            for(Pair al: adj.get(node)){
                double curprob = al.p;
                int curnode = al.v;
                if(prob[curnode] < curprob * prb){
                    prob[curnode] = curprob * prb;
                    pq.offer(new Pair(curnode, prob[curnode]));
                }
            }
        }
        if(prob[end]==(int)(-1e9)){
            return 0;
        }
        return prob[end];
    }
}

class Pair{
    int v;
    double p;
    Pair(int va, double pa){
        v = va;
        p = pa;
    }
}