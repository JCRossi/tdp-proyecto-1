package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.util.Calendar;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JLabel lblLU;
	private JTextField LU;
	private JTextField Apellido;
	private JTextField Nombre;
	private JTextField Email;
	private JTextField GithubUrl;
	private JTextField Fecha;
	private ImageIcon foto;

	public SimplePresentationScreen(Student studentData) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(630, 283));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		contentPane.setLayout(null);
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 430, 211);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la informaciÃ³n declarada por el alumno");
		tabInformation.setLayout(null);
		
		lblLU = new JLabel("LU");
		lblLU.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLU.setBounds(21, 9, 25, 14);
		tabInformation.add(lblLU);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblApellido.setBounds(21, 39, 65, 14);
		tabInformation.add(lblApellido);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setBounds(21, 75, 65, 14);
		tabInformation.add(lblNombre);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(21, 111, 46, 14);
		tabInformation.add(lblEmail);
		
		JLabel lblGithubUrl = new JLabel("Github URL");
		lblGithubUrl.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGithubUrl.setBounds(21, 150, 77, 14);
		tabInformation.add(lblGithubUrl);
		
		JLabel lblFoto = new JLabel();
		foto = new ImageIcon(new ImageIcon(this.getClass().getResource(studentData.getPathPhoto())).getImage().getScaledInstance(154, 190, Image.SCALE_DEFAULT));
		lblFoto.setIcon(foto);
		lblFoto.setBounds(445, 26, 154, 190);
		contentPane.add(lblFoto);
		
		LU = new JTextField();
		LU.setEditable(false);
		LU.setBounds(102, 7, 297, 20);
		LU.setText(studentData.getId()+"");
		tabInformation.add(LU);
		LU.setColumns(10);
		
		Apellido = new JTextField();
		Apellido.setEditable(false);
		Apellido.setBounds(102, 37, 297, 20);
		Apellido.setText(studentData.getLastName());
		tabInformation.add(Apellido);
		Apellido.setColumns(10);
		
		Nombre = new JTextField();
		Nombre.setEditable(false);
		Nombre.setBounds(102, 73, 297, 20);
		Nombre.setText(studentData.getFirstName());
		tabInformation.add(Nombre);
		Nombre.setColumns(10);
		
		Email = new JTextField();
		Email.setEditable(false);
		Email.setBounds(102, 109, 297, 20);
		Email.setText(studentData.getMail());
		tabInformation.add(Email);
		Email.setColumns(10);
		
		GithubUrl = new JTextField();
		GithubUrl.setEditable(false);
		GithubUrl.setBounds(102, 148, 297, 20);
		GithubUrl.setText(studentData.getGithubURL());
		tabInformation.add(GithubUrl);
		GithubUrl.setColumns(10);
		contentPane.add(tabbedPane);
		
		Date fecha = new Date();
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
		LocalTime hora = LocalTime.now();
		DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
		Fecha = new JTextField("Esta ventana fue generada el "+formatoFecha.format(fecha)+" a las: "+hora.format(formatoHora));
		Fecha.setBackground(null);
		Fecha.setBorder(null);
		Fecha.setEditable(false);
		Fecha.setBounds(5, 220, 397, 20);
		contentPane.add(Fecha);
		Fecha.setColumns(10);
	}
}
