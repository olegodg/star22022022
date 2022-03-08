package com.star.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Asteroid {
    private Texture texture;
    private Vector2 position;
    private Vector2 lastDisplacement;
    private float angleA;

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getLastDisplacement() {
        return lastDisplacement;
    }

    public float getAngle() {
        return angleA;
    }

    public Asteroid() {
        this.texture = new Texture("asteroid.png");
        this.position = new Vector2(128, 128);
        this.lastDisplacement = new Vector2(0, 0);
        this.angleA = 65.0f;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x - 128, position.y - 128, 128, 128,
                256, 256, 1, 1, angleA, 0, 0, 256, 256,
                false, false);
    }

    public void update(float dt) {
        position.x += MathUtils.cosDeg(angleA) * 300f * dt;
        position.y += MathUtils.sinDeg(angleA) * 300f * dt;

        checkBorders();
    }

    public void checkBorders() {
        if (position.y > ScreenManager.SCREEN_HEIGHT + 128) {
            position.y = 128;
        }
        if (angleA < 90 && position.x > ScreenManager.SCREEN_WIDTH + 128) {
            angleA = 180 - angleA;
        }
        if (angleA > 90 && position.x < -128) {
            angleA = -(angleA-180);
        }
    }
}



