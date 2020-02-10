package Transformer;

import java.util.concurrent.TimeUnit;

class Hand_Move implements Runnable{
	Hand hand;
	int stop_y=0;
	Hand_Move(Hand h,int s_y){
		hand=h;
		stop_y=s_y;
	}
	public void run() {
		int speed=1;
		while(hand.hand[0].getLocation().y>stop_y) {
			hand.hand[0].setLocation(hand.hand[0].getLocation().x,hand.hand[0].getLocation().y-20);
			hand.update_location();
			try {
				TimeUnit.MILLISECONDS.sleep(speed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		hand.Hand_Move_done=true;
	}
}