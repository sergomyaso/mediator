package nsu.sberlab.mediator.config.database;

import nsu.sberlab.mediator.types.AppConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

@Configuration
public class ConnectionsConfig {
	@Bean (name = "serviceDB")
	public Connections serviceDB() {
		return new Connections();
	}

}
