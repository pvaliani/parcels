import java.util.ArrayList;

public class Order {

    private ArrayList<Parcel> parcels;
    private Boolean speedyShipping;


    public Order() {
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
//    change a to parcel
    public int calculateCostOfOrder(){
        int sum = this.parcels.stream()
                .mapToInt(parcel -> parcel.getCost())
                .sum();
        if (speedyShipping == true){
            System.out.println("You have selected speedy shipping! The cost of speedy shipping is $"+sum);
            sum = sum*2;
        }
            System.out.println("The total order cost is " + "$"+sum);

        return sum;
    }

    public void displayOrderContents(){
        System.out.println("CURRENT ORDER CONTENTS:");
        this.parcels.forEach(parcel -> {
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
