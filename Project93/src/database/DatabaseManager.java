package database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseManager {
    
    private Connection conn = null;
    
    // Connection details
    private final String URL = "jdbc:mysql://my-database-instance-1.c3u46oqcahga.ap-southeast-1.rds.amazonaws.com:3306/mydb";
    private final String USER = "admin";
    private final String PASSWORD = "Project93063";


    private static final Logger logger = Logger.getLogger(DatabaseManager.class.getName());
    static {
        logger.setLevel(Level.WARNING);
    }
    public Connection connect() {
        try {
            if (conn == null || conn.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                logger.info("Connection Successful!");
            }
        } catch (ClassNotFoundException e) {
            logger.severe("JDBC Driver not found: " + e.getMessage());
            throw new RuntimeException("JDBC Driver not found", e);
        } catch (SQLException e) {
            logger.severe("Failed to connect to the database: " + e.getMessage());
            throw new RuntimeException("Database connection error", e);
        }
        return conn;
    }


    // Method to execute SELECT queries
    public ResultSet executeQuery(String sql, Object... params) {
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            connect();
            pstmt = conn.prepareStatement(sql);

            // Set parameters
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }

            rs = pstmt.executeQuery();
            logger.info("Query executed successfully!");
        } catch (SQLException e) {
            logger.severe("Error executing query: " + e.getMessage());
        }
        return rs;
    }

    // Method to execute INSERT, UPDATE, DELETE queries
    public int executeUpdate(String sql, Object... params) {
        int rowsAffected = 0;
        PreparedStatement pstmt = null;
        try {
            connect();
            pstmt = conn.prepareStatement(sql);

            // Set parameters
            for (int i = 0; i < params.length; i++) {
                if (params[i] == null) {
                    pstmt.setNull(i + 1, java.sql.Types.NULL);
                } else {
                    pstmt.setObject(i + 1, params[i]);
                }
            }

            rowsAffected = pstmt.executeUpdate();
            logger.info("Update executed successfully!");
        } catch (SQLException e) {
            logger.severe("Error executing update: " + e.getMessage());
            throw new RuntimeException("SQL execution failed: " + e.getMessage(), e);
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    logger.severe("Error closing PreparedStatement: " + e.getMessage());
                }
            }
        }
        return rowsAffected;
    }

    // Method to execute queries that return a single integer value
    public int executeQueryForInt(String sql, Object... params) {
        int result = 0;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            connect();
            pstmt = conn.prepareStatement(sql);

            // Set parameters
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }

            rs = pstmt.executeQuery();
            if (rs.next()) {
                result = rs.getInt(1); // Get the first column value as integer
            }
        } catch (SQLException e) {
            logger.severe("Error executing query for int: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                logger.severe("Error closing resources: " + e.getMessage());
            }
        }
        return result;
    }

    // Transaction management methods
    public void beginTransaction() throws SQLException {
        connect();
        conn.setAutoCommit(false);
    }

    public void commitTransaction() throws SQLException {
        if (conn != null) {
            conn.commit();
            conn.setAutoCommit(true);
        }
    }

    public void rollbackTransaction() throws SQLException {
        if (conn != null) {
            conn.rollback();
            conn.setAutoCommit(true);
        }
    }

    // Method to disconnect from the database
    public void disconnect() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                logger.info("Disconnected from the database.");
            }
        } catch (SQLException e) {
            logger.severe("Error closing database connection: " + e.getMessage());
        }
    }

    // Get connection (useful for external custom queries)
     public Connection getConnection() {
        return connect();
    }
}
