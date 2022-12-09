import model.Candidato;
import model.ProcessoSeletivo;
import model.Status;
import model.Vaga;
import repository.CandidatoDAO;
import repository.ProcessoSeletivoDAO;
import repository.VagaDAO;

import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//    try {
        menuOpcaoSistemas();
//    }catch (Exception e){
//        JOptionPane.showMessageDialog(null,"Erro no sistema!\n Entre em contato com o suporte!!!",
//                "ERRO", 0);;
//    }
    }
    private static void chamaConfirmacaoVaga() throws SQLException, ClassNotFoundException {
        Integer opcaoCrud = chamaOpcaoCrud();
        Vaga vaga = null;
        switch (opcaoCrud){
            case 0: //inserir
                vaga = chamaCadastroVagas();
                break;

            case 1: //alterar, tem que fazer as opcoes de alteracao
                vaga = selecaoVaga();
                vaga = editaVaga(vaga);
                VagaDAO vagaDAO = new VagaDAO();
                vagaDAO.salvar(vaga);
                break;

            case 2: //excluir, tem que fazer isso tambem
                vaga = selecaoVaga();
                getVagaDAO().remover(vaga);
                vaga = null;
                break;
        }

    }

    private static Vaga selecaoVaga(){
        Object[] selectionValues = getVagaDAO().findVagaInArray();
        String initialSelection = (String) selectionValues[1];
        Object selection = JOptionPane.showInputDialog(null, "Selecione a vaga: ",
         "TESTETETA", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Vaga> vagas = getVagaDAO().buscarPorNome((String) selection);
        return vagas.get(0);
    }

    private static void chamaConfirmacaoCandidato() throws SQLException, ClassNotFoundException {
        Integer opcaoCrud = chamaOpcaoCrud();
        Candidato candidato = null;
        switch (opcaoCrud){
            case 0: //inserir
                candidato = chamaCadastroCandidato();
                break;

            case 1: //alterar, tem que fazer as opcoes de alteracao
                candidato = selecaoDeCandidato();
                candidato = editaCandidato(candidato);
                CandidatoDAO candidatoDAO = new CandidatoDAO();
                candidatoDAO.salvar(candidato);
                break;

            case 2: //excluir, tem que fazer isso tambem
                candidato = selecaoDeCandidato();
                getCandidatoDAO().remover(candidato);
                candidato = null;
                break;
        }


    }
    private static Vaga editaVaga(Vaga vagaEdit) {
        Vaga vaga = new Vaga();
        Object[] status = {Status.ABERTO,Status.ANDAMENTO,Status.CONCLUIDO};
        Object selecionado = JOptionPane.showInputDialog(null, "Selecione qual o status da vaga:",
                "MENU", 1, null, status, " ");

        if(String.valueOf(selecionado).equals(Status.ABERTO.name())){
            vaga.setStatusVaga(Status.ABERTO);
        }else if (String.valueOf(selecionado).equals(Status.ANDAMENTO)){
            vaga.setStatusVaga(Status.ANDAMENTO);
        }else if (String.valueOf(selecionado).equals(Status.CONCLUIDO)){
            vaga.setStatusVaga(Status.CONCLUIDO);
        }
//        String statusVaga = JOptionPane.showInputDialog(null, "Digite a descrição do candidato: ", vagaEdit.getStatusVaga());
        String descVaga = JOptionPane.showInputDialog(null, "Digite a descrição da vaga: ", vagaEdit.getDescVaga());
        LocalDate dataInicio = LocalDate.parse(JOptionPane.showInputDialog(null, "Digite a data de inicio da vaga: ", vagaEdit.getDataInicio()));
        LocalDate dataFim = LocalDate.parse(JOptionPane.showInputDialog(null, "Digite a data de fim da vaga: ", vagaEdit.getDataFim()));
        String descRequisitos = JOptionPane.showInputDialog(null, "Digite os requisitos da vaga: ", vagaEdit.getDescRequisitos());


        vaga.setDescVaga(descVaga);
        vaga.setDataInicio(dataInicio);
        vaga.setDataFim(dataFim);
        vaga.setDescRequisitos(descRequisitos);

        return vaga;

    }

    private static void chamaRelatorioCandidato(){
        List<Candidato> candidatos = getCandidatoDAO().buscarTodos();

    }


    private static Candidato selecaoDeCandidato() throws SQLException, ClassNotFoundException {
        Object[] selectionValues = getCandidatoDAO().findCandidatoInArray();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione o candidato: ",
                "Candidato", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Candidato> candidatos = getCandidatoDAO().buscarPorNome((String) selection);
        return candidatos.get(0);
    }

    private static Candidato editaCandidato(Candidato candidatoEdit) {
        String descCandidato = JOptionPane.showInputDialog(null, "Digite a descrição do candidato: ", candidatoEdit.getDescCandidato());
        LocalDate dataNascimento = LocalDate.parse(JOptionPane.showInputDialog(null, "Digite a data de nascimento: ", candidatoEdit.getDataNascimento()));
        String cpf = JOptionPane.showInputDialog(null, "Digite o cpf: ", candidatoEdit.getCpf());
        String descCurriculo = JOptionPane.showInputDialog(null, "Digite a descrição do curriculo: ", candidatoEdit.getDescCurriculo());
        String email = JOptionPane.showInputDialog(null,"Digite o email: ",candidatoEdit.getDescEmail());

        Candidato candidato = new Candidato();
        candidato.setDescCandidato(descCandidato);
        candidato.setDataNascimento(dataNascimento);
        candidato.setCpf(cpf);
        candidato.setDescCurriculo(descCurriculo);
        candidato.setDescEmail(email);
        candidato.setCodigo(candidatoEdit.getCodigo());

        return candidato;

    }




    private static Integer chamaOpcaoCrud(){
        String[] opcao = {"Inserção", "Alteração", "Exclusão"};
        int tipoOpcao = JOptionPane.showOptionDialog(null,"Escolha uma opção: ",
                "Operação no cadastro: ",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null,opcao,
                opcao[0]);
        return tipoOpcao;
    }


    private static void chamaConfirmacaoProcessoSeletivo() throws SQLException, ClassNotFoundException {
        Integer opcaoCrud = chamaOpcaoCrud();
        ProcessoSeletivo processoSeletivo = null;
        switch (opcaoCrud){
            case 0: //inserir
                processoSeletivo = chamaProcessoSeletivo();
                break;

            case 1: //alterar, tem que fazer as opcoes de alteracao
                break;

            case 2: //excluir, tem que fazer isso tambem
        }
    }
    private static ProcessoSeletivo chamaProcessoSeletivo() throws SQLException, ClassNotFoundException {
        List<ProcessoSeletivo> processoSeletivos = new ArrayList<>();
        ProcessoSeletivo processoSeletivo = new ProcessoSeletivo();
        processoSeletivos.add(processoSeletivo);

        String[] opcaoMenuProcessoSeletivo = {"DADOS", "VOLTAR"};
        int menuCadastroProcessoSeletivo = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu Cadastro Processo Seletivo",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcaoMenuProcessoSeletivo, opcaoMenuProcessoSeletivo[0]);

        switch (menuCadastroProcessoSeletivo) {
            case 0:
                String dsStatusProcessoSeletivo = JOptionPane.showInputDialog("Escreva a descrição do status do processo seletivo: ");
                processoSeletivo.setDescStatusProcesso(dsStatusProcessoSeletivo);



                processoSeletivos.add(processoSeletivo);
                ProcessoSeletivoDAO.save(processoSeletivo);

                chamaProcessoSeletivo();
                break;

            case 1:
                menuOpcaoSistemas();
                break;
        }
        ProcessoSeletivoDAO.save(processoSeletivo);
        return processoSeletivo;
    }


    private static Candidato chamaCadastroCandidato() throws SQLException, ClassNotFoundException {

        List<Candidato> candidatos = new ArrayList<>();
        Candidato candidato = new Candidato();
        candidatos.add(candidato);

        String[] opcaoMenuCandidato = {"DADOS", "VOLTAR"};
        int menuCadastroCurriculo = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu Cadastro",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcaoMenuCandidato, opcaoMenuCandidato[0]);

        switch (menuCadastroCurriculo) {
            case 0:
                String dsCandidato = JOptionPane.showInputDialog("Escreva a descrição do candidato: ");
                candidato.setDescCandidato(dsCandidato);

                String dtNascimento = JOptionPane.showInputDialog("Escreva a sua data de nascimento: ");
                candidato.setDataNascimento(LocalDate.parse(dtNascimento));

                String cpf = JOptionPane.showInputDialog("Escreva seu cpf: ");
                candidato.setCpf(cpf);

                String descCurriculo = JOptionPane.showInputDialog("Escreva a descrição do seu curriculo: ");
                candidato.setDescCurriculo(descCurriculo);

                String descEmail = JOptionPane.showInputDialog("Escreva o seu email: ");
                candidato.setDescEmail(descEmail);

                candidatos.add(candidato);
                CandidatoDAO candidatoDAO = new CandidatoDAO();

                candidatoDAO.salvar(candidato);

                chamaCadastroCandidato();
                break;

            case 1:
                menuOpcaoSistemas();
                break;
        }

        return candidato;
    }



    private static Vaga
    chamaCadastroVagas() throws SQLException, ClassNotFoundException {
        List<Vaga> vagas = new ArrayList<>();
        Vaga vaga = new Vaga();
        vagas.add(vaga);
        String[] opcaoMenuVaga = {"DADOS", "VOLTAR"};
        int menuCadastroVaga = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu Cadastro",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcaoMenuVaga, opcaoMenuVaga[0]);

        switch (menuCadastroVaga) {
            case 0:

                Object[] status = {Status.ABERTO,Status.ANDAMENTO,Status.CONCLUIDO};
                Object selecionado = JOptionPane.showInputDialog(null, "Selecione qual o status da vaga:",
                        "MENU", 1, null, status, " ");

                if(String.valueOf(selecionado).equals(Status.ABERTO.name())){
                    vaga.setStatusVaga(Status.ABERTO);
                }else if (String.valueOf(selecionado).equals(Status.ANDAMENTO)){
                    vaga.setStatusVaga(Status.ANDAMENTO);
                }else if (String.valueOf(selecionado).equals(Status.CONCLUIDO)){
                    vaga.setStatusVaga(Status.CONCLUIDO);
                }


                String dsVaga = JOptionPane.showInputDialog("Escreva a descrição da vaga: ");
                vaga.setDescVaga(dsVaga);

                String dsRequisitos = JOptionPane.showInputDialog("Escreva a descrição dos requisitos: ");
                vaga.setDescRequisitos(dsRequisitos);

                LocalDate dtInicio = LocalDate.parse(JOptionPane.showInputDialog("Digite a data inicio da vaga: "));
                vaga.setDataInicio(dtInicio);

                LocalDate dtFim = LocalDate.parse(JOptionPane.showInputDialog("Digite a data fim da vaga: "));
                vaga.setDataFim(dtFim);

                vagas.add(vaga);

                VagaDAO vagaDAO = new VagaDAO();
                vagaDAO.salvar(vaga);


                chamaCadastroVagas();
                break;

            case 1:
                menuOpcaoSistemas();
                break;
        }
        return vaga;
    }

    static Object menuOpcaoSistemas() throws SQLException, ClassNotFoundException {
        Object[] opcaoInicial = {Candidato.CargosSistema.RH, Candidato.CargosSistema.CANDIDATO, Candidato.CargosSistema.PROCESSOSELETIVO};
        Object selecionado = JOptionPane.showInputDialog(null, "Selecione qual sistema você quer acessar:",
                "MENU", 1, null, opcaoInicial, " ");

        if (selecionado == (Candidato.CargosSistema.RH)) {
            chamaRh();
        } else if (selecionado == (Candidato.CargosSistema.CANDIDATO)) {
            chamaCandidato();
        }else if(selecionado == Candidato.CargosSistema.PROCESSOSELETIVO){
            chamaProcessoSeletivo();
        }
        return selecionado;
    }

    private static void chamaRh() throws SQLException, ClassNotFoundException {
        chamaConfirmacaoVaga();
    }

    private static void chamaCandidato() throws SQLException, ClassNotFoundException {
        chamaConfirmacaoCandidato();
    }

    public static CandidatoDAO getCandidatoDAO(){
        CandidatoDAO candidatoDAO = new CandidatoDAO();
        return candidatoDAO;
    }

    public static ProcessoSeletivoDAO getProcessoSeletivoDAO(){
        ProcessoSeletivoDAO processoSeletivoDAO = new ProcessoSeletivoDAO();
        return processoSeletivoDAO;
    }

    public static VagaDAO getVagaDAO(){
        VagaDAO vagaDAO = new VagaDAO();
        return vagaDAO;
    }

}

