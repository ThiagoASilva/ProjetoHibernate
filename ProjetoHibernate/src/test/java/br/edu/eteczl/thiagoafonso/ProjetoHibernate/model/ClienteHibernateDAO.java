package br.edu.eteczl.thiagoafonso.ProjetoHibernate.model;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;

import br.edu.eteczl.thiagoafonso.ProjetoHibernate.persistence.IDAO;

public class ClienteHibernateDAO<T> implements IDAO<T>{

	Logger logger = Logger.getLogger(ClienteHibernateDAO.class.getName());
	private Transaction currentTransaction;
	Session session;
	
	public ClienteHibernateDAO(Session session) {
		this.session = session;
	}
	
	public int encontrarPeloNome(String nome) {
		logger.info("public int encontrarPeloNome(String nome) { ..");
		CriteriaBuilder cb = this.session.getCriteriaBuilder();
		CriteriaQuery<Cliente> qry = cb.createQuery(Cliente.class);
		Root<Cliente> from = qry.from(Cliente.class);
		qry.select(from);
		qry.where(cb.and(
				cb.equal(from.get("nome"), nome)//,cB.equal(from.get("OutroCampo"), vlrParaProcurar)
				));
		Query<Cliente> createdQuery = session.createQuery(qry);
		List<Cliente> resultList = createdQuery.getResultList();
		return resultList().size();
	}
	
	public void persistir(T o) {
		session.save(o);		
	}
	
	public void excluiTodos() {
		CriteriaBuilder cB = this.session.getCriteriaBuilder();
		CriteriaDelete<Cliente> qryDelete = cB.createCriteriaDelete(Cliente.class);
		Root<Cliente> deleteFrom = qryDelete.from(Cliente.class);
		this.session.createCriteria(qryDelete).executeUpdate();
	}
	
	public List<T> Listar(){
		CriteriaBuilder cB = this.session.getCriteriaBuilder();
		CriteriaQuery<Cliente> qry = cB.createQuery(Cliente.class);
		qry.select(qry.from(cliente.class));
		Query<T> createdQuery = (Query<T>) this.session.createCriteria(qry);
		return createdQuery.getResultList();
	}

	public void excluir(Integer id) {
		this.session.remove(id);
		
	}

	public void alterar(T e) {
		this.session.merge(e);
		
	}

	public T encontrarPeloId(Integer id) {
		return (T) this.session.byId(Cliente.class).load(id);
	}

	public void closeSession() {
		this.session.close();
	}
	
	public void beginTransaction() {
		this.currentTransaction = this.session.beginTransaction();
	}
	
	public void commit() {
		this.currentTransaction.commit();
	}
}
