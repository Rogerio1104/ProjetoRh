package repository;

import model.Candidato;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class CandidatoDAO implements IGenericDAO<Candidato> {

    static List<Candidato> candidatos = new ArrayList<>();


    @Override
    public void salvar(Candidato objeto) throws SQLException, ClassNotFoundException {

        CandidatoRepository candidatoRepository = new CandidatoRepository();

        if(objeto.getCodigo() != null){
            candidatoRepository.update(objeto);
        }else{
            objeto.setCodigo(candidatoRepository.proximoCodigo());
            candidatoRepository.insere(objeto);
        }


    }

    @Override
    public void remover(Candidato objeto) throws SQLException, ClassNotFoundException {
        CandidatoRepository candidatoRepository = new CandidatoRepository();
        candidatoRepository.delete(objeto);

    }

    @Override
    public List<Candidato> buscarTodos() {
        CandidatoRepository   candidatoRepository = new CandidatoRepository();
        try {
            candidatos = candidatoRepository.busca();
        } catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }

        System.out.println(candidatos);
        return candidatos;

    }

    @Override
    public List<Candidato> buscarPorNome(String nome) {
        List<Candidato> candidatosFiltrados = new ArrayList<>();
        for (Candidato candidato : candidatos) {
            if (candidato.getDescCandidato().contains(nome)) {
                candidatosFiltrados.add(candidato);
            }
        }
        return candidatosFiltrados;
    }

    public Object[] findCandidatoInArray() {
        List<Candidato> candidatos = buscarTodos();
        List<String> candidatosNomes = new ArrayList<>();

        for (Candidato candidato : candidatos) {
            candidatosNomes.add(candidato.getDescCandidato());
        }

        return candidatosNomes.toArray();
    }

}
