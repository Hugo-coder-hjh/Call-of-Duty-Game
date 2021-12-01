package callOfDuty;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TargetTest {

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
    void testTarget() {

        // Armory
        assertEquals(2, armory.getHit().length);
        assertEquals(3, armory.getHit()[0].length);

        // Barrack
        assertEquals(1, barrack.getHit().length);
        assertEquals(3, barrack.getHit()[0].length);
        
        // sentry tower
        assertEquals(1, st.getHit().length);
        assertEquals(1, st.getHit()[0].length);
        
        // tank
        assertEquals(1, tank.getHit().length);
        assertEquals(1, tank.getHit()[0].length);

        // oil drum
        assertEquals(1, od.getHit().length);
        assertEquals(1, od.getHit()[0].length);      
        
    }

    
    @Test
    void testToString() {
        assertEquals("O", st.toString());
        assertEquals("T", tank.toString());
        
        // armory before shot
        assertEquals("O", armory.toString());
        armory.getShot(0, 0);
        // armory not destroyed
        assertEquals("O", armory.toString());
        
        // oil drum before shot
        assertEquals("O", od.toString());
        od.getShot(2, 1);
        // oil drum after get shot
        assertEquals("X", od.toString());
        
        // ground
        Target ground = new Ground(base);
        base.placeTargetAt(ground, 6, 6, false);
        ground.getShot(6, 6);
        assertEquals("-", ground.toString());
      
     
        
    }

    
    @Test
    void testGetTargetName() {
        assertEquals("tank", tank.getTargetName().toLowerCase());
        assertEquals("sentrytower", st.getTargetName().toLowerCase());
        assertEquals("oildrum", od.getTargetName().toLowerCase());
        
        // armory
        assertEquals("armory", armory.getTargetName().toLowerCase());
        // ground
        Target ground = new Ground(base);
        base.placeTargetAt(ground, 6, 6, false);
        assertEquals("ground", ground.getTargetName().toLowerCase());
 
    }

    @Test
    void testExplode() {
        assertFalse(armory.isDestroyed());
        od.explode();
        assertTrue(armory.isDestroyed());
        
        // the explosion of oil drum can trigger the explosion of the armory
        // but the explosion can not destroy that barrack at (0, 4)
        assertFalse(barrack.isDestroyed());
        
        // place a tank at (8, 8), place a sentry tower at (8,9), and a oil drum at (9,0)
        Target tank = new Tank(base);
        base.placeTargetAt(tank, 8, 8, false);
        Target sentryTow = new SentryTower(base);
        base.placeTargetAt(sentryTow, 8, 9, false);
        Target oilDr = new OilDrum(base);
        base.placeTargetAt(oilDr, 9, 0, false);
        tank.explode();
        // sentry tower will get destroyed
        assertTrue(sentryTow.isDestroyed());
        // oil drum will not get destroyed
        assertFalse(oilDr.isDestroyed());          
    }


    @Test
    void testGetShot() {
        Target am = new Armory(this.base);
        assertTrue(this.base.okToPlaceTargetAt(am, 5, 5, false));
        this.base.placeTargetAt(am, 5, 5, false);
        am.getShot(5, 6);
        assertEquals(1, am.getHit()[0][1]);
              
        // shot at the oil drum placed at (2, 1)
        od.getShot(2, 1);
        assertEquals(1, od.getHit()[0][0]);
        
        // shot at the barrack
        barrack.getShot(0, 4);
        // [0][0] will mark as 1, [0][2] will not mark the shot 
        assertEquals(0, barrack.getHit()[0][2]);
        
    }

 
    
    @Test
    void testIsDestroyed() {
        assertFalse(od.isDestroyed());
        od.getShot(2, 1);
        assertTrue(od.isDestroyed());
        assertTrue(tank.isDestroyed());

        // the armory will get destroyed after shoot at the oil drum
        assertTrue(armory.isDestroyed());
        
        // the barrack will not get destroyed
        assertFalse(barrack.isDestroyed());

    }

    
    @Test
    void testIsHitAt() {
        Target am = new Armory(this.base);
        assertTrue(this.base.okToPlaceTargetAt(am, 5, 5, false));
        this.base.placeTargetAt(am, 5, 5, true);
        assertFalse(am.isHitAt(5, 5));
        am.getShot(5, 5);
        assertTrue(am.isHitAt(5, 5));

        // shoot at the armory
        assertFalse(armory.isHitAt(0, 0));
        armory.getShot(0, 0);
        assertTrue(armory.isHitAt(0, 0));
        
        // shoot at the armory, get the status of oil drum
        assertFalse(od.isHitAt(2, 1));
        
    }

}