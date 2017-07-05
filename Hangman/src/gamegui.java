import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;

@SuppressWarnings("serial")
public class gamegui extends JPanel {
	JPanel panel;
	JPanel gui;
	JPanel disp;
	JTextArea text;
	JButton answer;
	JLabel label;
	JLabel display;
	int a, b, c, d;
	char[] wor = new char[4];
	int counter = 0;
	String opword;
	private static int hanger;
	boolean a1, b1, c1, d1;
	
	public JPanel creategui(){
		panel = new JPanel();
		gui = new JPanel();
		disp = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setPreferredSize(new Dimension(400, 400));
		JLabel lab = new JLabel();
		lab.setPreferredSize(new Dimension(500, 300));
		lab.setBackground(Color.white);
		gui.add(lab);
		hanger = 0;
		
		
		disp.setLayout(new BoxLayout(disp, BoxLayout.Y_AXIS));
		display = new JLabel();
		
		label = new JLabel();
		label.setText("Hi");
		
		answer = new JButton("CHECK");
		answer.addActionListener(new charListener());
		
		gameletter gro = new gameletter();
		String word = gro.word();
		
		opword = wordsetter(word);
		
		
		
		text = new JTextArea(1, 20);
		label.setText(opword);
		disp.add(label);
		disp.add(text);
		disp.add(answer);
		disp.add(display);
		panel.add(gui);
		panel.add(disp);
		return panel;
	}
	
	private String wordsetter(String word){
		String newword = new String();
		int len;
		len = word.length();
		ArrayList<Integer> l = new ArrayList<Integer>();
		for(int i = 0; i < len; i++){
			l.add(i);
		}
		Collections.shuffle(l);
		a = l.get(0);
		b = l.get(1);
		c = l.get(2);
		d = l.get(3);
		a1 = false;
		b1 = false;
		c1 = false;
		d1 = false;
		
		wor[0] = word.charAt(a);
		wor[1] = word.charAt(b);
		wor[2] = word.charAt(c);
		wor[3] = word.charAt(d); 
		//System.out.println(wor[0] + a + " " + wor[1] + b + " " + wor[2] + c);
		
		for(int i = 0; i < len; i++){
			if(i == a || i == b || i == c || i == d){
				newword += "_";
			}
			else{
				newword += word.charAt(i);
			}
			newword += " ";
		}
		return newword;
	}
	
	public class charListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			//System.out.print(hanger + " ");
			String M = text.getText();
			char s = M.charAt(0);
			if(M.length() > 1){
				display.setText("ENTER A SINGLE CHARACTER");
			}
			else{
				String newopword = new String();
				if(s == wor[0] && a1 == false){
					counter++;
					int j = 0;
					a1 = true;
					for(int i = 0; i < opword.length(); i++){
						char is = opword.charAt(i);
						if(is == ' '){
							newopword += " ";
						}
						else{
							if(j == a){
								newopword += s;
							}
							else{
								newopword += is;
							}
							j++;
						}
					}
					opword = newopword;
					label.setText(opword);
					display.setText("HURRA " + Integer.toString(counter) + " letter(s) found!!");
				}
				else if(s == wor[1] && b1 == false){
					counter++;
					b1 = true;
					int j = 0;
					for(int i = 0; i < opword.length(); i++){
						char is = opword.charAt(i);
						if(is == ' '){
							newopword += " ";
						}
						else{
							if(j == b){
								newopword += s;
							}
							else{
								newopword += is;
							}
							j++;
						}
					}
					opword = newopword;
					label.setText(opword);
					display.setText("HURRA " + Integer.toString(counter) + " letter(s) found!!");
				}
				else if(s == wor[2] && c1 == false){
					counter++;
					c1 = true;
					int j = 0;
					for(int i = 0; i < opword.length(); i++){
						char is = opword.charAt(i);
						if(is == ' '){
							newopword += " ";
						}
						else{
							if(j == c){
								newopword += s;
							}
							else{
								newopword += is;
							}
							j++;
						}
					}
					opword = newopword;
					label.setText(opword);
					display.setText("HURRA " + Integer.toString(counter) + " letter(s) found!!");
				}
				else if(s == wor[3] && d1 == false){
					counter++;
					d1 = true;
					int j = 0;
					for(int i = 0; i < opword.length(); i++){
						char is = opword.charAt(i);
						if(is == ' '){
							newopword += " ";
						}
						else{
							if(j == d){
								newopword += s;
							}
							else{
								newopword += is;
							}
							j++;
						}
					}
					opword = newopword;
					label.setText(opword);
					display.setText("HURRA " + Integer.toString(counter) + " letter(s) found!!");
				}
				else{
					display.setText("OOPS");
					hanger = ifwrong();
					//int l = wrongguesses();
					//System.out.println(l);
					if(hanger < 10){
						panel.remove(gui);
						panel.remove(disp);
						gui = new JPanel(){
							public void paintComponent(Graphics g){
								super.paintComponent(g);
								Color color1 = Color.BLUE;
						        Color color2 = Color.BLUE;
						        g.setColor(color1);
						        //System.out.println(hanger);
						        switch (hanger) {
						        case 9:{
						        	color2 = Color.RED;
						            drawRightLeg(g, color2);
						            //System.out.println("9");
						        }
						        case 8:{
						            drawLeftLeg(g, color2);
						            //System.out.println("8");
						        }
						        case 7:{
						            drawRightArm(g, color2);
						            //System.out.println("7");
						        }
						        case 6:{
						            drawLeftArm(g, color2);
						            //System.out.println("6");
						        }
						        case 5:{
						            drawBody(g, color2);
						           //System.out.println("5");
						        }
						        case 4:{
						            drawHead(g, color2);
						            //System.out.println("4");
						        }
						        case 3:{
						            drawHeader(g, color1);
						            //System.out.println("3");
						        }
						        case 2:{
						            drawPole(g, color1);
						            //System.out.println("2");
						        }
						        case 1:{
						            drawBase(g, color1);
						            //System.out.println("1");
						        }
						        }
							}
						};
						gui.repaint();
						gui.setPreferredSize(new Dimension(500, 300));
						panel.add(gui);
						panel.add(disp);
					}
					else{
						display.setText("GAME OVER");
						//System.out.println("GAMEOVER");
						text.setEditable(false);
					}
				}
			}
			text.setText(null);
			text.requestFocus(true);

			if(counter == 4){
				display.setText("HURRA YOU FOUND THE WORD");
				text.setEditable(false);
			}
		}
	}
	
	public static int ifwrong(){
		hanger += 1;
		//System.out.print(hanger + " ");
		return hanger;
	}
	
	public int wrongguesses(){
		//hanger = ifwrong();
		return hanger;
	}
	
	
	public void drawRightLeg(Graphics g, Color color){
		g.setColor(color);
        Graphics2D g2d = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(4.0f);
        g2d.setStroke(stroke);
        int x = 245;
        int y = 200;
        g2d.drawLine(x, y, x + 30, y + 30);
	}
	
	public void drawLeftLeg(Graphics g, Color color){
		g.setColor(color);
        Graphics2D g2d = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(4.0f);
        g2d.setStroke(stroke);
        int x = 245;
        int y = 200;
        g2d.drawLine(x, y, x - 30, y + 30);
	}
	
	public void drawRightArm(Graphics g, Color color){
		g.setColor(color);
        Graphics2D g2d = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(4.0f);
        g2d.setStroke(stroke);
        int x = 245;
        int y = 160;
        g2d.drawLine(x, y, x + 30, y - 30);
	}
	
	public void drawLeftArm(Graphics g, Color color){
		g.setColor(color);
        Graphics2D g2d = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(4.0f);
        g2d.setStroke(stroke);
        int x = 245;
        int y = 160;
        g2d.drawLine(x, y, x - 30, y - 30);
	}
	
	public void drawBody(Graphics g, Color color){
		g.setColor(color);
        Graphics2D g2d = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(4.0f);
        g2d.setStroke(stroke);
        int x = 245;
        int y = 110;
        g2d.drawLine(x, y, 245, 200);
	}
	
	public void drawHead(Graphics g, Color color){
		int x = 220;
		int y = 60;
		g.setColor(color);
		g.setColor(color);
        Graphics2D g2d = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(4.0f);
        g2d.setStroke(stroke);
        g2d.fillOval(x, y, 50, 50);
	}
	
	public void drawHeader(Graphics g, Color color){
		int x = 120;
		int y = 50;
		g.setColor(color);
		g.fill3DRect(x, y, 150, 10, true);
	}
	
	public void drawPole(Graphics g, Color color){
		int x = 150;
		int y = 50;
		g.setColor(color);
		g.fill3DRect(x, y, 20, 200, true);
	}
	
	public void drawBase(Graphics g, Color color){
		int x = 100;
        int y = 250;
        g.setColor(color);
        g.fill3DRect(x, y, 280, 30, true);
	}
}

	

