package dfs.plane;

import java.awt.Color;
import java.awt.Graphics;
import dfs.util.Constant;

public class Bullet extends GameObject{

	double degree;
	
	public Bullet(){
		x=Constant.GAME_WIDTH/2;
		y=Constant.GAME_HEIGHT/2;
		degree=Math.random()*Math.PI*2;		
		width = 5;
		height = 5;
	}

	public void draw(Graphics g){
		Color  color= g.getColor();
		g.setColor(Color.YELLOW);
		g.fillOval((int)x, (int)y, width, height);
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);
		if(y>Constant.GAME_HEIGHT-height||y<30){
			degree = -degree;
		}
		if(x<0||x>Constant.GAME_WIDTH-width){
			degree = Math.PI-degree;
		}
		g.setColor(color);
	}
}
