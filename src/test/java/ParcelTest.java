import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParcelTest {

    Parcel unassignedParcel;
    Parcel smallParcel;
    Parcel mediumParcel;
    Parcel largeParcel;
    Parcel XLParcel;

    @Before
    public void before(){
//      initialises edge cases for the parcels we expect and an unassigned parcel to test that
//      methods are functioning as correctly when setting the cost
        unassignedParcel = new Parcel (9,49,101, "unassigned", 0);
        smallParcel = new Parcel(9,9,9,"small",3);
        mediumParcel = new Parcel(49,49,49,"medium",8);
        largeParcel = new Parcel(99,99,99,"large",15);
        XLParcel = new Parcel(100,100,100,"XL",25);
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
        assertEquals("small", smallParcel.getType());
    }

    @Test
    public void setType() {
        smallParcel.setType("small");
        assertEquals("small", smallParcel.getType());

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
    public void getParcelCostBySizeUnassignedUncostedParcel(){
        unassignedParcel.setParcelCostBySize(unassignedParcel.getLength(), unassignedParcel.getWidth(), unassignedParcel.getHeight());
        assertEquals(25, unassignedParcel.getCost(), 0.01);
    }

    @Test
    public void getParcelTypeAfterCostedBySize(){
        unassignedParcel.setParcelCostBySize(unassignedParcel.getLength(), unassignedParcel.getWidth(), unassignedParcel.getHeight());
        unassignedParcel.setParcelTypeByCost(25);
        assertEquals("XL", unassignedParcel.getType());
    }

//    --------- IMPLEMENTATION STAGE 1 COMPLETE -----------
}
