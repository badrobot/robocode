package net.sf.robocode.battle.peer;

import javafx.scene.paint.Color;
import robocode.BattleRules;
import robocode.BulletHitEvent;
import robocode.HitByBulletEvent;
import robocode.Rules;
import robocode.control.snapshot.BulletState;

import java.util.List;

/**
 * Created by Steve on 03/05/2019.
 */
public class HealthPeer extends BulletPeer {


    public HealthPeer(RobotPeer owner, BattleRules battleRules, int bulletId) {
        super(owner, battleRules, bulletId);
        setStatic(true);
        color = 3;
        setPower(10);
    }

    @Override
    protected void checkRobotCollision(List<RobotPeer> robots) {
        for (RobotPeer otherRobot : robots) {
            if (!(otherRobot == null || otherRobot == owner || otherRobot.isDead())
                    && otherRobot.getBoundingBox().intersectsLine(boundingLine)) {

                state = BulletState.HIT_VICTIM;
                frame = 0;
                victim = otherRobot;

                double damage = Rules.getBulletDamage(power) * -1.0;


                double score = damage;
                if (score > otherRobot.getEnergy()) {
                    score = otherRobot.getEnergy();
                }
                otherRobot.updateEnergy(-damage);

                double newX, newY;

                if (otherRobot.getBoundingBox().contains(lastX, lastY)) {
                    newX = lastX;
                    newY = lastY;

                    setX(newX);
                    setY(newY);
                } else {
                    newX = x;
                    newY = y;
                }

                deltaX = newX - otherRobot.getX();
                deltaY = newY - otherRobot.getY();

                break;
            }
        };
    }
}
