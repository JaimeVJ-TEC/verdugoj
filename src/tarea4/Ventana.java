package tarea4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Ventana extends JFrame implements ActionListener{

	private JFrame frmSecuencia;
	private JTextField txtValor1;
	private JTextField txtValor2;
	private JTextField txtLimite;
	private JList listSecuencia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frmSecuencia.setVisible(true);
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
		frmSecuencia = new JFrame();
		frmSecuencia.setTitle("Secuencia");
		frmSecuencia.setBounds(100, 100, 329, 228);
		frmSecuencia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSecuencia.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Valor inicial:");
		lblNewLabel.setBounds(10, 28, 78, 14);
		frmSecuencia.getContentPane().add(lblNewLabel);
		
		JLabel lblValorFinal = new JLabel("Valor final:");
		lblValorFinal.setBounds(10, 65, 78, 14);
		frmSecuencia.getContentPane().add(lblValorFinal);
		
		JLabel lblIteraciones = new JLabel("Iteraciones:");
		lblIteraciones.setBounds(10, 104, 78, 14);
		frmSecuencia.getContentPane().add(lblIteraciones);
		
		txtValor1 = new JTextField();
		txtValor1.setBounds(98, 25, 86, 20);
		frmSecuencia.getContentPane().add(txtValor1);
		txtValor1.setColumns(10);
		
		txtValor2 = new JTextField();
		txtValor2.setColumns(10);
		txtValor2.setBounds(98, 62, 86, 20);
		frmSecuencia.getContentPane().add(txtValor2);
		
		txtLimite = new JTextField();
		txtLimite.setColumns(10);
		txtLimite.setBounds(98, 101, 86, 20);
		frmSecuencia.getContentPane().add(txtLimite);
		
		JLabel lblSecuenciaGenerada = new JLabel("Secuencia generada");
		lblSecuenciaGenerada.setBounds(188, 11, 125, 14);
		frmSecuencia.getContentPane().add(lblSecuenciaGenerada);
		
		JButton btnGenerarSecuencia = new JButton("Generar secuencia");
		btnGenerarSecuencia.setBounds(10, 136, 174, 42);
		frmSecuencia.getContentPane().add(btnGenerarSecuencia);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(207, 25, 77, 153);
		frmSecuencia.getContentPane().add(scrollPane);
		
		listSecuencia = new JList();
		scrollPane.setViewportView(listSecuencia);
		btnGenerarSecuencia.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			SecuenciaFibonacci secuencia = new SecuenciaFibonacci();
			
				int valor1 = Integer.parseInt(txtValor1.getText());
				int valor2 = Integer.parseInt(txtValor2.getText());
				int limite = Integer.parseInt(txtLimite.getText());
				DefaultListModel listModel = new DefaultListModel();
				int[] array = secuencia.CalcularSecuencia(valor1, valor2, limite);
				int i = 0;
				
				while(i<array.length) {
					listModel.add(i, array[i]);
					i++;
				}
				
				listSecuencia.setModel(listModel);
		}
		catch(NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Formato incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
