package Blockchain;
import java.util.ArrayList;
import java.util.List;
import Models.Inventory;

public class InventoryOperation extends BlockchainOperation{

    public InventoryOperation(BlockType blockType) {
        super(blockType);
    }

    public List<Inventory> getInventory() {
        List<Inventory> filteredInventory = new ArrayList<Inventory>();
        removeDuplicateData();
        for (Block blockInventory : filteredBlockchain) {
            filteredInventory.add(new Inventory(
                ( (Inventory) blockInventory.getBlockchainData()).getInventoryId(),
                ( (Inventory) blockInventory.getBlockchainData()).getInventoryName(),
                ( (Inventory) blockInventory.getBlockchainData()).getInventoryLocation()
                )
            );
        }
        return filteredInventory;
    }
}
