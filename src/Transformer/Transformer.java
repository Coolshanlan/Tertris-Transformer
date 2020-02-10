package Transformer;
import Transformer.Component;
import java.awt.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.lang.Thread;
import java.util.Random;
abstract class Component extends JFrame{
	
	Component(){
		
	}
	public boolean transform_done=false;
	public Vibrate vibrate;
	public Transform transform;
	public boolean vibrate_done=false;
    abstract void setup();
	public Point getcenter() {
		return new Point(this.getLocation().x+(int)(this.getSize().width/2)-25,this.getLocation().y+(int)(this.getSize().height/2-25));
	}
   public  void explosion() {
//    	Thread th = new Thread(()-> {
//    		JFrame jf =new JFrame();
//    		jf.setVisible(true);
//			JLabel jlb = new JLabel();	//实例化JLble
//			int width = 50,height = 50;	//这是图片和JLable的宽度和高度
//			jf.setSize(width,width);
//			ImageIcon image = new ImageIcon("C:\\Users\\Joey\\Desktop\\explotion.gif");//实例化ImageIcon 对象
//			image.setImage(image.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT ));//可以用下面三句代码来代替
//			jlb.setIcon(image);
//			jlb.setSize(width, height);
//            this.getContentPane().add(jlb);
//    	});
		System.out.println("gogogogoe");
    	new Thread(()->{
    		Thread body_v ;
    		for(int i=0;i<2;i++) {
    			vibrate = new Vibrate(this,+0);
        		body_v= new Thread(vibrate);
        		body_v.start();
        		this.setOpacity(0.9f);
        		Transformer.delay(120);
    		}
       		for(int i=0;i<2;i++) {
       			vibrate = new Vibrate(this,+1);
        		body_v= new Thread(vibrate);
        		body_v.start();
        		this.setOpacity(0.8f);
        		Transformer.delay(120);
    		}
       		for(int i=0;i<2;i++) {
       			vibrate = new Vibrate(this,+2);
        		body_v= new Thread(vibrate);
        		body_v.start();
        		this.setOpacity(0.7f);
        		Transformer.delay(120);
    		}
    		for(int i=0;i<2;i++) {
    			vibrate = new Vibrate(this,3);
        		body_v= new Thread(vibrate);
        		body_v.start();
        		this.setOpacity(0.6f);
        		Transformer.delay(120);
    		}
    		for(int i=0;i<4;i++) {
    			vibrate = new Vibrate(this,4);
        		body_v= new Thread(vibrate);
        		body_v.start();
        		this.setOpacity(0.5f);
        		Transformer.delay(120);
    		}
    		for(int i=0;i<2;i++) {
    			vibrate = new Vibrate(this,3);
        		body_v= new Thread(vibrate);
        		body_v.start();
        		this.setOpacity(0.4f);
        		Transformer.delay(120);
    		}
     		for(int i=0;i<2;i++) {
    			vibrate = new Vibrate(this,2);
        		body_v= new Thread(vibrate);
        		body_v.start();
        		this.setOpacity(0.3f);
        		Transformer.delay(120);
    		}
      		for(int i=0;i<2;i++) {
    			vibrate = new Vibrate(this,1);
        		body_v= new Thread(vibrate);
        		body_v.start();
        		this.setOpacity(0.2f);
        		Transformer.delay(120);
    		}
       		for(int i=0;i<2;i++) {
    			vibrate = new Vibrate(this,-1);
        		body_v= new Thread(vibrate);
        		body_v.start();
        		this.setOpacity(0.1f);
        		Transformer.delay(120);
    		}
     		this.setOpacity(0.0f);
    	}).start();
    }
	public void vibrate() {
		Thread body_v = new Thread(vibrate);
		body_v.start();
	}
	public void transform() {
		Thread body_t = new Thread(transform);
		body_t.start();
	}
	
}
class Body_Transform_2 implements Runnable {
	Body_Transform_2(){
	}
	public void run() {
		while(Transformer.body.getSize().height<540) {
			Transformer.body.setSize(Transformer.body.getSize().width,Transformer.body.getSize().height+2);
			Transformer.delay(50);
		}
		Transformer.body.vibrate();
		Transformer.delay(1000);
		int move=20;
		for(int i=0;i<4;i++) {
			int m=0;
			while(m<120) {
				m+=move;
				Transformer.right_leg.setLocation(Transformer.right_leg.getLocation().x-move, Transformer.right_leg.getLocation().y);
				Transformer.right_foot.setLocation(Transformer.right_foot.getLocation().x-move, Transformer.right_foot.getLocation().y);
				Transformer.delay(50);
			}
			m=0;
			Transformer.delay(300);
			while(m<120) {
				m+=move;
				Transformer.left_leg.setLocation(Transformer.left_leg.getLocation().x-move, Transformer.left_leg.getLocation().y);
				Transformer.left_foot.setLocation(Transformer.left_foot.getLocation().x-move, Transformer.left_foot.getLocation().y);
				Transformer.body.setLocation(Transformer.body.getLocation().x-move, Transformer.body.getLocation().y);
				Transformer.left_hand.hand[0].setLocation(Transformer.left_hand.hand[0].getLocation().x-move,Transformer.left_hand.hand[0].getLocation().y);
				Transformer.left_hand.update_location();
				Transformer.right_hand.hand[0].setLocation(Transformer.right_hand.hand[0].getLocation().x-move,Transformer.right_hand.hand[0].getLocation().y);
				Transformer.right_hand.update_location();
				Transformer.left_arm.setLocation(Transformer.left_arm.getLocation().x-move, Transformer.left_arm.getLocation().y);
				Transformer.right_arm.setLocation(Transformer.right_arm.getLocation().x-move, Transformer.right_arm.getLocation().y);
				Transformer.head.setLocation(Transformer.head.getLocation().x-move, Transformer.head.getLocation().y);
			}
			Transformer.delay(700);
		}
		Transformer.right_leg.vibrate();
		Transformer.right_foot.vibrate();
		Transformer.left_arm.vibrate();
		Transformer.right_arm.vibrate();
		Transformer.left_leg.vibrate();
		Transformer.left_foot.vibrate();
		Transformer.head.vibrate();
		Transformer.left_hand.vibrate();
		Transformer.right_hand.vibrate();
		Transformer.body.vibrate();
		Transformer.body.transform_2_doen=true;
		Transformer.delay(1000);
		Transformer.head.start_time();
		Transformer.Start_Game();
	}
}
class Square extends JFrame {
	int status = 1;
	public int x,y;
	public int type=0;
	public Vibrate vibrate;
	public JPanel jp = new JPanel();
	Square(int t){
		this.getInputContext().setCompositionEnabled(false);
		type =t;	
		this.setUndecorated(true);
		this.setVisible(true);
		this.setFocusable(false);
		jp.setOpaque(false);
		jp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.black));
		this.getContentPane().add(jp);
	}
	public void _setlocation(int _x , int _y) {
		x=_x;
		y=_y;
	}
	public  void explosion() {
    	new Thread(()->{
    		Thread body_v ;
    		for(int i=0;i<2;i++) {
    			vibrate = new Vibrate(this,+0);
        		body_v= new Thread(vibrate);
        		body_v.start();
        		this.setOpacity(0.9f);
        		Transformer.delay(120);
    		}
       		for(int i=0;i<2;i++) {
       			vibrate = new Vibrate(this,+1);
        		body_v= new Thread(vibrate);
        		body_v.start();
        		this.setOpacity(0.8f);
        		Transformer.delay(120);
    		}
       		for(int i=0;i<2;i++) {
       			vibrate = new Vibrate(this,+2);
        		body_v= new Thread(vibrate);
        		body_v.start();
        		this.setOpacity(0.7f);
        		Transformer.delay(120);
    		}
    		for(int i=0;i<2;i++) {
    			vibrate = new Vibrate(this,3);
        		body_v= new Thread(vibrate);
        		body_v.start();
        		this.setOpacity(0.6f);
        		Transformer.delay(120);
    		}
    		for(int i=0;i<4;i++) {
    			vibrate = new Vibrate(this,4);
        		body_v= new Thread(vibrate);
        		body_v.start();
        		this.setOpacity(0.5f);
        		Transformer.delay(120);
    		}
    		for(int i=0;i<2;i++) {
    			vibrate = new Vibrate(this,3);
        		body_v= new Thread(vibrate);
        		body_v.start();
        		this.setOpacity(0.4f);
        		Transformer.delay(120);
    		}
     		for(int i=0;i<2;i++) {
    			vibrate = new Vibrate(this,2);
        		body_v= new Thread(vibrate);
        		body_v.start();
        		this.setOpacity(0.3f);
        		Transformer.delay(120);
    		}
      		for(int i=0;i<2;i++) {
    			vibrate = new Vibrate(this,1);
        		body_v= new Thread(vibrate);
        		body_v.start();
        		this.setOpacity(0.2f);
        		Transformer.delay(120);
    		}
       		for(int i=0;i<2;i++) {
    			vibrate = new Vibrate(this,-1);
        		body_v= new Thread(vibrate);
        		body_v.start();
        		this.setOpacity(0.1f);
        		Transformer.delay(120);
    		}
     		this.setOpacity(0.0f);
    	}).start();
    }
}
abstract class Shape{
	public int mode=1;
	public int max_mode=0;
	public Point[] tryrotate;
	public ArrayList<Square> squares = new ArrayList<>();
	public Color color;
	public boolean end_game=false;
	public abstract boolean rotate(int[][] map,int mode);
	public void dispose() {
		squares.stream().forEach(s->s.dispose());
	}
	public void init_array(int t) {
		tryrotate=new Point[8];
		tryrotate[0] = new Point(0,1);
		tryrotate[1] = new Point(0,2);
		tryrotate[2] = new Point(1,1);
		tryrotate[3] = new Point(-1,1);
		tryrotate[4] = new Point(1,2);
		tryrotate[5] = new Point(-1,2);
		tryrotate[6] = new Point(1,3);
		tryrotate[7] = new Point(-1,3);
		for(int i=0;i<4;i++) {
			Square sq =new Square(t);
			sq.getContentPane().setBackground(color);
			squares.add(sq);
		}
	}
	public boolean try_rotate(int[][] map , ArrayList<Point>p) {
		boolean can_r=true;
		for(int t=0;t<8;t++) {
			can_r=true;
			for(int i=0;i<4;i++) {
				int x=p.get(i).x+tryrotate[t].x;
				int y=p.get(i).y+tryrotate[t].y;
				if(x>=0 && x<10 && y<20 && y>=0 ) {
					if(map[x][y] ==2) {
						can_r=false;
						break;
					}
				}
				else {
					can_r=false;
					break;
				}
			}
			if(can_r) {
				for(int i=0;i<4;i++) {
					p.get(i).x = p.get(i).x+tryrotate[t].x;
					p.get(i).y = p.get(i).y+tryrotate[t].y;
				}
				break;
			}
			
		}
		return can_r;
	}
	public ArrayList<Point> getPoint() {
		ArrayList<Point> p = new ArrayList<Point>();
		for(int i=0;i<4;i++) {
			Point np = new Point();
			np.x = squares.get(i).x;
			np.y = squares.get(i).y;
			p.add(np);
		}
		return p;
	}
	public void  setstop(int[][] map) {
		ArrayList<Point> p =getstop(map);
		for(int i=0;i<4;i++) {
			map[squares.get(i).x][squares.get(i).y]=0;
			map[p.get(i).x][p.get(i).y]=2;
			squares.get(i)._setlocation(p.get(i).x, p.get(i).y);
			squares.get(i).status=2;
		}
	}
	int stop_my=0;
	public ArrayList<Point> getstop(int[][] map ) {
		ArrayList<Point> p = getPoint();
		boolean can_m=true;
		stop_my=1;
		while(can_m) {
			for(int i=0;i<4;i++) {
				if(p.get(i).y+stop_my == 20||map[p.get(i).x][p.get(i).y+stop_my] ==2) {
					can_m=false;
					break;
				}
			}
			if(can_m)
				stop_my++;
		}
		stop_my--;
		p.stream().forEach(x->{x.y+=stop_my;});
		return p;
	}
	public boolean can_m=true;
	public boolean move_location(int[][] map,int mx,int my) {
		ArrayList<Point> p = getPoint();
		p.stream().forEach(x->{x.x+=mx;x.y+=my;});
		can_m=true;
		boolean re=revise_location(p);
		for(int i=0;i<4;i++) {
			if(map[p.get(i).x][p.get(i).y] ==2) {
				can_m=false;
				break;
			}
		}
		if(can_m && squares.get(0).status==1) {
			for(int i=0;i<4;i++) {
				map[squares.get(i).x][squares.get(i).y]=0;
				map[p.get(i).x][p.get(i).y]=1;
				squares.get(i)._setlocation(p.get(i).x, p.get(i).y);
			}
		}
		return can_m&!re;
	}
	public boolean revise_location(ArrayList<Point> p) {
		boolean re=false;
		for(int i=0;i<4;i++) {
			boolean again=false;
			if(p.get(i).x<0) {
				p.stream().forEach(x->x.x+=1);
				again=true;
				re=true;
			}
			else if(p.get(i).x>=10) {
				p.stream().forEach(x->x.x-=1);
				again=true;
				re=true;
			}
			if(p.get(i).y<0) {
				p.stream().forEach(x->x.y+=1);
				again=true;
				re=true;
			}
			else if(p.get(i).y>=20) {
				p.stream().forEach(x->x.y-=1);
				again=true;
				re=true;
			}
			if(again)i=-1;
		}
		return re;
	}
}
class Bottom {
	public ArrayList<Square> squares = new ArrayList<>();
	Bottom(){
		init_array(-1);
		squares.stream().forEach(s->s.setSize(50,50));
	}
	public void init_array(int t) {
		for(int i=0;i<4;i++) {
			Square sq =new Square(t);
			sq.jp.setOpaque(false);
			sq.setOpacity(0.6f);
			squares.add(sq);
		}
	}
	public void setlocation(ArrayList<Point> p) {
		for(int i=0;i<4;i++) {
			squares.get(i)._setlocation(p.get(i).x, p.get(i).y);
		}
	}
}
class T extends Shape{
	T(int[][] map){
		max_mode =4;
		color =Color.pink;
		init_array(1);
		squares.get(0)._setlocation(5, 1);
		end_game = rotate(map,0);
		//if(end_game)this.dispose();
		squares.stream().forEach(s->s.setSize(50,50));
	}
	public boolean rotate(int[][] map,int m) {
		mode=mode+m;
		ArrayList<Point> p = getPoint();
		int head_x = p.get(0).x;
		int head_y = p.get(0).y;
		if(mode>max_mode)mode=1;
		if(mode<1)mode=max_mode;
		if(mode ==1) {
			p.get(1).x = head_x;
			p.get(1).y = head_y-1;
			p.get(2).x = head_x-1;
			p.get(2).y = head_y;
			p.get(3).x = head_x+1;
			p.get(3).y = head_y;
		}
		else if(mode ==2) {
			p.get(1).x = head_x+1;
			p.get(1).y = head_y;
			p.get(2).x = head_x;
			p.get(2).y = head_y-1;
			p.get(3).x = head_x;
			p.get(3).y = head_y+1;
		}
		else if(mode ==3) {
			p.get(1).x = head_x;
			p.get(1).y = head_y+1;
			p.get(2).x = head_x+1;
			p.get(2).y = head_y;
			p.get(3).x = head_x-1;
			p.get(3).y = head_y;
		}
		else if(mode ==4) {
			p.get(1).x = head_x-1;
			p.get(1).y = head_y;
			p.get(2).x = head_x;
			p.get(2).y = head_y+1;
			p.get(3).x = head_x;
			p.get(3).y = head_y-1;
		}
		revise_location(p);
		boolean can_r=true;
		for(int i=0;i<4;i++) {
			if(map[p.get(i).x][p.get(i).y] ==2) {
				can_r=false;
				break;
			}
		}
		if(!can_r)
			can_r=try_rotate(map,p);
		if(can_r && squares.get(0).status==1) {
			for(int i=0;i<4;i++) {
				squares.get(i)._setlocation(p.get(i).x, p.get(i).y);
			}
		}
		return can_r;
		
	}
}
class J extends Shape{
	J(int[][] map){
		max_mode =4;
		color =Color.pink;
		init_array(1);
		squares.get(0)._setlocation(5, 1);
		end_game = rotate(map,0);
		squares.stream().forEach(s->s.setSize(50,50));
	}
	public boolean rotate(int[][] map,int m) {
		mode=mode+m;
		ArrayList<Point> p = getPoint();
		int head_x = p.get(0).x;
		int head_y = p.get(0).y;
		if(mode>max_mode)mode=1;
		if(mode<1)mode=max_mode;
		if(mode ==1) {
			p.get(1).x = head_x;
			p.get(1).y = head_y-1;
			p.get(2).x = head_x;
			p.get(2).y = head_y-2;
			p.get(3).x = head_x-1;
			p.get(3).y = head_y;
		}
		else if(mode ==2) {
			p.get(1).x = head_x+1;
			p.get(1).y = head_y;
			p.get(2).x = head_x+2;
			p.get(2).y = head_y;
			p.get(3).x = head_x;
			p.get(3).y = head_y-1;
		}
		else if(mode ==3) {
			p.get(1).x = head_x;
			p.get(1).y = head_y+1;
			p.get(2).x = head_x;
			p.get(2).y = head_y+2;
			p.get(3).x = head_x+1;
			p.get(3).y = head_y;
		}
		else if(mode ==4) {
			p.get(1).x = head_x-1;
			p.get(1).y = head_y;
			p.get(2).x = head_x-2;
			p.get(2).y = head_y;
			p.get(3).x = head_x;
			p.get(3).y = head_y+1;
		}
		revise_location(p);
		boolean can_r=true;
		for(int i=0;i<4;i++) {
			if(map[p.get(i).x][p.get(i).y] ==2) {
				can_r=false;
				break;
			}
		}
		if(!can_r)
			can_r=try_rotate(map,p);
		if(can_r && squares.get(0).status==1) {
			for(int i=0;i<4;i++) {
				squares.get(i)._setlocation(p.get(i).x, p.get(i).y);
			}
		}
		return can_r;
		
	}
}
class L extends Shape{
	L(int[][] map){
		max_mode =4;
		color =Color.orange;
		init_array(1);
		squares.get(0)._setlocation(5, 1);
		end_game = rotate(map,0);
		squares.stream().forEach(s->s.setSize(50,50));
	}
	public boolean rotate(int[][] map,int m) {
		mode=mode+m;
		ArrayList<Point> p = getPoint();
		int head_x = p.get(0).x;
		int head_y = p.get(0).y;
		if(mode>max_mode)mode=1;
		if(mode<1)mode=max_mode;
		if(mode ==1) {
			p.get(1).x = head_x;
			p.get(1).y = head_y-1;
			p.get(2).x = head_x;
			p.get(2).y = head_y-2;
			p.get(3).x = head_x+1;
			p.get(3).y = head_y;
		}
		else if(mode ==2) {
			p.get(1).x = head_x+1;
			p.get(1).y = head_y;
			p.get(2).x = head_x+2;
			p.get(2).y = head_y;
			p.get(3).x = head_x;
			p.get(3).y = head_y+1;
		}
		else if(mode ==3) {
			p.get(1).x = head_x;
			p.get(1).y = head_y+1;
			p.get(2).x = head_x;
			p.get(2).y = head_y+2;
			p.get(3).x = head_x-1;
			p.get(3).y = head_y;
		}
		else if(mode ==4) {
			p.get(1).x = head_x-1;
			p.get(1).y = head_y;
			p.get(2).x = head_x-2;
			p.get(2).y = head_y;
			p.get(3).x = head_x;
			p.get(3).y = head_y-1;
		}
		revise_location(p);
		boolean can_r=true;
		for(int i=0;i<4;i++) {
			if(map[p.get(i).x][p.get(i).y] ==2) {
				can_r=false;
				break;
			}
		}
		if(!can_r)
			can_r=try_rotate(map,p);
		if(can_r && squares.get(0).status==1) {
			for(int i=0;i<4;i++) {
				squares.get(i)._setlocation(p.get(i).x, p.get(i).y);
			}
		}
		return can_r;
		
	}
}
class Z extends Shape{
	Z(int[][] map){
		max_mode =2;
		color =Color.red;
		init_array(1);
		squares.get(0)._setlocation(5, 1);
		end_game = rotate(map,0);
		squares.stream().forEach(s->s.setSize(50,50));
	}
	public boolean rotate(int[][] map,int m) {
		mode=mode-m;
		ArrayList<Point> p = getPoint();
		int head_x = p.get(0).x;
		int head_y = p.get(0).y;
		if(mode>max_mode)mode=1;
		if(mode<1)mode=max_mode;
		if(mode ==1) {
			p.get(1).x = head_x;
			p.get(1).y = head_y-1;
			p.get(2).x = head_x+1;
			p.get(2).y = head_y-1;
			p.get(3).x = head_x-1;
			p.get(3).y = head_y;
		}
		else if(mode ==2) {
			p.get(1).x = head_x+1;
			p.get(1).y = head_y;
			p.get(2).x = head_x+1;
			p.get(2).y = head_y+1;
			p.get(3).x = head_x;
			p.get(3).y = head_y-1;
		}
		revise_location(p);
		boolean can_r=true;
		for(int i=0;i<4;i++) {
			if(map[p.get(i).x][p.get(i).y] ==2) {
				can_r=false;
				break;
			}
		}
		if(!can_r)
			can_r=try_rotate(map,p);
		if(can_r && squares.get(0).status==1) {
			for(int i=0;i<4;i++) {
				squares.get(i)._setlocation(p.get(i).x, p.get(i).y);
			}
		}
		return can_r;
		
	}
}
class O extends Shape{
	O(int[][] map){
		max_mode =1;
		color =Color.yellow;
		init_array(1);
		squares.get(0)._setlocation(5, 1);
		end_game = rotate(map,0);
		squares.stream().forEach(s->s.setSize(50,50));
	}
	public boolean rotate(int[][] map,int m) {
		mode=mode-m;
		ArrayList<Point> p = getPoint();
		int head_x = p.get(0).x;
		int head_y = p.get(0).y;
		if(mode>max_mode)mode=1;
		if(mode<1)mode=max_mode;
		p.get(1).x = head_x;
		p.get(1).y = head_y+1;
		p.get(2).x = head_x-1;
		p.get(2).y = head_y+1;
		p.get(3).x = head_x-1;
		p.get(3).y = head_y;
		revise_location(p);
		boolean can_r=true;
		for(int i=0;i<4;i++) {
			if(map[p.get(i).x][p.get(i).y] ==2) {
				can_r=false;
				break;
			}
		}
		if(can_r && squares.get(0).status==1) {
			for(int i=0;i<4;i++) {
				squares.get(i)._setlocation(p.get(i).x, p.get(i).y);
			}
		}
		return can_r;
		
	}
}
class Move implements Runnable{
	public boolean go=false;
	Game game ;
	int x;
	int y;
	Move(Game g,int mx , int my){
		game=g;
		x=mx;
		y=my;
	}
	public void run() {
		while(!game.game_end) {
			while(go) {
				boolean canmove=false;	
				canmove=game.now_shape.move_location(game.map, x, y);
				if(x==0&&y==1) {
					if(canmove) {
						game.restart=true;
					}
				}
				game.update_shape();
				Transformer.delay(100);
			}
			Transformer.delay(100);
		}
		
	}
}
class S extends Shape{
	S(int[][] map){
		max_mode =2;
		color =Color.green;
		init_array(1);
		squares.get(0)._setlocation(5, 1);
		end_game = rotate(map,0);
		squares.stream().forEach(s->s.setSize(50,50));
	}
	public boolean rotate(int[][] map,int m) {
		mode=mode-m;
		ArrayList<Point> p = getPoint();
		int head_x = p.get(0).x;
		int head_y = p.get(0).y;
		if(mode>max_mode)mode=1;
		if(mode<1)mode=max_mode;
		if(mode ==1) {
			p.get(1).x = head_x;
			p.get(1).y = head_y-1;
			p.get(2).x = head_x-1;
			p.get(2).y = head_y-1;
			p.get(3).x = head_x+1;
			p.get(3).y = head_y;
		}
		else if(mode ==2) {
			p.get(1).x = head_x+1;
			p.get(1).y = head_y;
			p.get(2).x = head_x+1;
			p.get(2).y = head_y-1;
			p.get(3).x = head_x;
			p.get(3).y = head_y+1;
		}
		revise_location(p);
		boolean can_r=true;
		for(int i=0;i<4;i++) {
			if(map[p.get(i).x][p.get(i).y] ==2) {
				can_r=false;
				break;
			}
		}
		if(!can_r)
			can_r=try_rotate(map,p);
		if(can_r && squares.get(0).status==1) {
			for(int i=0;i<4;i++) {
				squares.get(i)._setlocation(p.get(i).x, p.get(i).y);
			}
		}
		return can_r;
		
	}
}
class I extends Shape{
	I(int[][] map){
		max_mode =2;
		color =Color.blue;
		init_array(1);
		squares.get(0)._setlocation(5, 1);
		end_game = rotate(map,0);
		squares.stream().forEach(s->s.setSize(50,50));
	}
	public boolean rotate(int[][] map,int m) {
		mode=mode-m;
		ArrayList<Point> p = getPoint();
		int head_x = p.get(0).x;
		int head_y = p.get(0).y;
		if(mode>max_mode)mode=1;
		if(mode<1)mode=max_mode;
		if(mode ==1) {
			p.get(1).x = head_x-1;
			p.get(1).y = head_y;
			p.get(2).x = head_x+1;
			p.get(2).y = head_y;
			p.get(3).x = head_x+2;
			p.get(3).y = head_y;
		}
		else if(mode ==2) {
			p.get(1).x = head_x;
			p.get(1).y = head_y-1;
			p.get(2).x = head_x;
			p.get(2).y = head_y+1;
			p.get(3).x = head_x;
			p.get(3).y = head_y+2;
		}
		revise_location(p);
		boolean can_r=true;
		for(int i=0;i<4;i++) {
			if(map[p.get(i).x][p.get(i).y] ==2) {
				can_r=false;
				break;
			}
		}
		if(!can_r)
			can_r=try_rotate(map,p);
		if(can_r && squares.get(0).status==1) {
			for(int i=0;i<4;i++) {
				squares.get(i)._setlocation(p.get(i).x, p.get(i).y);
			}
		}
		return can_r;
		
	}
}
class Textsquare extends Square{

	Textsquare(int t,int x,int y,String s) {
		super(t);
		JLabel l =new JLabel(s,JLabel.CENTER);
		l.setFont(new Font("Serif", Font.BOLD, 20));
		this.getContentPane().add(l);
		this.setSize(50,50);
		this.setLocation(x, y);
		this.getContentPane().add(l);
	}
	

}
class Shoot implements Runnable{
	Point target;
	int robot_HP=0;
	Shoot(int hp){
		robot_HP=hp;
	}
	public Square create_bullet(){
		Square b= new Square(-2);
		b.setSize(50,800);
		b.setLocation(1700,10+200);//screen
		b.getContentPane().setBackground(new Color(255,30,30));
		return b;
	}
	public void run() {
		ArrayList<Component> com =new ArrayList<Component>();
		Square bullet=create_bullet();
		while(bullet.getSize().height != 50) {
			bullet.setSize(50,bullet.getSize().height-10);
			bullet.setLocation(bullet.getLocation().x,bullet.getLocation().y+5);
			Transformer.delay(10);
		}
		if(robot_HP == 14) {
			target=Transformer.left_hand.hand[1].getcenter();
			com.add(Transformer.left_hand.hand[1]);
			com.add(Transformer.left_hand.hand[2]);
			com.add(Transformer.left_hand.hand[3]);
		}
		else if(robot_HP == 13) {
			target=Transformer.right_hand.hand[1].getcenter();
			com.add(Transformer.right_hand.hand[1]);
			com.add(Transformer.right_hand.hand[2]);
			com.add(Transformer.right_hand.hand[3]);
		}
		else if(robot_HP == 12) {
			Transformer.game.speed=90;
			target=Transformer.left_hand.hand[0].getcenter();
			com.add(Transformer.left_hand.hand[0]);
		}
		else if(robot_HP == 11) {
			Transformer.game.speed=80;
			target=Transformer.right_hand.hand[0].getcenter();
			com.add(Transformer.right_hand.hand[0]);
		}
		else if(robot_HP == 10) {
			Transformer.game.speed=70;
			target=Transformer.left_arm.getcenter();
			com.add(Transformer.left_arm);
		}
		else if(robot_HP == 9) {
			Transformer.game.speed=60;
			target=Transformer.right_arm.getcenter();
			com.add(Transformer.right_arm);
		}
		else if(robot_HP == 8) {
			Transformer.game.speed=50;
			target=Transformer.left_foot.getcenter();
			com.add(Transformer.left_foot);
		}
		else if(robot_HP == 7) {
			Transformer.game.speed=40;
			target=Transformer.right_foot.getcenter();
			com.add(Transformer.right_foot);
		}
		else if(robot_HP == 6) {
			Transformer.game.speed=30;
			target=Transformer.left_leg.getcenter();
			com.add(Transformer.left_leg);
		}
		else if(robot_HP == 5) {
			Transformer.game.speed=15;
			target=Transformer.right_leg.getcenter();
			com.add(Transformer.right_leg);
		}
		else if (robot_HP<5 &&robot_HP>=2){
			Transformer.game.speed=10;
			target=Transformer.body.getcenter();
			if(robot_HP==2)
			com.add(Transformer.body);
		}
		else {
			Game.win=true;
			Transformer.game.game_end=true;
			Transformer.show_end_text("YOU WIN ");
			target=Transformer.head.getcenter();
			com.add(Transformer.head);
		}
		double mx;
		double my;
		double x = bullet.getLocation().x;
		double y = bullet.getLocation().y;
		mx=(target.x-bullet.getLocation().x)/50.0;
		my=(target.y-bullet.getLocation().y)/50.0;
		while(bullet.getLocation().x>target.x) {
			x+=mx;
			y+=my;
			bullet.setLocation((int)x,(int)y);
			Transformer.delay(7);
		}
		bullet.dispose();
		for(int i=0;i<com.size();i++) {
			com.get(i).explosion();
			com.remove(i);
			i--;
		}
		bullet.setLocation(target.x,target.y);
	}
}
class Game implements Runnable{
	int speed=100;
	int screen_X=1100;
	public static boolean win = false;
	static public int screen_Y=10;
	public int[][] map = new int[10][20];
	public ArrayList<Square> square_list = new ArrayList<>();
	public Shape now_shape;
	public int now;
	public int next=-1;
	public int store=-1;
	public Shape next_shape;
	public Shape store_shape;
	public Bottom bottom;
	public boolean game_end=false;
	public Square left_limit;
	public Square right_limit;
	public Square ultimate_background;
	public Square ultimate;
	public static Move move_right;
	public static Move move_left;
	public static Move move_down;
	Random rnd ;
	public int robot_HP=14;
	int ultimate_score=0;
	public Thread ul = new Thread(()->{
		if(ultimate.getSize().height==2 ) {
			System.out.println("Revise_ul_inul");
			ultimate.setSize(50,0);
			ultimate.setLocation(1700,screen_Y+1000);
		}
		while(!this.game_end) {
			while(ultimate.getSize().height!=ultimate_score*80) {
				double delay=(ultimate_score*80-ultimate.getSize().height)/8;
				if(delay<0)delay=50;
				Transformer.delay((int)(350*(1/delay)));	
				ultimate.setSize(50,ultimate.getSize().height+8);
				ultimate.getContentPane().setBackground(new Color(255,ultimate.getContentPane().getBackground().getGreen()-2,ultimate.getContentPane().getBackground().getBlue()-1));
				ultimate.setLocation(1700,ultimate.getLocation().y-8);
				if(ultimate.getSize().height == 800) {
					//shoot
					ultimate_score-=10;
					new Thread(new Shoot(robot_HP)).start();
					robot_HP--;
					ultimate.setSize(50,0);
					ultimate.setLocation(1700,screen_Y+1000);
					ultimate.getContentPane().setBackground(new Color(255,230,130));
					Transformer.delay(1150);
				}
			}
			Transformer.delay(100);
		}
		if(!this.win) {
			Transformer.show_end_text("YOU LOSE ");
		}
	});
	Game() {
		rnd= new Random();
		rnd.setSeed(rnd.nextInt(10000));
		bottom = new Bottom();
		left_limit = new Square(-2);
		right_limit = new Square(-2);
		left_limit.setSize(50,1000);
		right_limit.setSize(50,1000);
		left_limit.getContentPane().setBackground(Color.black);
		right_limit.getContentPane().setBackground(Color.black);
		left_limit.setLocation(screen_X-50, screen_Y);
		right_limit.setLocation(1600, screen_Y);
		ultimate_background= new Square(-2);
		ultimate= new Square(-2);
		ultimate.setSize(50,0);
		ultimate.setLocation(1700,screen_Y+1000);
		ultimate.getContentPane().setBackground(new Color(255,230,130));
		ultimate_background.setSize(50,800);
		ultimate_background.setOpacity(0.4f);
		ultimate_background.setLocation(1700, screen_Y+200);
		move_right = new Move(this,1,0);
		move_left = new Move(this,-1,0);
		move_down = new Move(this,0,1);
		Thread tm_r =new Thread(move_right);
		tm_r.start();
		Thread tm_l =new Thread(move_left);
		tm_l.start();
		Thread tm_d =new Thread(move_down);
		tm_d.start();
		create_shape();
		ul.start();
	}
	public void score(int add) {
		int n_score=0;
		if(add==0)return;
		else if(add ==4)n_score=8;
		else if(add==3)n_score=5;
		else if(add==2)n_score=3;
		else if(add==1) n_score=1;
		ultimate_score+=n_score;
		
	}
	public void stop_shape() {
		wait_stopdelay=true;
		now_shape.squares.stream().forEach(x->{
			map[x.x][x.y]=2;
			x.status=2;
		});
		update_shape();
		ArrayList<Integer> dis_y =new ArrayList<Integer>();
		boolean dis=false;
		int line_num=0;
		for(int i=0;i<20;i++) {
			dis=true;
			for(int j=0;j<10;j++) {
				if(map[j][i] != 2) {
					dis=false;
					break;
				}
			}
			if(dis) {
				dis_y.add(i);
				line_num++;
			}
		}
		score(line_num);
		for(int i=0;i<20;i++) {
			for(int j=0;j<10;j++) {
				map[j][i]=0;
			}
		}
		square_list.addAll(now_shape.squares);
		square_list=new ArrayList<Square>(square_list.stream().sorted((x,y)->x.y>y.y?-1:((x.y == y.y)?((x.x>y.x)?1:-1):1)).collect(Collectors.toList()));
		for(int i=0;i<dis_y.size();i++) {
			int y = dis_y.get(i);
			for(int s=0;s<square_list.size();s++) {
				Square sq =square_list.get(s);
				if(sq.y==y) {
					sq.dispose();
					square_list.remove(s);
					s--;
					Transformer.delay(20);
				}
			}
		}
		for(int i=0;i<square_list.size();i++) {
			int count =0;
			for(int d= 0;d<dis_y.size();d++) {
				if(square_list.get(i).y<dis_y.get(d))count++;
			}
			square_list.get(i)._setlocation(square_list.get(i).x, square_list.get(i).y+count);
			map[square_list.get(i).x][square_list.get(i).y]=2;
		}
		update();
		for(int i=0;i<4;i++) {
			if(now_shape.squares.get(i).getSize().width!=50) {
				System.out.println("Revise_STOP_S");
				now_shape.squares.get(i).setSize(50,50);
			}
		}
		create_shape();
		wait_stopdelay=false;
		if(store_wait) {
			store();
			//store_wait=false;
		}
	}
	public boolean store_wait=false;
	ArrayList<Integer> shape_pool = new ArrayList<Integer>();
	public Shape shape_type(int num) {
		if(num ==0) {
			return new I(map);
		}else if(num ==1) {
			return new Z(map);
		}else if(num ==2) {
			return new S(map);
		}else if(num ==3) {
			return new O(map);
		}else if(num ==4) {
			return new T(map);
		}else if(num ==5) {
			return new L(map);
		}else {
			return new J(map);
		}
	}
	public void update_next() {
		if(next_shape!=null)next_shape.dispose();
		next_shape = shape_type(next);
		next_shape.squares.stream().forEach(s->{
			s.setLocation(screen_X+400+s.x*50,screen_Y+s.y*50);
		});
	}
	public boolean wait_stopdelay=false;
	public void store() {
		if(wait_stopdelay)return;
		store_wait=false;
		for(int i=0;i<4;i++) {
			map[now_shape.squares.get(i).x][now_shape.squares.get(i).y]=0;
		}
		now_shape.dispose();
		if(store!=-1)
		store_shape.dispose();
		if(store==-1) {
			int c = now;
			now=store;
			store=c;
			create_shape();
		}
		else {
			int c = now;
			now=store;
			store=c;
			now_shape = shape_type(now);
		}
		store_shape = shape_type(store);
		store_shape.squares.stream().forEach(s->{
			s.setLocation(screen_X-450+s.x*50,screen_Y+s.y*50);
		});
		for(int i=0;i<4;i++) {
			if(store_shape.squares.get(i).getSize().width!=50) {
				System.out.println("Revise_St");
				store_shape.squares.get(i).setSize(50,50);
			}
		}
	}
	public void create_shape() {
		move_left.go=false;
		move_right.go=false;
		if(shape_pool.size() == 0) {
			for(int i=0;i<7;i++)
				for(int j=0;j<2;j++)
					shape_pool.add(i);
		}
		if(next == -1) {
			int rd= rnd.nextInt(shape_pool.size());
			next =shape_pool.get(rd);
			shape_pool.remove(rd);
		}
		now=next;
		now_shape = shape_type(now);
		int rd= rnd.nextInt(shape_pool.size());
		next =shape_pool.get(rd);
		shape_pool.remove(rd);
		game_end = !now_shape.end_game;
		update_next();
		update_shape();
		for(int i=0;i<4;i++) {
			if(now_shape.squares.get(i).getSize().width!=50) {
				System.out.println("Revise_S");
				now_shape.squares.get(i).setSize(50,50);
			}
			if(bottom.squares.get(i).getSize().width!=50) {
				System.out.println("Revise_B");
				bottom.squares.get(i).setSize(50,50);
			}
			if(next_shape.squares.get(i).getSize().width!=50) {
				System.out.println("Revise_N");
				next_shape.squares.get(i).setSize(50,50);
			}
		}
	}
	public void update() {	
		square_list.stream().forEach(s->{
			s.setLocation(screen_X+s.x*50,screen_Y+s.y*50);
		});
	}
	public void update_shape() {	
		bottom.setlocation(now_shape.getstop(map));
		for(int i=0;i<4;i++) {
			bottom.squares.get(i).setLocation(bottom.squares.get(i).x*50+screen_X,bottom.squares.get(i).y*50+screen_Y);
			now_shape.squares.get(i).setLocation(now_shape.squares.get(i).x*50+screen_X,now_shape.squares.get(i).y*50+screen_Y);
		}
	}
	boolean stop=false;
	boolean restart=false;
	public void run() {
		if(left_limit.getSize().width!=50) {
			System.out.println("Revise_L");
			left_limit.setSize(50,1000);
		}
		if(right_limit.getSize().width!=50) {
			System.out.println("Revise_R");
			right_limit.setSize(50,1000);
		}
		if(ultimate.getSize().height==2 ) {
			System.out.println("Revise_ul");
			ultimate.setSize(50,0);
			ultimate.setLocation(1700,screen_Y+1000);
		}
		if(ultimate_background.getSize().width!=50) {
			System.out.println("Revise_ul_b");
			right_limit.setSize(50,800);
		}
		while(!game_end) {
			stop=false;
			restart=false;
			for(int i=0;i<10;i++) {
				if(!stop&&!restart)
				Transformer.delay(speed);
				else break;
			}
			if(stop) {
				stop_shape();
				continue;
			}
			else if(restart) {
				continue;
			}
			else {
				for(Square s:now_shape.squares) {
					if(s.y == 19||map[s.x][s.y+1] == 2) {
						stop=true;
						break;
					}
				}
				if(stop) {
					stop_shape();
					continue;
				}
				else {
					now_shape.move_location(map,0,1);
					update_shape();
				}
			}
		}
		now_shape.squares.forEach(x->x.dispose());
		square_list.forEach(s->s.getContentPane().setBackground(Color.gray));
	}
}
public  class Transformer extends JFrame {
	public static void wait_transform(Component c) {
		while(!c.transform_done) {
			delay(100);
		}
		while(!c.vibrate_done) {
			delay(100);
		}
	}
	public static void wait_move(Hand c) {
		while(!c.Hand_Move_done) {
			delay(100);
		}
	}
	public static void wait_move(Leg c) {
		while(!c.Leg_Move_done) {
			delay(100);
		}
	}
	public static void delay(int time) {
		try {
			TimeUnit.MILLISECONDS.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	static void show_end_text(String text) {
		Transformer.head.end_game=true;
		String time = text;
		time+=Transformer.head.get_time();
		Textsquare[] textw =new Textsquare[time.length()];
		if(!game.win)
		game.square_list.stream().forEach(a->a.explosion());
		Transformer.delay(2280);
		for(int i=0;i<textw.length;i++) {
			Transformer.delay(50);
			textw[i] = new Textsquare(-1,650+50*i,500,time.charAt(i)+"");
		}
		for(int i=0;i<textw.length;i++) {
			textw[i].setSize(50, 50);
		}
		
	}
	static void  Transform_Start() {
		body = new Body();
		wait_transform(body);
		delay(1000);
		head = new Head(body.getLocation().x+130,body.getLocation().y);
		head.transform();
		wait_transform(head);
		delay(1000);
		left_arm = new Arm(body.getLocation().x,body.getLocation().y+175);
		right_arm = new Arm(body.getLocation().x+body.getSize().width,body.getLocation().y+175);
		right_arm.transform = new Transform(right_arm, new Point(152,76),new Point(2,0), 10, 10, 0,0); 
		right_arm.transform();
		left_arm.transform();
		wait_transform(right_arm);
		delay(1000);
		left_hand = new Hand(body.getLocation().x-225,body.getLocation().y+150);
		left_hand.move();
		wait_move(left_hand);
		delay(300);
		right_hand = new Hand(body.getLocation().x+body.getSize().width+2,body.getLocation().y+150);
		right_hand.move();
		wait_move(right_hand);
		delay(500);
		left_leg = new Leg(body.getLocation().x+70,body.getLocation().y+body.getSize().height);
		left_leg.move();
		wait_move(left_leg);
		right_leg = new Leg(body.getLocation().x+body.getSize().width-70-75,body.getLocation().y+body.getSize().height);
		right_leg.move();
		wait_move(right_leg);
		delay(1000);
		left_foot= new Foot(left_leg.getLocation().x-25,left_leg.getLocation().y+left_leg.getSize().height);
		left_foot.transform();
		wait_transform(left_foot);
		delay(1000);
		right_foot= new Foot(right_leg.getLocation().x-25,right_leg.getLocation().y+right_leg.getSize().height);
		right_foot.transform();
		wait_transform(right_foot);
		
	}
	public static Body body;
	public static Head head;
	public static Arm left_arm;
	public static Arm right_arm;
	public static Hand left_hand;
	public static Hand right_hand;
	public static Leg left_leg;
	public static Leg right_leg;
	public static Foot left_foot;
	public static Foot right_foot;
	public static Panel C_Game;
	public static Panel C_Stone;
	public static Canvas C_Next;
	public static Game game;
	public static ActionListener  A_Show_Game=new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			body.remove((JButton)e.getSource());
			Body_Transform_2 bt2= new Body_Transform_2();
			Thread b_t_2=new Thread(bt2);
			b_t_2.start();
		}
	};
	public static void Start_Game() {
		game = new Game();
		Thread g = new Thread(game);
		g.start();
		Transformer tt =new Transformer();
		tt.setUndecorated(true);
		tt.setVisible(true);
		tt.addKeyListener(KL);
		while(true) {
			tt.requestFocus(true);
			Transformer.delay(100);
		}
	}
	public static void main(String[] args) {
		//Start_Game();
//		File audioFile = new File("C:\\Users\\Joey\\eclipse-workspace\\Tertris Transformer\\src\\Transformer\\green04.wav");
//		AudioPlayer player = AudioPlayer.createPlayer(audioFile);
//		player.play();
		System.out.print(System.getProperty("user.dir"));
		Transform_Start();
		//done
		delay(1000);
		JButton B_Show_Game =new JButton();
		B_Show_Game.setSize(50,50);
		body.getContentPane().add(B_Show_Game);
		B_Show_Game.setLocation(body.getSize().width/2-25,body.getSize().height/2-25);
		B_Show_Game.addActionListener(A_Show_Game);
		while(!body.transform_2_doen) {
			delay(100);
		}
		//Game
	}
	Transformer() {
		this.getInputContext().dispose();
	}
	public static KeyListener KL = new KeyListener() {
		public  void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_Z||e.getKeyCode() == KeyEvent.VK_UP) {
				game.now_shape.rotate(game.map,+1);
				game.update_shape();
			}
			else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				game.move_down.go=true;
			}
			else if(e.getKeyCode() == KeyEvent.VK_X) {
				game.now_shape.rotate(game.map,-1);
				game.update_shape();
			}
			else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				game.move_left.go=true;
			}
			else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				game.move_right.go=true;
			}
			else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
				game.wait_stopdelay=true;
				game.now_shape.setstop(game.map);
				game.stop=true;
			}
			else if(e.getKeyCode() == KeyEvent.VK_Y) {
				new Thread(new Shoot(game.robot_HP)).start();
				game.robot_HP--;
			}
			else if(e.getKeyCode() == KeyEvent.VK_C || e.getKeyCode() == KeyEvent.VK_SHIFT) {
				game.store_wait=true;
				game.store();
			}
			else if(e.getKeyCode() ==KeyEvent.VK_ESCAPE ) {
				System.exit(0);
			}
			//System.out.println(KeyEvent.getKeyText(e.getKeyCode()));
		}
	 
		public  void keyReleased(KeyEvent e) {
			//text.append("键盘" + KeyEvent.getKeyText(e.getKeyCode()) + "键松开\n");
			if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				game.move_down.go=false;
			}
			else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				game.move_left.go=false;
			}
			else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				game.move_right.go=false;
			}
		}
	 
		public  void keyTyped(KeyEvent e) {
			//text.append("输入的内容是" + e.getKeyChar() + "\n");
		}
	};
	
}
