import java.awt.Color;

import javax.media.j3d.Appearance;
import javax.media.j3d.Material;
import javax.vecmath.Color3f;


public class TileAppearance {
	public static void main(String args[]) {
		
	}
	
	public static void createRockAppearance() {
        My3DTest.rockAppearance = new Appearance();
        Color3f ambientColour = new Color3f();
        ambientColour.set(Color.GRAY);
        Color3f emissiveColour = new Color3f(0.0f, 0.0f, 0.0f);
        Color3f specularColour = new Color3f(1.0f, 1.0f, 1.0f);
        Color3f diffuseColour = new Color3f();
        diffuseColour.set(Color.GRAY);

        float shininess = 20.0f;
        My3DTest.rockAppearance.setMaterial(new Material(ambientColour, emissiveColour,
                diffuseColour, specularColour, shininess));
    }
	public static void createDirtAppearance() {
        My3DTest.dirtAppearance = new Appearance();
        Color3f ambientColour = new Color3f();
        ambientColour.set(Color.GRAY);
        Color3f emissiveColour = new Color3f(0.0f, 0.0f, 0.0f);
        Color3f specularColour = new Color3f(1.0f, 1.0f, 1.0f);
        Color3f diffuseColour = new Color3f();
        diffuseColour.set(Color.GRAY);

        float shininess = 20.0f;
        My3DTest.dirtAppearance.setMaterial(new Material(ambientColour, emissiveColour,
                diffuseColour, specularColour, shininess));
        }
	public static void createTestTileAppearance() {
        My3DTest.testTileAppearance = new Appearance();
        Color3f ambientColour = new Color3f();
        ambientColour.set(Color.GRAY);
        Color3f emissiveColour = new Color3f(0.0f, 0.0f, 0.0f);
        Color3f specularColour = new Color3f(1.0f, 1.0f, 1.0f);
        Color3f diffuseColour = new Color3f();
        diffuseColour.set(Color.GRAY);

        float shininess = 20.0f;
        My3DTest.testTileAppearance.setMaterial(new Material(ambientColour, emissiveColour,
                diffuseColour, specularColour, shininess));
        }
	public static void createGrassAppearance() {
        My3DTest.grassAppearance = new Appearance();
        Color3f ambientColour = new Color3f();
        ambientColour.set(Color.GRAY);
        Color3f emissiveColour = new Color3f(0.0f, 0.0f, 0.0f);
        Color3f specularColour = new Color3f(1.0f, 1.0f, 1.0f);
        Color3f diffuseColour = new Color3f();
        diffuseColour.set(Color.GRAY);

        float shininess = 20.0f;
        My3DTest.grassAppearance.setMaterial(new Material(ambientColour, emissiveColour,
                diffuseColour, specularColour, shininess));
        }
}
