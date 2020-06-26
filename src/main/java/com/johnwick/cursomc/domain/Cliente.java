package com.johnwick.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.johnwick.cursomc.domain.enums.Perfil;
import com.johnwick.cursomc.domain.enums.TipoCliente;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@Entity
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    @Column(unique=true)
    private String email;
    private String cpfOuCnpj;
    private Integer tipo;

    @JsonIgnore
    private String senha;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Endereco> enderecos =  new ArrayList<>();

    @ElementCollection
    @CollectionTable(name="telefone")
    private Set<String> telefones = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList<>();

    @ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable(name="PERFIS")
    private Set<Integer> perfis = new HashSet<>();

    public Cliente() {
        addPerfil(Perfil.CLIENTE);
    }

    public Cliente(Integer id, String nome, String email, String cpfOuCnpj, TipoCliente tipo, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipo = (tipo == null) ? null : tipo.getCod();
        this.senha = senha;
        addPerfil(Perfil.CLIENTE);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public TipoCliente getTipo() throws IllegalAccessException {
        return TipoCliente.toEnum(tipo);
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo.getCod();
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(x -> {
            try {
                return Perfil.toEnum(x);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toSet());
    }

    public void addPerfil(Perfil perfil) {
        perfis.add(perfil.getCod());
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Set<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<String> telefones) {
        this.telefones = telefones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(getId(), cliente.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
