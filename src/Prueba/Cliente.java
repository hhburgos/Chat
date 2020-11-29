package Prueba;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Cliente extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton = new JButton("New button");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Cliente mimarco = new Cliente();
		mimarco.setVisible(true);
	}
	
	@Override
	public void actionPerformed (ActionEvent e) {
		//System.out.println(campo1.getText());
		try {
			Socket misocket = new Socket("192.168.0.128",9999);
			
			DataOutputStream flujo_salida = new DataOutputStream(misocket.getOutputStream());
			
			flujo_salida.writeUTF(textField.getText());
			
			flujo_salida.close();
		} 
		catch (IOException e1) {
			System.out.println(e1.getMessage());
		}
	}

	/**
	 * Create the frame.
	 */
	public Cliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(150, 73, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnNewButton.setBounds(150, 128, 116, 25);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(this);
	}
}
