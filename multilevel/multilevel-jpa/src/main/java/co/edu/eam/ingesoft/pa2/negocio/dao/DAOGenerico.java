package co.edu.eam.ingesoft.pa2.negocio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


public class DAOGenerico {


	private EntityManager em;

	private Class clase;


	public DAOGenerico(EntityManager em, Class clase) {
		super();
		this.em = em;
		this.clase = clase;
	}

	
	public void crear(Object obj) {
		em.persist(obj);
	}

	
	public void editar(Object obj) {
		em.merge(obj);
	}


	public void borrar(Object obj) {
		em.remove(em.contains(obj)? obj : em.merge(obj));
	}


	public <T> T buscar(Object pk) {
		return (T) em.find(clase, pk);
	}


	/**
	 * retorna una lista de una consulta
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public <T> List<T> ejecutarNamedQuery(String nombre, Object... parametros) {

		Query query = em.createNamedQuery(nombre);
		for (int i = 0; i < parametros.length; i++) {
			Object param = parametros[i];
			query.setParameter((i + 1), param);
		}
		return query.getResultList();

	}

	/**
	 * Retorna un objeto de una consulta
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	public <T> T ejecutarQuery(String nombre, Object... parametros) {

		Query query = em.createNamedQuery(nombre);
		for (int i = 0; i < parametros.length; i++) {
			Object param = parametros[i];
			query.setParameter((i + 1), param);
		}
		return (T) query.getSingleResult();
	}
}