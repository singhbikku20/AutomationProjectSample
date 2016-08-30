package clearTrip_Testing;

import org.testng.annotations.Test;

public class ExampleTest {

    @Test
    public void testSingleJourney() {
        ActionCleartrip cleartrip = new ActionCleartrip();
        cleartrip.hitURL();
        cleartrip.login();
        cleartrip.verifyLogin();
        cleartrip.oneWaySearch();
        cleartrip.HighLowPrice();
        cleartrip.driverKill();
    }
}
