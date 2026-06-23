package main.game.Model;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.math.Rectangle;

public class Player {
    private float x;
    private float y;
    private float xVelocity;
    private float yVelocity;
    private final Rectangle playerHitBox;

    public Player(Rectangle playerHitBox, float yVelocity, float xVelocity) {
        this.playerHitBox = playerHitBox;
        this.yVelocity = yVelocity;
        this.xVelocity = xVelocity;
        this.y = playerHitBox.y;
        this.x = playerHitBox.x;
    }

    public void update(float delta) {
        yVelocity -= 5f;

        x += xVelocity * delta;
        y += yVelocity * delta;

        playerHitBox.x = (int) x;
        playerHitBox.y = (int) y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setxVelocity(float xVelocity) {
        this.xVelocity = xVelocity;
    }

    public void setyVelocity(float yVelocity) {
        this.yVelocity = yVelocity;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getxVelocity() {
        return xVelocity;
    }

    public float getyVelocity() {
        return yVelocity;
    }

    public Rectangle getPlayerHitBox() {
        return playerHitBox;
    }
}
