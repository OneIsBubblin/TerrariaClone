package com.github.oneisbubblin.terrariaclone.ui;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public enum Texture
{
    PLAYER_LEFT_JUMP  ("/sprites/player/left_jump.png"             ),
    PLAYER_LEFT_STILL ("/sprites/player/left_still.png"            ),
    PLAYER_LEFT_WALK  ("/sprites/player/left_walk.png"             ),
    PLAYER_RIGHT_JUMP ("/sprites/player/right_jump.png"            ),
    PLAYER_RIGHT_STILL("/sprites/player/right_still.png"           ),
    PLAYER_RIGHT_WALK ("/sprites/player/right_walk.png"            ),
    SHOOTING_STAR     ("/sprites/monsters/shooting_star/normal.png");

    public final Image image;

    Texture(final String pathToTexture)
    {
        Image image;
        try
        {
            image = ImageIO.read(getClass().getResource(pathToTexture));
            image = image.getScaledInstance(image.getWidth(null) * 2, image.getHeight(null) * 2, Image.SCALE_DEFAULT);
        }
        catch(final IOException exception)
        {
            System.out.println("Unable to load texture \"" + pathToTexture + "\"");
            image = null;
        }
        this.image = image;
    }
}
