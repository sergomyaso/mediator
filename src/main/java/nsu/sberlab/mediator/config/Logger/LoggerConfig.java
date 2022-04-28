package nsu.sberlab.mediator.config.Logger;

import nsu.sberlab.mediator.config.database.Connections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
public class LoggerConfig {
	@Bean (name = "Logger")
	public Logger logger() {
		return Logger.getLogger("logger");
	}

}
