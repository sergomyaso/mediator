package nsu.sberlab.mediator.domain.repository;

import nsu.sberlab.mediator.controller.dto.ExecuteSqlInput;

import java.sql.SQLException;

public interface ExecuteRepository {
	public int execute(ExecuteSqlInput executeInput) throws SQLException;
}
