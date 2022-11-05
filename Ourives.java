
public class Ourives extends Thread {

	private int lingotes = 0;
	private double ouro = 0;
	private Balanca b;
	private boolean ligado = true;

	public Ourives(Balanca b) {
		this.b = b;
	}

	public int getLingotes() {
		return lingotes;
	}

	public void transforma() {
		ouro = -12.5;
		try {
			sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lingotes++;

	}

	public void desliga_liga() {
		if (ligado == true)
			ligado = false;
		else {
			ligado = true;
		}

	}

	public void run() {
		while (true) {
			System.out.println(";)");
			while (ligado) {
				try {
					ouro += b.get();
					if (ouro >= 12.5)
						transforma();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
