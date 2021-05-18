public class Parcel {

    private double length;
    private double width;
    private double height;
    private ParcelType type;
    private double cost;
    private double weight;

    public Parcel(double length, double width, double height, ParcelType type, double cost, double weight) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.type = type;
        this.cost = cost;
        this.weight = weight;
    }

    //  Getters and setters

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public ParcelType getType() {
        return type;
    }

    public void setType(ParcelType type) {
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getOverweightCharge(double weightDiff){


        double overweightCharge = 2 * weightDiff;
        return overweightCharge;

    }


//  Parcels are costed by their size and weight with respect to the weight limit provided for each type
//  of parcel in the exercise documentation

    public double setParcelCostBySize(double length, double width, double height){
        if (length < 10 && width < 10  && height < 10 && weight <= ParcelType.SMALL.getWeightLimit()){
            this.cost = 3;
        }
        else if (length < 10 && width < 10  && height < 10 && weight > ParcelType.SMALL.getWeightLimit()){
                double weightDiff = this.weight-ParcelType.SMALL.getWeightLimit();
                this.cost =  3 + getOverweightCharge(weightDiff);
        }
        else if ( length < 50  && width < 50  && height < 50 && weight <= ParcelType.MEDIUM.getWeightLimit()){
            this.cost = 8;
        }
        else if (length < 50 && width < 50  && height < 50 && weight > ParcelType.MEDIUM.getWeightLimit()){
            double weightDiff = this.weight-ParcelType.MEDIUM.getWeightLimit();
            this.cost =  8 + getOverweightCharge(weightDiff);
        }
        else if ( length < 100  && width < 100  && height < 100 && weight <= ParcelType.LARGE.getWeightLimit() ){
            this.cost = 15;
        }
        else if (length < 100 && width < 100  && height < 100 && weight > ParcelType.LARGE.getWeightLimit()) {
            double weightDiff = this.weight - ParcelType.LARGE.getWeightLimit();
            this.cost = 15 + getOverweightCharge(weightDiff);
        }
        else if (length >= 100 && width >= 100  && height >= 100 && weight <= ParcelType.XL.getWeightLimit()) {
            this.cost = 25;
        }
        else if (length >= 100 && width >= 100  && height >= 100 && weight > ParcelType.XL.getWeightLimit() && weight < ParcelType.HEAVY.getWeightLimit()) {
            double weightDiff = this.weight - ParcelType.XL.getWeightLimit();
            this.cost = 25 + getOverweightCharge(weightDiff);
        }
        else if (weight >= ParcelType.HEAVY.getWeightLimit()) {
            double weightDiff = this.weight - ParcelType.HEAVY.getWeightLimit();
            this.cost = 50 + getOverweightCharge(weightDiff)/2;
        }

    return cost;
    }

//  Once the cost has been defined for the parcel object the type is set accordingly
    public void setParcelTypeByCost(double cost){
        if (cost <= 3){
            this.type = ParcelType.SMALL;
        }
        else if (cost <= 8){
            this.type = ParcelType.MEDIUM;
        }
        else if (cost <= 15){
            this.type = ParcelType.LARGE;
        }
        else if (cost <= 25){
            this.type = ParcelType.XL;
        }
        else this.type = ParcelType.HEAVY;
    }

//   ----------- IMPLEMENTATION STAGE 1 COMPLETE -----------



//
}
