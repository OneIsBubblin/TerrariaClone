package com.github.oneisbubblin.terrariaclone.ui;

import com.github.oneisbubblin.terrariaclone.world.Location;

import static com.github.oneisbubblin.terrariaclone.TerrariaClone.INSTANCE;

public final class ScreenLocation
{
    public final int x;
    public final int y;

    public ScreenLocation(final int x, final int y)
    {
        this.x = x;
        this.y = y;
    }

    public ScreenLocation(final Location location)
    {
        final Location playerLocation = INSTANCE.getPlayer().getLocation();
        this.x = (int) (location.getX() - playerLocation.getX()) + INSTANCE.halfWidth;
        this.y = (int) (location.getY() - playerLocation.getY()) + INSTANCE.halfHeight;
    }
}
