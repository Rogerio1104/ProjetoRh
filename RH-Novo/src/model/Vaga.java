package model;

import java.time.LocalDate;

public class Vaga  {
    private Integer codigoVaga;
    private String descVaga;
    private String descRequisitos;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Status statusVaga;

    public Status getStatusVaga() {
        return statusVaga;
    }

    public void setStatusVaga(Status statusVaga) {
        this.statusVaga = statusVaga;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Integer getCodigoVaga() {
        return codigoVaga;
    }

    public void setCodigoVaga(Integer codigoVaga) {
        this.codigoVaga = codigoVaga;

    }

    public String getDescVaga() {
        return descVaga;
    }

    public void setDescVaga(String descVaga) {
        this.descVaga = descVaga;
    }

    public String getDescRequisitos() {
        return descRequisitos;
    }

    public void setDescRequisitos(String descRequisitos) {
        this.descRequisitos = descRequisitos;
    }
}
