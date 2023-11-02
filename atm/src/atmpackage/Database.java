package atmpackage;

import java.sql.*;

class Database {
	
	private static final String url = "jdbc:mysql://localhost/atm_db";
    private static final String user = "root";
    private static final String password = "#Roni@Ganrai@20";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public boolean isValidUser(int userId, int userPin) {
        try (Connection con = getConnection();
             PreparedStatement statement = con.prepareStatement("SELECT user_id FROM atm_users WHERE user_id = ? AND user_pin = ?")) {
            statement.setInt(1, userId);
            statement.setInt(2, userPin);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public double getUserBalance(int userId) {
        try (Connection con = getConnection();
             PreparedStatement statement = con.prepareStatement("SELECT account_balance FROM atm_users WHERE user_id = ?")) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getDouble("account_balance");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    
    public void updateUserBalance(int userId, double newBalance) {
        try (Connection con = getConnection();
             PreparedStatement statement = con.prepareStatement("UPDATE atm_users SET account_balance = ? WHERE user_id = ?")) {
            statement.setDouble(1, newBalance);
            statement.setInt(2, userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public int createUser(String username, int userPin) {
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = con.prepareStatement("INSERT INTO atm_users (username, user_pin, account_balance) VALUES (?, ?, 0)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, username);
            statement.setInt(2, userPin);
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
