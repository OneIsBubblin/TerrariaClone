package com.github.oneisbubblin.terrariaclone;

import com.github.oneisbubblin.terrariaclone.entity.Entity;
import com.github.oneisbubblin.terrariaclone.entity.EntityPlayer;
import com.github.oneisbubblin.terrariaclone.entity.EntityShootingStar;
import com.github.oneisbubblin.terrariaclone.ui.ScreenLocation;
import com.github.oneisbubblin.terrariaclone.world.Location;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TerrariaClone extends JFrame implements KeyListener, MouseListener, Runnable
{
    public static final TerrariaClone INSTANCE = new TerrariaClone(800, 600);

    public static void main(final String[] args)
    {
        INSTANCE.run();
    }

    public final int width;
    public final int halfWidth;
    public final int height;
    public final int halfHeight;

    private boolean running;
    private int     fps;

    private final EntityPlayer         player   ;
    private final Set         <Entity> entitySet;

    private byte movement;

    public TerrariaClone(final int width, final int height)
    {
        this.width      = width;
        this.halfWidth  = width / 2;
        this.height     = height;
        this.halfHeight = height / 2;

        this.running = false;

        this.player    = new EntityPlayer(new Location(0, 0));
        this.entitySet = new HashSet<>();

        this.movement = 0;
    }

    public EntityPlayer getPlayer()
    {
        return player;
    }

    @Override
    public void keyTyped(final KeyEvent event) {}

    @Override
    public void keyPressed(final KeyEvent event)
    {
        switch(event.getKeyChar())
        {
            case 'w':
                movement |= 0b1;
                break;
            case 'a':
                movement |= 0b10;
                break;
            case 's':
                movement |= 0b100;
                break;
            case 'd':
                movement |= 0b1000;
                break;
        }
    }

    @Override
    public void keyReleased(final KeyEvent event)
    {
        switch(event.getKeyChar())
        {
            case 'w':
                movement &= ~0b1;
                break;
            case 'a':
                movement &= ~0b10;
                break;
            case 's':
                movement &= ~0b100;
                break;
            case 'd':
                movement &= ~0b1000;
                break;
        }
    }

    @Override
    public void mouseClicked(final MouseEvent event) {}

    @Override
    public synchronized void mousePressed(final MouseEvent event)
    {
        final Location location = new Location(new ScreenLocation(event.getX(), event.getY()));
        entitySet.add(new EntityShootingStar(location));
    }

    @Override
    public void mouseReleased(final MouseEvent event) {}

    @Override
    public void mouseEntered(final MouseEvent event) {}

    @Override
    public void mouseExited(final MouseEvent event) {}

    private void onTick()
    {
        final Location location = player.getLocation();
        location.add((((movement & 0b1000) == 0 ? 0 : 1) + ((movement & 0b10) == 0 ? 0 : -1)) * 3, (((movement & 0b100) == 0 ? 0 : 1) + ((movement & 0b1) == 0 ? 0 : -1)) * 3);
    }

    private synchronized Graphics onRender(final Graphics graphics)
    {
        for(final Entity entity : entitySet)
        {
            final Image          image    = entity.getTexture().image;
            final ScreenLocation position = new ScreenLocation(entity.getLocation());
            graphics.drawImage(image, position.x - image.getWidth(null) / 2, position.y - image.getHeight(null) / 2, null);
        }

        fps++;
        return graphics;
    }

    @Override
    public void run()
    {
        this.running = true;
        this.fps     = 0;

        entitySet.add(player);

        setTitle("TerrariaClone: Infinite worlds");
        setSize(width, height);
        setResizable(false);

        addMouseListener(this);
        addKeyListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        final long tickDelay     = 1000 / 20;
              long lastTick      = System.currentTimeMillis(),
                   lastFPSUpdate = lastTick,
                   currentTime;
        createBufferStrategy(2);
        final BufferStrategy bufferStrategy = getBufferStrategy();
        while(running)
        {
            currentTime = System.currentTimeMillis();
            if(currentTime - lastTick >= tickDelay)
            {
                onTick();
                lastTick = currentTime;
            }

            final Graphics graphics = bufferStrategy.getDrawGraphics();
            graphics.fillRect(0, 0, width, height);
            onRender(graphics).dispose();
            bufferStrategy.show();
            if(currentTime - lastFPSUpdate >= 1000)
            {
                setTitle("TerrariaClone: Infinite worlds (FPS: " + fps + ")");
                fps = 0;
                lastFPSUpdate = currentTime;
            }
        }
    }
}
