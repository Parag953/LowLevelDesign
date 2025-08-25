package ParkingLot;

import java.util.List;
import java.util.Map;

public class ParkingLot {
    Map<VehicleType, List<ParkingSpot>> parkingSpots;
    List<Vehicle> parkedVehicles;

    synchronized public boolean parkVehicle(Vehicle vehicle){
        VehicleType vehicleType = vehicle.type;
        List<ParkingSpot> applicableParkingSpot = parkingSpots.get(vehicleType).stream().filter(ParkingSpot::isFree).toList();
        if(applicableParkingSpot.isEmpty()){
            System.out.println("No Parking Available");
            return false;
        }
        ParkingSpot parkingSpot = applicableParkingSpot.get(0);
        parkingSpot.occupy(vehicle.number);
        parkedVehicles.add(vehicle);
        vehicle.parkingSpotId = parkingSpot.id;
        return true;
    }

    synchronized public boolean unParkVehicle(Vehicle vehicle) {
        VehicleType vehicleType = vehicle.type;
        List<ParkingSpot> vehicleViseParkingSpots = parkingSpots.get(vehicleType);

        for(ParkingSpot parkingSpot : vehicleViseParkingSpots){
            if(parkingSpot.id == vehicle.parkingSpotId){
                parkingSpot.makeFree();
                parkedVehicles.remove(vehicle);
                return true;
            }
        }
        return false;
    }




}
