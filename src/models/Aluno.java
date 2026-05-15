package models;

import java.util.Date;

public class Aluno {
    private String rgm;
    private String nome;
    private String sobrenome;
    private int curso;
    private String cpf;
    private String numeroCelular;
    private String email;
    private Date dataNascimento;
    private String endereco;
    private String municipio;
    private String uf;
    private String genero;
    private String periodo;
   
    public Aluno() {
    }

    public Aluno(String rgm, String nome, String sobrenome, int curso_id, String cpf, String numeroCelular, String email, java.util.Date dataNascimento, String endereco, String municipio, String uf, String genero, String periodo) {

        this.rgm = rgm;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.curso = curso_id;
        this.cpf = cpf;
        this.numeroCelular = numeroCelular;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.municipio = municipio;
        this.uf = uf;
        this.genero = genero;
        this.periodo = periodo;
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
    
    public String getSobrenome() {
    	return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
    	this.sobrenome = sobrenome;
    }

    public int getCurso_id() {
        return curso;
    }
    public void setCurso_id(int curso_id) {
        this.curso = curso_id;
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
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getPeriodo() {
        return periodo;
    }
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
}
