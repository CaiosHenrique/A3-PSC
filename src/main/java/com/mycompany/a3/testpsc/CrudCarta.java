package com.mycompany.a3.testpsc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

public class CrudCarta {
    Connection conexao = ConnFactory.getConn();
    PreparedStatement statement = null;

    public int InsertCarta(Cartas carta) {
        String sqlInsert = "INSERT INTO CARTA (NOME, TIPO, ATRIBUTO, EFEITO, NIVEL, ATAQUE, DEFESA) VALUES (?, ?, ?, ?, ?, ?, ?)";
        int idCarta = 0;
        try {
            statement = conexao.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, carta.getNome());
            statement.setString(2, carta.getTipo());
            statement.setString(3, carta.getAtributo());
            statement.setString(4, carta.getEfeito());
            statement.setInt(5, carta.getNivel());
            statement.setInt(6, carta.getAtaque());
            statement.setInt(7, carta.getDefesa());

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

    public void DeleteCarta(int id) {
        String sqlDelete = "DELETE FROM CARTA WHERE numero = ?";
        try {
            statement = conexao.prepareStatement(sqlDelete);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao excluir os dados" + e.toString());
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
        }
    }

    public ArraayList<integer> SelectIdCartaUsuario(int id) {
        String sqlSelect = "SELECT numero_carta FROM cartadousuario WHERE ID_USUARIO = ?";
        ArrayList<Integer> cartas = new ArrayList<Integer>();
        try {
            statement = conexao.prepareStatement(sqlSelect);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                cartas.add(rs.getInt("numero_carta"));
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar os dados" + e.toString());
        }
        return cartas;
    }

    public ArrayList<Cartas> GetCartasByArrayId(ArrayList<Integer> cartas) {
        String sqlSelect = "SELECT * FROM CARTA WHERE NUMERO = ?";
        ArrayList<Cartas> cartasUsuario = new ArrayList<Cartas>();
        try {
            statement = conexao.prepareStatement(sqlSelect);
            for (int i = 0; i < cartas.size(); i++) {
                statement.setInt(1, cartas.get(i));
                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    Cartas carta = new Cartas();
                    carta.setNumero(rs.getInt("numero"));
                    carta.setNome(rs.getString("nome"));
                    carta.setTipo(rs.getString("tipo"));
                    carta.setAtributo(rs.getString("atributo"));
                    carta.setEfeito(rs.getString("efeito"));
                    carta.setNivel(rs.getInt("nivel"));
                    carta.setAtaque(rs.getInt("ataque"));
                    carta.setDefesa(rs.getInt("defesa"));
                    cartasUsuario.add(carta);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar os dados" + e.toString());
        } finally {
            ConnFactory.closeConn(conexao, statement);
        }
        return cartasUsuario;
    }

    public Cartas GetCartaById(int id) {
        String sqlSelect = "SELECT * FROM CARTA WHERE NUMERO = ?";
        Cartas carta = new Cartas();
        try {
            statement = conexao.prepareStatement(sqlSelect);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                carta.setNumero(rs.getInt("numero"));
                carta.setNome(rs.getString("nome"));
                carta.setTipo(rs.getString("tipo"));
                carta.setAtributo(rs.getString("atributo"));
                carta.setEfeito(rs.getString("efeito"));
                carta.setNivel(rs.getInt("nivel"));
                carta.setAtaque(rs.getInt("ataque"));
                carta.setDefesa(rs.getInt("defesa"));
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar os dados" + e.toString());
        } finally {
            ConnFactory.closeConn(conexao, statement);
        }
        return carta;
    }

    public int GetUsuarioByEmail(String email) {
        String sqlSelect = "SELECT * FROM USUARIO WHERE EMAIL = ?";
        int idUsuario = 0;
        try {
            statement = conexao.prepareStatement(sqlSelect);
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                idUsuario = rs.getInt("id");
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar os dados: " + e.toString());

        }
        return idUsuario;
    }

    public void UpdateCarta(Cartas carta) {
        String sqlUpdate = "UPDATE CARTA SET NOME = ?, TIPO = ?, ATRIBUTO = ?, EFEITO = ?, NIVEL = ?, ATAQUE = ?, DEFESA = ? WHERE NUMERO = ?";
        try {
            statement = conexao.prepareStatement(sqlUpdate);
            statement.setString(1, carta.getNome());
            statement.setString(2, carta.getTipo());
            statement.setString(3, carta.getAtributo());
            statement.setString(4, carta.getEfeito());
            statement.setInt(5, carta.getNivel());
            statement.setInt(6, carta.getAtaque());
            statement.setInt(7, carta.getDefesa());
            statement.setInt(8, carta.getNumero());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao atualizar os dados" + e.toString());
        } finally {
            ConnFactory.closeConn(conexao, statement);
        }
    }

}