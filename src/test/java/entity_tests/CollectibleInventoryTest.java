package entity_tests;
import entity.Collectible;
import entity.CollectibleInventory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CollectibleInventoryTest {
    Collectible essence = new Collectible("Essence", 100);
    Collectible artifact = new Collectible("Artifact", 1);
    CollectibleInventory inventory;

    @BeforeEach
    @DisplayName("Setup before Each Test")
    void setUp(){
        inventory = new CollectibleInventory("Collectible Inventory", essence, artifact);
    }

    @Test
    @DisplayName("Test Get Collectible Type")
    void testGetCollectible(){
        Assertions.assertAll(
                () -> Assertions.assertEquals(essence, inventory.getCollectible("Essence")),
                () -> Assertions.assertEquals(artifact, inventory.getCollectible("Artifact"))
        );
    }

    @Test
    @DisplayName("Test to add amount to Essence and Artifact")
    void testAddAmount(){

        Assertions.assertAll(
                () -> inventory.changeAmount("Essence", 20),
                () -> Assertions.assertEquals(120, inventory.getCollectible("Essence").getNum()),
                () -> inventory.changeAmount("Artifact", 1),
                () -> Assertions.assertEquals(2, inventory.getCollectible("Artifact").getNum())
        );
    }

    @Test
    @DisplayName("Test to subtract amount to Essence and Artifact")
    void testSubtractAmount(){
        Assertions.assertAll(
                () -> inventory.changeAmount("Essence", -30),
                () -> Assertions.assertEquals(70, inventory.getCollectible("Essence").getNum()),
                () -> inventory.changeAmount("Artifact", -1),
                () -> Assertions.assertEquals(0, inventory.getCollectible("Artifact").getNum())
        );
    }

}
