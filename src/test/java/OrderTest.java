import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderTest {

    Order myOrder;
    Parcel smallParcel;
    Parcel mediumParcel;
    Parcel largeParcel;
    Parcel XLParcel;

    @Before
    public void before(){
        myOrder = new Order();
        smallParcel = new Parcel(9,9,9,"small",3);
        mediumParcel = new Parcel(49,49,49,"medium",8);
        largeParcel = new Parcel(99,99,99,"large",15);
        XLParcel = new Parcel(100,100,100,"XL",25);
    }

    @Test
    public void canGetNumberOfParcelsInOrder(){
        assertEquals(0,myOrder.parcelCount());
    }



}
