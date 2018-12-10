package com.github.oneisbubblin.terrariaclone.ui;

import com.github.oneisbubblin.terrariaclone.world.Locatable;
import com.github.oneisbubblin.terrariaclone.world.Location;

import static com.github.oneisbubblin.terrariaclone.TerrariaClone.INSTANCE;

public final class Camera implements Locatable
{
    private Location location;

    public Camera(final Location location)
    {
        this.location = location;
    }

    public Location getLocation()
    {
        return location;
    }

    public void setLocation(final Location location)
    {
        this.location = location;
    }

    public Location translate(final ScreenLocation fromLocation, final Location toLocation)
    {
        toLocation.x = (fromLocation.x + this.location.x) - INSTANCE.halfWidth;
        toLocation.y = (fromLocation.y + this.location.y) - INSTANCE.halfHeight;
        return toLocation;
    }

    public ScreenLocation translate(final Location fromLocation, final ScreenLocation toLocation)
    {
        toLocation.x = (int) (fromLocation.x - this.location.x) + INSTANCE.halfWidth;
        toLocation.y = (int) (fromLocation.y - this.location.y) + INSTANCE.halfHeight;
        return toLocation;
    }
}
