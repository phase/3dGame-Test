package engineTester;

import models.RawModel;
import models.TexturedModel;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.Renderer;
import shaders.StaticShader;
import textures.ModelTexture;
import entities.Entity;

public class MainGameLoop {
	public static void main(String[] args) {

		DisplayManager.createDisplay();

		Loader loader = new Loader();
		
		StaticShader shader = new StaticShader();
		
		Renderer rend = new Renderer(shader);
		
		
		float[] verts = { 
				-0.5f, 0.5f, 0f,  //v0
				-0.5f, -0.5f, 0f, //v1 
				0.5f, -0.5f, 0.0f,//v2
				0.5f, 0.5f, 0f   //v3
				};
		int[] indices = {
				0,1,3 //Top Left Triangle
			   ,3,1,2 //Bottom Right Triangle
		};
		
		float[] textureCords = {
				0,0,
				0,1,
				1,1,
				1,0
		};
		
		RawModel model = loader.loadToVao(verts, textureCords, indices);
		ModelTexture texture = new ModelTexture(loader.loadTexture("Penguin"));
		TexturedModel texmod = new TexturedModel(model, texture);
		Entity entity = new Entity(texmod, new Vector3f(0,0,-1),0,0,0,1);
		
		while (!Display.isCloseRequested()) {
			entity.increasePosition(0f, 0.0f, -0.1f);
			rend.prepare();
			shader.start();
			rend.render(entity,shader);
			shader.stop();
			DisplayManager.updateDisplay();
		}
		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}

}
