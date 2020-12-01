package Vista;

import Modelo.SQLConnection;
import Modelo.Usuario;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Login extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfMail;
	private JTextField tfPassword;
	private JLabel lblLogin = new JLabel("LOGIN");
	private JButton btnEntrar = new JButton("Entrar");
	private Usuario user;
	private JTextField tfIPServidor;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnEntrar) {
			verificacion();
		}
	}
	
	public void verificacion () { //falta veriifcar que esten llenos los campos
		String mail, password, ipServer;
		
		mail = tfMail.getText().trim();
		password = tfPassword.getText().trim();
		ipServer = tfIPServidor.getText().trim();
		
		if (!camposLlenos()) {
			JOptionPane.showMessageDialog(this, "No puedes dejar campos vacíos","Atención", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		if (SQLConnection.compruebaLogin(mail, password)) {
			user = new Usuario(mail,ipServer);
			//JOptionPane.showMessageDialog(this, "Inicio de sesión correcto");
			this.setVisible(false);
			Cliente1 c = new Cliente1();
			c.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(this, "Datos incorrectos","ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public boolean camposLlenos () {
		if (tfMail.getText().trim().equals("")) {
			return(false);
		} else if (tfPassword.getText().trim().equals("")) {
			return(false);
		} else if (tfIPServidor.getText().trim().equals("")) {
			return(false);
		} else {
			return (true);
		}
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfMail = new JTextField();
		tfMail.setToolTipText("");
		tfMail.setBounds(129, 132, 232, 39);
		contentPane.add(tfMail);
		tfMail.setColumns(10);
		
		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(129, 176, 232, 39);
		contentPane.add(tfPassword);
		
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnEntrar.setBounds(149, 228, 199, 39);
		contentPane.add(btnEntrar);
		btnEntrar.addActionListener(this);
		
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblLogin.setBounds(194, 60, 130, 39);
		contentPane.add(lblLogin);
		
		tfIPServidor = new JTextField();
		tfIPServidor.setBounds(12, 300, 130, 22);
		contentPane.add(tfIPServidor);
		tfIPServidor.setColumns(10);
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

}
