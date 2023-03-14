package KodlamaIo.devs.ProgrammingLanguages.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import KodlamaIo.devs.ProgrammingLanguages.entities.concretes.Framework;

public interface FrameworkRepository extends JpaRepository<Framework,Integer>{

}
