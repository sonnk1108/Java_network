package LoginClient;

public class ClientRun {
	public static void main(String[] args) {
		ClienView view = new ClienView();
		ClientControl control= new ClientControl(view);
		view.setVisible(true);
	}
}
