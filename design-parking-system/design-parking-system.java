class ParkingSystem {

    int slot[];
    public ParkingSystem(int big, int medium, int small) {
        slot = new int[3];
        slot[0] = big;
        slot[1] = medium;
        slot[2] = small;
    }
    
    public boolean addCar(int carType) {
        int slotCheck = carType - 1;
        if(slot[slotCheck] > 0){
            slot[slotCheck]--;
            return true;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */