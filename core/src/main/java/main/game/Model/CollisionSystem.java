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
        player.setOnGround(false);

        for (Rectangle rectangle : rectangles) {
            if (playerHitBox.overlaps(rectangle)) {

                float aCenterX = playerHitBox.x + playerHitBox.width / 2f;
                float aCenterY = playerHitBox.y + playerHitBox.height / 2f;
                float bCenterX = rectangle.x + rectangle.width / 2f;
                float bCenterY = rectangle.y + rectangle.height / 2f;

                float dx = aCenterX - bCenterX;
                float dy = aCenterY - bCenterY;

                float overlapX = (playerHitBox.width / 2f + rectangle.width / 2f) - Math.abs(dx);
                float overlapY = (playerHitBox.height / 2f + rectangle.height / 2f) - Math.abs(dy);

                if (overlapX < overlapY) {
                    if (dx > 0) {
                        playerHitBox.x = rectangle.x + rectangle.width;
                    } else {
                        playerHitBox.x = rectangle.x - playerHitBox.width;
                    }
                    player.setxVelocity(0);
                } else {
                    if (dy > 0) {
                        playerHitBox.y = rectangle.y + rectangle.height;
                        player.setJumpCount(0);
                        player.setOnGround(true);
                    } else {
                        playerHitBox.y = rectangle.y - playerHitBox.height;
                    }
                    player.setyVelocity(0);
                }
            }
        }
        player.setX(playerHitBox.x);
        player.setY(playerHitBox.y);
    }

    public Map getMap() {
        return map;
    }

    public ArrayList<Rectangle> getRectangles() {
        return rectangles;
    }
}
