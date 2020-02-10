package Transformer;

import java.util.concurrent.TimeUnit;

class Leg_Move implements Runnable{
	Leg leg;
	int stop_y;
	Leg_Move(Leg l,int s_y){
		leg=l;
		stop_y=s_y;
	}
	public void run() {
		int speed=2;
		while(leg.getLocation().y>stop_y) {
			leg.setLocation(leg.getLocation().x,leg.getLocation().y-16);
			try {
				TimeUnit.MILLISECONDS.sleep(speed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		leg.Leg_Move_done=true;
	}
}

