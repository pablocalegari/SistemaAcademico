package models;

import java.util.Date;

public class Aluno {
    private String rgm;
    private String nome;
    private int curso;
    private String cpf;
    private String numeroCelular;
    private String email;
    private Date dataNascimento;
    private String endereco;
    private String municipio;
    private String uf;

    public Aluno(String rgm, String nome, int curso, String cpf, String numeroCelular, String email, java.util.Date dataNascimento, String endereco, String municipio, String uf) {
        this.rgm = rgm;
        this.nome = nome;
        this.curso = curso;
        this.cpf = cpf;
        this.numeroCelular = numeroCelular;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.municipio = municipio;
        this.uf = uf;
    }

    public String getRgm() {
        return rgm;
    }
    public void setRgm(String rgm) {
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

    public String getNumeroCelular() {
        return numeroCelular;
    }
    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getMunicipio() {
        return municipio;
    }
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUf() {
        return uf;
    }
    public void setUf(String uf) {
        this.uf = uf;
    }
}
