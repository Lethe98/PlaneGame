package dfs.plane;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import dfs.util.GameUtil;

public class Plane extends GameObject {

	boolean left,up,right,down;
	boolean live = true;
	int speed =6;
	public void draw(Graphics g){
		if(live){
			width= 30;
			height = 30;
		g.drawImage(img, (int)x, (int)y, (int)width, (int)height, null);
		move();
		}
	}

	public Plane(){
		
	}
	
	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public Plane(String imgPath, double x, double y) {
		this.img= GameUtil.getImage(imgPath);
		this.width=img.getWidth(null);
		this.height=img.getHeight(null);
		this.x = x;
		this.y = y;
	}
	
	public void move(){
		if(left){
			x-=speed;
		}
		if(right){
			x+=speed;
		}
		if(up){
			y-=speed;
		}
		if(down){
			y+=speed;
		}		
	}
	public void addDirection(KeyEvent e){
		switch (e.getKeyCode()) {
		case 37:    //KeyEvent.VK_LEFT
			left=true;
			break;
		case 38:
			up=true;
			break;
		case 39:
			right=true;
			break;
		case 40:
			down=true;
			break;
		case 100:
			left=true;
			break;
		case 104:
			up=true;
			break;
		case 102:
			right=true;
			break;
		case 98:
			down=true;
			break;

		default:
			break;
		}
	}
	public void minusDirection(KeyEvent e){
		switch (e.getKeyCode()) {
		case 37:    //KeyEvent.VK_LEFT
			left=false;
			break;
		case 38:
			up=false;
			break;
		case 39:
			right=false;
			break;
		case 40:
			down=false;
			break;
		case 100:
			left=false;
			break;
		case 104:
			up=false;
			break;
		case 102:
			right=false;
			break;
		case 98:
			down=false;
			break;

		default:
			break;
		}
	}
}
	

