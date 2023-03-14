package KodlamaIo.devs.ProgrammingLanguages.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import KodlamaIo.devs.ProgrammingLanguages.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage,Integer> {

}
