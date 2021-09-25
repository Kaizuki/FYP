package Models;

public class Inventory {
    private int inventoryId;
    private String inventoryName;
    
    public Inventory(int inventoryId, String inventoryName) {
        this.inventoryId = inventoryId;
        this.inventoryName = inventoryName;
    }

    public int getInventoryId() {
        return this.inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getInventoryName() {
        return this.inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    @Override
    public String toString() {
        return "{" +
            " inventoryId='" + getInventoryId() + "'" +
            ", inventoryName='" + getInventoryName() + "'" +
            "}";
    }    
}
