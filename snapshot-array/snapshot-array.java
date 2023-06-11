class SnapshotArray {

    HashMap<Integer, Integer>[] snaps;
	int snapno;

    public SnapshotArray(int length) {
        snaps = new HashMap[length];
        for(int i = 0; i < length; i++)
            snaps[i] = new HashMap<>();
        snapno = 0;
    }
    
    public void set(int index, int val) {
        snaps[index].put(snapno, val);
    }
    
    public int snap() {
        snapno++;
        return snapno - 1;
    }
    
    public int get(int index, int snap_id) {
        while(snap_id >= 0){
            if(snaps[index].containsKey(snap_id))
                return snaps[index].get(snap_id);
            else
                snap_id--;
        }
        return 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */