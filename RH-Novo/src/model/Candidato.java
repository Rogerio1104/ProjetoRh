package model;

import java.time.LocalDate;

public class Candidato {
    private Integer codigo;
    private String descCandidato;
    private String dataNascimento;
    private String cpf;
    private String descCurriculo;
    private String descEmail;
//teste push
    public enum CargosSistema{
        RH,
        CANDIDATO,
        PROCESSOSELETIVO,
        RELATORIOS;
    }


public Integer getCodigo() {
        return codigo;
    }
  

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescCandidato() {
        return descCandidato;
    }

    public void setDescCandidato(String descCandidato) {
        this.descCandidato = descCandidato;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = String.valueOf(dataNascimento);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDescCurriculo() {
        return descCurriculo;
    }

    public void setDescCurriculo(String descCurriculo) {
        this.descCurriculo = descCurriculo;
    }

    public String getDescEmail() {
        return descEmail;
    }

    public void setDescEmail(String descEmail) {
        this.descEmail = descEmail;
    }
}
