package Blockchain;

import java.io.File;
import java.util.LinkedList;

import com.google.gson.GsonBuilder;

import Blockchain.Data.Config;

public class BlockchainOperation {
    private LinkedList<Block> blockchain = new LinkedList<Block>();

    private Blockchain blockchainFunction;

    public static enum BlockType {ORDER, INVENTORY, STOCK}

    private BlockType blockType;
    private String bcFile = "";
    private String ledgerFile = "";

    public BlockchainOperation(BlockType blockType) {
        this.blockType = blockType;
    }

    private void initBlock(Object data) throws Exception {
        Block b1 = new Block(data, "0", 0);
        blockchain.add(b1);
        blockchainFunction.persist(blockchain);
        distributeBlockchain(blockchain);   
    }

    private void nextBlock(Object data) throws Exception {
        blockchain = blockchainFunction.getBlockchain();
        Block block = new Block(data, blockchain.getLast().getNowHash(), blockchain.getLast().getBlockIndex());
        blockchain.add(block);
        blockchainFunction.persist(blockchain);
        distributeBlockchain(blockchain);
    }

    private void distributeBlockchain(LinkedList<Block> blockchain) {
        String blockchainData = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        blockchainFunction.distribute(blockchainData);
    }

    public void createBlock(Object data) throws Exception {
        switch (blockType) {
            case ORDER:
                bcFile = Config.BC_ORDER_FILE;
                ledgerFile = Config.LEDGER_ORDER_FILE;
                break;

            case INVENTORY:
                bcFile = Config.BC_INVENTORY_FILE;
                ledgerFile = Config.LEDGER_INVENTORY_FILE;
                break;

            case STOCK:
                bcFile = Config.BC_STOCK_FILE;
                ledgerFile = Config.LEDGER_STOCK_FILE;
                break;
        }

        blockchainFunction = new Blockchain(bcFile, ledgerFile);
        blockPosition(data, bcFile);
    }

    // public void createBlock(Object data, BlockType blockType) throws Exception {
    //     switch (blockType) {
    //         case ORDER:
    //             bcFile = Config.BC_ORDER_FILE;
    //             ledgerFile = Config.LEDGER_ORDER_FILE;
    //             break;

    //         case INVENTORY:
    //             bcFile = Config.BC_INVENTORY_FILE;
    //             ledgerFile = Config.LEDGER_INVENTORY_FILE;
    //             break;

    //         case STOCK:
    //             bcFile = Config.BC_STOCK_FILE;
    //             ledgerFile = Config.LEDGER_STOCK_FILE;
    //             break;
    //     }

    //     blockchainFunction = new Blockchain(bcFile, ledgerFile);
    //     blockPosition(data, bcFile);
    // }

    private void blockPosition(Object data, String filePath) throws Exception {
        File file = new File(filePath);
        // File file = new File(Config.BC_OBJ_FILE);
        if (file.exists() && !file.isDirectory()) {
            nextBlock(data);
        }
        else {
            initBlock(data);
        }
    }

    private LinkedList<Block> getBlockchain() {
        return this.blockchain;
    }
    

    @Override
    public String toString() {
        return "{" +
            " blockchain='" + getBlockchain() + "}";
    }


}
