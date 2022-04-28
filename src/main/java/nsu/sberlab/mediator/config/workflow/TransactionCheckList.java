package nsu.sberlab.mediator.config.workflow;

import java.util.ArrayList;
import java.util.HashMap;

public class TransactionCheckList {
	public static class TransactionBlock {
		private HashMap<String, ServiceStage> block;

		public TransactionBlock() {
			block = new HashMap<>();
		}

		public TransactionBlock(HashMap<String, ServiceStage> block) {
			this.block = block;
		}

		public HashMap<String, ServiceStage> getBlock() {
			return block;
		}

		public void setBlock(HashMap<String, ServiceStage> block) {
			this.block = block;
		}

		public void setServiceStage(String serviceName, ServiceStage stage) {
			block.put(serviceName, stage);
		}

		public ServiceStage getServiceStage(String serviceName) {
			return block.get(serviceName);
		}
	}

	public enum ServiceStage {
		FAILED,
		DONE,
		WAIT
	}

	private HashMap<String, TransactionBlock> transactionBlocks = new HashMap<>();

	public TransactionBlock getTransactionBlockById(String transactionID) {
		return transactionBlocks.get(transactionID);
	}

	public void createTransactionBlock(ArrayList<String> serviceNames, String transactionID) {
		transactionBlocks.put(transactionID, new TransactionBlock());
		for (String serviceName : serviceNames) {
			transactionBlocks.get(transactionID).setServiceStage(serviceName, ServiceStage.WAIT);
		}
	}

	public void setStageServiceToTransactionBlock(ServiceStage stage, String transactionID, String serviceName) {
		transactionBlocks.get(transactionID).setServiceStage(serviceName, stage);
	}

}
