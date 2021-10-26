package Blockchain;

import java.io.ByteArrayOutputStream;
import java.util.LinkedList;
import Blockchain.Data.Config;
import DigitalSignature.DigitalSignature;

public class BlockchainVerification {

    String bcFile, ledgerFile;

    public BlockchainVerification(String bcFile, String ledgerFile) {
        this.bcFile = bcFile;
        this.ledgerFile = ledgerFile;
    }

    public boolean verifyBlockChain() throws Exception {
        boolean verifyCurrentHash = false;
        boolean verifyPreviousHash = false;
        Blockchain blockchain = new Blockchain(bcFile, ledgerFile);
        LinkedList<Block> blockChainLst = blockchain.getBlockchain();
        Block currentBlock;
        Block nextBlock;
        
        if (blockChainLst.size() <= 1 || blockChainLst.equals(null)) {
            return true;
        }

        for (int counter = 0; counter < blockChainLst.size(); counter++) {
            currentBlock = blockChainLst.get(counter);
            verifyCurrentHash = verifyHash(currentBlock);

            if (counter < blockChainLst.size() - 1) {
                nextBlock = blockChainLst.get(counter + 1);
                verifyPreviousHash = verifyPreviousHash(currentBlock, nextBlock);
            }
        }
        return verifyCurrentHash && verifyPreviousHash;
    }

    private boolean verifyHash(Block block) throws Exception {
        DigitalSignature digitalSignature = new DigitalSignature();
        Block blockClone = new Block(block.getBlockIndex(), block.getBlockchainData(), block.getPreHash(), block.getTimeStamp());
        String blockCloneHash = "";

        byte[] blockBytesOfClone = Block.generateByteArray(blockClone);

        if (blockBytesOfClone != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(blockBytesOfClone);
            byteArrayOutputStream.write(blockClone.getPreHash().getBytes());
            byteArrayOutputStream.write(Long.toString(blockClone.getTimeStamp()).getBytes());
            blockCloneHash = Hash.hashing(byteArrayOutputStream.toByteArray(), Config.HASH_ALGORITHM);
        }
        return digitalSignature.verifySignature(blockCloneHash, block.getNowHash());
    }

    private boolean verifyPreviousHash(Block currentBlock, Block nextBlock) {
        return (currentBlock.getNowHash().equals(nextBlock.getPreHash()));
    }
}
