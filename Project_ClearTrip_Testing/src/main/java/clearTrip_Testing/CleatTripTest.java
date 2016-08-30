package clearTrip_Testing;

public class CleatTripTest {
	
	 

	public static void main(String[] args) throws InterruptedException {		
		
		ActionCleartrip cleartrip = new ActionCleartrip();
		cleartrip.hitURL();
		cleartrip.login();
		cleartrip.verifyLogin();
		cleartrip.oneWaySearch();
		cleartrip.HighLowPrice();
		cleartrip.driverKill();
	}

}
