package Controller;

import java.util.List;
import Blockchain.BlockchainOperation.BlockType;
import Blockchain.StocksOperation;
import Models.Stocks;
import Models.Stocks.StockStatus;

public class StocksController {

    public StocksOperation stocksOperation;

    public StocksController() {
        stocksOperation = new StocksOperation(BlockType.STOCK);
    }

    //* Manually key in new StockId
    //* addEditStocks handles add and delete operation
    public void createStocks(String stockId, String inventoryId, StockStatus stockStatus) throws Exception {
        if (stocksOperation.chkDuplicateId(stockId)) {
            stocksOperation.createBlock( new Stocks(stockId, inventoryId, stockStatus.toString()) );
        } else {
            System.out.println("ERROR: Duplicate Stock Id found");
        }
    }

    public void updateStocks(String stockId, String inventoryId, StockStatus stockStatus) throws Exception {
        stocksOperation.createBlock( new Stocks(stockId, inventoryId, stockStatus.toString()) );
    }

    public int countInventoryStock(String inventoryId) {
       return (int) stocksOperation.getStocks().stream().filter(stock -> stock.getInventoryId() == inventoryId).count();
    }

    public List<Stocks> getStocks() {
        return stocksOperation.getStocks();
    }
}
