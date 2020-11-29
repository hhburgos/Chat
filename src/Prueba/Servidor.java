package Prueba;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class Servidor extends JFrame implements Runnable {

	private JPanel contentPane;
	private JTextArea textArea = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Servidor m = new Servidor();
		m.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Servidor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea.setBounds(45, 13, 353, 212);
		contentPane.add(textArea);
		
		Thread mihilo = new Thread(this);
		mihilo.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//System.out.println("Estoy a la escucha1");
		try {
			ServerSocket servidor = new ServerSocket(9999); 
			while (true) {
				Socket misocket = servidor.accept();
				
				DataInputStream flujo_entrada = new DataInputStream(misocket.getInputStream());
				
				String mensaje_texto = flujo_entrada.readUTF();
				textArea.append("\n" + mensaje_texto);
				misocket.close();
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("ssss");
		}
		
	}
}
