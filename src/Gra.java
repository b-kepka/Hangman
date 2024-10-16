package src;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class Gra extends JFrame {
	String alphabet = "abcdefghijklmnopqrstuvwxyz";
	static Color bgColor = Color.LIGHT_GRAY;
	static String passwordChar = "_";
	String tempPassword = "";
	JMenuBar menu_bar= new JMenuBar();
	JMenu menu = new JMenu("Gra");
	JMenuItem nowa,info,exit;
	JPanel main_panel = new JPanel(null);
	JPanel alphabet_grid = new JPanel(new GridLayout(2,13)); // 5 7
	JLabel password = new JLabel("hasło nie zostało wygenerowane!",SwingConstants.CENTER); // set a new font with a letter spacing
	ArrayList<JButton> letter_array = new ArrayList<>();
	private Font passwordFont = new Font("Serif",Font.BOLD,18);
	private DrawGraphics graphic_panel = new DrawGraphics();
	private Hasla randomizer = new Hasla();
	
	ActionListener listener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() instanceof JButton){
				char tempChar = ((JButton) e.getSource()).getText().charAt(0);
				if (randomizer.randomPassword.indexOf(tempChar) == -1) {
					drawNextStage();
				} else {
					for (int i = 0; i<randomizer.randomPassword.length(); i++) {
						if (tempChar==randomizer.randomPassword.charAt(i)) {
							char[] charPassword = tempPassword.toCharArray();
							charPassword[i] = tempChar;
							tempPassword = String.valueOf(charPassword);
							password.setText(tempPassword);
						}
						((JButton) e.getSource()).setEnabled(false);
					}
					if (tempPassword.equals(randomizer.randomPassword)) {
						JOptionPane.showMessageDialog(null, "Wygrałeś!", "Gratulacje!", JOptionPane.INFORMATION_MESSAGE);
						newGame();
					}
				}
				
			}
			if (e.getSource() == nowa) {
				newGame();
			}
			if (e.getSource() == info) {
				JOptionPane.showMessageDialog(null,"Bartłomiej Kępka\nKlasa 4pP\n27.10.2022");
			}
			if (e.getSource() == exit) {
				System.exit(0);
			}
		}
	};
	public Gra() {
		setTitle("Gra w wisielca - Bartłomiej Kępka");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setSize(600,300);
		initComponents();
		setContentPane(main_panel);
		setVisible(true);
	}
	private void initComponents() {
		main_panel.add(graphic_panel);
		graphic_panel.setLocation(0,0);
		password.setBounds(200,20,350,40);
		password.setFont(passwordFont);
		main_panel.add(password);
		main_panel.setBackground(bgColor);
		System.out.println(randomizer.randomPassword);
		initGrid();
		initPassword();
		initMenu();
	}
	private void initMenu() {
		setJMenuBar(menu_bar);
		menu_bar.add(menu);
		nowa = new JMenuItem("Nowa");
		info = new JMenuItem("Info");
		exit = new JMenuItem("Exit");
		nowa.addActionListener(listener);
		info.addActionListener(listener);
		exit.addActionListener(listener);
		menu.add(nowa);
		menu.add(info);
		menu.add(exit);
	}
	private void initGrid() {
		for (int i = 0; i<alphabet.length(); i++) {
			letter_array.add(new JButton(String.valueOf(alphabet.charAt(i))));
			letter_array.get(i).addActionListener(listener);
			letter_array.get(i).setOpaque(true);
			letter_array.get(i).setBackground(bgColor);
			alphabet_grid.add(letter_array.get(i));
		}
		alphabet_grid.setBounds(185,100,380,100);
		alphabet_grid.setBackground(bgColor);
		main_panel.add(alphabet_grid);
	}
	private void initPassword() {
		tempPassword = "";
		for (int i = 0; i<randomizer.randomPassword.length(); i++) {
			if(randomizer.randomPassword.charAt(i) == ' ') tempPassword+=" ";
			else if (randomizer.randomPassword.charAt(i) == '-') tempPassword+="-";
			else tempPassword+=passwordChar;
		}
		password.setText(tempPassword);
	}
	private void drawNextStage() {
		graphic_panel.stage++;
		graphic_panel.repaint();
		if (graphic_panel.stage == 8) {
			password.setText(randomizer.randomPassword);
			JOptionPane.showMessageDialog(null, "Przegrałeś!", "Przegrałeś!", JOptionPane.ERROR_MESSAGE);
			newGame();
		}
	}
	private void newGame(){
		graphic_panel.stage = 0;
		randomizer.choosePassword();
		graphic_panel.repaint();
		initPassword();
		for (JButton val:
				letter_array) {
			val.setEnabled(true);
			val.setBackground(bgColor);
		}
	}
}