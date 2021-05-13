import java.util.ArrayList;

public class Order {

    private ArrayList<Parcel> parcels;
    private Boolean speedyShipping;


    public Order(Boolean speedyShipping) {
        this.parcels = new ArrayList<>();
        this.speedyShipping = false;
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
        if (speedyShipping == true){
            System.out.println("You have selected speedy shipping! The cost of speedy shipping is $"+sum);
            System.out.println("The total order cost in $ is:" + sum*2);
            return sum * 2;
        }

        else if (speedyShipping == false){
            System.out.println("The total order cost in $ is:" + sum);
        }
            return sum;
        }

    public void displayOrderContents(ArrayList<Parcel> parcels){
        System.out.println("CURRENT ORDER CONTENTS:");
        parcels.forEach(parcel -> {
            System.out.println("Parcel Type - " + parcel.getType() + ", Parcel cost $" + parcel.getCost());
        });
    }

//    --------- IMPLEMENTATION STAGE 1 COMPLETE -----------

    public Boolean getSpeedyShipping() {
        return speedyShipping;
    }

    public void setSpeedyShipping(Boolean speedyShipping) {
        this.speedyShipping = speedyShipping;
    }




}
