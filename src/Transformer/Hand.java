package Transformer;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JFrame;


class finger extends Component{
	public void vibrate() {
			vibrate = new Vibrate(this);
			Thread body_v = new Thread(vibrate);
			body_v.start();	
	}
	public void  setup() {
		
	}
}
class Hand{
	int in_l_x=0;
	Hand_Move hm;
	public boolean Hand_Move_done=false;
	public finger[] hand = new finger[4];
	Hand(int l_x,int s_y) {
		in_l_x=l_x;
		setup();
		hm = new Hand_Move(this,s_y);
	}
	public void update_location() {
		hand[1].setLocation(hand[0].getLocation().x-hand[1].getSize().width/2+hand[0].getSize().width/2  ,  hand[0].getLocation().y+hand[0].getSize().height);
		hand[2].setLocation(hand[1].getLocation().x  ,   hand[1].getLocation().y+hand[1].getSize().height);
		hand[3].setLocation(hand[1].getLocation().x+ hand[1].getSize().width -hand[2].getSize().width  ,   hand[1].getLocation().y+hand[1].getSize().height);
	}
	public void move() {
		Thread m=new Thread(hm);
		m.start();
	}
	public Point getcenter() {
		return new Point(hand[0].getcenter());
	}
	public Vibrate vibrate;
	public void vibrate() {
		for(int i=0;i<4;i++) {
			hand[i].vibrate();
		}
	}	
	void setup() {
		
		for(int i=0;i<4;i++) {
			hand[i] = new finger();
			hand[i].setUndecorated(true);
			hand[i].getContentPane().setLayout(null);
			hand[i].setVisible(true);
		}
		hand[0].setSize(75,300);
		hand[1].setSize(200,50);
		hand[2].setSize(50,70);
		hand[3].setSize(50,70);
		in_l_x=in_l_x+hand[0].getSize().width;
		hand[0].getContentPane().setBackground(Color.pink);
		hand[1].getContentPane().setBackground(Color.red);
		hand[2].getContentPane().setBackground(Color.red);
		hand[3].getContentPane().setBackground(Color.red);
		hand[0].setLocation(in_l_x,1200);
		hand[0].setSize(75,300);
		hand[1].setSize(200,50);
		hand[2].setSize(50,70);
		hand[3].setSize(50,70);
		update_location();
	}
}
