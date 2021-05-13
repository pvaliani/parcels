public class Parcel {

    private int length;
    private int width;
    private int height;
    private String type;
    private int cost;

    public Parcel(int length, int width, int height, String type, int cost) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.type = type;
        this.cost = cost;
    }

    //  Getters and setters

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setParcelCostBySize(int length, int width, int height){
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



//
}
