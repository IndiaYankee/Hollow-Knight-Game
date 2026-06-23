package main.game.Model;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;

import com.badlogic.gdx.math.Rectangle;
import java.util.ArrayList;

public class CollisionSystem {
    private final Map map;
    private final ArrayList<Rectangle> rectangles;

    public CollisionSystem(Map map) {
        this.map = map;
        this.rectangles = new ArrayList<>();
    }

    public void loadRectangles() {
        rectangles.clear();
        for (MapObject mapObject: map.getCollisionLayer().getObjects()) {
            if(mapObject instanceof RectangleMapObject) {
                Rectangle rectangle = new Rectangle(((RectangleMapObject) mapObject).getRectangle());
                rectangles.add(rectangle);
            }
        }
    }

    public boolean isColliding(Rectangle playerHitBox) {
        for (Rectangle rectangle: rectangles) {
            if (playerHitBox.overlaps(rectangle)) return true;
        }
        return false;
    }

    public void resolve(Player player) {
        Rectangle playerHitBox = player.getPlayerHitBox();
        for (Rectangle rectangle: rectangles) {
            if(playerHitBox.overlaps(rectangle)) {
                if(playerHitBox.y < rectangle.y) {
                    player.setY(rectangle.y + rectangle.height);
                }
            }
        }
    }
}
