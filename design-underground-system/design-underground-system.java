class UndergroundSystem {

    public HashMap<String, HashMap<String, Pair>> map;
    public HashMap<Integer, Customer> customerFetch;
    public UndergroundSystem() {
        map = new HashMap<>();
        customerFetch = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        Customer customer = new Customer(id, stationName, t);
        customerFetch.put(customer.id, customer);
    }
    
    public void checkOut(int id, String stationName, int t) {
        Customer existingCustomer = customerFetch.get(id);
        int totalTimeTaken = t - existingCustomer.time1;
        if(!map.containsKey(existingCustomer.stNameIn)){
            map.put(existingCustomer.stNameIn, new HashMap<>());
        }
        if(!map.get(existingCustomer.stNameIn).containsKey(stationName)){
            map.get(existingCustomer.stNameIn).put(stationName, new Pair(totalTimeTaken, 1));
            return;
        }
        Pair p = map.get(existingCustomer.stNameIn).get(stationName);
        totalTimeTaken += p.tt;
        int count = p.c + 1;
        map.get(existingCustomer.stNameIn).put(stationName, new Pair(totalTimeTaken, count));
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Pair p = map.get(startStation).get(endStation);
        System.out.println(p.tt + " " + p.c);
        double averageTime = (double)p.tt / p.c;
        return averageTime;
    }
}
class Pair{
    int tt;
    int c;
    Pair(int totaltime, int count){
        tt = totaltime;
        c = count;
    }
}

class Customer{
    int id;
    String stNameIn;
    String stNameOut;
    int time1;
    int time2;
    Customer(int i, String sin, int t){
        id = i;
        stNameIn = sin;
        time1 = t;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */