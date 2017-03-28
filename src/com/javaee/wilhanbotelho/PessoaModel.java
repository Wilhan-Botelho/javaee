package com.javaee.wilhanbotelho;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Table;

@Entity
@Table(name="pessoa")
public class PessoaModel {
	@Id
	@GeneratedValue
	private int id;
	private String nome  = null;
	private String email = null;
	private boolean ativo = false;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
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
	
	public void Salva(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pessoa");
	    EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    if(this.id != 0){
	    	em.merge(this);
	    }else{
	    	em.persist(this);
	    }
	    em.getTransaction().commit();
	    em.close();
	}

	public PessoaModel Busca(int id){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pessoa");
	    EntityManager em = emf.createEntityManager();
	    PessoaModel pessoa = em.find(PessoaModel.class, id);
	    em.close();
	    return pessoa;
	}
	public PessoaModel Deleta(int id){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pessoa");
	    EntityManager em = emf.createEntityManager();
	    PessoaModel pessoa = em.find(PessoaModel.class, id);
	    em.getTransaction().begin();
	    em.remove(pessoa);
	    em.getTransaction().commit();
	    em.close();
	    return pessoa;
	}
	public List<PessoaModel> BuscaTodos(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pessoa");
	    EntityManager em = emf.createEntityManager();
	    Query query = em.createQuery("select t from PessoaModel as t");
		List<PessoaModel> lista = query.getResultList();
	    em.close();
	    return lista;
	}
}