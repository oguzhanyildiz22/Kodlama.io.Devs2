package KodlamaIo.devs.ProgrammingLanguages.business.abstracts;

import java.util.List;

import KodlamaIo.devs.ProgrammingLanguages.business.requests.language.CreateLanguagesRequests;
import KodlamaIo.devs.ProgrammingLanguages.business.requests.language.UpdateLanguagesRequests;
import KodlamaIo.devs.ProgrammingLanguages.business.responses.GetAllLanguagesResponse;

public interface ProgrammingLanguageService {

	void add(CreateLanguagesRequests createLanguagesRequests) throws Exception;
	void delete(int id);
	void update(UpdateLanguagesRequests updateLanguagesRequests) throws Exception;
	
	List<GetAllLanguagesResponse> getAll();
	
	
	
}
