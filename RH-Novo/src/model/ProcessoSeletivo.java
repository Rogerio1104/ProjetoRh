package model;

import java.time.LocalDate;

public class ProcessoSeletivo {

    private Integer codigoProcesso;
    private Integer cdVaga;
    private Integer cdCandidato;
    private String descStatusProcesso;

    public Integer getCodigoProcesso() {
        return codigoProcesso;
    }

    public void setCodigoProcesso(Integer codigoProcesso) {
        this.codigoProcesso = codigoProcesso;
    }

    public Integer getCdVaga() {
        return cdVaga;
    }

    public void setCdVaga(Integer cdVaga) {
        this.cdVaga = cdVaga;
    }

    public Integer getCdCandidato() {
        return cdCandidato;
    }

    public void setCdCandidato(Integer cdCandidato) {
        this.cdCandidato = cdCandidato;
    }

    public String getDescStatusProcesso() {
        return descStatusProcesso;
    }

    public void setDescStatusProcesso(String descStatusProcesso) {
        this.descStatusProcesso = descStatusProcesso;
    }
}
