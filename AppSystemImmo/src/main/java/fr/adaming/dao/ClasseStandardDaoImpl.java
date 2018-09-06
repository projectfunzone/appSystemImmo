package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.model.ClasseStandard;

@Repository
public class ClasseStandardDaoImpl extends GenericDaoImpl<ClasseStandard> implements IClasseStandardDao {

	/**
	 * Constructeur vide pour spécifier le type de classe au DAO générique
	 */
	public ClasseStandardDaoImpl() {
		type = ClasseStandard.class;
	}

}
