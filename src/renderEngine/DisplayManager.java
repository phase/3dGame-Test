package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class DisplayManager {

	public static final int Width = 1280;
	public static final int Height = 720;
	public static final int FPS_CAP = 120;
	
	public static void createDisplay() {
		try {
			Display.setDisplayMode(new DisplayMode(Width, Height));
			Display.create();
			Display.setTitle("3D Game");
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		GL11.glViewport(0, 0, Width, Height);
	}

	public static void updateDisplay() {
		Display.sync(FPS_CAP);
		Display.update();
	}

	public static void closeDisplay() {
		Display.destroy();
	}
}
