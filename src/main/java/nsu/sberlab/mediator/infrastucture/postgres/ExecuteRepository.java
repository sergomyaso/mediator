package nsu.sberlab.mediator.infrastucture.postgres;

import lombok.AllArgsConstructor;
import lombok.Data;
import nsu.sberlab.mediator.config.database.Connections;
import nsu.sberlab.mediator.config.workflow.TransactionCheckList;
import nsu.sberlab.mediator.controller.dto.ExecuteSqlInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

@Component
public class ExecuteRepository implements nsu.sberlab.mediator.domain.repository.ExecuteRepository {
	@Autowired
	Connections servicesDB;
	@Autowired
	Logger logger;
	@Autowired
	TransactionCheckList checkList;

	public int execute(ExecuteSqlInput executeInput)
	throws SQLException {
		var conn = servicesDB.getConnectionByService(executeInput.getServiceName());
		int row = -1;

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(executeInput.getQuery());
			ResultSet resultSet = preparedStatement.executeQuery();
			logger.info(String.format(
				"result set in executing query from %s result: %s", executeInput.getServiceName(),
				resultSet.getRow())
				);
			row = resultSet.getRow();
			checkList.setStageServiceToTransactionBlock(
				TransactionCheckList.ServiceStage.DONE,
				executeInput.getTransactionID(),
				executeInput.getServiceName()
				);
		} catch (SQLException e) {
			logger.info(String.format("Gark in findById Client Bank repo, err: %s", e.getMessage()));
			checkList.setStageServiceToTransactionBlock(
				TransactionCheckList.ServiceStage.FAILED,
				executeInput.getTransactionID(),
				executeInput.getServiceName()
				);
			throw e;
		}

		return row;
	}

}
