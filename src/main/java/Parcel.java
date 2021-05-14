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

    public double getOverweightCharge(double weight){
        double overweightCharge = 2 * weight;
        return overweightCharge;
    }

//  if all lengths are less than 10 and the parcels weight is less than the weight limit the cost is 3
//  else if the weight is > the weight limit for that parcel type

    public void setParcelCostBySize(double length, double width, double height){
        if (length < 10 && width < 10  && height < 10 && weight <= ParcelType.SMALL.getWeightLimit()){
            this.cost = 3;
        }
        else if (length < 10 && width < 10  && height < 10 && weight > ParcelType.SMALL.getWeightLimit()){
                double weightDiff = this.weight-ParcelType.SMALL.getWeightLimit();
                this.cost =  3 + getOverweightCharge(weightDiff);
        }
        else if ( length < 50  && width < 50  && height < 50 ){
            this.cost = 8;
        }
        else if ( length < 100  && width < 100  && height < 100 ){
            this.cost = 15;
        }
        else
            this.cost = 25;
    }

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
        else this.type = ParcelType.XL;
    }

//   ----------- IMPLEMENTATION STAGE 1 COMPLETE -----------



//
}
