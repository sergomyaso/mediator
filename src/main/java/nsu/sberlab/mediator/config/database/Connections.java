package nsu.sberlab.mediator.config.database;

import lombok.AllArgsConstructor;
import lombok.Data;
import nsu.sberlab.mediator.types.AppConstants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

//@TODO безопасность не продумана, возможны падения при отсутсвии подключения к базе

public class Connections {
	private static HashMap<String, ConnectionConfig> connectionsConfigs;
	private static HashMap<String, Connection> connections;

	public Connections() {
		createConnections();
	}

	public Connection getConnectionByService(String serviceName) {
		return connections.get(serviceName);
	}

	private void createConnections() {
		connections = new HashMap<>();
		var configs = getConnectionsConfigs();

		for (var item : configs.values()) {
			connections.put(item.getServiceName(), createConnection(item));
		}
	}

	private Connection createConnection(ConnectionConfig config) {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(
					config.getPostgresDSN(),
					config.getPostgresUser(),
					config.getPostgresPassword());
		} catch (SQLException e) {
			System.out.printf(
					"[ERROR] Gark with connection to db %s, err: %s",
					config.getServiceName(),
					e.getMessage()
							 );
		}

		return conn;
	}

	private HashMap<String, ConnectionConfig> getConnectionsConfigs() {
		if (connectionsConfigs != null) {
			return connectionsConfigs;
		}

		return initConnectionConfigs();
	}

	private HashMap<String, ConnectionConfig> initConnectionConfigs() {
		connectionsConfigs = new HashMap<>();

		connectionsConfigs.put("service-credit", new ConnectionConfig(
				AppConstants.SERVICE_CREDIT_TITLE,
				"jdbc:postgresql://127.0.0.1:5434/credit",
				"superadmin",
				"123123"
		));

		connectionsConfigs.put("service-card", new ConnectionConfig(
				AppConstants.SERVICE_CARD_TITLE,
				"jdbc:postgresql://127.0.0.1:5433/card",
				"superadmin",
				"123123"
		));

		connectionsConfigs.put("service-deposit", new ConnectionConfig(
				AppConstants.SERVICE_DEPOSIT_TITLE,
				"jdbc:postgresql://127.0.0.1:5435/deposit",
				"superadmin",
				"123123"
		));

		return connectionsConfigs;
	}

}
