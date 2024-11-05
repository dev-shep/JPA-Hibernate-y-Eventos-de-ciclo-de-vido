package com.ksolis.curso.spriingboot.jpa.springbot_jpa;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.ksolis.curso.spriingboot.jpa.springbot_jpa.dto.PersonDto;
import com.ksolis.curso.spriingboot.jpa.springbot_jpa.entities.Person;
import com.ksolis.curso.spriingboot.jpa.springbot_jpa.repositories.PersonRepository;

@SpringBootApplication
public class SpringbotJpaApplication implements CommandLineRunner {
    
	@Autowired
	private PersonRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(SpringbotJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		create();
		list();
	}
	@Transactional(readOnly=true)
	public void personalizedQueriesDistinct(){
		System.out.println("=======Consulta con nombre de personas=========");
		List<String> names = repository.findAllNames();
		names.forEach(System.out::println);
	
		System.out.println("=======Consulta con Distinct nombre de personas=========");
		List<String> namesDistinct = repository.findDistinctNames();
		namesDistinct.forEach(System.out::println);

		System.out.println("=======Consulta con Count y distinct nombre de personas=========");
		Long namesDistinctCount = repository.findAllNamesDistinctCount();
		System.out.println("total::"+namesDistinctCount);

		System.out.println("=======Consulta que puebla y devuelve los id de entre 2 y 5=========");
		List<Person> persons = repository.findAllBetweenÏd();
		persons.forEach(person -> System.out.println(person));

		System.out.println("=======Consulta que puebla y devuelve los nombres de entre A y D=========");
		List<Person> personsBetween = repository.findAllBetweenNames(2,5);
		personsBetween.forEach(person -> System.out.println(person));

		System.out.println("=======Consulta que puebla y devuelve los nombres de entre A y D=========");
		List<Person> personsBetween1 = repository.findAllBetweenName("a","d");
		personsBetween1.forEach(person -> System.out.println(person));

		System.out.println("=======Consulta con Count =========");
		Long getTotalPerson = repository.getTotalPerson();
		System.out.println("total::"+getTotalPerson);

		System.out.println("=======Consulta con Min=========");
		Long getMinId = repository.getMinId();
		System.out.println("total::"+getMinId);

		System.out.println("=======Consulta con Max=========");
		Long getMaxId = repository.getMaxId();
		System.out.println("total::"+getMaxId);

		System.out.println("=======Consulta con el minimo de nombre Length=========");
		Integer getPersonMinNameLength = repository.getPersonMinNameLength();
		System.out.println("total::"+getPersonMinNameLength);





		System.out.println("=======Consulta con el maximo de nombre Length=========");
		Integer getPersonMaxNameLength = repository.getPersonMaxNameLength();
		System.out.println("total::"+getPersonMaxNameLength);

	}

	@Transactional(readOnly=true)
	public void personalizeQueries2(){
		System.out.println("=======Consulta por objeto persona y lenguaje de programaicon=========");
		List<Object[]> personRegs = repository.findAllMixPerson();

		personRegs.forEach(reg ->{
				System.out.println("programmingLanguage="+reg[1]+ " person="+reg[0]);
		});
		System.out.println("=======Consulta que puebla y devuelve objeto de una entity de una instancia personalizada=========");
		List<Person> persons = repository.findAllObjectPersonPersonalized();
		persons.forEach(person -> System.out.println(person));

		System.out.println("=======Consulta que puebla y devuelve objeto dto de una clase personalizada=========");
		List<PersonDto> personDto = repository.findAllPersonDto();
		personDto.forEach(System.out::println);
	}

    @Transactional(readOnly=true)
	public void personalizeQueries(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("=======Consulta solo el nombre por el id =========");
		System.out.println("Ingrese el id para el nombre");
		Long id = scanner.nextLong();
	    scanner.close();
		System.out.println("=======Mpstrando solo  el nombre =========");
		String name = repository.getNameById(id);
		System.out.println(name);

		System.out.println("=======Mpstrando solo  el id =========");

		Long idDd = repository.getIdById(id);
		System.out.println(idDd);
		String fullName = repository.getFullNameById(id);
		System.out.println(fullName);

		System.out.println("=====Consulta por campos personalizados or el id=====");
		Object[] personReg = (Object[]) repository.obtenerFullDataById(id);

		System.out.println("id="+personReg[0]+" nombre="+personReg[1]+"apellido="+personReg[2]+"lenguaje="+personReg[2]);
		
		System.out.println("=====Consulta por Lista=====");
		List<Object[]> regs= repository.obtenerFullData();

		regs.forEach(reg ->System.out.println("id="+reg[0]+" nombre="+reg[1]+"apellido="+reg[2]+"lenguaje="+reg[2]));



	}

	@Transactional
	public void delete2(){
		repository.findAll().forEach(System.out::println);

		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el id a eliminar");
		Long id = scanner.nextLong();

		Optional <Person> optionalPerson = repository.findById(id);

		optionalPerson.ifPresentOrElse(repository::delete, 
									   () -> System.out.println("Lo sentimos no existe la persona con ese ID.")
									   );

		repository.findAll().forEach(System.out::println);
		scanner.close();
	}
	@Transactional
	public void delete(){
		repository.findAll().forEach(System.out::println);

		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el id a eliminar");
		Long id = scanner.nextLong();
		repository.deleteById(id);

		repository.findAll().forEach(System.out::println);
		scanner.close();
	}

	@Transactional
	public void update(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el id de la persona");
		Long id = scanner.nextLong();

		Optional<Person> optionalPerson = repository.findById(id);
        optionalPerson.ifPresent(person -> {
			System.out.println(person);
			System.out.println("Ingrese el lenguajed de programacion");
			String programmingLanguage = scanner.next();
			person.setProgrammingLanguage(programmingLanguage);
			Person personDb = repository.save(person);
			System.out.println(personDb);
		}); 
	}

    @Transactional
	public void create(){
        Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el nombre");
		String name = scanner.next();
		System.out.println("Ingrese el apellido");
		String lastname = scanner.next();
		System.out.println("Ingrese el lenguaje de programacion");
		String programmingLanguage =scanner.next();
		scanner.close();

		Person person = new Person(null, name, lastname, programmingLanguage);
        Person personNew = repository.save(person);
		System.out.println(personNew);

		repository.findById(personNew.getId()).ifPresent(p -> System.out.println(p));
	}
	@Transactional(readOnly = true)
	public void findOne(){
		/* Person person = null;
		Optional<Person> optionalPerson = repository.findById(1L);
		if (optionalPerson.isPresent()) {
			person = optionalPerson.get();	
		}
		System.out.println(person); */

		repository.findByNameContaining("karl").ifPresent(person -> System.out.println(person));
	}

	@Transactional(readOnly = true)
	public void list(){
		//List<Person> persons = (List<Person>) repository.findAll();
		//List<Person> persons = (List<Person>) repository.buscarByProgrammingLanguage("java","karla");
		List<Person> persons = (List<Person>) repository.findByProgrammingLanguageAndName("java","karla");
		persons.stream().forEach(person ->{
			System.out.println(person);
		});

		List<Object[]> personsValues =  repository.obtenerPersonData();
		personsValues.stream().forEach(person ->{
			System.out.println(person[0]+" es experto en 1 "+person[1]);			
		});

		List<Object[]> personsValue =  repository.obtenerPersonData("kara");
		personsValue.stream().forEach(person ->{
			System.out.println(person[0]+" es experto en "+person[1]);			
		});
	}
}
