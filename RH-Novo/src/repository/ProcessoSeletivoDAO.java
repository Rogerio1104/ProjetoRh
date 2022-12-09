package repository;

import model.ProcessoSeletivo;
import model.Vaga;

import java.util.ArrayList;
import java.util.List;

public class ProcessoSeletivoDAO {
    private static List<ProcessoSeletivo> processoSeletivos = new ArrayList<>();

    public static List<ProcessoSeletivo> findProcessoSeletivo(){return processoSeletivos;}

    public static void save(ProcessoSeletivo processoSeletivo){processoSeletivos.add(processoSeletivo);}

    public static void save(List<ProcessoSeletivo> processoSeletivoList){processoSeletivos.addAll(processoSeletivoList);}
}
