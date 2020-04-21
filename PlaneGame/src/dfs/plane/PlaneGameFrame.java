package dfs.plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.ArrayList;

import dfs.util.Constant;
import dfs.util.GameUtil;
import dfs.util.MyFrame;

public class PlaneGameFrame extends MyFrame {
	Image bg = GameUtil.getImage("images/bg.jpg");
	Plane p=new Plane("images/plane.png",250,400);	
	ArrayList bulletList = new ArrayList();//泛型未学，暂不加。以后学了强烈建议加上

	long startTime ;
	long endTime;
	
	Explode bao;
	
	public void paint(Graphics g){
		g.drawImage(bg, 0, 0, null);
		p.draw(g);
		

		
		for (int i = 0; i < bulletList.size(); i++) {
			Bullet b =(Bullet)bulletList.get(i);
			b.draw(g);
			//检测跟飞机的碰撞
			boolean peng =b.getRect().intersects(p.getRect());
			if(peng){
				p.setLive(false);//飞机死掉	
			
				if(bao==null){
					endTime=System.currentTimeMillis();//結束時間
					bao = new Explode(p.x, p.y);
				}
				bao.draw(g);				
				break;
			}
		}
		
		if(!p.isLive()){
			printInfo(g, "游戏结束!", 50,Constant.GAME_WIDTH/4,Constant.GAME_HEIGHT/2,Color.WHITE);			
			long period = (endTime-startTime)/100;		
			printInfo(g,"分数:"+period, 20, 20, 50, Color.GREEN);	
		}	

	}
	/**
	 * 在窗口打印信息
	 * @param g
	 * @param str
	 * @param size
	 */
	public void printInfo(Graphics g,String str,int size,int x,int y,Color color ){
		Color c0 = g.getColor();
		g.setColor(color);
		Font f0 = getFont();
		Font f1 = new Font("宋体", Font.BOLD, size);
		g.setFont(f1);
		g.drawString(str, x, y);
		
		g.setFont(f0);
		g.setColor(c0);
	}
	public void launchFrame(){
		super.launchFrame();
		//增加键盘的监听
		addKeyListener(new KeyMonitor());
		
		//生成一堆子弹
		for (int i = 0; i < 30; i++) {
			Bullet b=new  Bullet();
			bulletList.add(b);
		}
		startTime=System.currentTimeMillis();
	}
	//定义为内部类，可以方便地使用外部类的普通属性
	class KeyMonitor extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			//System.out.println(e.getKeyCode());//获取按下键的值
			p.addDirection(e);
		}
		@Override
		public void keyReleased(KeyEvent e) {
			p.minusDirection(e);		
		}
	}

	public static void main(String[] args) {
		new PlaneGameFrame().launchFrame();
		
	}
}











