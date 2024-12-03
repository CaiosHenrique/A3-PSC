package com.mycompany.a3.testpsc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CrudCarta {
    Connection conexao = ConnFactory.getConn();
    PreparedStatement statement = null;

    public int InsertCarta(Cartas carta) {
        String sqlInsert = "INSERT INTO CARTA (NUMERO, NOME, TIPO, ATRIBUTO, EFEITO, NIVEL, ATAQUE, DEFESA) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        int idCarta = 0;
        try {
            statement = conexao.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, carta.getNumero());
            statement.setString(2, carta.getNome());
            statement.setString(3, carta.getTipo());
            statement.setString(4, carta.getAtributo());
            statement.setString(5, carta.getEfeito());
            statement.setInt(6, carta.getNivel());
            statement.setInt(7, carta.getAtaque());
            statement.setInt(8, carta.getDefesa());

            statement.executeUpdate();
    
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                idCarta = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Erro ao incluir os dados" + e.toString());
        
        }
        return idCarta;
    }

    public void DeleteCarta(int id) {
        String sqlDelete = "DELETE FROM CARTA WHERE id = ?";
        try {
            statement = conexao.prepareStatement(sqlDelete);
            statement.setString(1, carta.getNome());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao excluir os dados" + e.toString());
        } finally {
            ConnFactory.closeConn(conexao, statement);
        }
    }

    public void UpdateCarta(Cartas carta) {
        String sqlUpdate = "UPDATE CARTA SET TIPO = ?, ATRIBUTO = ?, EFEITO = ?, NIVEL = ?, ATAQUE = ?, DEFESA = ? WHERE NOME = ?";
        try {
            statement = conexao.prepareStatement(sqlUpdate);
            statement.setString(1, carta.getTipo());
            statement.setString(2, carta.getAtributo());
            statement.setString(3, carta.getEfeito());
            statement.setInt(4, carta.getNivel());
            statement.setInt(5, carta.getAtaque());
            statement.setInt(6, carta.getDefesa());
            statement.setString(7, carta.getNome());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao alterar os dados" + e.toString());
        } finally {
            ConnFactory.closeConn(conexao, statement);
        }
    }

    public void SelectCarta(Cartas carta) {
        String sqlSelect = "SELECT * FROM CARTA WHERE NOME = ?";
        try {
            statement = conexao.prepareStatement(sqlSelect);
            statement.setString(1, carta.getNome());
            statement.executeQuery();
        } catch (Exception e) {
            System.out.println("Erro ao consultar os dados" + e.toString());
        } finally {
            ConnFactory.closeConn(conexao, statement);
        }
    }

    public int GetUsuarioByEmail(String email) {
    String sqlSelect = "SELECT NUMERO FROM USUARIO WHERE EMAIL = ?";
    int idUsuario = 0;
    try {
        statement = conexao.prepareStatement(sqlSelect);
        statement.setString(1, email);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            idUsuario = rs.getInt("NUMERO");
        }
    } catch (Exception e) {
        System.out.println("Erro ao consultar os dados: " + e.toString());
    
    }
    return idUsuario;
}

    public void InsertCartaUsuario(int idUsuario, int idCarta) {
        String sqlInsert = "INSERT INTO cartadousuario(ID_USUARIO, NUMERO_CARTA) VALUES(?, ?)";
        try {
            statement = conexao.prepareStatement(sqlInsert);
            statement.setInt(1, idUsuario);
            statement.setInt(2, idCarta);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao incluir os dados" + e.toString());
        } finally {
            ConnFactory.closeConn(conexao, statement);
        }
    }

    public void DeleteCartaUsuario(int idUsuario, int idCarta) {
        String sqlDelete = "DELETE FROM cartadousuario WHERE ID_USUARIO = ? AND NUMERO_CARTA = ?";
        try {
            statement = conexao.prepareStatement(sqlDelete);
            statement.setInt(1, idUsuario);
            statement.setInt(2, idCarta);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao excluir os dados" + e.toString());
        } finally {
            ConnFactory.closeConn(conexao, statement);
        }
    }

    public void SelectCartaUsuario(int idUsuario) {
        String sqlSelect = "SELECT * FROM cartadousuario WHERE ID_USUARIO = ?";
        try {
            statement = conexao.prepareStatement(sqlSelect);
            statement.setInt(1, idUsuario);
            statement.executeQuery();
        } catch (Exception e) {
            System.out.println("Erro ao consultar os dados" + e.toString());
        } finally {
            ConnFactory.closeConn(conexao, statement);
        }
    }
}