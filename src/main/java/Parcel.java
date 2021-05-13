public class Parcel {

    private double length;
    private double width;
    private double height;
    private String type;
    private double cost;

    public Parcel(double length, double width, double height, String type, double cost) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.type = type;
        this.cost = cost;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setParcelCostBySize(double length, double width, double height){
        if (length < 10 && width < 10  && height < 10){
            this.cost = 3;
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
            this.type = "small";
        }
        else if (cost <= 8){
            this.type = "medium";
        }
        else if (cost <= 15){
            this.type = "large";
        }
        else this.type = "XL";
    }

//   ----------- IMPLEMENTATION STAGE 1 COMPLETE -----------



//
}
