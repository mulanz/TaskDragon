import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.*;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import javax.swing.*;

public class Frame extends JFrame implements GLEventListener{
	
	final private int width = 2540; 
	final private int height = 1280; 
	
	private GLProfile profile;
	private GLCapabilities capabilities;
	private GLCanvas canvas;
	
	public Frame() { 
		super("Minimal OpenGL");
		profile = GLProfile.get(GLProfile.GL2);
		
		capabilities = new GLCapabilities(profile);
		capabilities.setDoubleBuffered(false);
		System.out.println(capabilities.toString());
		
		canvas = new GLCanvas(capabilities);
		canvas.addGLEventListener(this);
		
		this.setName("Minimal OpenGL");
		this.getContentPane().add(canvas);
		
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		canvas.requestFocusInWindow();
	}
	public static final long serialVersionUID = 1L;
	
	public void play() {
		
	}

	@Override
	public void display(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		/*GL4 gl = drawable.getGL().getGL4();
		gl.glClear(GL4.GL_COLOR_BUFFER_BIT | GL4.GL_DEPTH_BUFFER_BIT);
		
		gl.glFlush();*/
		
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}
	
		
}
