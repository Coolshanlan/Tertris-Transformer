package Transformer;

import java.awt.Point;
import java.util.concurrent.TimeUnit;

class Transform implements Runnable{
	Component frame;
	Point size;
	Point vector;
	int speed_1 =1;
	int speed_2 =1;
	int control_lx=0;
	int control_ly=0;
	Transform(Component f,Point s,Point v,int sp1,int sp2,int clx,int cly){
		control_lx=clx;
		control_ly=cly;
		speed_1=sp1;
		speed_2=sp2;
		frame=f;
		size=s;
		vector=v;
		
	}
	public void run() {
		int a=0;
		a=10;
		while(frame.getSize().width<size.x/4 && frame.getSize().height<size.y/4) {
			frame.setSize(frame.getSize().width+vector.x,frame.getSize().height+vector.y);
			frame.setLocation(frame.getLocation().x-control_lx,frame.getLocation().y-control_ly);
			try {
				TimeUnit.MILLISECONDS.sleep(speed_1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		while(frame.getSize().width<size.x && frame.getSize().height<size.y) {
			frame.setSize(frame.getSize().width+vector.x,frame.getSize().height+vector.y);
			frame.setLocation(frame.getLocation().x-control_lx,frame.getLocation().y-control_ly);
			try {
				TimeUnit.MILLISECONDS.sleep(speed_2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		frame.transform_done=true;
		frame.vibrate();
	}
}
