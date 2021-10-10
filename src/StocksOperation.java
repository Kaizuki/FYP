import java.util.ArrayList;
import java.util.List;

import Blockchain.Block;
import Blockchain.BlockchainOperation;
import Models.Stocks;

public class StocksOperation extends BlockchainOperation {

    public StocksOperation(BlockType blockType) {
        super(blockType);
    }

    public List<Stocks> getStocks() {
        List<Stocks> filteredStocks = new ArrayList<Stocks>();
        removeDuplicateData();
        for (Block blockOrders : filteredBlockchain) {
            filteredStocks.add(new Stocks(
                ( (Stocks) blockOrders.getBlockchainData() ).getStockId(),
                ( (Stocks) blockOrders.getBlockchainData() ).getInventoryId(),
                ( (Stocks) blockOrders.getBlockchainData() ).getWarehouseId()
                )
            );
        }
        return filteredStocks;
    }
}
