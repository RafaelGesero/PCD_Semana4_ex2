import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Janela {

	public static void main(String[] args) {
		Balanca b = new Balanca();
		Escavadora e1 = new Escavadora(b);
		Ourives o1 = new Ourives(b);

		JFrame frame = new JFrame("balança");
		frame.setLayout(new BorderLayout());
		frame.add(e1.getTextD(), BorderLayout.CENTER);
		JButton botao = new JButton("STOP");
		frame.add(botao, BorderLayout.SOUTH);
		botao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				e1.desliga_liga();
				o1.desliga_liga();
				System.out.println("linogtes criados: " + o1.getLingotes());
			}

		});
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
		e1.start();
		o1.start();
	}
}
