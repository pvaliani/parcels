import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParcelTest {

    Parcel smallParcel;
    Parcel mediumParcel;
    Parcel largeParcel;
    Parcel XLParcel;

    @Before
    public void before(){
        smallParcel = new Parcel(9,9,9,"small",3);
        mediumParcel = new Parcel(49,49,49,"medium",8);
        largeParcel = new Parcel(99,99,99,"large",15);
        XLParcel = new Parcel(100,100,100,"XL",25);
    }

    @Test
    public void getLength() {
        assertEquals(9,smallParcel.getLength());
    }

    @Test
    public void canSetLength() {
        smallParcel.setLength(5);
        assertEquals(5,smallParcel.getLength());
    }

    @Test
    public void hasWidth() {
        assertEquals(9, smallParcel.getWidth());
    }

    @Test
    public void canSetWidth() {
        smallParcel.setWidth(5);
        assertEquals(5, smallParcel.getWidth());
    }

    @Test
    public void hasHeight() {
//        
    }

    @Test
    public void canSetHeight() {
    }

    @Test
    public void getType() {
    }

    @Test
    public void setType() {
    }

    @Test
    public void getCost() {
    }

    @Test
    public void setCost() {
    }
}
