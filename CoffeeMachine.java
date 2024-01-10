package package1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import package2.*;

public class CoffeeMachine extends JPanel implements ActionListener, ItemListener, KeyListener{
	
	Drink eps = new Coffee("Espresso", 55.25, "Robusta");
	Drink amn = new Coffee("Americano", 55.25, "Arabrica");
	Drink lt = new Coffee("Latte", 55.25, "Arabrica");
	Drink tt = new Coffee("Thai Tea", 60.50, "-");
	Drink mc = new Coffee("Matcha", 65.50, "-");
	Drink ic = new Coffee("Iced Chocolate", 55.75, "-");
	
	JFrame f = new JFrame("Java Cafe");
	JPanel p1 = new JPanel();
	JLabel name = new JLabel("Customer's name :");
	public JTextField space = new JTextField(5);
	
	JPanel p2 = new JPanel();
	JPanel menu = new JPanel();
	JCheckBox menu1 = new JCheckBox(eps.getDrinkType());
	JCheckBox menu2 = new JCheckBox(amn.getDrinkType());
	JCheckBox menu3 = new JCheckBox(lt.getDrinkType());
	JCheckBox menu4 = new JCheckBox(tt.getDrinkType());
	JCheckBox menu5 = new JCheckBox(mc.getDrinkType());
	JCheckBox menu6 = new JCheckBox(ic.getDrinkType());
	
	JPanel p3 = new JPanel();
	JLabel price = new JLabel("Total price :");
	JLabel enter = new JLabel("(Press Enter to Continue)");
	
	private int[]x1 = {177,185,265,273};
	private int[]y1 = {260,320,320,260};
	
	private int[]x = {165,185,265,285};
	private int[]y = {170,320,320,170};
	
	private int[]x2 = {169,177,273,281};
	private int[]y2 = {200,260,260,200};
	
	private String menustate = "";
	public static double totalprice = 0.00;
	
	private String text = "";
	public static String finish = "";
	
	public CoffeeMachine(){
		super();		
		f.setSize(450, 650);
	    f.setLocationRelativeTo(null);
	    f.setVisible(true);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		p1.setBackground(new Color(255,240,235));
		menu.setBackground(new Color(255,240,235));
		p3.setBackground(new Color(255,240,235));

		menu.setLayout(new GridLayout(2,3));
		menu.add(menu1);
		menu.add(menu2);
		menu.add(menu3);
		menu.add(menu4);
		menu.add(menu5);
		menu.add(menu6);
		
		p1.setLayout(new FlowLayout());
		p1.add(name);
		p1.add(space);
		
		p2.setLayout(new BorderLayout());
		p2.add(p1, BorderLayout.NORTH);
		p2.add(menu);
		
		p3.setLayout(new FlowLayout());
		p3.add(price);
		p3.add(enter);
		
		f.setLayout(new BorderLayout());
		f.add(p2, BorderLayout.NORTH);
		f.add(this);
		f.add(p3, BorderLayout.SOUTH);
		
		menu1.addItemListener(this);
		menu2.addItemListener(this);
		menu3.addItemListener(this);
		menu4.addItemListener(this);
		menu5.addItemListener(this);
		menu6.addItemListener(this);
		
		menu1.addActionListener(this);
		menu2.addActionListener(this);
		menu3.addActionListener(this);
		menu4.addActionListener(this);
		menu5.addActionListener(this);
		menu6.addActionListener(this);
		
		menu1.addKeyListener(this);
		menu2.addKeyListener(this);
		menu3.addKeyListener(this);
		menu4.addKeyListener(this);
		menu5.addKeyListener(this);
		menu6.addKeyListener(this);
		
		space.addActionListener(this);
		space.addKeyListener(this);
	
		this.setFocusable(true);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(new Color(255,252,245));
		
		if (menustate == "1") {
			g.setColor(new Color(255,252,245));
			g.fillRect(100, 100, 300, 300);
			g.setColor(new Color(121,84,35));
			g.fillPolygon(x1,y1,4);
			g.setColor(Color.BLACK);
			g.drawPolygon(x,y,4);
			g.drawString("Price "+eps.getDrinkPrice()+" .-",185,350);
			g.drawString("Coffee bean : "+((Coffee)eps).getCoffeeType(), 155, 370);}
		
		else if (menustate == "2") {
			g.setColor(new Color(255,252,245));
			g.fillRect(100, 100, 300, 300);			
			g.setColor(new Color(220,238,247));
			g.fillPolygon(x2,y2,4);
			g.setColor(new Color(121,84,35));
			g.fillPolygon(x1,y1,4);
			g.setColor(Color.BLACK);
			g.drawPolygon(x,y,4);
			g.drawString("Price "+amn.getDrinkPrice()+" .-",185,350);
			g.drawString("Coffee bean : "+((Coffee)amn).getCoffeeType(), 155, 370);}

		else if (menustate == "3") {
			g.setColor(new Color(255,252,245));
			g.fillRect(100, 100, 300, 300);
			g.setColor(new Color(249,232,210));
			g.fillPolygon(x2,y2,4);
			g.setColor(new Color(121,84,35));
			g.fillPolygon(x1,y1,4);
			g.setColor(Color.BLACK);
			g.drawPolygon(x,y,4);
			g.drawString("Price "+lt.getDrinkPrice()+" .-",185,350);
			g.drawString("Coffee bean : "+((Coffee)lt).getCoffeeType(), 155, 370);}
		
		else if (menustate == "4") {
			g.setColor(new Color(255,252,245));
			g.fillRect(100, 100, 300, 300);
			g.setColor(new Color(249,232,210));
			g.fillPolygon(x2,y2,4);
			g.setColor(new Color(200,111,38));
			g.fillPolygon(x1,y1,4);
			g.setColor(Color.PINK);
			g.fillRect(250, 110, 8, 60);
			g.setColor(Color.BLACK);
			g.drawPolygon(x,y,4);
			g.drawString("Price "+tt.getDrinkPrice()+" .-",185,350);}

		
		else if (menustate == "5") {
			g.setColor(new Color(255,252,245));
			g.fillRect(100, 100, 300, 300);
			g.setColor(new Color(249,232,210));
			g.fillPolygon(x2,y2,4);
			g.setColor(new Color(87,107,51));
			g.fillPolygon(x1,y1,4);
			g.setColor(Color.PINK);
			g.fillRect(250, 110, 8, 60);
			g.setColor(Color.BLACK);
			g.drawPolygon(x,y,4);
			g.drawString("Price "+mc.getDrinkPrice()+" .-",185,350);}

		
		else if (menustate == "6") {
			g.setColor(new Color(255,252,245));
			g.fillRect(100, 100, 300, 300);
			g.setColor(new Color(249,232,210));
			g.fillPolygon(x2,y2,4);
			g.setColor(new Color(97,58,39));
			g.fillPolygon(x1,y1,4);
			g.setColor(Color.PINK);
			g.fillRect(250, 110, 8, 60);
			g.setColor(Color.BLACK);
			g.drawPolygon(x,y,4);
			g.drawString("Price "+ic.getDrinkPrice()+" .-",185,350);}

		else {}	
		
		}
	
	public void itemStateChanged(ItemEvent e) {

		if (menu1.isSelected()) {
			menustate = "1";}
		if (menu2.isSelected()) {
			menustate = "2";}
		if (menu3.isSelected()) {
			menustate = "3";}
		if (menu4.isSelected()) {
			menustate = "4";}
		if (menu5.isSelected()) {
			menustate = "5";}
		if (menu6.isSelected()) {
			menustate = "6";}

		if (e.getSource() == menu1) {
			if( menu1.isSelected()) { menustate = "1";}}
		if (e.getSource() == menu2) {
			if( menu2.isSelected()) { menustate = "2";}}
		if (e.getSource() == menu3) {
			if( menu3.isSelected()) { menustate = "3";}}
		if (e.getSource() == menu4) {
			if( menu4.isSelected()) { menustate = "4";}}
		if (e.getSource() == menu5) {
			if( menu5.isSelected()) { menustate = "5";}}
		if (e.getSource() == menu6 ) {
			if( menu6.isSelected()) { menustate = "6";}}	
		
		if (!menu1.isSelected() && !menu2.isSelected() && !menu3.isSelected() && !menu4.isSelected() && 
				!menu5.isSelected() && !menu6.isSelected()) {
			menustate = "";}
		
		repaint();

		}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menu1) {
			if( menustate == "1") {
				totalprice = totalprice + eps.getDrinkPrice();
				price.setText("Total price : "+totalprice+" baht ");}
			else 
			{ totalprice = totalprice - eps.getDrinkPrice();
			price.setText("Total price : "+totalprice+" baht ");} 
			f.setFocusable(true);}
		
		if (e.getSource() == menu2) {
			if( menustate == "2") {
				totalprice = totalprice + amn.getDrinkPrice();
				price.setText("Total price : "+totalprice+" baht ");}
			else 
			{ totalprice = totalprice - amn.getDrinkPrice();
			price.setText("Total price : "+totalprice+" baht ");} }
		
		if (e.getSource() == menu3) {
			if( menustate == "3") {
				totalprice = totalprice + lt.getDrinkPrice();
				price.setText("Total price : "+totalprice+" baht ");}
			else 
			{ totalprice = totalprice - lt.getDrinkPrice();
			price.setText("Total price : "+totalprice+" baht ");} }
		
		if (e.getSource() == menu4) {
			if( menustate == "4") {
				totalprice = totalprice + tt.getDrinkPrice();
				price.setText("Total price : "+totalprice+" baht ");}
			else 
			{ totalprice = totalprice - tt.getDrinkPrice();
			price.setText("Total price : "+totalprice+" baht ");} }
		
		if (e.getSource() == menu5) {
			if( menustate == "5") {
				totalprice = totalprice + mc.getDrinkPrice();
				price.setText("Total price : "+totalprice+" baht ");}
			else 
			{ totalprice = totalprice - mc.getDrinkPrice() ;
			price.setText("Total price : "+totalprice+" baht ");} }
		
		if (e.getSource() == menu6 ) {
			if( menustate == "6") {
				totalprice = totalprice + ic.getDrinkPrice();
				price.setText("Total price : "+totalprice+" baht ");}
			else 
			{ totalprice = totalprice - ic.getDrinkPrice();
			price.setText("Total price : "+totalprice+" baht ");} }
		
		else {}
		
		}

	@Override
	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			text = space.getText();
			finish = text+"'s order is ready!";
			JFrame f2 = new f2();
			f2.setVisible(true);	
		}

	}
	
}
	

	











