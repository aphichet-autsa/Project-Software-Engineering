package project93;

import database.DatabaseManager;

public class RegisterManager extends UserManager {
    public RegisterManager(DatabaseManager db) {
        super(db);
    }

    public boolean registerUser(String username, String email, String password) {
        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("กรุณากรอกข้อมูลให้ครบถ้วน");
        }

        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("รูปแบบอีเมล์ไม่ถูกต้อง");
        }

        try {
            String query = "INSERT INTO user (username, email, password) VALUES (?, ?, ?)";
            int rowsInserted = db.executeUpdate(query, username, email, password);
            return rowsInserted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("เกิดข้อผิดพลาดระหว่างการบันทึกข้อมูล");
        }
    }
} 

