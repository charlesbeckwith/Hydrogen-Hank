/**
 * 
 */
package com.hh.objects.powerups;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Area;

import com.hh.Game;
import com.hh.graphics.Animation;
import com.hh.graphics.ArtAssets;
import com.hh.graphics.SpriteSheet.spriteID;
import com.hh.objects.Powerup;
import com.hh.sound.SoundManager.SoundFile;

/**
 * COSC3550 Spring 2014
 * 
 * Created : Feb. 28, 2014 
 * Last Updated : Feb. 28, 2014 
 * Purpose: Defines a balloon pack powerup
 * 
 * @author Charlie Beckwith & Mark Schlottke
 */
public class BalloonPack extends Powerup
{
  private Animation animation;
  private ArtAssets art;

  /**
   * @param x
   * @param y
   * @param width
   * @param height
   * @param powerupType
   */
  public BalloonPack(float x, float y, int width, int height)
  {
    super(x, y, width, height, PowerupType.BalloonPack);
    art = Game.getArtAssets();
    initAnimation();
    VALUE = 20.0;
  }

  @Override
  public void tick()
  {
    animation.runAnimation();
  }

  @Override
  public void render(Graphics g)
  {
    Graphics2D g2d = (Graphics2D) g.create();
    g2d.drawImage(animation.getAnimationFrame(), (int) center.getX(), (int) center.getY(),
        (int) width, (int) height, null);
    g2d.dispose();
    super.render(g);
  }

  @Override
  public Area boundingBox()
  {
    return new Area(super.boundingBox());
  }

  private void initAnimation()
  {
    animation = new Animation(3, art.getSpriteFrame(spriteID.BALLOONPACK, 0), art.getSpriteFrame(
        spriteID.BALLOONPACK, 1), art.getSpriteFrame(spriteID.BALLOONPACK, 2), art.getSpriteFrame(
        spriteID.BALLOONPACK, 3), art.getSpriteFrame(spriteID.BALLOONPACK, 4), art.getSpriteFrame(
        spriteID.BALLOONPACK, 5), art.getSpriteFrame(spriteID.BALLOONPACK, 6));
  }

  @Override
  public double getValue()
  {
    return VALUE;
  }

  @Override
  public void kill()
  {
    super.kill();
    Game.soundManager.playAudioClip(SoundFile.tank);
  }
}
