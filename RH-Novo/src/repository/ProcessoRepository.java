package repository;

import model.Candidato;
import model.ProcessoSeletivo;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProcessoRepository {

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/db_rh";
        Connection connection = DriverManager.getConnection(url, "root", "");


        return connection;
    }

    public void insere(ProcessoSeletivo processo) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();

        PreparedStatement stmt = connection.prepareStatement("insert into " +
                "processo_seletivo values(?, ?, ?, ?,)");

        stmt.setInt(1, processo.getCodigoProcesso());
        stmt.setInt(2, processo.getCdVaga());
        stmt.setInt(3, processo.getCdCandidato());
        stmt.setString(4,processo.getDescStatusProcesso());

        int i = stmt.executeUpdate();
        System.out.println(i + " linhas inseridas");
        connection.close();

    }
    public Integer proximoCodigo() throws SQLException, ClassNotFoundException {

        List<ProcessoSeletivo> processo = new ArrayList<>();

        Connection connection = getConnection();

        PreparedStatement stmt = connection.prepareStatement("select max(cd_processo) from processo_seletivo ");
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {
            return resultSet.getInt(1) + 1;
        }
        return 1;
    }
    public void update(ProcessoSeletivo processo) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement("update processo_seletivo " + "SET cd_vaga = ?, cd_candidato = ?  " +
                 "ds_status_processo WHERE cd_processo = ? ");

        stmt.setInt(1,processo.getCdVaga());
        stmt.setInt(2,processo.getCdCandidato());
        stmt.setString(3,processo.getDescStatusProcesso());
        stmt.setInt(1,processo.getCodigoProcesso());

        int i = stmt.executeUpdate();
        System.out.println(i + "linhas atualizadas");
        connection.close();
    }

    public void delete(ProcessoSeletivo processo) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement("DELETE FROM candidato " + " WHERE cd_candidato = ? ");

        stmt.setInt(1, processo.getCodigoProcesso());
        stmt.executeUpdate();
        connection.close();
    }

    public List<ProcessoSeletivo> busca() throws SQLException, ClassNotFoundException {
        List<ProcessoSeletivo> processos = new ArrayList<>();
        Connection connection = getConnection();

        PreparedStatement stmt = connection.prepareStatement("select * from processo_seletivo");
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {

            ProcessoSeletivo processo = new ProcessoSeletivo();

            processo.setCodigoProcesso(resultSet.getInt(1));
            processo.setCdVaga(resultSet.getInt(2));
            processo.setCdCandidato(resultSet.getInt(3));
            processo.setDescStatusProcesso(resultSet.getString(4));


            processos.add(processo);
        }
        connection.close();
        return processos;

//TODO WHILE
    }
}


