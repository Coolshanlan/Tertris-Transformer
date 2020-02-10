package Transformer;

import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

class Body extends Component {
	Point body_size = new Point(490,490);
	boolean transformed=false;
	public boolean transform_2_doen=false;
	MouseListener ml =new MouseListener() {
        public void mousePressed(MouseEvent me) { }
        public void mouseReleased(MouseEvent me) { }
        public void mouseEntered(MouseEvent me) { }
        public void mouseExited(MouseEvent me) { }
        public void mouseClicked(MouseEvent me) { 
        	if(!transformed) {
        		transformed=true;
        		transform();
        	}
        }
    };
	Body(){
		setup();
		this.addMouseListener(ml);
		transform = new Transform(this,new Point(body_size.x,body_size.y),new Point(2,2),50,5,1,1);
		vibrate = new Vibrate(this);
		this.setLocation(this.getLocation().x,this.getLocation().y-100);
	}
	void setup() {
		this.setSize(50,50);
		setUndecorated(true);
		getContentPane().setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.pink);
	}

}

