package shaders;

import org.lwjgl.util.vector.Matrix4f;

public class StaticShader extends ShaderProgram {

	private static final String Vertex_File = "src/shaders/vertexShader.txt";
	private static final String Fragment_File = "src/shaders/fragmentShader.txt";
	
	private int location_transformationMatrix;
	
	public StaticShader() {
		super(Vertex_File, Fragment_File);
		
	}

	@Override
	protected void bindAttibutes() {
		super.bindAttribute(0, "position");
		super.bindAttribute(1, "textureCoords");
	}

	@Override
	protected void getAllUniformLocations() {
		location_transformationMatrix = super.getUniformLocation("transformationMatrix");
	}
	
	public void loadTransformationMatrix(Matrix4f matrix){
		super.loadMatrix(location_transformationMatrix, matrix);
	}

}
