package models;

import java.sql.Date;

import javafx.scene.chart.PieChart.Data;

public class Aluno {
    private int rgm;
    private String nome;
    private int curso;
    private String cpf;
    private int numeroCelular;
    private String email;
    private Date dataNascimento;
    private String endereco;

    public Aluno(int rgm, String nome, int curso, String cpf, int numeroCelular, String email, java.util.Date dataNascimento2, String endereco){
        this.rgm = rgm;
        this.nome = nome;
        this.curso = curso;
        this.cpf = cpf;
        this.numeroCelular = numeroCelular;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public int getRgm() {
        return rgm;
    }
    public void setRgm(int rgm) {
        this.rgm = rgm;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCurso() {
        return curso;
    }
    public void setCurso(int curso) {
        this.curso = curso;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumeroCelular() {
        return numeroCelular;
    }
    public void setNumeroCelular(int numeroCelular) {
        this.numeroCelular = numeroCelular;
    }
}
