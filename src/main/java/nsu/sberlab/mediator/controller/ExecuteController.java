package nsu.sberlab.mediator.controller;

import nsu.sberlab.mediator.controller.dto.ExecuteSqlInput;
import nsu.sberlab.mediator.service.ExecuteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ExecuteController {
	@Autowired
	ExecuteService executeService;

	@PostMapping ("/services/{service-name}")
	public int executeSql(@PathVariable ("service-name") String serviceName, @RequestBody ExecuteSqlInput input) {
		return executeService.executeQuery(input);
	}

}
