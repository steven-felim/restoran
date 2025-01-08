package controller;

import model.classes.Deliveryman;
import model.classes.Employee;
import model.enums.DeliverymanStatus;
import model.enums.Jobdesk;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeController {
    public List<Employee> getAllEmployee() {
        List<Employee> empList = new ArrayList<>();
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        try (
                Statement stmt = conn.con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT user_id, name, email, cellphone, jobdesk FROM user WHERE role = 'EMPLOYEE'")) {
            while (rs.next()) {
                int id = rs.getInt("user_id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String cellphone = rs.getString("cellphone");
                Jobdesk jobdesk = Jobdesk.valueOf(rs.getString("jobdesk"));
                switch (rs.getString("jobdesk")) {
                    case "CASHIER":
                        jobdesk = Jobdesk.CASHIER;
                        break;
                    case "CHEF":
                        jobdesk = Jobdesk.CHEF;
                        break;
                    case "WAITER":
                        jobdesk = Jobdesk.WAITER;
                        break;
                    case "DELIVERYMAN":
                        jobdesk = Jobdesk.DELIVERYMAN;
                        break;
                }
                empList.add(new Employee(id, name, email, "", cellphone, jobdesk));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empList;
    }

    public Employee getDataFromDB (int searchID) {
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        Employee emp = null;
        try (
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE user_id = " + searchID + ";")) {
            while (rs.next()) {
                Integer id = rs.getInt("user_id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = null;
                String cellphone = rs.getString("cellphone");
                Jobdesk jobdesk = Jobdesk.valueOf(rs.getString("jobdesk"));
                emp = new Employee(id, name, email, password, cellphone, jobdesk);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;
    }

    public List<Deliveryman> getAllDeliveryMan() {
        List<Deliveryman> empList = new ArrayList<>();
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        try (
                Statement stmt = conn.con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT user_id, name, email, cellphone, jobdesk, deliveryman_status FROM user WHERE jobdesk = 'DELIVERYMAN'")) {
            while (rs.next()) {
                int id = rs.getInt("user_id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String cellphone = rs.getString("cellphone");
                Jobdesk jobdesk = Jobdesk.valueOf(rs.getString("jobdesk"));
                DeliverymanStatus status = DeliverymanStatus.valueOf(rs.getString("deliveryman_status"));
                empList.add(new Deliveryman(id, name, email, "", cellphone, jobdesk, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empList;
    }

    public void addEmployee(String name, String email, String jobdesk) {
        DatabaseHandler.getInstance().connect();

        String query = "INSERT INTO user(name, email, password, cellphone, role, jobdesk) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = DatabaseHandler.getInstance().con.prepareStatement(query);

            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, "123456xyz");
            pstmt.setString(4, "-");
            pstmt.setString(5, "EMPLOYEE");
            pstmt.setString(6, jobdesk);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseHandler.getInstance().disconnect();
        }
    }

    public void editEmployee(int idUser, String name, String email, String jobdesk) {
        DatabaseHandler.getInstance().connect();

        String query = "UPDATE user SET name = ?, email = ?, cellphone = ?, jobdesk = ? WHERE user_id = ?";
        try {
            PreparedStatement pstmt = DatabaseHandler.getInstance().con.prepareStatement(query);

            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, "-");
            pstmt.setString(4, jobdesk);
            pstmt.setInt(5, idUser);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseHandler.getInstance().disconnect();
        }
    }
}
