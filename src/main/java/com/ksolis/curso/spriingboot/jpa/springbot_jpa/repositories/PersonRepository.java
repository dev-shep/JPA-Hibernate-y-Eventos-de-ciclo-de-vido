/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.ksolis.curso.spriingboot.jpa.springbot_jpa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ksolis.curso.spriingboot.jpa.springbot_jpa.dto.PersonDto;
import com.ksolis.curso.spriingboot.jpa.springbot_jpa.entities.Person;

/**
 *
 * @author Limon
 */
public interface PersonRepository extends CrudRepository<Person, Long>{

 @Query("select  min(length(p.name)) from Person p")
 public Integer getPersonMinNameLength(); 
   

 @Query("select  max(length(p.name)) from Person p")
 public Integer getPersonMaxNameLength(); 

 @Query("select count(p) from Person p")
 Long getTotalPerson();   

 @Query("select min(p.id) from Person p")
 Long getMinId();   

 @Query("select max(p.id) from Person p")
 Long getMaxId();

 @Query("select p from Person p where p.name between ?1 and ?2")
 List<Person> findAllBetweenName(String c1,String c2);
    
 @Query("select p from Person p where p.id between ?1 and ?2")
 List<Person> findAllBetweenNames(Integer id1, Integer id2);   


 @Query("select p from Person p where p.name between 'A' and 'D'")
 List<Person> findAllBetweenNames();

 @Query("select p from Person p where p.id between 2 and 3")
 List<Person> findAllBetweenÏd();

 @Query("select count(distinct(p.name)) from Person p")
 Long findAllNamesDistinctCount();
   

 @Query("select p.name from Person p")
 List<String> findAllNames();
      
 @Query("select distinct p.name from Person p")
 List<String> findDistinctNames();

 @Query("select new com.ksolis.curso.spriingboot.jpa.springbot_jpa.dto.PersonDto (p.name, p.lastname) from Person p")
 List<PersonDto> findAllPersonDto();

 @Query("select new Person (p.name, p.lastname) from Person p")
 List<Person> findAllObjectPersonPersonalized(); 

 @Query("select p.name from Person p where p.id=?1")   
 String getNameById(Long id);

 @Query("select p.id from Person p where p.id=?1")   
 Long getIdById(Long id);

 @Query("select concat(p.name, ' ', p.lastname) as fullname from Person p where p.id=?1")   
 String getFullNameById(Long id);

 @Query("select p from Person p where p.id=?1")
 Optional<Person> findOne(Long id);
 
 @Query("select p from Person p where p.name=?1")
 Optional<Person> findOneName(String name);

 @Query("select p from Person p where p.name like %?1%")
 Optional<Person> findOneLikeName(String name);

 Optional<Person> findByNameContaining(String name);
    
 List<Person> findByProgrammingLanguage(String programmingLanguage);
 
 @Query("select p from Person p where p.programmingLanguage=?1 and p.name=?2") 
 List<Person> buscarByProgrammingLanguage(String programmingLanguage, String name);

 List<Person> findByProgrammingLanguageAndName(String programmingLanguage, String name);

 @Query("select p, p.programmingLanguage from Person p")
 List<Object[]> findAllMixPerson();

 @Query("select p.id, p.name, p.lastname, p.programmingLanguage from Person p")
 List<Object[]> obtenerFullData();

 @Query("select p.id, p.name, p.lastname, p.programmingLanguage from Person p where p.id=?1")
 Object obtenerFullDataById(Long id);

 @Query("select p.name, p.programmingLanguage from Person p")
 List<Object[]> obtenerPersonData();

 @Query("select p.name, p.programmingLanguage from Person p where p.name=?1")
 List<Object[]> obtenerPersonData(String name);

 @Query("select p.name, p.programmingLanguage from Person p where p.programmingLanguage=?1")
 List<Object[]> obtenerPersonDataByProgrammingLanguage(String programmingLanguage);
 

 @Query("select p.name, p.programmingLanguage from Person p where p.programmingLanguage=?1 and p.name=?2")
 List<Object[]> obtenerPersonData(String programmingLanguage, String name); 
}
