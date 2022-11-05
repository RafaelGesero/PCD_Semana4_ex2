import javax.swing.JTextField;

public class Escavadora extends Thread {

	private double ouro = 0;
	private Balanca b;
	private JTextField textD;
	private boolean ligado = true;

	public Escavadora(Balanca b) {
		this.b = b;
		textD = new JTextField(String.valueOf(ouro));
	}

	public JTextField getTextD() {
		return textD;
	}

	public double escava() {
		double rand = Math.random();
		ouro += rand;
		return rand;
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
			while (ligado) {
				if (b.getOuroTotal() < 12.5) {
					double ouroEscavado = escava();
					textD.setText(String.valueOf(ouro));
					try {
						b.put(ouroEscavado);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

	}

}
