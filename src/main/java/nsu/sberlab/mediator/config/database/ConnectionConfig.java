package nsu.sberlab.mediator.config.database;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConnectionConfig {
	private String serviceName;
	private String postgresDSN;
	private String postgresUser;
	private String postgresPassword;
}
