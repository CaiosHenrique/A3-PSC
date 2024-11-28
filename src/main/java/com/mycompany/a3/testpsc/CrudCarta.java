package com.mycompany.a3.testpsc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CrudCarta {
    Connection conexao = ConnFactory.getConn();
    PreparedStatement statement = null;

    public void InsertCarta(Cartas carta) {
        String sqlInsert = "INSERT INTO CARTAS(NOME, TIPO, ATRIBUTO, EFEITO, NIVEL, ATAQUE, DEFESA) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try {
            statement = conexao.prepareStatement(sqlInsert);
            statement.setString(1, carta.getNome());
            statement.setString(2, carta.getTipo());
            statement.setString(3, carta.getAtributo());
            statement.setString(4, carta.getEfeito());
            statement.setInt(5, carta.getNivel());
            statement.setInt(6, carta.getAtaque());
            statement.setInt(7, carta.getDefesa());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao incluir os dados" + e.toString());
        } finally {
            ConnFactory.closeConn(conexao, statement);
        }
    }

    public void DeleteCarta(Cartas carta) {
        String sqlDelete = "DELETE FROM CARTA WHERE NOME = ?";
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

    public void InsertCartaUsuario(int idUsuario, int idCarta) {
        String sqlInsert = "INSERT INTO CARTA_USUARIO(ID_USUARIO, NUMERO_CARTA) VALUES(?, ?)";
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
        String sqlDelete = "DELETE FROM CARTA_USUARIO WHERE ID_USUARIO = ? AND NUMERO_CARTA = ?";
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
        String sqlSelect = "SELECT * FROM CARTA_USUARIO WHERE ID_USUARIO = ?";
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