/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.mysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.mAutores;

public class cAutores {

    public void cadastrar(mAutores modelA) {
        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO autores (Còdigo, Nome, Endereco, Bairro, Número, Cidade, CPF)"
                    + " VALUES (?,?,?,?,?,?,?) ");
            stmt.setInt(1, modelA.getId_autores());
            stmt.setString(2, modelA.getNome());
            stmt.setString(3, modelA.getEndereco());
            stmt.setString(4, modelA.getBairro());
            stmt.setString(5, modelA.getNumero());
            stmt.setString(6, modelA.getCidade());
            stmt.setString(7, modelA.getCPF());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Autores cadastrados com sucesso!"
            );

        } catch (SQLException ex) {
            Logger.getLogger(cAutores.class.getName()).log(Level.SEVERE, null,
                    ex);
        }

    }

    public List<mAutores> listar() {

        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<mAutores> lista = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT * FROM autores");
            rs = stmt.executeQuery();

            while (rs.next()) {
                mAutores modelA = new mAutores();
                modelA.setId_autores(rs.getInt("id_autores"));
                modelA.setNome(rs.getString("nome"));
                modelA.setNome(rs.getString("Endereço"));
                modelA.setNome(rs.getString("Bairro"));
                modelA.setNome(rs.getString("Número"));
                modelA.setNome(rs.getString("Cidade"));
                modelA.setNome(rs.getString("CPF"));

                lista.add(modelA);

            }

        } catch (SQLException ex) {
            Logger.getLogger(cAutores.class.getName()).log(Level.SEVERE, null,
                    ex);
        }

        return lista;

    }

    public List<mAutores> pesquisar(String texto) {

        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<mAutores> lista = new ArrayList<>();

        try {

            stmt = conn.prepareStatement("SELECT * FROM autores WHERE nome like ?");
            stmt.setString(1, "%" + texto + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                mAutores modelA = new mAutores();
                modelA.setId_autores(rs.getInt("id_autores"));
                modelA.setNome(rs.getString("nome"));
                modelA.setNome(rs.getString("Endereço"));
                modelA.setNome(rs.getString("Bairro"));
                modelA.setNome(rs.getString("Número"));
                modelA.setNome(rs.getString("Cidade"));
                modelA.setNome(rs.getString("CPF"));

                lista.add(modelA);

            }

        } catch (SQLException ex) {
            Logger.getLogger(cAutores.class.getName()).log(Level.SEVERE, null,
                    ex);
        }

        return lista;

    }

    public void Alterar(mAutores modelA) {
        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("UPDATE autores SET nome = ? WHERE id_autores");
            stmt.setString(1, modelA.getNome());
            stmt.setInt(2, modelA.getId_autores());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Autores alterados com sucesso!"
            );

        } catch (SQLException ex) {
            Logger.getLogger(cAutores.class.getName()).log(Level.SEVERE, null,
                    ex);
        }

    }
}
