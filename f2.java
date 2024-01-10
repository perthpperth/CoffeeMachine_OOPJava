package package2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import package1.CoffeeMachine;

public class f2 extends JFrame implements ActionListener {
	
	Discount x = new Discount(CoffeeMachine.totalprice);
	
	JPanel pn = new JPanel();
	JPanel pn2 = new JPanel();
	public JLabel time = new JLabel("", SwingConstants.CENTER);
	JLabel lb0 = new JLabel("Total Price : " + CoffeeMachine.totalprice+" baht");
	JLabel lb1 = new JLabel("<<< Surpise Promotion of The Month >>>", SwingConstants.CENTER);
	JLabel lb3 = new JLabel("Discount Price : - ");
	JButton confirm = new JButton("Confirm & Get a discount price");
	JButton cancel = new JButton("Cancel the order");

	public int i = 60;
	public Timer timer = new Timer(1000, this);

	public f2() {
		
		timer.start();
	
		setTitle("Order Summary");
		setSize(300, 350);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new GridLayout(2,1));
		time.setFont(new Font("", Font.BOLD, 25));
		time.setForeground(new Color(243,103,88));
		pn.setLayout(new GridLayout(1,1));
		pn.add(time);
		pn.setBackground(new Color(255,240,235));
		
		
		pn2.setLayout(new GridLayout(5,1));
		pn2.setBackground(new Color(255,252,245));
		pn2.add(lb1);
		pn2.add(lb0);
		pn2.add(lb3);
		pn2.add(confirm);
		pn2.add(cancel);

		add(pn);
		add(pn2);
		
		confirm.addActionListener(this);
		cancel.addActionListener(this);

	}
	
	public void actionPerformed(ActionEvent e) {
		if ((e.getSource()!= confirm) && (e.getSource()!= cancel)) {
			time.setText(String.valueOf(i));
			i--;
			if (i == -1) {
				timer.stop();
				time.setText(CoffeeMachine.finish);
				}
		}
		
		if (e.getSource() == confirm) {
			System.out.println("Order sucessful");
			lb3.setText("Discount Price : "+Discount.calculatePrice()+" baht");
		}
		
		if (e.getSource() == cancel) {
			System.out.println("Order unsucessful");
			JFrame f2 = new f2();
			f2.setVisible(false);
		}
		
	}
}