package main.game.Control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import main.game.Model.Player;

public class PlayerController {
    private final Player player;

    public PlayerController(Player player) {
        this.player = player;
    }

    public void movePlayer() {
        float xSpeed = 200;
        float jumpSpeed = 2 * xSpeed;

        player.setxVelocity(0);
        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            player.setxVelocity(xSpeed);
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.A)) {
            player.setxVelocity(-xSpeed);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE) && player.isOnGround()) {
            player.setyVelocity(jumpSpeed);
            player.setOnGround(false);
        }
    }
}
