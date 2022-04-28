package nsu.sberlab.mediator.config.workflow;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionCheckListConfig {
	@Bean (name = "checkList")
	public TransactionCheckList TransactionCheckList() {
		return new TransactionCheckList();
	}
}
