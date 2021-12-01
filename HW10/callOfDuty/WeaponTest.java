package callOfDuty;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeaponTest {

    Base base;
    Missile mis;
    RocketLauncher rl;

    @BeforeEach
    void setUp() throws Exception {

        base = new Base();
        
        mis = new Missile();
        rl = new RocketLauncher();
    }

    @Test
    void testWeapon() {
        assertEquals(3, mis.getShotLeft());

        // TODO: add more cases
        assertEquals(20,rl.getShotLeft());
        rl.shootAt(0, 0, base);
        assertEquals(19,rl.getShotLeft());
        rl.shootAt(4, 5, base);
        assertEquals(18,rl.getShotLeft());
        mis.shootAt(0, 0, base);
        assertEquals(2, mis.getShotLeft());
        mis.shootAt(5, 5, base);
        assertEquals(1, mis.getShotLeft());
        mis.shootAt(9, 9, base);
        assertEquals(0, mis.getShotLeft());
        mis.shootAt(0, 0, base);
        assertEquals(0, mis.getShotLeft());
    }

    @Test
    void testGetWeaponType() {
        assertEquals("missile", mis.getWeaponType().toLowerCase());

        // TODO: add more cases
        assertEquals("rocketLauncher", rl.getWeaponType());
    }

    
    @Test
    void testGetShotLeft() {
        mis.shootAt(0, 0, this.base);
        assertEquals(2, mis.getShotLeft());

        // TODO: add more cases
        assertEquals(20,rl.getShotLeft());
        rl.shootAt(0, 0,base);
        assertEquals(19,rl.getShotLeft());   
        rl.shootAt(2, 3,base);
        assertEquals(18,rl.getShotLeft());
        mis.shootAt(5, 8,base);
        assertEquals(1, mis.getShotLeft()); 
        mis.shootAt(12, 12,base);
        assertEquals(1, mis.getShotLeft()); 
    }

    @Test
    void testDecrementShotleft() {
        mis.decrementShotLeft();
        assertEquals(2, mis.getShotLeft());

        // TODO: add more cases
        rl.decrementShotLeft();
        assertEquals(19,rl.getShotLeft());
    }

    @Test
    void testShootAt() {
        mis.shootAt(0, 0, this.base);
        assertTrue(base.getTargetsArray()[0][0].isHitAt(0, 0));
        assertTrue(base.getTargetsArray()[1][0].isHitAt(1, 0));
        assertEquals(1, base.getShotsCount());
        // TODO: add more cases 
        mis.shootAt(5, 5, this.base);
        assertTrue(base.getTargetsArray()[4][4].isHitAt(4, 4));
        assertTrue(base.getTargetsArray()[6][6].isHitAt(6, 6));
        assertEquals(2, base.getShotsCount());    
        rl.shootAt(9, 9, this.base);
        assertTrue(base.getTargetsArray()[9][9].isHitAt(9, 9));
        assertEquals(3, base.getShotsCount());
        
    }

}
