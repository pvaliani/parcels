import org.junit.Before;

public class OrderTest {

    Order order;
    Parcel smallParcel;
    Parcel mediumParcel;
    Parcel largeParcel;
    Parcel XLParcel;

    @Before
    public void before(){
        Order myOrder = new Order();
        smallParcel = new Parcel(9,9,9,"small",3);
        mediumParcel = new Parcel(49,49,49,"medium",8);
        largeParcel = new Parcel(99,99,99,"large",15);
        XLParcel = new Parcel(100,100,100,"XL",25);
    }


}
