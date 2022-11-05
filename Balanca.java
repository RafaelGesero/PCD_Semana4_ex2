import javax.swing.JTextField;

public class Balanca {

	private double ouro = 0;

	public Balanca() {
	}

	public double getOuroTotal() {
		return ouro;
	}

	public synchronized void put(double newOuro) throws InterruptedException {
		ouro += newOuro;
		while (ouro >= 12.5) {
			notifyAll();
			wait();
		}
	}

	public synchronized double get() throws InterruptedException {
		while (ouro < 12.5) {
			wait();
		}
		ouro -= 12.5;
		notifyAll();
		return 12.5;
	}
}
