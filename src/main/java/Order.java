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

    public void removeParcelFromOrder(Parcel parcel){
        this.parcels.remove(parcel);
    }

    public void clearOrder(){
        this.parcels.clear();
    }

    public int calculateCostOfOrder(ArrayList<Parcel> parcels){
        int sum = parcels.stream()
                .mapToInt(a -> a.getCost())
                .sum();
        System.out.println(sum);
        return sum;
    }
}
