

import com.sun.j3d.utils.behaviors.keyboard.KeyNavigatorBehavior;
import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.image.TextureLoader;

import com.sun.j3d.utils.universe.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.Toolkit;

import javax.media.j3d.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.vecmath.*;

public class My3DTest extends JFrame {

    SimpleUniverse world;
    static Appearance dirtAppearance;
    static Appearance rockAppearance;
    static Appearance testTileAppearance;
    static Appearance grassAppearance;
    BranchGroup branchGroup;
    BoundingSphere boundingSphere;
    GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
    Canvas3D canvas3D = new Canvas3D(config);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
   

    public My3DTest() {
    	setUndecorated(true);
    	setExtendedState(JFrame.MAXIMIZED_BOTH);
        add(canvas3D);
        setVisible(true);
    	setTitle("3D Tests");
    	createUniverse();
        TileAppearance.createDirtAppearance();
        TileAppearance.createRockAppearance();
        TileAppearance.createTestTileAppearance();
        TileAppearance.createGrassAppearance();
        createSceneGraph();
        createPlatform();
        createLights();
        createBehaviourInteractors();
        world.getViewingPlatform().setNominalViewingTransform();
        world.addBranchGraph(branchGroup);
        repaint();
        
    }
    public BranchGroup createSceneGraph() {
    	BranchGroup objRoot = new BranchGroup();
    	TextureLoader dirtLoader = new TextureLoader("dirt.png",this);
    	TextureLoader rockLoader = new TextureLoader("rock.png",this);
    	TextureLoader testTileLoader = new TextureLoader("testTile.png",this);
    	TextureLoader grassLoader = new TextureLoader("grass.png",this);
    	Texture dirt = dirtLoader.getTexture();
    	Texture rock = rockLoader.getTexture();
    	Texture grass = grassLoader.getTexture();
    	Texture testTile = testTileLoader.getTexture();    
    	dirtAppearance.setTexture(dirt);
    	rockAppearance.setTexture(rock);
    	testTileAppearance.setTexture(testTile);
    	grassAppearance.setTexture(grass);
    	return objRoot;
     }



	private void createUniverse() {
        world = new SimpleUniverse(canvas3D);
        branchGroup = new BranchGroup();
        boundingSphere = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0);
        
    }

    

    public void createPlatform() {
        for (float x = 0.0f; x <= 98.0f; x = x += 2.0f) {
            for (float y = 0.0f; y <= 0.0f; y += 2.0f) {
                for (float z = 0.0f; z <= 98.0f; z += 2.0f) {
                    Box box = new Box(1.0f, 1.0f, 1.0f,Primitive.GENERATE_TEXTURE_COORDS, rockAppearance);
                    box.setCollidable(true);
                    TransformGroup tg = new TransformGroup();
                    Transform3D transform = new Transform3D();
                    Vector3f vector = new Vector3f(x, y - 8, z);
                    transform.setTranslation(vector);
                    tg.setTransform(transform);
                    tg.addChild(box);
                    branchGroup.addChild(tg);
               }
            }

        }
        for (float x = 0.0f; x <= 98.0f; x = x += 2.0f) {
            for (float y = 2.0f; y <= 4.0f; y += 2.0f) {
                for (float z = 0.0f; z <= 98.0f; z += 2.0f) {
                    Box box = new Box(1.0f, 1.0f, 1.0f,Primitive.GENERATE_TEXTURE_COORDS, dirtAppearance);
                    box.setCollidable(true);
                    TransformGroup tg = new TransformGroup();
                    Transform3D transform = new Transform3D();
                    Vector3f vector = new Vector3f(x, y - 8, z);
                    transform.setTranslation(vector);
                    tg.setTransform(transform);
                    tg.addChild(box);
                    branchGroup.addChild(tg);
               }
            }

        }
        for (float x = 0.0f; x <= 98.0f; x = x += 2.0f) {
            for (float y = 6.0f; y <= 6.0f; y += 2.0f) {
                for (float z = 0.0f; z <= 98.0f; z += 2.0f) {
                    Box box = new Box(1.0f, 1.0f, 1.0f,Primitive.GENERATE_TEXTURE_COORDS, testTileAppearance);
                    box.setCollidable(true);
                    TransformGroup tg = new TransformGroup();
                    Transform3D transform = new Transform3D();
                    Vector3f vector = new Vector3f(x, y - 8, z);
                    transform.setTranslation(vector);
                    tg.setTransform(transform);
                    tg.addChild(box);
                    branchGroup.addChild(tg);
               }
            }

        }

        
    }
    public void paint(Graphics g) {
    	g.drawRect(WIDTH - 200, HEIGHT - 200, WIDTH / 2 + 40, HEIGHT /2 + 40);
    }

    public void createLights() {
        Color3f ambientLightColour = new Color3f(0.9f, 0.9f, 0.9f);
        AmbientLight ambientLight = new AmbientLight(ambientLightColour);
        ambientLight.setInfluencingBounds(boundingSphere);
        Color3f directionLightColour = new Color3f(1.0f, 1.0f, 1.0f);
        Vector3f directionLightDir = new Vector3f(-1.0f, -1.0f, -1.0f);
        DirectionalLight directionLight = new DirectionalLight(directionLightColour, directionLightDir);
        directionLight.setInfluencingBounds(boundingSphere);
        branchGroup.addChild(ambientLight);
        branchGroup.addChild(directionLight);
    }

    private void createBehaviourInteractors() {
        TransformGroup viewTransformGroup =
                world.getViewingPlatform().getViewPlatformTransform();

        KeyNavigatorBehavior keyInteractor =
                new KeyNavigatorBehavior(viewTransformGroup);

        BoundingSphere movingBounds = new BoundingSphere(new Point3d(0.0, 0.0,
        0.0), 100.0);
        keyInteractor.setSchedulingBounds(movingBounds);
        branchGroup.addChild(keyInteractor);

       /* MouseRotate behavior = new MouseRotate(10);
        behavior.setTransformGroup(viewTransformGroup);
        branchGroup.addChild(behavior);
        behavior.setSchedulingBounds(boundingSphere);*/
    }

    public static void main(String[] args) {
        JFrame frame = new My3DTest();
        
        
    }
}
