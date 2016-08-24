package gmail_Testing;

public class RunThis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LoginGmail gmail = new LoginGmail();
		gmail.hitURL();
		gmail.login();
		gmail.verifyLoginSuccess();
		gmail.rowCount();
		gmail.openMail();
		gmail.toemailID();
	}

}
