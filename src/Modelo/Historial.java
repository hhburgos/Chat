package Modelo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
//import java.util.Scanner;

public class Historial {
	
	static final int errorInt = -760;
	static String rutaConversaciones = "Conversaciones.obj";
	static String rutaUsuarios = "Usuarios.obj";
	//static Scanner sc = new Scanner (System.in);
	static ArrayList<Mensaje> gente = new ArrayList<Mensaje>();
	static File fich;
	static boolean cambios;
	
}
