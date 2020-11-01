package progressbarhilos;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class Hilobarra implements Runnable{
	
	JProgressBar barra;
	
	public Hilobarra(JProgressBar b)
	{
		barra = b;
	}
	
	@Override
	public void run() {
		
		
		try {
			for(int i = 0; i <= 100; i+=10){
				Thread.sleep(500);
				barra.setValue(i);
				
			}
		}
		catch(InterruptedException ex) {
		}
		
		JOptionPane.showMessageDialog(null, "La barra se ha llenado");
		
	}

}