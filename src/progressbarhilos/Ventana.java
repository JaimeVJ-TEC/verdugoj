package progressbarhilos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana {

	private JFrame frmAds;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frmAds.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAds = new JFrame();
		frmAds.setTitle("JProgresBar con Hilos");
		frmAds.setBounds(100, 100, 450, 190);
		frmAds.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAds.getContentPane().setLayout(null);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(10, 24, 414, 31);
		frmAds.getContentPane().add(progressBar);
		
		JButton btnNewButton = new JButton("Correr");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Hilobarra barraProgreso = new Hilobarra(progressBar);
				Thread hilo = new Thread(barraProgreso);
				btnNewButton.setEnabled(false);
				
				hilo.start();
				
			}
		});
		btnNewButton.setBounds(172, 117, 89, 23);
		frmAds.getContentPane().add(btnNewButton);
		
		JButton btnVaciar = new JButton("Vaciar");
		btnVaciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				progressBar.setValue(0);
				btnNewButton.setEnabled(true);
			}
		});
		btnVaciar.setBounds(335, 117, 89, 23);
		frmAds.getContentPane().add(btnVaciar);
	}

}
