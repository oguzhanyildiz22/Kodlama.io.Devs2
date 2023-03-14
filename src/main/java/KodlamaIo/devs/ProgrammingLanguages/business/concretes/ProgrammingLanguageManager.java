package KodlamaIo.devs.ProgrammingLanguages.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KodlamaIo.devs.ProgrammingLanguages.business.abstracts.ProgrammingLanguageService;
import KodlamaIo.devs.ProgrammingLanguages.business.requests.language.CreateLanguagesRequests;
import KodlamaIo.devs.ProgrammingLanguages.business.requests.language.UpdateLanguagesRequests;
import KodlamaIo.devs.ProgrammingLanguages.business.responses.GetAllLanguagesResponse;
import KodlamaIo.devs.ProgrammingLanguages.dataAccess.abstracts.ProgrammingLanguageRepository;
import KodlamaIo.devs.ProgrammingLanguages.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	ProgrammingLanguageRepository languageRepository;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository languageRepository) {
		super();
		this.languageRepository = languageRepository;

	}

	@Override
	public void add(CreateLanguagesRequests createLanguagesRequests) throws Exception {
		ProgrammingLanguage language = new ProgrammingLanguage();
		if (createLanguagesRequests.getName().isEmpty()) {
			throw new Exception("this field can not be empty");
		}
		language.setName(createLanguagesRequests.getName());

		this.languageRepository.save(language);
	}
 
	@Override
	public void delete(int id) {

		this.languageRepository.deleteById(id);
		;

	}

	@Override
	public void update(UpdateLanguagesRequests updateLanguagesRequests) throws Exception {

		List<ProgrammingLanguage> languages = languageRepository.findAll();
		ProgrammingLanguage language = new ProgrammingLanguage();
		if (updateLanguagesRequests.getName().isEmpty()) {
			throw new Exception("this field can not be empty");

		}
		for (ProgrammingLanguage i : languages) {
			if (i.getName().equals(updateLanguagesRequests.getName())) {
				throw new Exception("we have already this name");
			}

		}
		language = languageRepository.findById(updateLanguagesRequests.getId()).get();
		language.setName(updateLanguagesRequests.getName());

		this.languageRepository.save(language);

	}

	@Override
	public List<GetAllLanguagesResponse> getAll() {
		List<ProgrammingLanguage> languages = languageRepository.findAll();

		List<GetAllLanguagesResponse> languagesResponses = new ArrayList<GetAllLanguagesResponse>();

		for (ProgrammingLanguage i : languages) {
			GetAllLanguagesResponse languagesResponseItem = new GetAllLanguagesResponse();
			languagesResponseItem.setId(i.getId());
			languagesResponseItem.setName(i.getName());
			languagesResponses.add(languagesResponseItem);
		}

		return languagesResponses;
	}

}
