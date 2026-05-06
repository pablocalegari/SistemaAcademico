package models;

public class Nota {
    private double nota;
    private String disciplina;
    private int falta;
    private String semestre;
    // private int alunoId;

    public Nota(double nota, String disciplina, int falta, String semestre){
        this.nota = nota;
        this.disciplina = disciplina;
        this.falta = falta;
        this.semestre = semestre;
    }

    public double getNota() {
        return nota;
    }
    public void setNota(double nota) {
        this.nota = nota;
    }
    
    public String getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public int getFalta() {
        return falta;
    }
    public void setFalta(int falta) {
        this.falta = falta;
    }
    public String getSemestre() {
        return semestre;
    }
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
}
