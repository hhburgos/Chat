package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Modelo.Mensaje;
import Modelo.miPC;

public class Cliente1 extends JDialog implements ActionListener, Runnable {

	private JPanel contentPane;
	private JTextField tfMensaje;
	private JButton btnEnviar = new JButton("Enviar");
	private JTextArea textArea;
	private JTextField tfNick;
	private JTextField tfIP;
	
	private String serverIP;
	private static final int puertoSalida = 9999;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Cliente1 dialog = new Cliente1();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed (ActionEvent e) {
		if (e.getSource() == btnEnviar) {
			enviarMensaje();
		}
	}
	
	public boolean enviarMensaje () {
		try {
			Socket miSocket;
			String ipEmisor, ipDestinatario, nickname, mensaje;
			Mensaje usuario;
			
			ipEmisor = miPC.obtenerIP();
			ipDestinatario = tfIP.getText();
			nickname = this.tfNick.getText();
			mensaje = this.tfMensaje.getText();
			
			serverIP = miPC.obtenerIP();
			usuario = new Mensaje(ipEmisor, ipDestinatario, nickname, mensaje);
			miSocket = new Socket(serverIP ,9999);
			
			ObjectOutputStream datos = new ObjectOutputStream(miSocket.getOutputStream());
			datos.writeObject(usuario);
			miSocket.close();
			
			return (true);
		} 
		catch (IOException e1) {
			System.out.println(e1.getMessage());
			return (false);
		}
	}

	/**
	 * Create the dialog.
	 */
	public Cliente1() {
		setBounds(100, 100, 1195, 757);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfMensaje = new JTextField();
		tfMensaje.setBounds(503, 600, 394, 51);
		contentPane.add(tfMensaje);
		tfMensaje.setColumns(10);
		
		btnEnviar.setBounds(909, 600, 133, 51);
		contentPane.add(btnEnviar);
		
		textArea = new JTextArea();
		textArea.setBounds(422, 95, 671, 462);
		contentPane.add(textArea);
		
		tfNick = new JTextField();
		tfNick.setText("Nickname");
		tfNick.setBounds(141, 32, 161, 36);
		contentPane.add(tfNick);
		tfNick.setColumns(10);
		
		tfIP = new JTextField();
		tfIP.setText("ip");
		tfIP.setBounds(45, 95, 161, 22);
		contentPane.add(tfIP);
		tfIP.setColumns(10);
		btnEnviar.addActionListener(this);
		
		Thread mihilo = new Thread(this);
		mihilo.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			ServerSocket servidor_cliente = new ServerSocket(9090);
			Socket cliente;
			Mensaje usuario_recibido;
			String nick, mensaje, hora;
			
			while (true) {
					cliente = servidor_cliente.accept();
					ObjectInputStream flujo_entrada = new ObjectInputStream(cliente.getInputStream());
					usuario_recibido = (Mensaje) flujo_entrada.readObject();
					
					nick = usuario_recibido.getNickname();
					mensaje = usuario_recibido.getMensaje();
					hora = miPC.dameHM(usuario_recibido.getMomento());
					textArea.append(nick + ": " + mensaje + " " + hora + "\n");
					
					//flujo_entrada.close();
					cliente.close(); //puede que sobre
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
