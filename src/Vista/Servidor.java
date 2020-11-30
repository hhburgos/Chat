package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Perfil;

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
			String ip, nickname, mensaje;
			
			Perfil usuario_recibido;
			
			while (true) {
				Socket miSocket = servidor.accept();
				ObjectInputStream datos = new ObjectInputStream(miSocket.getInputStream());
				usuario_recibido = (Perfil) datos.readObject();
				
				ip = usuario_recibido.getIp().toString();
				nickname = usuario_recibido.getNickname();
				mensaje = usuario_recibido.getMensaje();
				
				textArea.append(nickname + ": " + mensaje + " para " + ip + "\n");
				
				Socket envia_destinatario = new Socket("172.202.255.238",9090);
				ObjectOutputStream datos_reenvio = new ObjectOutputStream(envia_destinatario.getOutputStream());
				datos_reenvio.writeObject(usuario_recibido);
				
				datos_reenvio.close();
				datos.close();
				envia_destinatario.close();
				miSocket.close();
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("ssss");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
