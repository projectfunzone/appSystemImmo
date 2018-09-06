package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClasseStandardDao;
import fr.adaming.model.ClasseStandard;

@Service
@Transactional
public class ClasseStandardServiceImpl implements IClasseStandardService {

	@Autowired
	IClasseStandardDao classeStandardDao;

	public void setClasseStandardDao(IClasseStandardDao classeStandardDao) {
		this.classeStandardDao = classeStandardDao;
	}

	@Override
	public ClasseStandard addClasseStandard(ClasseStandard cs) {
		return classeStandardDao.add(cs);
	}

	@Override
	public void updateClasseStandard(ClasseStandard cs) {
		classeStandardDao.update(cs);

	}

	@Override
	public void deleteClasseStandard(ClasseStandard cs) {
		classeStandardDao.delete(cs.getId());

	}

	@Override
	public ClasseStandard getClasseStandard(int id) {
		return classeStandardDao.get(id);
	}

	@Override
	public List<ClasseStandard> getAllClasseStandards() {
		return classeStandardDao.getAll();
	}

}
