package main.game.Model;

import com.badlogic.gdx.math.Rectangle;

public class App {
    private final Player player;
    private final Map map;
    private final CollisionSystem collisionSystem;

    public App() {
        this.player = new Player(new Rectangle(0, 0, 20, 30), 0, 0);
        this.map = new Map();
        this.collisionSystem = new CollisionSystem(map);
    }
}
