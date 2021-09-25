package Models;

public class Stocks {
    private int stockId;
    private int inventoryId;
    private int warehouseId;

    public Stocks(int stockId, int inventoryId, int warehouseId) {
        this.stockId = stockId;
        this.inventoryId = inventoryId;
        this.warehouseId = warehouseId;
    }

    public int getStockId() {
        return this.stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public int getInventoryId() {
        return this.inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getWarehouseId() {
        return this.warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    @Override
    public String toString() {
        return "{" +
            " stockId='" + getStockId() + "'" +
            ", inventoryId='" + getInventoryId() + "'" +
            ", warehouseId='" + getWarehouseId() + "'" +
            "}";
    }
}
