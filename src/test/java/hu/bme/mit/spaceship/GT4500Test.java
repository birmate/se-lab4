package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GT4500Test {

    private GT4500 ship;

    @BeforeEach
    public void init() {
        this.ship = new GT4500();
    }

    @Test
    void fireTorpedo_Single_Success() {
        // Arrange

        // Act
        boolean result = ship.fireTorpedo(FiringMode.SINGLE);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void fireTorpedo_All_Success() {
        // Arrange

        // Act
        boolean result = ship.fireTorpedo(FiringMode.ALL);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void fireLaser_Test() {
        boolean result = ship.fireLaser(FiringMode.SINGLE);
        assertEquals(false, result);
    }

    @Test
    void fireTorpedo_Single_Alternates() {
        ship.fireTorpedo(FiringMode.SINGLE);
        boolean result = ship.fireTorpedo(FiringMode.SINGLE);
        assertEquals(true, result);
    }

    @Test
    void fireTorpedo_Single_PrimaryEmpty_SecondaryFires() {
        GT4500 customShip = new GT4500(0, 0.0, 10, 0.0);
        boolean result = customShip.fireTorpedo(FiringMode.SINGLE);
        assertEquals(true, result);
    }

    @Test
    void fireTorpedo_Single_BothEmpty_Fails() {
        GT4500 emptyShip = new GT4500(0, 0.0, 0, 0.0);
        boolean result = emptyShip.fireTorpedo(FiringMode.SINGLE);
        assertEquals(false, result);
    }

    @Test
    void fireTorpedo_All_BothEmpty_Fails() {
        GT4500 emptyShip = new GT4500(0, 0.0, 0, 0.0);
        boolean result = emptyShip.fireTorpedo(FiringMode.ALL);
        assertEquals(false, result);
    }

    @Test
    void fireTorpedo_Single_PrimaryFails_DoesNotFireSecondary() {
        GT4500 failingShip = new GT4500(10, 1.0, 10, 0.0);
        boolean result = failingShip.fireTorpedo(FiringMode.SINGLE);
        assertEquals(false, result);
    }
}
