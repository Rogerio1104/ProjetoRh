package repository;

import model.Candidato;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CandidatoRepository {

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/db_rh";
        Connection connection = DriverManager.getConnection(url, "root", "");


        return connection;
    }

    public void insere(Candidato candidato) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();

        PreparedStatement stmt = connection.prepareStatement("insert into " +
                "candidato values(?, ?, ?, ?, ?, ?)");
        stmt.setInt(1, candidato.getCodigo());
        stmt.setString(2, candidato.getDescCandidato());
        stmt.setString(3, String.valueOf(candidato.getDataNascimento()));
        stmt.setString(4, (candidato.getCpf()));
        stmt.setString(5, candidato.getDescCurriculo());
        stmt.setString(6, candidato.getDescEmail());

        int i = stmt.executeUpdate();
        System.out.println(i + " linhas inseridas");
        connection.close();

    }

    public Integer proximoCodigo() throws SQLException, ClassNotFoundException {

        List<Candidato> candidatos = new ArrayList<>();

        Connection connection = getConnection();

        PreparedStatement stmt = connection.prepareStatement("select max(cd_candidato) from candidato ");
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {
            return resultSet.getInt(1) + 1;
        }
        return 1;
    }

    public void update(Candidato candidato) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement("update candidato " + "SET ds_candidato = ?, nr_cpf = ? " +
                ", dt_nascimento = ?, ds_curriculo = ?, ds_email = ?  WHERE cd_candidato = ? ");

        stmt.setString(1, candidato.getDescCandidato());
        stmt.setString(2, (candidato.getCpf()));
        stmt.setString(3, String.valueOf(candidato.getDataNascimento()));
        stmt.setString(4, candidato.getDescCurriculo());
        stmt.setString(5, candidato.getDescEmail());
        stmt.setInt(6, candidato.getCodigo());
        int i = stmt.executeUpdate();
        System.out.println(i + "linhas atualizadas");
        connection.close();
    }

    public void delete(Candidato candidato) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement("DELETE FROM candidato " + " WHERE cd_candidato = ? ");

        stmt.setInt(1, candidato.getCodigo().intValue());
        stmt.executeUpdate();
        connection.close();
    }

    public List<Candidato> busca() throws SQLException, ClassNotFoundException {
        List<Candidato> candidatos = new ArrayList<>();
        Connection connection = getConnection();

        PreparedStatement stmt = connection.prepareStatement("select * from candidato");
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {
            Candidato candidato = new Candidato();
            candidato.setCodigo(resultSet.getInt(1));
            candidato.setDescCandidato(resultSet.getString(2));
            candidato.setDataNascimento(LocalDate.parse(resultSet.getString(3)));
            candidato.setCpf(resultSet.getString(4));
            candidato.setDescCurriculo(resultSet.getString(5));
            candidato.setDescEmail(resultSet.getString(6));

            candidatos.add(candidato);
        }
        connection.close();
        return candidatos;

//TODO WHILE
    }
}


