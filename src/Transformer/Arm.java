package Transformer;

import java.awt.Color;
import java.awt.Point;

class Arm extends Component{
	
	int ini_y=0;
	int ini_x;
	Point Arm_size=new Point(152,76);
	Arm(int i_x,int i_y){
		ini_x=i_x;
		ini_y=i_y;
		setup();
		transform = new Transform(this, new Point(152,76),new Point(2,0), 10, 10, 2,0); 
		vibrate = new Vibrate(this);
		this.setLocation(this.getLocation().x,this.getLocation().y-100);
	}
	
	void setup() {
		this.setSize(0,75);
		this.setLocation(ini_x,ini_y);
		setUndecorated(true);
		getContentPane().setLayout(null);
		setVisible(true);
		getContentPane().setBackground(Color.pink);
	}
}
