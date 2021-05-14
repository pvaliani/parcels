import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderTest {

    Order myOrder;
    Parcel smallParcel;
    Parcel smallParcelOverweight;
    Parcel mediumParcel;
    Parcel mediumParcelOverweight;
    Parcel largeParcel;
    Parcel largeParcelOverweight;
    Parcel XLParcel;
    Parcel XLParcelOverweight;


    @Before
    public void before(){
        myOrder = new Order();
        smallParcel = new Parcel(9,9,9,ParcelType.SMALL,3, 1);
        smallParcelOverweight = new Parcel(9,9,9,ParcelType.SMALL,3, 2);
        mediumParcel = new Parcel(49,49,49,ParcelType.MEDIUM,8, 3);
        mediumParcelOverweight = new Parcel(49,49,49,ParcelType.MEDIUM,8, 5);
        largeParcel = new Parcel(99,99,99,ParcelType.LARGE,15, 6);
        largeParcelOverweight = new Parcel(99,99,99,ParcelType.LARGE,15, 8);
        XLParcel = new Parcel(100,100,100,ParcelType.XL,25, 10);
        XLParcelOverweight = new Parcel(100,100,100,ParcelType.XL,25, 12);
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
        assertEquals(26, myOrder.calculateCostOfOrder(),0.01);
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
        assertEquals(52, myOrder.calculateCostOfOrder(), 0.01);

    }

    @Test
    public void resultsSpeedyShippingNotApplied(){
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(largeParcel);
        myOrder.setSpeedyShipping(false);
        myOrder.displayOrderContents();
        assertEquals(26, myOrder.calculateCostOfOrder(), 0.01);

    }

//    -------- IMPLEMENTATION STAGE 2 COMPLETE ----------


    //    -------- IMPLEMENTATION STAGE 3 COMPLETE ----------
    @Test
    public void canCalculateTotalCostOfOrderOverweightPackages(){
        myOrder.addParcelToOrder(smallParcelOverweight);
        myOrder.addParcelToOrder(mediumParcelOverweight);
        myOrder.addParcelToOrder(largeParcelOverweight);
        assertEquals(36, myOrder.calculateCostOfOrder(),0.01);
    }

    @Test
    public void resultsSpeedyShippingAppliedOverweightPackages(){
        myOrder.addParcelToOrder(smallParcelOverweight);
        myOrder.addParcelToOrder(mediumParcelOverweight);
        myOrder.addParcelToOrder(largeParcelOverweight);
        myOrder.setSpeedyShipping(true);
        myOrder.displayOrderContents();
        assertEquals(72, myOrder.calculateCostOfOrder(), 0.01);

    }



}
