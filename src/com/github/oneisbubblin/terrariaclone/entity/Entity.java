package com.github.oneisbubblin.terrariaclone.entity;

import com.github.oneisbubblin.terrariaclone.ui.Renderable;
import com.github.oneisbubblin.terrariaclone.world.Locatable;
import com.github.oneisbubblin.terrariaclone.world.Location;

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
}
