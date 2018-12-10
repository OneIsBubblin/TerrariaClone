package com.github.oneisbubblin.terrariaclone.ui;

import java.awt.*;

public interface Renderable
{
    Texture getTexture();

    void onRender(final Camera camera, final ScreenLocation location, final Graphics graphics);
}
