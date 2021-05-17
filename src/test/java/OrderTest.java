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
    Parcel heavyParcel;
    Parcel heavyParcelOverweight;

// initalise a test order and test parcels including overweight parcels
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
        heavyParcel = new Parcel(100,100,100,ParcelType.HEAVY,50, 50);
        heavyParcelOverweight = new Parcel(100,100,100,ParcelType.HEAVY,50, 51);
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

//  Test to calculate the cost of an order without discounts or speedy shipping and with 3 standard parcels
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

//  Test to calculate the cost of an order with speedy shipping applied - no discounts
    @Test
    public void resultsSpeedyShippingApplied(){
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(largeParcel);
        myOrder.setSpeedyShipping(true);
        myOrder.displayOrderContents();
        assertEquals(52, myOrder.calculateCostOfOrder(), 0.01);

    }
// Test to calculate the cost of an order without speedy shipping applied (called as false) - no discounts
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

//  Test to calculate the cost of an order of overweight parcels without speedy shipping or discounts
    @Test
    public void canCalculateTotalCostOfOrderOverweightParcels(){
        myOrder.addParcelToOrder(smallParcelOverweight);
        myOrder.addParcelToOrder(mediumParcelOverweight);
        myOrder.addParcelToOrder(largeParcelOverweight);
        assertEquals(36, myOrder.calculateCostOfOrder(),0.01);
    }

//  Test to calculate the cost of an order of overweight packages with speedy shipping applied - no discounts
    @Test
    public void resultsSpeedyShippingAppliedOverweightParcels(){
        myOrder.addParcelToOrder(smallParcelOverweight);
        myOrder.addParcelToOrder(mediumParcelOverweight);
        myOrder.addParcelToOrder(largeParcelOverweight);
        myOrder.setSpeedyShipping(true);
        myOrder.displayOrderContents();
        assertEquals(72, myOrder.calculateCostOfOrder(), 0.01);
    }

//  Test to calculate the cost of an order with a mix of overweight and standard parcels, with speedy shipping - no discounts
//     add overwight surcharge note
    @Test
    public void resultsSpeedyShippingAppliedMixOfUnderAndOverweightParcels(){
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(mediumParcelOverweight);
        myOrder.addParcelToOrder(largeParcelOverweight);
        myOrder.setSpeedyShipping(true);
        myOrder.displayOrderContents();
        assertEquals(68, myOrder.calculateCostOfOrder(), 0.01);
    }

    //    -------- IMPLEMENTATION STAGE 4 COMPLETE ----------

//  Test to calculate the cost of an order with a heavy parcel that is within heavy
//  weight limits - no discounts or speedy shipping
    @Test
    public void canCalculateTotalCostOfOrderWithHeavyParcel(){
        myOrder.addParcelToOrder(smallParcelOverweight);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(heavyParcel);
        assertEquals(63, myOrder.calculateCostOfOrder(),0.01);
    }

    //  Test to calculate the cost of an order with a heavy parcel that is overweight - no discounts or speedy shipping
    @Test
    public void canCalculateTotalCostOfOrderWithHeavyParcelOverweight(){
        myOrder.addParcelToOrder(smallParcelOverweight);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(heavyParcelOverweight);
        assertEquals(64, myOrder.calculateCostOfOrder(),0.01);
    }

//  Tests that the small parcel discount can be applied to an order
    @Test
    public void smallParcelDiscountTest(){
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(mediumParcel);
        assertEquals(9,  myOrder.smallParcelDiscount(),0.01);
    }

    //  Tests that the medium parcel discount can be applied to an order
    @Test
    public void mediumParcelDiscountTest(){
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(smallParcel);
        assertEquals(16,  myOrder.mediumParcelDiscount(),0.01);
    }

    //  Tests that the mixed parcel mania discount can be applied to an order
    @Test
    public void mixedParcelDiscountTest(){
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(largeParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(XLParcel);
        myOrder.addParcelToOrder(smallParcelOverweight);
        assertEquals(23,  myOrder.mixedParcelDiscount(),0.01);
    }

// Test calculates an order consisting mostly of small parcels and applies the appropriate small parcel discount
    @Test
    public void calculateTotalCostWithSmallParcelDiscount(){
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.displayOrderContents();
        assertEquals(29,  myOrder.calculateCostOfOrder(),0.01);
    }

    @Test
    public void calculateTotalCostWithSmallParcelDiscountMixedParcels(){
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(largeParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(XLParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(smallParcelOverweight);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.displayOrderContents();
        assertEquals(71,  myOrder.calculateCostOfOrder(),0.01);
    }

    @Test
    public void calculateTotalCostWithSmallParcelDiscountMixedParcelsSpeedyShippingApplied(){
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(largeParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(XLParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(smallParcelOverweight);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.displayOrderContents();
        myOrder.setSpeedyShipping(true);
        assertEquals(142,  myOrder.calculateCostOfOrder(),0.01);
    }

    // Test calculates an order consisting mostly of medium parcels and applies the appropriate small parcel discount
    @Test
    public void calculateTotalCostWithMediumParcelDiscount(){
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.displayOrderContents();
        assertEquals(43,  myOrder.calculateCostOfOrder(),0.01);
    }

    @Test
    public void calculateTotalCostWithMediumParcelDiscountMixedParcels(){
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(largeParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(XLParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(smallParcelOverweight);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.displayOrderContents();
        assertEquals(84,  myOrder.calculateCostOfOrder(),0.01);
    }

    @Test
    public void calculateTotalCostWithMediumParcelDiscountMixedParcelsSpeedyShippingApplied(){
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(largeParcel);
        myOrder.addParcelToOrder(largeParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(largeParcel);
        myOrder.addParcelToOrder(XLParcel);
        myOrder.addParcelToOrder(largeParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(smallParcelOverweight);
        myOrder.addParcelToOrder(smallParcelOverweight);
        myOrder.addParcelToOrder(smallParcelOverweight);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.displayOrderContents();
        myOrder.setSpeedyShipping(true);
        assertEquals(218,  myOrder.calculateCostOfOrder(),0.01);
    }

    // Test calculates an order consisting mostly of medium parcels and applies the appropriate small parcel discount
    @Test
    public void calculateTotalCostWithMixedParcelDiscount(){
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(largeParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(largeParcel);
        myOrder.addParcelToOrder(XLParcel);
        myOrder.addParcelToOrder(largeParcel);
        myOrder.addParcelToOrder(mediumParcelOverweight);
        myOrder.addParcelToOrder(smallParcelOverweight);
        myOrder.addParcelToOrder(heavyParcel);
        myOrder.addParcelToOrder(largeParcel);
        myOrder.displayOrderContents();
        assertEquals(103,  myOrder.calculateCostOfOrder(),0.01);
    }

    @Test
    public void calculateTotalCostWithMixedParcelDiscountSpeedyShippingApplied(){
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(largeParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(largeParcel);
        myOrder.addParcelToOrder(XLParcel);
        myOrder.addParcelToOrder(largeParcel);
        myOrder.addParcelToOrder(mediumParcelOverweight);
        myOrder.addParcelToOrder(smallParcelOverweight);
        myOrder.addParcelToOrder(heavyParcel);
        myOrder.addParcelToOrder(largeParcel);
        myOrder.displayOrderContents();
        myOrder.setSpeedyShipping(true);
        assertEquals(206,  myOrder.calculateCostOfOrder(),0.01);
    }







}
