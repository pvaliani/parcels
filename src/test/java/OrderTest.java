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
//      tests an order of 3 parcels - small, medium, large
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(largeParcel);
        assertEquals(3, myOrder.parcelCount());
    }

    @Test
    public void canRemoveParcelFromOrder(){
//      tests removal of a parcel from an order of mixed parcels
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
//      Tests that the total cost of an order can be calculated - without a discount or speedy shipping
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(largeParcel);
        assertEquals(26, myOrder.calculateCostOfOrder(),0.00);
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
        //  Test to calculate the cost of an order with speedy shipping applied - no discounts
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(largeParcel);
        myOrder.setSpeedyShipping(true);
        myOrder.displayOrderContents();
        assertEquals(52, myOrder.calculateCostOfOrder(), 0.00);

    }

    @Test
    public void resultsSpeedyShippingNotApplied(){
        // Test to calculate the cost of an order without speedy shipping applied (called as false) - no discounts
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(largeParcel);
        myOrder.setSpeedyShipping(false);
        myOrder.displayOrderContents();
        assertEquals(26, myOrder.calculateCostOfOrder(), 0.00);

    }

//    -------- IMPLEMENTATION STAGE 2 COMPLETE ----------


    //    -------- IMPLEMENTATION STAGE 3 COMPLETE ----------


    @Test
    public void canCalculateTotalCostOfOrderOverweightParcels(){
        //  Test to calculate the cost of an order of 3 overweight parcels without speedy shipping or discounts
        myOrder.addParcelToOrder(smallParcelOverweight);
        myOrder.addParcelToOrder(mediumParcelOverweight);
        myOrder.addParcelToOrder(largeParcelOverweight);
        assertEquals(36, myOrder.calculateCostOfOrder(),0.00);
    }


    @Test
    public void resultsSpeedyShippingAppliedOverweightParcels(){
        //  Test to calculate the cost of an order of 3 overweight packages with speedy shipping applied - no discounts
        myOrder.addParcelToOrder(smallParcelOverweight);
        myOrder.addParcelToOrder(mediumParcelOverweight);
        myOrder.addParcelToOrder(largeParcelOverweight);
        myOrder.setSpeedyShipping(true);
        myOrder.displayOrderContents();
        assertEquals(72, myOrder.calculateCostOfOrder(), 0.00);
    }


    @Test
    public void resultsSpeedyShippingAppliedMixOfUnderAndOverweightParcels(){
        // Test to calculate the cost of an order with a mix of 3 overweight and standard parcels, with speedy shipping - no discounts
        myOrder.addParcelToOrder(smallParcel);
        myOrder.addParcelToOrder(mediumParcelOverweight);
        myOrder.addParcelToOrder(largeParcelOverweight);
        myOrder.setSpeedyShipping(true);
        myOrder.displayOrderContents();
        assertEquals(68, myOrder.calculateCostOfOrder(), 0.00);
    }

    //    -------- IMPLEMENTATION STAGE 4 COMPLETE ----------


    @Test
    public void canCalculateTotalCostOfOrderWithHeavyParcel(){
        //  Test to calculate the cost of an order with a heavy parcel that is within heavy
        //  weight limits - no discounts or speedy shipping
        myOrder.addParcelToOrder(smallParcelOverweight);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(heavyParcel);
        assertEquals(63, myOrder.calculateCostOfOrder(),0.00);
    }


    @Test
    public void canCalculateTotalCostOfOrderWithHeavyParcelOverweight(){
        // Test to calculate the cost of an order with a heavy parcel that is overweight - no discounts or speedy shipping
        myOrder.addParcelToOrder(smallParcelOverweight);
        myOrder.addParcelToOrder(mediumParcel);
        myOrder.addParcelToOrder(heavyParcelOverweight);
        assertEquals(64, myOrder.calculateCostOfOrder(),0.00);
    }


    @Test
    public void smallParcelDiscountTest(){
        //  Tests the overall value of the small parcel discount to be deducted from the total cost
        // 13 Parcels total - 12 small, 1 medium
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
        assertEquals(9,  myOrder.smallParcelDiscount(),0.00);
    }


    @Test
    public void mediumParcelDiscountTest(){
        //  Tests the overall value of the medium parcel discount to be deducted from the total cost
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
        assertEquals(16,  myOrder.mediumParcelDiscount(),0.00);
    }


    @Test
    public void mixedParcelDiscountTest(){
        //  Tests the overall value of the mixed parcel discount to be deducted from the total cost
        // 14 Parcels total - 4 small, 7 medium, 1 large, 1 XL
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
        assertEquals(23,  myOrder.mixedParcelDiscount(),0.00);
    }


    @Test
    public void calculateTotalCostWithSmallParcelDiscount(){
        // Tests the value of the order consisting mostly of small parcels when the small parcel discount is applied
        // 12 small, 1 medium
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
        assertEquals(29,  myOrder.calculateCostOfOrder(),0.00);
    }

    @Test
    public void calculateTotalCostWithSmallParcelDiscountMixedParcels(){
        // Tests the value of the order of mixed parcels when the mixed parcel discount is applied
        // 9 small, 2 medium, 1 XL
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
        assertEquals(71,  myOrder.calculateCostOfOrder(),0.00);
    }

    @Test
    public void calculateTotalCostWithSmallParcelDiscountMixedParcelsSpeedyShippingApplied(){
        // Tests the value of the order of mixed parcels when the small parcel discount and speedy shipping are applied
        // 9 small, 2 medium, 1 XL
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
        assertEquals(142,  myOrder.calculateCostOfOrder(),0.00);
    }

    @Test
    public void calculateTotalCostWithMediumParcelDiscount(){
        // Tests the value of the order consisting mostly of small parcels when the small parcel discount is applied
        // 12 medium, 1 small
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
        assertEquals(43,  myOrder.calculateCostOfOrder(),0.00);
    }

    @Test
    public void calculateTotalCostWithMediumParcelDiscountMixedParcels(){
        // Tests the value of the order with mixed parcels when the medium parcel discount is applied
        // 9 small, 2 medium, 1 XL
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
        assertEquals(84,  myOrder.calculateCostOfOrder(),0.00);
    }

    @Test
    public void calculateTotalCostWithMediumParcelDiscountMixedParcelsSpeedyShippingApplied(){
        // Test calculates an order total consisting of mixed parcels for the medium parcel discount with speedy shipping applied
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
        assertEquals(218,  myOrder.calculateCostOfOrder(),0.00);
    }


    @Test
    public void calculateTotalCostWithMixedParcelDiscount(){
        // Test calculates an order total consisting of mixed parcels for the mixed parcel discount
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
        assertEquals(103,  myOrder.calculateCostOfOrder(),0.00);
    }

    @Test
    public void calculateTotalCostWithMixedParcelDiscountSpeedyShippingApplied(){
        // Test calculates an order total consisting of mixed parcels for the mixed parcel discount with speedy shipping
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
        assertEquals(206,  myOrder.calculateCostOfOrder(),0.00);
    }




}
