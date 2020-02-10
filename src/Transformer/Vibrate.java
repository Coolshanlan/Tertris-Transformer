package Transformer;

import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

class Vibrate implements Runnable{
	Component frame;
	Square square;
	int move=0;
	boolean mode=false;
	boolean hide=false;
	Vibrate(Component f){
		frame=f;
	}
	Vibrate(Component f,int m){
		frame=f;
		move=m;
	}
	Vibrate(Square s,int m){
		square=s;
		move=m;
		mode=true;
	}
	void delay(int speed) {
		try {
			TimeUnit.MILLISECONDS.sleep(speed);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void run() {
		int speed=20;
		if(!mode) {
			frame.setLocation(frame.getLocation().x+10+move,frame.getLocation().y-10-move);
			delay(speed);
			frame.setLocation(frame.getLocation().x-20-move,frame.getLocation().y);
			delay(speed);
			frame.setLocation(frame.getLocation().x+15+move,frame.getLocation().y+20+move);
			delay(speed);
			frame.setLocation(frame.getLocation().x-5-move,frame.getLocation().y-15-move);
			delay(speed);
			frame.setLocation(frame.getLocation().x-10-move,frame.getLocation().y+5+move);
			delay(speed);
			frame.setLocation(frame.getLocation().x+10+move,frame.getLocation().y);
			delay(speed);
			frame.vibrate_done=true;
		}
		else {
			square.setLocation(square.getLocation().x+10+move,square.getLocation().y-10-move);
			delay(speed);
			square.setLocation(square.getLocation().x-20-move,square.getLocation().y);
			delay(speed);
			square.setLocation(square.getLocation().x+15+move,square.getLocation().y+20+move);
			delay(speed);
			square.setLocation(square.getLocation().x-5-move,square.getLocation().y-15-move);
			delay(speed);
			square.setLocation(square.getLocation().x-10-move,square.getLocation().y+5+move);
			delay(speed);
			square.setLocation(square.getLocation().x+10+move,square.getLocation().y);
			delay(speed);
		}
	}
}