package main.game.View;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class PlayerAnimations {
    private final TextureAtlas atlas = new TextureAtlas("PlayerAnimations/Idle/idle.atlas");
    Array<Animation<TextureRegion>> animations = new Array<>();
    public Animation<TextureRegion> runAnimation = new Animation<>(0.1f, atlas.findRegions("Idle"), Animation.PlayMode.LOOP);
}


