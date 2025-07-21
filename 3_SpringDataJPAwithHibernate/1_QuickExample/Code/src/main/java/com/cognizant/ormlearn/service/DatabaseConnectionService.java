package com.cognizant.ormlearn.service;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Database Connection Test Service
 * Tests and displays database connection information on startup
 */
@Component
@Order(1) // Run first to test connection
public class DatabaseConnectionService implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseConnectionService.class);
    
    private final DataSource dataSource;

    public DatabaseConnectionService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void run(String... args) throws Exception {
        testDatabaseConnection();
    }

    /**
     * Test database connection and display connection information
     */
    public void testDatabaseConnection() {
        LOGGER.info("=== Testing Database Connection ===");
        
        try (Connection connection = dataSource.getConnection()) {
            if (connection != null && !connection.isClosed()) {
                LOGGER.info("✅ Database connection established successfully!");
                
                // Get database metadata
                DatabaseMetaData metaData = connection.getMetaData();
                LOGGER.info("Database Product: {}", metaData.getDatabaseProductName());
                LOGGER.info("Database Version: {}", metaData.getDatabaseProductVersion());
                LOGGER.info("Driver Name: {}", metaData.getDriverName());
                LOGGER.info("Driver Version: {}", metaData.getDriverVersion());
                LOGGER.info("Connection URL: {}", metaData.getURL());
                LOGGER.info("Connection User: {}", metaData.getUserName());
                
                // Test if country table exists
                testTableExistence(connection);
                
            } else {
                LOGGER.error("❌ Failed to establish database connection!");
            }
        } catch (SQLException e) {
            LOGGER.error("❌ Database connection error: {}", e.getMessage(), e);
            LOGGER.error("Please check your database configuration in application.properties");
        }
        
        LOGGER.info("=== Database Connection Test Complete ===");
    }

    /**
     * Test if the country table exists and display basic information
     * 
     * @param connection the database connection
     */
    private void testTableExistence(Connection connection) {
        try {
            DatabaseMetaData metaData = connection.getMetaData();
            
            // Check if country table exists
            try (ResultSet tables = metaData.getTables(null, null, "country", new String[]{"TABLE"})) {
                if (tables.next()) {
                    LOGGER.info("✅ Country table found in database");
                    
                    // Get column information
                    try (ResultSet columns = metaData.getColumns(null, null, "country", null)) {
                        LOGGER.info("Table structure:");
                        while (columns.next()) {
                            String columnName = columns.getString("COLUMN_NAME");
                            String dataType = columns.getString("TYPE_NAME");
                            int columnSize = columns.getInt("COLUMN_SIZE");
                            boolean nullable = columns.getBoolean("NULLABLE");
                            
                            LOGGER.info("  - {} {} ({}) {}", 
                                columnName, 
                                dataType, 
                                columnSize,
                                nullable ? "NULL" : "NOT NULL"
                            );
                        }
                    }
                } else {
                    LOGGER.warn("⚠️ Country table not found. It will be created by Hibernate.");
                }
            }
        } catch (SQLException e) {
            LOGGER.warn("⚠️ Could not verify table existence: {}", e.getMessage());
        }
    }

    /**
     * Get connection pool information if using HikariCP
     * 
     * @return connection pool status
     */
    public String getConnectionPoolInfo() {
        try {
            if (dataSource instanceof com.zaxxer.hikari.HikariDataSource hikariDS) {
                com.zaxxer.hikari.HikariPoolMXBean poolBean = hikariDS.getHikariPoolMXBean();
                
                return String.format(
                    "Pool: %s, Active: %d, Idle: %d, Total: %d, Waiting: %d",
                    hikariDS.getPoolName(),
                    poolBean.getActiveConnections(),
                    poolBean.getIdleConnections(),
                    poolBean.getTotalConnections(),
                    poolBean.getThreadsAwaitingConnection()
                );
            }
        } catch (Exception e) {
            LOGGER.debug("Could not get connection pool info: {}", e.getMessage());
        }
        
        return "Connection pool information not available";
    }
}
