package Controller;

import java.util.List;

import Blockchain.BlockchainOperation.BlockType;
import Helper.IdGenerator;
import Blockchain.InventoryOperation;
import Models.Inventory;

public class InventoryController {

    InventoryOperation inventoryOperation;

    public InventoryController() {
        inventoryOperation = new InventoryOperation(BlockType.INVENTORY);
    }

    public void createInventory(String inventoryName, String inventoryLocation) throws Exception {
        inventoryOperation.createBlock(new Inventory("IN" + IdGenerator.generateUUID(), inventoryName, inventoryLocation));
    }

    public List<Inventory> getInventory() {
        return inventoryOperation.getInventory();
    }
}
