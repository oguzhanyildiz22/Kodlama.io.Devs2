package KodlamaIo.devs.ProgrammingLanguages.business.abstracts;

import java.util.List;

import KodlamaIo.devs.ProgrammingLanguages.business.requests.framework.CreateFrameworksRequests;
import KodlamaIo.devs.ProgrammingLanguages.business.requests.framework.UpdateFrameworksRequests;
import KodlamaIo.devs.ProgrammingLanguages.business.responses.GetAllFrameworksResponse;

public interface FrameworkService {

	void add(CreateFrameworksRequests createFrameworksRequests) throws Exception;
	void delete(int id);
	void update(UpdateFrameworksRequests frameworksRequests) throws Exception;
	
	List<GetAllFrameworksResponse> getAll();
}
