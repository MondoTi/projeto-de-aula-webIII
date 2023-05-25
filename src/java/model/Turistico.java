package model;


public class Turistico {
    private int idTuristico;
    private String ponto;
    private String historia;
    private String regiao;
    private int praca;
    private int monumento;

    public Turistico(String ponto, String historia, String regiao, int praca, int monumento) {
        this.ponto = ponto;
        this.historia = historia;
        this.regiao = regiao;
        this.praca = praca;
        this.monumento = monumento;
    }
    
    public Turistico(){}

    public int getIdTuristico() {
        return idTuristico;
    }

    public void setIdTuristico(int idTuristico) {
        this.idTuristico = idTuristico;
    }

    public String getPonto() {
        return ponto;
    }

    public void setPonto(String ponto) {
        this.ponto = ponto;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public int getPraca() {
        return praca;
    }

    public void setPraca(int praca) {
        this.praca = praca;
    }

    public int getMonumento() {
        return monumento;
    }

    public void setMonumento(int monumento) {
        this.monumento = monumento;
    }
    
    
}
