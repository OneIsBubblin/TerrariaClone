package com.github.oneisbubblin.terrariaclone.world;

import com.github.oneisbubblin.terrariaclone.ui.ScreenLocation;

import static com.github.oneisbubblin.terrariaclone.TerrariaClone.INSTANCE;

public class Location
{
    private double x;
    private double y;

    public Location(final double x, final double y)
    {
        this.x = x;
        this.y = y;
    }

    public Location(final ScreenLocation screenLocation)
    {
        final Location playerLocation = INSTANCE.getPlayer().getLocation();
        this.x = (int) (screenLocation.x + playerLocation.getX()) - INSTANCE.halfWidth;
        this.y = (int) (screenLocation.y + playerLocation.getY()) - INSTANCE.halfHeight;
    }

    public Location add(final double x, final double y)
    {
        this.x += x;
        this.y += y;
        return this;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public Location setX(final double x)
    {
        this.x = x;
        return this;
    }

    public Location setY(final double y)
    {
        this.y = y;
        return this;
    }

    public Location subtract(final double x, final double y)
    {
        this.x -= x;
        this.y -= y;
        return this;
    }
}
