package Transformer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

class Head extends Component{
	Point Head_size=new Point(230,150);
	int ini_x,ini_y;
	public boolean end_game=false;
	public JLabel ltime ;
	int min=0;
	int sec=-1;
	Thread time = new Thread(()->{
		while(!end_game) {
			sec++;
			if(sec == 60) {
				min++;
				sec=0;
			}
			ltime.setText(String.format("%02d:%02d",min,sec));
			Transformer.delay(1000);
		}
	});
	void start_time() {
		ltime = new JLabel("00:00",JLabel.CENTER);
		ltime.setText("00:00");
		ltime.setSize(230,150);
		ltime.setFont(new Font("Serif", Font.BOLD, 64));
		this.getContentPane().add(ltime);
		time.start();
	}
	Head(int i_x,int i_y){
		ini_x=i_x;
		ini_y=i_y;
		setup();
		transform = new Transform(this,new Point(Head_size.x+1,Head_size.y),new Point(0,2),10,10,0,2);
		vibrate = new Vibrate(this);
	}
	String get_time() {
		return String.format("%02d:%02d",min,sec);
	}
	void setup() {
		this.setSize(230,0);
		this.setLocation(ini_x,ini_y);
		setUndecorated(true);
		getContentPane().setLayout(null);
		setVisible(true);
		getContentPane().setBackground(Color.red);
	}

}