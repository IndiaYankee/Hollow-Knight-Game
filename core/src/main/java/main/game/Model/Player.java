package main.game.Model;

import com.badlogic.gdx.math.Rectangle;

public class Player {
    private static final float GRAVITY = 900f;

    private float x;
    private float y;
    private float xVelocity;
    private float yVelocity;
    private final Rectangle playerHitBox;
    private boolean isOnGround;
    private int jumpCount;
    private PlayerDirection direction;
    private PlayerState state;

    public Player(Rectangle playerHitBox, float yVelocity, float xVelocity) {
        this.playerHitBox = playerHitBox;
        this.yVelocity = yVelocity;
        this.xVelocity = xVelocity;
        this.y = playerHitBox.y;
        this.x = playerHitBox.x;
        this.jumpCount = 0;
        this.direction = PlayerDirection.RIGHT;
        this.state = PlayerState.IDLE;
    }

    public void update(float delta) {
        yVelocity -= GRAVITY * delta;

        playerHitBox.x += xVelocity * delta;
        playerHitBox.y += yVelocity * delta;

        this.x = playerHitBox.getX();
        this.y = playerHitBox.getY();
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

    public void setOnGround(boolean onGround) {
        isOnGround = onGround;
    }

    public void setJumpCount(int jumpCount) {
        this.jumpCount = jumpCount;
    }

    public void setDirection(PlayerDirection direction) {
        this.direction = direction;
    }

    public void setState(PlayerState state) {
        this.state = state;
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

    public boolean isOnGround() {
        return isOnGround;
    }

    public int getJumpCount() {
        return jumpCount;
    }

    public PlayerDirection getDirection() {
        return direction;
    }

    public PlayerState getState() {
        return state;
    }
}
