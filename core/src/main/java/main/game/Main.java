package main.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import main.game.*;
import main.game.Control.PlayerController;
import main.game.Model.App;
import main.game.Model.Player;

import com.badlogic.gdx.math.Rectangle;
import main.game.View.PlayerAnimations;

import static com.badlogic.gdx.Gdx.app;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    private App app;
    private ShapeRenderer shapeRenderer;
    private PlayerController playerController;
    private PlayerAnimations playerAnimations;
    float stateTime = 0;

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("libgdx.png");
        app = new App();
        shapeRenderer = new ShapeRenderer();
        app.getCollisionSystem().loadRectangles();
        playerController = new PlayerController(app.getPlayer());
        playerAnimations = new PlayerAnimations();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        float delta = Gdx.graphics.getDeltaTime();
        stateTime += delta;
        playerController.movePlayer();

        app.getPlayer().update(delta);

        app.getCollisionSystem().resolve(app.getPlayer());
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        for (Rectangle rectangle : app.getCollisionSystem().getRectangles()) {
            shapeRenderer.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        }
        Rectangle p = app.getPlayer().getPlayerHitBox();
        shapeRenderer.rect(p.x, p.y, p.width, p.height);
        shapeRenderer.end();
        TextureRegion frame = playerAnimations.runAnimation.getKeyFrame(stateTime);

        batch.begin();
        batch.draw(frame, app.getPlayer().getX(),  app.getPlayer().getY(), 48, 72);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
