package callOfDuty;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseTest {

    Base base;
    Armory armory;
    Barrack barrack;
    SentryTower st;
    Tank tank;
    OilDrum od;

    @BeforeEach
    void setUp() throws Exception {

        base = new Base();

        armory = new Armory(base);
        base.placeTargetAt(armory, 0, 0, true);

        barrack = new Barrack(base);
        base.placeTargetAt(barrack, 0, 4, true);

        st = new SentryTower(base);
        base.placeTargetAt(st, 2, 4, true);

        tank = new Tank(base);
        base.placeTargetAt(tank, 1, 3, true);

        od = new OilDrum(base);
        base.placeTargetAt(od, 2, 1, true);
    }

    @Test
    void testBase() {
        assertEquals(10, base.getTargetsArray().length);

        // the size of the base
        assertEquals(10, base.getTargetsArray()[0].length);
        //the placed armory
        assertEquals("Armory", base.getTargetsArray()[0][0].getTargetName());
        // the placed barrack
        assertEquals("Barrack", base.getTargetsArray()[0][4].getTargetName());
        // the placed sentry tower
        assertEquals("SentryTower", base.getTargetsArray()[2][4].getTargetName());
        // the placed tank
        assertEquals("Tank", base.getTargetsArray()[1][3].getTargetName());
        // the placed oil drum
        assertEquals("OilDrum", base.getTargetsArray()[2][1].getTargetName());
    }

    @Test
    void testPlaceAllTargetRandomly() {
        this.base = new Base();
        base.placeAllTargetRandomly();
        List<Target> list = new ArrayList<Target>();
        int headQuarterCount = 0;
        int armoryCount = 0;
        int barracksCount = 0;
        int sentryCount = 0;
        int tanksCount = 0;
        int odCount = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (base.getTargetsArray()[i][j].getTargetName() != "ground") {
                    if (!list.contains(base.getTargetsArray()[i][j])) {
                        list.add(base.getTargetsArray()[i][j]);
                        switch (base.getTargetsArray()[i][j].getTargetName().toLowerCase()) {
                        case "armory": {
                            armoryCount++;
                            break;
                        }
                        case "headquarter": {
                            headQuarterCount++;
                            break;
                        }
                        case "barrack": {
                            barracksCount++;
                            break;
                        }
                        case "sentrytower": {
                            sentryCount++;
                            break;
                        }
                        case "tank": {
                            tanksCount++;
                            break;
                        }
                        case "oildrum": {
                            odCount++;
                            break;
                        }
                        }
                    }
                }
            }
        }
        assertEquals(list.size(), 18);

        assertEquals(1, headQuarterCount);
        assertEquals(2, armoryCount);
        assertEquals(3, barracksCount);
        assertEquals(4, sentryCount);
        assertEquals(4, tanksCount);
        assertEquals(4, odCount);
    }

    
    @Test
    void testOkToPlaceTargetAt() {
        assertFalse(this.base.okToPlaceTargetAt(new Armory(this.base), 1, 7, false));
        assertFalse(this.base.okToPlaceTargetAt(new Armory(this.base), 1, 8, true));
        assertTrue(this.base.okToPlaceTargetAt(new Armory(this.base), 1, 8, false));

        // it is OK to place a tank at coordinate of (0, 3)
        assertTrue(this.base.okToPlaceTargetAt(new Tank(this.base), 0, 3, false));
        // it is not OK to place a Sentry Tower at (0,3)
        assertFalse(this.base.okToPlaceTargetAt(new SentryTower(this.base), 0, 3, false));
        // it is OK to place an vertical armory at (4, 4)
        assertTrue(this.base.okToPlaceTargetAt(new Armory(this.base), 4, 4, false));
       
    }
    
    

    @Test
    void testPlaceTargetAt() {
        Target armory = new Armory(base);
        this.base.placeTargetAt(armory, 5, 5, false);
        assertEquals(5, armory.getCoordinate()[0]);
        assertEquals(5, armory.getCoordinate()[1]);
        assertEquals(3, armory.getHit().length);
        assertEquals(2, armory.getHit()[0].length);
        
        // place a tank at (0,4)
        Target tank = new Tank(base);
        this.base.placeTargetAt(tank, 0, 4, false);
        assertEquals(0, tank.getCoordinate()[0]);
        assertEquals(4, tank.getCoordinate()[1]);
        assertEquals(1, tank.getHit().length);
        assertEquals(1, tank.getHit()[0].length);
        
        // place a barrack at (4,4)
        Target barrack = new Barrack(base);
        this.base.placeTargetAt(barrack, 4, 4, true);
        assertEquals(4, barrack.getCoordinate()[0]);
        assertEquals(4, barrack.getCoordinate()[1]);
        assertEquals(1, barrack.getHit().length);
        assertEquals(3, barrack.getHit()[0].length);
        
        // place a oil drum at (9,9)
        Target oildrum = new OilDrum(base);
        this.base.placeTargetAt(oildrum, 9, 9, false);
        assertEquals(9, oildrum.getCoordinate()[0]);
        assertEquals(9, oildrum.getCoordinate()[1]);
        assertEquals(1, oildrum.getHit().length);
        assertEquals(1, oildrum.getHit()[0].length);
  
        
    }
    
    
    @Test
    void testIsOccupied() {

        Armory arm = new Armory(base);
        this.base.placeTargetAt(arm, 0, 0, true);
        assertTrue(base.isOccupied(0, 0));

        // place a tank at (0,4)
        Target tank = new Tank(base);
        this.base.placeTargetAt(tank, 0, 4, false);
        assertTrue(base.isOccupied(0, 4));
        
        // place a barrack at (4,4)
        Target barrack = new Barrack(base);
        this.base.placeTargetAt(barrack, 4, 4, true);
        assertTrue(base.isOccupied(4, 4));
        
        // place a oil drum
        Target oildrum = new OilDrum(base);
        this.base.placeTargetAt(oildrum, 9, 9, false);
        assertTrue(base.isOccupied(9, 9));
        
    }

    @Test
    void testShootAt() {

        Armory arm = new Armory(base);
        this.base.placeTargetAt(arm, 5, 5, true);

        base.shootAt(5, 5);
        assertTrue(arm.isHitAt(5, 5));

        // place a tank at (0,4) and hit
        Target tank = new Tank(base);
        this.base.placeTargetAt(tank, 0, 4, false);
        base.shootAt(0, 4);
        assertTrue(tank.isHitAt(0, 4));
        
        // place a barrack at (4,4) and not shot
        Target barrack = new Barrack(base);
        this.base.placeTargetAt(barrack, 4, 4, true);
        assertFalse(barrack.isHitAt(4, 4));
        
        // place a oil drum and shoot elsewhere
        Target oildrum = new OilDrum(base);
        this.base.placeTargetAt(oildrum, 9, 9, false);
        base.shootAt(0, 0);
        assertFalse(oildrum.isHitAt(9, 9));
    
    }

    @Test
    void testIsGameOver() {

        assertFalse(base.isGameOver(new RocketLauncher(), new Missile()));

        // TODO: add more cases
        // create two weapon
        RocketLauncher weapon1= new RocketLauncher();
        Missile weapon2 = new Missile();
    
        // put a tower and destroy it, check whether game-over
            SentryTower tower = new SentryTower(base);
            base.placeTargetAt(tower, 1, 1, true);
            assertFalse(base.win());
            base.shootAt(1, 1);
            assertTrue(base.win());
            assertTrue(base.isGameOver(weapon1, weapon2));
            base.placeAllTargetRandomly();
            assertFalse(base.isGameOver(new RocketLauncher(), new Missile()));
            
    }

    @Test
    void testWin() {
        assertFalse(this.base.win());

        // shot at the oil drum
        od.getShot(2, 1);
        barrack.getShot(0, 5);
        barrack.getShot(0, 6);    
        assertTrue(this.base.win());
    }
    
    @Test
    void testIncrementAndSetShotsCount() {

        assertEquals(0, base.getShotsCount());
        base.incrementShotsCount();
        assertEquals(1, base.getShotsCount());

        // TODO: add more cases
        Weapon rl = new RocketLauncher();
        Weapon ml = new Missile();
        rl.shootAt(1, 1, base);
        assertEquals(2,base.getShotsCount());
        ml.shootAt(1, 1, base);
        assertEquals(3,base.getShotsCount());
    }

    @Test
    void testSetAndGetDestroyedTargetCount() {
        base.setDestroyedTargetCount(10);
        assertEquals(10, base.getDestroyedTargetCount());

        // TODO: add more cases
        base.setDestroyedTargetCount(0);
        assertEquals(0, base.getDestroyedTargetCount());
    }

    @Test
    void testGetDestroyedTargetCount() {
        
        assertEquals(0, base.getDestroyedTargetCount());
                
        // TODO: add more cases
        // destroy the tower, and count + 1
        SentryTower tower = new SentryTower(base);
        base.placeTargetAt(tower, 1, 1, true);
        base.shootAt(1, 1);
        assertEquals(1, base.getDestroyedTargetCount());
        // shoot at the tank but not destroyed, so count does not change
        Tank tank = new Tank(base);
        base.placeTargetAt(tank, 1, 1, true);
        base.shootAt(1, 1);
        assertEquals(1, base.getDestroyedTargetCount());
        
        
    }


    @Test
    void testGetTargetsArray() {
        assertEquals(10, base.getTargetsArray().length);

        // TODO: add more cases
        assertEquals(10, base.getTargetsArray()[0].length);
    }


}
