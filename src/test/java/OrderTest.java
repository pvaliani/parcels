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

    @Test
    public void canAddParcelToOrder(){
        myOrder.addParcelToOrder(smallParcel);
        assertEquals(1, myOrder.parcelCount());
    }

    @Test
    public void canAddMultipleParcelsToOrder(){
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(largeParcel);
        assertEquals(3, myOrder.parcelCount());
    }

    @Test
    public void canRemoveParcelFromOrder(){
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(largeParcel);
        myOrder.removeParcelFromOrder(mediumParcel);
        assertEquals(2, myOrder.parcelCount());
    }

    @Test
    public void canClearOrder(){
        myOrder.clearOrder();
        assertEquals(0,myOrder.parcelCount());
    }

    @Test
    public void canCalculateTotalCostOfOrder(){
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(largeParcel);
        assertEquals(26, myOrder.calculateCostOfOrder());
    }


//    ----------- IMPLEMENTATION STAGE 1 COMPLETE --------------

    @Test
    public void speedyShippingFalseByDefault(){
        assertEquals(false, myOrder.getSpeedyShipping());
    }

    @Test
    public void speedyShippingSetTrue(){
        myOrder.setSpeedyShipping(true);
        assertEquals(true,myOrder.getSpeedyShipping());
    }

    @Test
    public void resultsSpeedyShippingApplied(){
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(largeParcel);
        myOrder.setSpeedyShipping(true);
        myOrder.displayOrderContents();
        assertEquals(52, myOrder.calculateCostOfOrder());

    }

    @Test
    public void resultsSpeedyShippingNotApplied(){
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(largeParcel);
        myOrder.setSpeedyShipping(false);
        myOrder.displayOrderContents();
        assertEquals(26, myOrder.calculateCostOfOrder());

    }


}
