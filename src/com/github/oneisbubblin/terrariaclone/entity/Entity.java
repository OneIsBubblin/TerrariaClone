package com.github.oneisbubblin.terrariaclone.entity;

import com.github.oneisbubblin.terrariaclone.ui.Camera;
import com.github.oneisbubblin.terrariaclone.ui.Renderable;
import com.github.oneisbubblin.terrariaclone.ui.ScreenLocation;
import com.github.oneisbubblin.terrariaclone.world.Locatable;
import com.github.oneisbubblin.terrariaclone.world.Location;

import java.awt.*;

public abstract class Entity implements Locatable, Renderable
{
    private final EntityType type;
    private final Location   location;

    Entity(final EntityType type, final Location location)
    {
        this.type     = type;
        this.location = location;
    }

    @Override
    public Location getLocation()
    {
        return location;
    }

    public EntityType getType()
    {
        return type;
    }

    @Override
    public void onRender(final Camera camera, final ScreenLocation location, final Graphics graphics)
    {
        final Image          image    = getTexture().image;
        final ScreenLocation position = camera.translate(this.location, location);
        graphics.drawImage(image, position.x - image.getWidth(null) / 2, position.y - image.getHeight(null) / 2, null);
    }
}
