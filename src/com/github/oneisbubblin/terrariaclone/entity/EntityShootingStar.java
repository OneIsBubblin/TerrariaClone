package com.github.oneisbubblin.terrariaclone.entity;

import com.github.oneisbubblin.terrariaclone.ui.Texture;
import com.github.oneisbubblin.terrariaclone.world.Location;

public class EntityShootingStar extends Entity
{
    public EntityShootingStar(final Location location)
    {
        super(EntityType.PLAYER, location);
    }

    @Override
    public Texture getTexture()
    {
        return Texture.SHOOTING_STAR;
    }
}
