import java.util.ArrayList;
import java.util.stream.IntStream;

// Order class instantiates an ArrayList of parcel objects which make up the couriers parcel order
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

//  The overall cost of an order is returned as a sum depending on whether or not speedyShipping is selected
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

//  The discounts operate by returning a total sum which is made up of the value of the discounted parcel
//  in relation to its cost as per the rules in the documentation. The original cost of each parcel is not modified.
//  i.e every 3rd/4th/Nth parcel is added to a total and returned as a sum which can be subtracted from the Order.

    public double smallParcelDiscount(){

        double smallParcelDiscount = IntStream.range(0, parcels.size())
                .filter(n -> (n + 1) % 4 == 0) // every 4th parcel
                .mapToObj(parcels::get)
                .filter(parcel -> ParcelType.SMALL.equals(parcel.getType())) // filter the smalls
                .mapToDouble(parcel -> parcel.getCost())
                .sum();
                System.out.println("You have saved $"+smallParcelDiscount+" with the Small Parcel Mania discount!");
        return smallParcelDiscount;
    }

    public double mediumParcelDiscount(){
        double mediumParcelDiscount =  IntStream.range(0, parcels.size())
                .filter(n -> (n + 1) % 3 == 0) // every 3rd parcel
                .mapToObj(parcels::get)
                .filter(parcel -> ParcelType.MEDIUM.equals(parcel.getType())) // filter the mediums
                .mapToDouble(parcel -> parcel.getCost())
                .sum();
                System.out.println("You have saved $"+mediumParcelDiscount+" with the Medium Parcel Mania discount!");
        return mediumParcelDiscount;
    }

//  The mixed parcel discount implementation does not require a filter
    public double mixedParcelDiscount(){
        double mixedParcelDiscount = IntStream.range(0, parcels.size())
                .filter(n -> (n + 1) % 5 == 0) // every 5th parcel
                .mapToObj(parcels::get)
                .mapToDouble(parcel -> parcel.getCost())
                .sum();
                System.out.println("You have saved $"+mixedParcelDiscount+" with the Mixed Parcel Mania discount!");
        return mixedParcelDiscount;
    }





}
