
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
//import java.awt.Graphics;
import java.awt.event.*;

//import java.io.PrintStream;
//import java.awt.*;


public class home {

	//private static final PrintStream Y_AXIS = null;
	JFrame frame;
	JPanel panel;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		home h = new home();
		h.go();
	}
	
	public void go(){
		frame = new JFrame("HANGMAN");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		panel = new JPanel();
		panel.setBounds(0, 0, 500, 450);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		//panel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(Box.createVerticalStrut(20));
		try{
			ImageIcon img = new ImageIcon("resources/logo.jpg");
			JLabel picLabel = new JLabel(img);
			picLabel.setPreferredSize(new Dimension(400, 250));
			picLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			panel.add(picLabel);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		panel.add(Box.createVerticalStrut(40));
		
		JButton game = new JButton("NEW GAME");
		game.addActionListener(new newgameListener());
		game.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(game);
		
		JMenuBar bar = new JMenuBar();
		
		JMenu option = new JMenu("OPTIONS");
		JMenu about = new JMenu("ABOUT");
		
		JMenuItem newgame = new JMenuItem("NEW GAME");
		JMenuItem ex = new JMenuItem("EXIT");
		
		newgame.addActionListener(new newgameListener());
		ex.addActionListener(new exitListener());
		
		option.add(newgame);
		option.addSeparator();
		option.add(ex);
		
		JMenuItem help = new JMenuItem("HELP");
		
		help.addActionListener(new helpListener());
		
		about.add(help);
		bar.add(option);
		bar.add(about);
		
		frame.getContentPane().add(BorderLayout.NORTH, bar);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setVisible(true);
	}
	
	public class newgameListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			frame.remove(panel);
			if(ev.getActionCommand().equals("NEW GAME")){
			gamegui n = new gamegui();
			panel = new JPanel();
			panel = n.creategui();
			panel.setPreferredSize(new Dimension(450, 400));
			frame.add(panel);
			frame.setVisible(true);
			}
		}
	}
	
	public class exitListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			System.exit(0);
		}
	}
	
	public class helpListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			String s = "A word is given with blanks. All you need to do is find the missing letters before hangman gets completed";
			JOptionPane opt = new JOptionPane();
			opt.setMessage(s);
			JDialog d = opt.createDialog("HELP");
			d.setVisible(true);
		}
	}

}
