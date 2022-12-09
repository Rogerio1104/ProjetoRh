package repository;

import model.Candidato;
import model.Vaga;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class VagaDAO implements IGenericDAO<Vaga>{

    static List<Vaga> vagas = new ArrayList<>();



    @Override
    public void salvar(Vaga objeto) throws SQLException, ClassNotFoundException {

        VagaRepository vagaRepository = new VagaRepository();

        if(objeto.getCodigoVaga() != null){
            vagaRepository.update(objeto);
        }else{
            objeto.setCodigoVaga(vagaRepository.proximoCodigo());
            vagaRepository.insere(objeto);

        }

    }

    @Override
    public void remover(Vaga objeto) throws SQLException, ClassNotFoundException {
        VagaRepository vagaRepository = new VagaRepository();
        vagaRepository.delete(objeto);

    }

    @Override
    public List<Vaga> buscarTodos() {
        VagaRepository vagaRepository = new VagaRepository();
        try {
            vagas = vagaRepository.busca();
        } catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }

        System.out.println(vagas);
        return vagas;
    }

    @Override
    public List<Vaga> buscarPorNome(String nome) {
        List<Vaga> vagasFiltradas = new ArrayList<>();
        for (Vaga vaga : vagas) {
            if (vaga.getDescVaga().contains(nome)) {
                vagasFiltradas.add(vaga);
            }
        }
        return vagasFiltradas;
    }

    public Object[] findVagaInArray(){
        List<Vaga> vagas = buscarTodos();
        List<String> vagasNomes = new ArrayList<>();

        for(Vaga vaga : vagas){
            vagasNomes.add(vaga.getDescVaga());
        }
        return vagasNomes.toArray();
    }

}
