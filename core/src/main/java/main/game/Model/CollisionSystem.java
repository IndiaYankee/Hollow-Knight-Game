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
        float xVelocity = player.getxVelocity();
        float yVelocity = player.getyVelocity();
        for (Rectangle rectangle: rectangles) {
            if(playerHitBox.overlaps(rectangle)) {
                // X axis
                if (xVelocity > 0) {
                    playerHitBox.x = rectangle.x - playerHitBox.width;
                }
                else if (xVelocity < 0) {
                    playerHitBox.x = rectangle.x + rectangle.width;
                }
                player.setxVelocity(0);
                break;
            }
        }
        player.setX(playerHitBox.x);
        for (Rectangle rectangle: rectangles) {
            if (playerHitBox.overlaps(rectangle)) {
                // Y axis
                if(yVelocity > 0) {
                    playerHitBox.y = rectangle.y - playerHitBox.height;
                }
                else if(yVelocity < 0) {
                    player.setOnGround(true);
                    playerHitBox.y = rectangle.y + rectangle.height;
                }
                player.setyVelocity(0);
                break;
            }
        }
        player.setY(playerHitBox.y);
    }
}
