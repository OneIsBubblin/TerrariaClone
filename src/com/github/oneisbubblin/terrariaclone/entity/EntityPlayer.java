package com.github.oneisbubblin.terrariaclone.entity;

import com.github.oneisbubblin.terrariaclone.Direction;
import com.github.oneisbubblin.terrariaclone.Directionable;
import com.github.oneisbubblin.terrariaclone.ui.Texture;
import com.github.oneisbubblin.terrariaclone.world.Location;

public final class EntityPlayer extends Entity implements Directionable
{
    private static final Texture[] PLAYER_TEXTURES = {Texture.PLAYER_LEFT_JUMP , Texture.PLAYER_LEFT_STILL , Texture.PLAYER_LEFT_WALK ,
                                                      Texture.PLAYER_RIGHT_JUMP, Texture.PLAYER_RIGHT_STILL, Texture.PLAYER_RIGHT_WALK};

    private Direction direction;

    public EntityPlayer(final Location location)
    {
        super(EntityType.PLAYER, location);
        this.direction = Direction.RIGHT;
    }

    @Override
    public Direction getDirection()
    {
        return direction;
    }

    @Override
    public Texture getTexture()
    {
        return direction == Direction.RIGHT ? PLAYER_TEXTURES[4] : PLAYER_TEXTURES[1];
    }

    @Override
    public void setDirection(final Direction direction)
    {
        this.direction = direction;
    }
}
