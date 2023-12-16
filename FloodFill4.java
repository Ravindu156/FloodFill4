import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



class FloodFill4 extends JFrame implements MouseListener{
	
	int x1,y1;
	Graphics g;
	Color[][] pixels=new Color[800][800];
	
	
	FloodFill4(){
		setTitle("Flood Fill4 Algorithm");
		setSize(800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		addMouseListener(this);
		g=getGraphics();
		
	}
	
		public Color getPixel(int x, int y){
			return pixels[x][y];
		}
		
		public void setPixel(int x, int y, Color c){
			g.setColor(c);
			pixels[x][y]=g.getColor();
			g.drawOval(x,y,1,1);
			
		}
		
		public void floodFilling(int x,int y,Color oc,Color nc){
			Color pc= getPixel(x,y);
			if(pc==oc){
				setPixel(x,y,nc);
				floodFilling(x,y-1,oc,nc);
				floodFilling(x,y+1,oc,nc);
				floodFilling(x-1,y,oc,nc);
				floodFilling(x+1,y,oc,nc);
			}
						
		}
		
		public void mouseClicked(MouseEvent e){
			x1=e.getX();
			y1=e.getY();
			
			drawObject(x1,y1,40);
			floodFilling(x1,y1,Color.green,Color.red);
			
		}
		
		public void drawObject(int x1,int y1,int d){
			for(int x=x1-d;x<=x1+d;x++){
				for(int y=y1-d;y<=y1+d;y++){
					setPixel(x,y,Color.green);
				}
			}
			
			
		}
		
		public void mouseEntered(MouseEvent e){}
		public void mouseExited(MouseEvent e){}
		public void mousePressed(MouseEvent e){}
		public void mouseReleased(MouseEvent e){}
		
		public static void main(String[] args){
			new FloodFill4();
		}
		
	
	
	
	
	
	
}