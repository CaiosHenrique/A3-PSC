package com.mycompany.a3.testpsc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CrudBD {

    public boolean incluirReg(User uD) {
        if (uD == null || uD.getUser() == null || uD.getPass() == null || uD.getEmail() == null) {
            JOptionPane.showMessageDialog(null, "Dados inválidos! Verifique os campos e tente novamente.");
            return false;
        }

        String sqlInsert = "INSERT INTO USUARIO(USER, PASS, EMAIL) VALUES(?, ?, ?)";

        try (Connection conn = ConnFactory.getConn(); PreparedStatement stmt = conn.prepareStatement(sqlInsert)) {

            conn.setAutoCommit(false); // Desativa o auto-commit para permitir rollback em caso de erro

            stmt.setString(1, uD.getUser());
            stmt.setString(2, uD.getPass());
            stmt.setString(3, uD.getEmail());
            stmt.executeUpdate();

            conn.commit(); // Confirma a transação
            JOptionPane.showMessageDialog(null, "Conta criada com sucesso!");
            return true;

        } catch (SQLException e) {
            System.err.println("Erro ao incluir os dados: " + e.getMessage());
            e.printStackTrace();

            try (Connection conn = ConnFactory.getConn()) {
                if (!conn.getAutoCommit()) {
                    conn.rollback(); // Reverte a transação em caso de erro
                    System.err.println("Transação revertida com sucesso.");
                }
            } catch (SQLException rollbackEx) {
                System.err.println("Erro ao tentar reverter a transação: " + rollbackEx.getMessage());
                rollbackEx.printStackTrace();
            }

            return false;

        }
    }

    public boolean consultarReg(String email, String pass) {
        String sqlSelect = "SELECT * FROM USUARIO WHERE EMAIL = ? AND PASS = ?";
        PreparedStatement stmt = null;

        try {
            Connection conn = ConnFactory.getConn();
            stmt = conn.prepareStatement(sqlSelect);

            stmt.setString(1, email);
            stmt.setString(2, pass);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {

                    return true;

                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar todos os dados" + ex.toString());
        }

        return false;
    }

    public boolean recuperarreg(String email) {
        String sqlSelect = "SELECT * FROM USUARIO WHERE EMAIL = ?";
        PreparedStatement stmt = null;

        try {
            Connection conn = ConnFactory.getConn();
            stmt = conn.prepareStatement(sqlSelect);

            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o e-mail" + ex.toString());
        }

        return false;
    }

    public void alterarReg(User uD) {
        String sqlUpdate = "UPDATE USUARIO SET PASS = ? WHERE USER = ?";
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sqlUpdate);
            stmt.setString(1, uD.getPass());
            stmt.setString(2, uD.getUser());
            stmt.executeUpdate();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                System.out.println("Erro ao alterar os dados" + ex.toString());
            }
        } finally {
            ConnFactory.closeConn(conn, stmt);
        }
    }

    public boolean alterarPass(String pass, String email) {
        String sqlUpdate = "UPDATE USUARIO SET PASS = ? WHERE EMAIL = ?";
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sqlUpdate);
            stmt.setString(1, pass);
            stmt.setString(2, email);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Senha alterada ");
            return true;
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                System.out.println("Erro ao alterar a senha" + ex.toString());
            }
        } finally {
            ConnFactory.closeConn(conn, stmt);
        }
        return false;
    }

    public boolean excluirReg(String email) {
        String sqlDelete = "DELETE FROM USUARIO WHERE EMAIL = ?";
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sqlDelete);
            stmt.setString(1, email);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                System.out.println("Erro ao excluir os dados" + ex.toString());
            }
        } finally {
            ConnFactory.closeConn(conn, stmt);
        }
        return false;
    }

    public ArrayList<User> buscarTodos() {
        ArrayList<User> aL = new ArrayList<>();
        String sqlSelect = "SELECT USER, PASS, EMAIL FROM USUARIO";
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;
        ResultSet rs;
        try {
            stmt = conn.prepareStatement(sqlSelect);
            rs = stmt.executeQuery();
            while (rs.next()) {
                User uD = new User();
                uD.setUser(rs.getString("USER"));
                uD.setPass(rs.getString("PASS"));
                uD.setEmail(rs.getString("EMAIL"));
                aL.add(uD);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar todos os dados" + ex.toString());
        } finally {
            ConnFactory.closeConn(conn, stmt);
        }
        return aL;
    }
}
