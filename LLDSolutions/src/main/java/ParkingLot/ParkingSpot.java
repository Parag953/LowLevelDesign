package ParkingLot;

public class ParkingSpot {
    private VehicleType type;
    int id;
    private Status status;
    String vehhicleNumber;

    public boolean isFree(){
        if(status == Status.FREE)return true;
        return false;
    }

    public void makeFree(){
        this.status = Status.FREE;
        this.vehhicleNumber = null;
    }
    public void occupy(String number){
        this.vehhicleNumber = number;
        this.status = Status.NOT_FREE;
    }

}
