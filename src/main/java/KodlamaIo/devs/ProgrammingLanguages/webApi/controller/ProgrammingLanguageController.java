package KodlamaIo.devs.ProgrammingLanguages.webApi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import KodlamaIo.devs.ProgrammingLanguages.business.abstracts.ProgrammingLanguageService;
import KodlamaIo.devs.ProgrammingLanguages.business.requests.language.CreateLanguagesRequests;
import KodlamaIo.devs.ProgrammingLanguages.business.requests.language.UpdateLanguagesRequests;
import KodlamaIo.devs.ProgrammingLanguages.business.responses.GetAllLanguagesResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/languages")
@AllArgsConstructor
public class ProgrammingLanguageController {
 
	private ProgrammingLanguageService programmingLanguageService;
	
	
	
	@GetMapping()
	public List<GetAllLanguagesResponse> getAll(){
		return this.programmingLanguageService.getAll();
	}
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(CreateLanguagesRequests createLanguagesRequests) throws Exception {
		this.programmingLanguageService.add(createLanguagesRequests);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.programmingLanguageService.delete(id);
	}
	@PutMapping()
	public void update(@RequestBody UpdateLanguagesRequests updateLanguagesRequests){
		this.programmingLanguageService.update(updateLanguagesRequests);
	}
}
