package utils;

import config.ConfigReader;

import java.sql.*;

public class DatabaseConnection {

    public static String getEmail;
    public static String getPassword;

    public static String getFirstName;
    public static String getLastName;
    public static String getPhone;
    public static String getPhoneNumber;
    public static String getLinkedIn;
    public static String getGithubUsername;
    public static String getLinkedInUrl;
    public static String getLinkedin;
    public static String getYearsOfExperience;

    public static String Image;
    public static String CurrentProfileImage;
    public static String PreviousProfileImage;


    public static void getLoginUser(int userId) throws SQLException {

        String dbURL = ConfigReader.getProperty("DB_URL");
        String dbUsername = ConfigReader.getProperty("DB_USERNAME");
        String dbPassword = ConfigReader.getProperty("DB_PASSWORD");

        String query = "SELECT * FROM loginUser WHERE id = ?";

        try (
                Connection connection =
                        DriverManager.getConnection(dbURL, dbUsername, dbPassword);

                PreparedStatement statement =
                        connection.prepareStatement(query)
        ) {

            statement.setInt(1, userId);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {

                    getEmail = resultSet.getString("email");
                    getPassword = resultSet.getString("password");

                    System.out.println("Email: " + getEmail);
                    System.out.println("Password: " + getPassword);
                }
            }
        }
    }


    public static void getUserProfile(int userId) throws SQLException {

        String dbURL = ConfigReader.getProperty("DB_URL");
        String dbUsername = ConfigReader.getProperty("DB_USERNAME");
        String dbPassword = ConfigReader.getProperty("DB_PASSWORD");

        String query = "SELECT * FROM profile WHERE user_id = ?";

        try (
                Connection connection =
                        DriverManager.getConnection(dbURL, dbUsername, dbPassword);

                PreparedStatement statement =
                        connection.prepareStatement(query)
        ) {

            statement.setInt(1, userId);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {

                    getFirstName = resultSet.getString("firstName");
                    getLastName = resultSet.getString("lastName");
                    getPhone = resultSet.getString("phone");
                    getPhoneNumber = resultSet.getString("phoneNumber");
                    getLinkedIn = resultSet.getString("linkedIn");
                    getGithubUsername = resultSet.getString("githubUsername");
                    getLinkedInUrl = resultSet.getString("linkedInUrl");
                    getLinkedin = resultSet.getString("linkedin");
                    getYearsOfExperience =
                            resultSet.getString("yearsOfExperience");
                }
            }
        }
    }

    public static void getUserImage(int userId) throws SQLException {

        String dbURL = ConfigReader.getProperty("DB_URL");
        String dbUsername = ConfigReader.getProperty("DB_USERNAME");
        String dbPassword = ConfigReader.getProperty("DB_PASSWORD");

        String query = "SELECT * FROM profile WHERE user_id = ?";

        try (
                Connection connection =
                        DriverManager.getConnection(dbURL, dbUsername, dbPassword);

                PreparedStatement statement =
                        connection.prepareStatement(query)
        ) {

            statement.setInt(1, userId);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {

                    Image = resultSet.getString("profileImage");

                    CurrentProfileImage =
                            resultSet.getString("currentProfileImage");

                    PreviousProfileImage =
                            resultSet.getString("previousProfileImage");
                }
            }
        }
    }
}