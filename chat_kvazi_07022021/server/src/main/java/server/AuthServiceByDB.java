package server;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthServiceByDB implements AuthService {
    Connection connection;
    PreparedStatement ps;
    Statement statement;

    public AuthServiceByDB() {
        try {
            connect();
            statement = connection.createStatement();
            statement.executeUpdate("drop table if exists users;");
            statement.executeUpdate("create table if not exists users (id integer primary key autoincrement, login text, password text, nickname text);");
            ps = connection.prepareStatement("insert into users (login, password, nickname) values(?, ?, ?);");
            ps.setString(1, "qwe");
            ps.setString(2, "qwe");
            ps.setString(3, "qwe");
            ps.executeUpdate();

            ps.setString(1, "asd");
            ps.setString(2, "asd");
            ps.setString(3, "asd");
            ps.executeUpdate();

            ps.setString(1, "zxc");
            ps.setString(2, "zxc");
            ps.setString(3, "zxc");
            ps.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    @Override
    public String getNicknameByLoginAndPassword(String login, String password) {
        try {
            ResultSet rs = statement.executeQuery("select * from users;");
            while (rs.next()) {
                String tempLogin = rs.getString(2);
                String tempPassword = rs.getString(3);
                String tempNickname = rs.getString(4);
                if (tempLogin.equals(login) && tempPassword.equals(password)) {
                    return tempNickname;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean registration(String login, String password, String nickname) {
        try {
            ResultSet rs = statement.executeQuery("select * from users;");
            while (rs.next()) {
                if (rs.getString(2).equals(login) || rs.getString(4).equals(nickname)) {
                    return false;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            ps = connection.prepareStatement("insert into users (login, password, nickname) values(?, ?, ?);");
            ps.setString(1, login);
            ps.setString(2, password);
            ps.setString(3, nickname);
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    public void connect() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:usersdb.db");
    }
}
