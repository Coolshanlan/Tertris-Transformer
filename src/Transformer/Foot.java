package Transformer;

import java.awt.Color;
import java.awt.Point;

class Foot extends Component{
	Point Foot_size=new Point(125,75);
	int ini_x,ini_y;
	Foot(int i_x,int i_y){
		ini_x=i_x;
		ini_y=i_y;
		setup();
		transform = new Transform(this,new Point(Foot_size.x+1,Foot_size.y),new Point(0,2),10,10,0,0);
		vibrate = new Vibrate(this);
	}
	void setup() {
		this.setSize(125,0);
		this.setLocation(ini_x,ini_y);
		setUndecorated(true);
		getContentPane().setLayout(null);
		setVisible(true);
		getContentPane().setBackground(Color.red);
	}
}
