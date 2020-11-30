package Vista;

import Modelo.Perfil;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;

public class Cliente extends JFrame implements ActionListener,Runnable {

	private JPanel contentPane;
	private JTextField tfMensaje;
	private JButton btnEnviar = new JButton("Enviar");
	private JTextArea textArea;
	private JTextField tfNick;
	private JTextField tfIP;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Cliente mimarco = new Cliente();
		mimarco.setVisible(true);
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
			String ip, nickname, mensaje;
			Perfil usuario;
			
			ip = this.tfIP.getText();
			nickname = this.tfNick.getText();
			mensaje = this.tfMensaje.getText();
			
			usuario = new Perfil(ip, nickname, mensaje);
			miSocket = new Socket("192.168.1.143" ,9999);
			
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
	 * Create the frame.
	 */
	public Cliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			Perfil usuario_recibido;
			
			while (true){
					cliente = servidor_cliente.accept();
					ObjectInputStream flujo_entrada = new ObjectInputStream(cliente.getInputStream());
					usuario_recibido = (Perfil) flujo_entrada.readObject();
					textArea.append(usuario_recibido.getNickname() + ": " + usuario_recibido.getMensaje() + "\n");
					cliente.close(); //puede que sobre
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
