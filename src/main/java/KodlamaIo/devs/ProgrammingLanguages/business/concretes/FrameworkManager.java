package KodlamaIo.devs.ProgrammingLanguages.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import KodlamaIo.devs.ProgrammingLanguages.business.abstracts.FrameworkService;
import KodlamaIo.devs.ProgrammingLanguages.business.requests.framework.CreateFrameworksRequests;
import KodlamaIo.devs.ProgrammingLanguages.business.requests.framework.UpdateFrameworksRequests;
import KodlamaIo.devs.ProgrammingLanguages.business.responses.GetAllFrameworksResponse;
import KodlamaIo.devs.ProgrammingLanguages.dataAccess.abstracts.FrameworkRepository;
import KodlamaIo.devs.ProgrammingLanguages.entities.concretes.Framework;
@Service
public class FrameworkManager implements FrameworkService {

	FrameworkRepository frameworkRepository;
	
	

	@Autowired
	public FrameworkManager(FrameworkRepository frameworkRepository) {
		super();
		this.frameworkRepository = frameworkRepository;
		
	}

	@Override
	public void add(CreateFrameworksRequests createFrameworksRequests) throws Exception {
		Framework framework = new Framework();
		if (createFrameworksRequests.getName().isEmpty()) {
			throw new Exception("this field cannot be empty");
		}
		framework.setName(createFrameworksRequests.getName());
		this.frameworkRepository.save(framework);

	}

	@Override
	public void delete(@PathVariable int id) {
		
		this.frameworkRepository.deleteById(id);

	}

	@Override
	public void update(UpdateFrameworksRequests frameworksRequests) throws Exception {
		
		List<Framework> frameworks = frameworkRepository.findAll();
		Framework framework = new Framework();
		if (frameworksRequests.getName().isEmpty()) {
			throw new Exception("this field can not be empty");

		}
		for (Framework i : frameworks) {
			if (i.getName().equals(frameworksRequests.getName())) {
				throw new Exception("we have already this name");
			}

		}
		framework = frameworkRepository.findById(frameworksRequests.getId()).get();
		framework.setName(frameworksRequests.getName());

		this.frameworkRepository.save(framework);

	}

	@Override
	public List<GetAllFrameworksResponse> getAll() {

		List<Framework> frameworks = frameworkRepository.findAll();
		List<GetAllFrameworksResponse> frameworksResponses = new ArrayList<GetAllFrameworksResponse>();
		for (Framework i : frameworks) {
			GetAllFrameworksResponse frameworksResponseItem = new GetAllFrameworksResponse();
			frameworksResponseItem.setId(i.getId());
			frameworksResponseItem.setName(i.getName());

			frameworksResponses.add(frameworksResponseItem);

		}

		return frameworksResponses;
	}

}
