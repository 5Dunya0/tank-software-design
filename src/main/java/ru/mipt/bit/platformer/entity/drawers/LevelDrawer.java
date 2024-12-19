package ru.mipt.bit.platformer.entity.drawers;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.MapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Interpolation;

<<<<<<< HEAD
import ru.mipt.bit.platformer.entity.objects.*;
import ru.mipt.bit.platformer.entity.objects.base.AbstractMovableLevelObject;
import ru.mipt.bit.platformer.entity.objects.base.AbstractUnmovableLevelObject;
import ru.mipt.bit.platformer.util.TileMovement;

import java.util.HashMap;
import java.util.Map;
=======
import ru.mipt.bit.platformer.entity.tree.Tree;
import ru.mipt.bit.platformer.entity.tank.Tank;
import ru.mipt.bit.platformer.entity.level.Level;
import ru.mipt.bit.platformer.util.TileMovement;

import java.util.ArrayList;
import java.util.List;
>>>>>>> 4fe93b7764387c3a3f40158528b2cb4ed6ee3efe

import static ru.mipt.bit.platformer.util.GdxGameUtils.*;

public class LevelDrawer implements GraphicObject {

    private Batch batch;
    private String filePath;
    private TiledMap map;
    private MapRenderer renderer;
    private TiledMapTileLayer groundLayer;
    private TileMovement tileMovement;
    private Level level;
<<<<<<< HEAD
    private final HashMap<AbstractMovableLevelObject, LevelObjectDrawer> movableDrawers = new HashMap<>();
    private final HashMap<AbstractUnmovableLevelObject, LevelObjectDrawer> unmovableDrawers = new HashMap<>();
=======
    private LevelObjectDrawer tankDrawer;
    private final List<LevelObjectDrawer> treesDrawer = new ArrayList<LevelObjectDrawer>();
>>>>>>> 4fe93b7764387c3a3f40158528b2cb4ed6ee3efe


    public LevelDrawer(String filePath, Batch batch, Level level) {
        this.filePath = filePath;
        this.batch = batch;
        this.level = level;
    }

    public void draw() {
        drawLevel();
<<<<<<< HEAD
        drawMovable();
        drawUnmovable();
=======
        drawTank();
        drawTrees();
>>>>>>> 4fe93b7764387c3a3f40158528b2cb4ed6ee3efe
    }

    public void drawLevel() {
        this.map = new TmxMapLoader().load(this.filePath);
        this.renderer = createSingleLayerMapRenderer(this.map, this.batch);
        this.groundLayer = getSingleLayer(this.map);
        this.tileMovement = new TileMovement(this.groundLayer, Interpolation.smooth);
    }

<<<<<<< HEAD
    public void drawMovable() {
        for (AbstractMovableLevelObject obj : level.getMovable()) {
            LevelObjectDrawer tankDrawerObject = new LevelObjectDrawer("images/blueTank.png");
            movableDrawers.put(obj, tankDrawerObject);
            tankDrawerObject.draw();
        }
    }

    public void drawUnmovable() {
        for (AbstractUnmovableLevelObject obj : level.getUnmovable()) {
            LevelObjectDrawer treeDrawerObject = new LevelObjectDrawer("images/greenTree.png");
            unmovableDrawers.put(obj, treeDrawerObject);
            treeDrawerObject.draw();
            moveRectangleAtTileCenter(groundLayer, treeDrawerObject.getRectangle(), obj.getCoordinates());
=======
    public void drawTank() {
        tankDrawer = new LevelObjectDrawer("images/tank_blue.png");
        tankDrawer.draw();
    }

    public void drawTrees() {
        for (Tree tree : level.getTress()) {
            LevelObjectDrawer treeDrawerObject = new LevelObjectDrawer("images/greenTree.png");
            treesDrawer.add(treeDrawerObject);
            treeDrawerObject.draw();
            moveRectangleAtTileCenter(groundLayer, treeDrawerObject.getRectangle(), tree.getCoordinates());
>>>>>>> 4fe93b7764387c3a3f40158528b2cb4ed6ee3efe
        }
    }

    public void renderMoves(float deltaTime) {
<<<<<<< HEAD
        float movementSpeed = 0.4f;
        for (Map.Entry<AbstractMovableLevelObject, LevelObjectDrawer> entry : movableDrawers.entrySet()) {
            LevelObjectDrawer drawer = entry.getValue();
            AbstractMovableLevelObject movableObject = entry.getKey();
            tileMovement.moveRectangleBetweenTileCenters(drawer.getRectangle(), movableObject.getCoordinates(), movableObject.getDestinationCoordinates(), movableObject.getMovementProgress());
            movableObject.updateState(deltaTime, movementSpeed);
        }
        renderer.render();
    }

    private void renderMovableObjects() {
        for (Map.Entry<AbstractMovableLevelObject, LevelObjectDrawer> entry : movableDrawers.entrySet()) {
            LevelObjectDrawer drawer = entry.getValue();
            AbstractMovableLevelObject movableObject = entry.getKey();
            drawTextureRegionUnscaled(batch, drawer.getGraphics(), drawer.getRectangle(), movableObject.getRotation());
        }
    }

    private void renderUnmovableObjects() {
        for (Map.Entry<AbstractUnmovableLevelObject, LevelObjectDrawer> entry : unmovableDrawers.entrySet()) {
            LevelObjectDrawer drawer = entry.getValue();
            drawTextureRegionUnscaled(batch, drawer.getGraphics(), drawer.getRectangle(), 0f);
        }
    }

    public void renderObjects() {
        renderMovableObjects();
        renderUnmovableObjects();
    }

    public void recordDrawCommand() {
        batch.begin();
        renderObjects();
=======
        Tank tank = level.getTank();
        tileMovement.moveRectangleBetweenTileCenters(tankDrawer.getRectangle(), tank.getCoordinates(), tank.getDestinationCoordinates(), tank.getMovementProgress());
        tank.updateState(deltaTime);

        renderer.render();
    }

    public void renderObjects() {
        Tank tank = level.getTank();
        drawTextureRegionUnscaled(batch, tankDrawer.getGraphics(), tankDrawer.getRectangle(), tank.getRotation());
        for (LevelObjectDrawer treeDrawer : treesDrawer) {
            drawTextureRegionUnscaled(batch, treeDrawer.getGraphics(), treeDrawer.getRectangle(), 0f);
        }
    }

    public void recordDrawCommand() {
        // start recording all drawing commands
        batch.begin();
        renderObjects();
        // submit all drawing requests
>>>>>>> 4fe93b7764387c3a3f40158528b2cb4ed6ee3efe
        batch.end();
    }

    public void dispose() {
<<<<<<< HEAD
        for (LevelObjectDrawer drawer : movableDrawers.values()) {
            drawer.dispose();
        }

        for (LevelObjectDrawer drawer : unmovableDrawers.values()) {
            drawer.dispose();
        }

=======
        tankDrawer.dispose();
        for (LevelObjectDrawer treeDrawer : treesDrawer) {
            treeDrawer.dispose();
        }
>>>>>>> 4fe93b7764387c3a3f40158528b2cb4ed6ee3efe
        map.dispose();
        batch.dispose();
    }
}
