package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.ClasseStandard;
import fr.adaming.service.IClasseStandardService;

@RestController
@RequestMapping("/classestandard")
public class ClasseStandardRestController {

	// transformation del 'association uml java
	@Autowired
	private IClasseStandardService classeStandardService;

	public void setClasseStandardService(IClasseStandardService classeStandardService) {
		this.classeStandardService = classeStandardService;
	}

	/**
	 * Recupérer la liste des ClassesStandards enregistrées
	 * 
	 * @return la liste des ClassesStandards
	 */
	@RequestMapping(value = "/liste", method = RequestMethod.GET, produces = "application/json")
	public List<ClasseStandard> getAllClasseStandards() {
		return classeStandardService.getAllClasseStandards();
	}

	/**
	 * Recupérer une classe standard par son id
	 * 
	 * @return le classe standard correspondant à l'id
	 */
	@RequestMapping(value = "/getID", method = RequestMethod.GET, produces = "application/json")
	public ClasseStandard getClasseStandardbyID(@RequestParam("pID") int id) {
		return classeStandardService.getClasseStandard(id);
	}

	/**
	 * Ajouter une classe standard passée en paramètre
	 * 
	 * @return la classe standard ajoutée
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public ClasseStandard addClient(@RequestBody ClasseStandard cs) {
		return classeStandardService.addClasseStandard(cs);
	}

	/**
	 * Modifier une classe standard passée en paramètre
	 * 
	 * @return pas de retour
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public void updateClasseStandard(@RequestBody ClasseStandard cs) {
		classeStandardService.updateClasseStandard(cs);
	}

	/**
	 * Supprimer ne classe standard ciblée
	 * 
	 * @return pas de retour
	 */
	@RequestMapping(value = "/del/{pId}", method = RequestMethod.DELETE)
	public void deleteClasseStandard(@PathVariable("pId") int id) {
		ClasseStandard csIn = new ClasseStandard();
		csIn.setId(id);
		classeStandardService.deleteClasseStandard(csIn);
	}

}
