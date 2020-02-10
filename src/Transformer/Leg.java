package Transformer;

import java.awt.Color;

class Leg extends Component {
	int ini_x;
	Leg_Move lm;
	public boolean Leg_Move_done=false;
	Leg(int i_x,int s_y){
		ini_x=i_x;
		lm = new Leg_Move(this,s_y);
		setup(); 
		vibrate = new Vibrate(this);
	}
	public void move() {
		Thread m=new Thread(lm);
		m.start();
	}
	void setup() {
		this.setSize(75,250);
		this.setLocation(ini_x,1200);
		setUndecorated(true);
		getContentPane().setLayout(null);
		setVisible(true);
		getContentPane().setBackground(Color.pink);
	}

}