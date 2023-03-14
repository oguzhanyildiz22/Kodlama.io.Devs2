package KodlamaIo.devs.ProgrammingLanguages.webApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import KodlamaIo.devs.ProgrammingLanguages.business.abstracts.ProgrammingLanguageService;
import KodlamaIo.devs.ProgrammingLanguages.business.requests.language.CreateLanguagesRequests;
import KodlamaIo.devs.ProgrammingLanguages.business.requests.language.UpdateLanguagesRequests;
import KodlamaIo.devs.ProgrammingLanguages.business.responses.GetAllLanguagesResponse;
@RestController
@RequestMapping("/api/languages")
public class ProgrammingLanguageController {
 
	private ProgrammingLanguageService programmingLanguageService;
	
	@Autowired
	public ProgrammingLanguageController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}
	
	@GetMapping("/getall")
	public List<GetAllLanguagesResponse> getAll(){
		return this.programmingLanguageService.getAll();
	}
	@PostMapping("/add")
	public void add(CreateLanguagesRequests createLanguagesRequests) throws Exception {
		this.programmingLanguageService.add(createLanguagesRequests);
	}
	@DeleteMapping("/delete/{id}")
	public void delete(int id) {
		this.programmingLanguageService.delete(id);
	}
	@PostMapping("/update")
	public void update(UpdateLanguagesRequests updateLanguagesRequests) throws Exception {
		this.programmingLanguageService.update(updateLanguagesRequests);
	}
}
