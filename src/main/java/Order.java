import java.util.ArrayList;

public class Order {

    private ArrayList<Parcel> parcels;

    public Order() {
        this.parcels = new ArrayList<>();
    }

    public ArrayList<Parcel> getParcels(){
        return parcels;
    }

    public int parcelCount(){
        return this.parcels.size();
    }

    public void addParcelToOrder(Parcel parcel){
        this.parcels.add(parcel);
    }
}
