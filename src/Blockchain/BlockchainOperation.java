package Blockchain;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.GsonBuilder;

import Blockchain.Data.Config;
import Models.Models;

public class BlockchainOperation {
    public static enum BlockType {ORDER, INVENTORY, STOCK}

    protected LinkedList<Block> blockchain = new LinkedList<Block>();
    protected List<Block> filteredBlockchain;
    
    private Blockchain blockchainFunction;
    private String bcFile = "";
    private String ledgerFile = "";

    public BlockchainOperation(BlockType blockType) {

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
    }

    private void initBlock(Object data) throws Exception {
        Block block = new Block(data, "0", 0);
        blockchain.add(block);
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
        blockchainFunction = new Blockchain(bcFile, ledgerFile);
        blockPosition(data, bcFile);
    }

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

    protected void removeDuplicateData() {
        filteredBlockchain = new ArrayList<Block>();
        LinkedList<Block> tempBlockchain = getBlockchain();
        List<Block> reverseBlockchain = tempBlockchain.stream().collect(Collectors.toList());
        Collections.reverse(reverseBlockchain);
        
        for (Block block : reverseBlockchain) {
            boolean check = false;
            if (filteredBlockchain.isEmpty()) {
                filteredBlockchain.add(block);
                continue;
            }
            
            for (Block newLists : filteredBlockchain) {
                if ( ( (Models) block.getBlockchainData() ).getModelId() == ( ((Models) newLists.getBlockchainData()).getModelId() ) ) {
                    check = true;
                    break;
                }
            }
            
            if (!check) {
                filteredBlockchain.add(block);
            }
        }
    }

    protected LinkedList<Block> getBlockchain() {
        File file = new File(bcFile);
    
        if (file.exists() && !file.isDirectory()) {
            this.blockchain = blockchainFunction.getBlockchain();
        }
    
        return this.blockchain;
    }
    
    @Override
    public String toString() {
        return "{" +
            " blockchain='" + getBlockchain() + "}";
    }
    
}
