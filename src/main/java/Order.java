import java.util.ArrayList;
import java.util.stream.IntStream;

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
    public double calculateCostOfOrder(){
        double sum = this.parcels.stream()
                .mapToDouble(parcel -> parcel.setParcelCostBySize(parcel.getLength(), parcel.getWidth(), parcel.getHeight()))
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

    //    -------- IMPLEMENTATION STAGE 2 COMPLETE ----------

    public double smallParcelDiscount(){
        return IntStream.range(0, parcels.size())
                .filter(n -> (n + 1) % 4 == 0) //take every fourth parcel one based
                .mapToObj(parcels::get)
                .filter(parcel -> ParcelType.SMALL.equals(parcel.getType()))
                .mapToDouble(parcel -> parcel.getCost())
                .sum();

    }

    public double mediumParcelDiscount(){
        return IntStream.range(0, parcels.size())
                .filter(n -> (n + 1) % 3 == 0) //take every fourth parcel one based
                .mapToObj(parcels::get)
                .filter(parcel -> ParcelType.MEDIUM.equals(parcel.getType()))
                .mapToDouble(parcel -> parcel.getCost())
                .sum();

    }

    public double mixedParcelDiscount(){
        return IntStream.range(0, parcels.size())
                .filter(n -> (n + 1) % 5 == 0) //take every fourth parcel one based
                .mapToObj(parcels::get)
//                .filter(parcel -> ParcelType.MEDIUM.equals(parcel.getType()))
                .mapToDouble(parcel -> parcel.getCost())
                .sum();

    }





}
