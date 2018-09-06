package fr.adaming.service;

import java.util.List;

import fr.adaming.model.ClasseStandard;

public interface IClasseStandardService {

	// methode du CRUD
	public ClasseStandard addClasseStandard(ClasseStandard cs);

	public void updateClasseStandard(ClasseStandard cs);

	public void deleteClasseStandard(ClasseStandard cs);

	public ClasseStandard getClasseStandard(int id);

	public List<ClasseStandard> getAllClasseStandards();

}
