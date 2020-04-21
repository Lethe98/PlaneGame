package dfs.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame{

	//加载窗口
	public void launchFrame(){	
		setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		setLocation(300,100);
		setVisible(true);
		new PaintThread().start();
		
		
		//关闭窗口
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}			
		});
		
	}
	
	//定义一个重画窗口的线程类，是一个内部类
	class PaintThread extends Thread{
		public void run(){
			while(true){
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
				e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 双缓冲技术！！！！
	 * 消除闪烁
	 */
	private Image offScreenImage = null;//利用双缓冲技术消除闪烁
	public void update(Graphics g){
		if(offScreenImage==null){
			offScreenImage = this.createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		}
		Graphics gOff  = offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
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
	
}
