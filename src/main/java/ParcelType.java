public enum ParcelType {
    UNASSIGNED(0.000),
    SMALL(1),
    MEDIUM(3),
    LARGE(6),
    XL(10);

    private final double weightLimit;

    ParcelType(double weightLimit){
        this.weightLimit = weightLimit;
    }

    public double getWeightLimit(){
        return weightLimit;
    }

}
