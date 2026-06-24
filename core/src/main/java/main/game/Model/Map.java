package main.game.Model;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class Map {
    private final TiledMap tileMap;
    private final TmxMapLoader mapLoader;
    private final OrthogonalTiledMapRenderer renderer;

    public Map() {
        mapLoader = new TmxMapLoader();
        tileMap = mapLoader.load("untitled.tmx");
        renderer = new OrthogonalTiledMapRenderer(tileMap);
    }

    public TiledMap getTileMap() {
        return tileMap;
    }

    public TmxMapLoader getMapLoader() {
        return mapLoader;
    }

    public OrthogonalTiledMapRenderer getRenderer() {
        return renderer;
    }

    public MapLayer getCollisionLayer() {
        return tileMap.getLayers().get("CollisionLayer");
    }
    public MapLayer getTileLayer() {
        return tileMap.getLayers().get("TileLayer");
    }
    public MapLayer getSpawnLayer() {
        return tileMap.getLayers().get("SpawnLayer");
    }
}
