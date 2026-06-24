package main.game.Control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import main.game.Model.PlayerDirection;
import main.game.Model.Player;
import main.game.Model.PlayerState;

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
            player.setState(PlayerState.RUN);
            player.setDirection(PlayerDirection.RIGHT);
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.A)) {
            player.setxVelocity(-xSpeed);
            player.setState(PlayerState.RUN);
            player.setDirection(PlayerDirection.LEFT);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && player.getJumpCount() < 1) {
            if (!player.isOnGround()) player.setJumpCount(player.getJumpCount() + 1);
            player.setyVelocity(jumpSpeed);
            player.setOnGround(false);
        }
        if(player.getyVelocity() > 0 && !Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            player.setyVelocity(player.getyVelocity() * 0.5f);
        }
    }
}
