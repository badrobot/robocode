package net.sf.robocode.battle.peer;

import net.sf.robocode.battle.Battle;
import net.sf.robocode.host.IHostManager;
import robocode.control.RobotSpecification;

/**
 * Created by Steve on 03/05/2019.
 */
public class SecretRobotPeer extends RobotPeer {

    public SecretRobotPeer(Battle battle, IHostManager hostManager, RobotSpecification robotSpecification, int duplicate, TeamPeer team, int robotIndex) {
        super(battle, hostManager, robotSpecification, duplicate, team, robotIndex);
    }
}
