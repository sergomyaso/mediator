package nsu.sberlab.mediator.service;

import nsu.sberlab.mediator.controller.dto.ExecuteSqlInput;
import nsu.sberlab.mediator.infrastucture.postgres.ExecuteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class ExecuteService {
	@Autowired
	ExecuteRepository repo;

	public int executeQuery(ExecuteSqlInput input) {
		int row = -1;

		try {
			row = repo.execute(input);
		} catch (SQLException e) {
			return -1;
		}

		return row;
	}

}
