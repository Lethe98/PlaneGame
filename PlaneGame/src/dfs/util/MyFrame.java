package dfs.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame{

	//���ش���
	public void launchFrame(){	
		setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		setLocation(300,100);
		setVisible(true);
		new PaintThread().start();
		
		
		//�رմ���
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}			
		});
		
	}
	
	//����һ���ػ����ڵ��߳��࣬��һ���ڲ���
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
	 * ˫���弼����������
	 * ������˸
	 */
	private Image offScreenImage = null;//����˫���弼��������˸
	public void update(Graphics g){
		if(offScreenImage==null){
			offScreenImage = this.createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		}
		Graphics gOff  = offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	/**
	 * �ڴ��ڴ�ӡ��Ϣ
	 * @param g
	 * @param str
	 * @param size
	 */
	public void printInfo(Graphics g,String str,int size,int x,int y,Color color ){
		Color c0 = g.getColor();
		g.setColor(color);
		Font f0 = getFont();
		Font f1 = new Font("����", Font.BOLD, size);
		g.setFont(f1);
		g.drawString(str, x, y);
		
		g.setFont(f0);
		g.setColor(c0);
	}
	
}
