package hu.bme.mit.spaceship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertTrue(result);
        assertEquals(0, store.getTorpedoCount());
        assertTrue(store.isEmpty());
    }

    @Test
    void fire_Multiple() {
        TorpedoStore store = new TorpedoStore(5, 0.0);

        boolean result = store.fire(3);

        assertTrue(result);
        assertEquals(2, store.getTorpedoCount());
        assertFalse(store.isEmpty());
    }

    @Test
    void fire_Fail() {
        TorpedoStore store = new TorpedoStore(5, 1.0);
        boolean result = store.fire(2);

        assertFalse(result);
        assertEquals(5, store.getTorpedoCount());
        assertFalse(store.isEmpty());
    }

    @Test
    void fire_InvalidCount() {
        TorpedoStore store = new TorpedoStore(5);
        assertThrows(IllegalArgumentException.class, () -> store.fire(0));
        assertThrows(IllegalArgumentException.class, () -> store.fire(-1));
        assertEquals(5, store.getTorpedoCount());
    }

    @Test
    void fire_TooMany() {
        TorpedoStore store = new TorpedoStore(2);
        assertThrows(IllegalArgumentException.class, () -> store.fire(3));
        assertEquals(2, store.getTorpedoCount());
    }

    @Test
    void isEmpty_Empty() {
        TorpedoStore store = new TorpedoStore(0);
        assertTrue(store.isEmpty());
        assertEquals(0, store.getTorpedoCount());
    }
}
