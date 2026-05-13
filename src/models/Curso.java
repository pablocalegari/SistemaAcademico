package models;

public class Curso {
    private String nome;
    private String campus;
    private String periodo;

    public Curso(String nome, String campus, String periodo){
        this.nome = nome;
        this.campus = campus;
        this.periodo = periodo;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCampus() {
        return campus;
    }
    public void setCampus(String campus) {
        this.campus = campus;
    }
    
    public String getPeriodo() {
        return periodo;
    }
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
}
