import org.junit.Before;
import org.junit.Test;

public class ParcelTest {

    Parcel parcel;

    @Before
    public void before(){
        Parcel smallParcel = new Parcel(9,9,9,"small",3);
        Parcel mediumParcel = new Parcel(49,49,49,"medium",8);
        Parcel largeParcel = new Parcel(99,99,99,"large",15);
        Parcel XLParcel = new Parcel(100,100,100,"XL",25);
    }




}
