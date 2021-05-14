import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParcelTest {

    Parcel smallParcel;
    Parcel smallParcelOverweight;
    Parcel mediumParcel;
    Parcel mediumParcelOverweight;
    Parcel largeParcel;
    Parcel largeParcelOverweight;
    Parcel XLParcel;
    Parcel XLParcelOverweight;
    Parcel HeavyParcelOverweight;

    @Before
    public void before(){
//      initialises edge cases for the parcels we expect
        smallParcel = new Parcel(9,9,9,ParcelType.SMALL,3, 1);
        smallParcelOverweight = new Parcel(9,9,9,ParcelType.SMALL,3, 2);
        mediumParcel = new Parcel(49,49,49,ParcelType.MEDIUM,8, 3);
        mediumParcelOverweight = new Parcel(49,49,49,ParcelType.MEDIUM,8, 5);
        largeParcel = new Parcel(99,99,99,ParcelType.LARGE,15, 6);
        largeParcelOverweight = new Parcel(99,99,99,ParcelType.LARGE,15, 8);
        XLParcel = new Parcel(100,100,100,ParcelType.XL,25, 10);
        XLParcelOverweight = new Parcel(100,100,100,ParcelType.XL,25, 12);
        HeavyParcelOverweight = new Parcel(100,100,100,ParcelType.HEAVY,50, 51);
    }

    @Test
    public void getLength() {
        assertEquals(9,smallParcel.getLength(),0.01);
    }

    @Test
    public void canSetLength() {
        smallParcel.setLength(5);
        assertEquals(5,smallParcel.getLength(), 0.01);
    }

    @Test
    public void hasWidth() {
        assertEquals(9, smallParcel.getWidth(), 0.01);
    }

    @Test
    public void canSetWidth() {
        smallParcel.setWidth(5);
        assertEquals(5, smallParcel.getWidth(), 0.01);
    }

    @Test
    public void hasHeight() {
        assertEquals(9, smallParcel.getHeight(), 0.01);
//
    }

    @Test
    public void canSetHeight() {
        smallParcel.setHeight(5);
        assertEquals(5, smallParcel.getHeight(), 0.01);
    }

    @Test
    public void getType() {
        assertEquals(ParcelType.SMALL, smallParcel.getType());
    }

    @Test
    public void setType() {
        smallParcel.setType(ParcelType.SMALL);
        assertEquals(ParcelType.SMALL, smallParcel.getType());

    }

    @Test
    public void getCost() {
        assertEquals(3, smallParcel.getCost() ,0.01);
    }

    @Test
    public void setCost() {
        smallParcel.setCost(3);
        assertEquals(3, smallParcel.getCost(), 0.01);
    }

    @Test
    public void getParcelCostBySize(){
        smallParcel.setParcelCostBySize(9,9,9);
        assertEquals(3, smallParcel.getCost(), 0.01);
    }

    @Test
    public void getParcelTypeAfterCostedBySize(){
        smallParcel.setParcelCostBySize(smallParcel.getLength(), smallParcel.getWidth(), smallParcel.getHeight());
        smallParcel.setParcelTypeByCost(25);
        assertEquals(ParcelType.XL, smallParcel.getType());
    }

//    --------- IMPLEMENTATION STAGE 1 COMPLETE -----------

    @Test
    public void canGetWeightLimitFromParcelType(){
        assertEquals(1,ParcelType.SMALL.getWeightLimit(),0.01);
    }

//    ------------------- IMPLEMENTATION STAGE 3 COMPLETE ---------------------

    @Test
    public void getParcelCostBySizeOverweightSmallParcel(){
        smallParcelOverweight.setParcelCostBySize(smallParcelOverweight.getLength(), smallParcelOverweight.getWidth(), smallParcelOverweight.getHeight());
        assertEquals(5, smallParcelOverweight.getCost(), 0.01);
    }

    @Test
    public void getParcelCostBySizeOverweightMediumParcel(){
        mediumParcelOverweight.setParcelCostBySize(mediumParcelOverweight.getLength(), mediumParcelOverweight.getWidth(), mediumParcelOverweight.getHeight());
        assertEquals(12, mediumParcelOverweight.getCost(), 0.01);
    }

    @Test
    public void getParcelCostBySizeOverweightLargeParcel(){
        largeParcelOverweight.setParcelCostBySize(largeParcelOverweight.getLength(), largeParcelOverweight.getWidth(), largeParcelOverweight.getHeight());
        assertEquals(19, largeParcelOverweight.getCost(), 0.01);
    }

    @Test
    public void getParcelCostBySizeOverweightXLParcel(){
        XLParcelOverweight.setParcelCostBySize(XLParcelOverweight.getLength(), XLParcelOverweight.getWidth(), XLParcelOverweight.getHeight());
        assertEquals(29, XLParcelOverweight.getCost(), 0.01);
    }

    //    -------- IMPLEMENTATION STAGE 4 COMPLETE ----------

    @Test
    public void getParcelCostBySizeOverweightHeavyParcel(){
        HeavyParcelOverweight.setParcelCostBySize(HeavyParcelOverweight.getLength(), HeavyParcelOverweight.getWidth(), HeavyParcelOverweight.getHeight());
        assertEquals(51, HeavyParcelOverweight.getCost(), 0.01);
    }




}
