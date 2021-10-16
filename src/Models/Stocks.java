package Models;

import java.io.Serializable;

public class Stocks extends Models implements Serializable{
    private int stockId;
    private int inventoryId;
    private String stockStatus;
    public static enum StockStatus {AVAILABLE, SOLD, DEFECTIVE, MISSING, NOT_AVAILABLE}; 

    public Stocks(int stockId, int inventoryId, String stockStatus) {
        this.stockId = stockId;
        this.inventoryId = inventoryId;
        this.stockStatus = stockStatus;
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

    public String getStockStatus() {
        return this.stockStatus;
    }

    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus;
    }

    @Override
    public String toString() {
        return "{" +
            " stockId='" + getStockId() + "'" +
            ", inventoryId='" + getInventoryId() + "'" +
            ", stockStatus='" + getStockStatus() + "'" +
            "}";
    }

    @Override
    public int getModelId() {
        return this.stockId;
    }
}
