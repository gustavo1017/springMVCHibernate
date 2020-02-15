package com.isil.spring;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.isil.spring.model.Person;
import com.isil.spring.model.PersonaVO;
import com.isil.spring.service.PersonService;

@Controller
public class PersonController {
	String pattern = "MM/dd/yyyy HH:mm:ss"; 
	DateFormat df = new SimpleDateFormat(pattern);
	private PersonService personService;
	
	@Autowired(required=true)
	@Qualifier(value="personService")
	public void setPersonService(PersonService ps){
		this.personService = ps;
	}
	
	@RequestMapping(value = {"/persons","/"}, method = RequestMethod.GET)
	public String listPersons(Model model) {
		
		List<PersonaVO> personLis = new ArrayList<>();
		personLis = listarPersonaVO();
		model.addAttribute("personVO", new PersonaVO());
		model.addAttribute("listPersons", personLis);
		return "person";
	}
	
	
	
	//For add and update person both
	@RequestMapping(value= "/person/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("personVO") PersonaVO p) throws Exception{
		Person personTransfer = new Person();
		try {
			personTransfer.setId(p.getId());
			personTransfer.setName(p.getName());
			personTransfer.setLastName(p.getLastName());
			personTransfer.setEmail(p.getEmail());
			personTransfer.setPhone(p.getPhone());
			personTransfer.setAddress(p.getAddress());
			personTransfer.setAge(p.getAge());
			personTransfer.setCountry(p.getCountry());
			Date a = df.parse(p.getBirthDate());
			personTransfer.setBirthDate(df.parse(p.getBirthDate()));
			personTransfer.setBirthday(df.parse(p.getBirthDay()));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		if(p.getId() == 0){
			//new person, add it
			this.personService.addPerson(personTransfer);
		}else{
			//existing person, call update
			this.personService.updatePerson(personTransfer);
		}
		
		return "redirect:/persons";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
		
        this.personService.removePerson(id);
        return "redirect:/persons";
    }
 
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("personVO", obtenerObjetoVO(id));
        List<PersonaVO> listPerson = listarPersonaVO();
        model.addAttribute("listPersons", listPerson);
        return "person";
    }
    
    //Metodos comunes
    private List<PersonaVO> listarPersonaVO(){
		List<Person> personTransfer = this.personService.listPersons();
		List<PersonaVO> personLis = new ArrayList<>();
		
		try {
			for (Person person : personTransfer) {
				
				PersonaVO personaVO = new PersonaVO();
				personaVO.setId(person.getId());
				personaVO.setName(person.getName());
				personaVO.setLastName(person.getLastName());
				personaVO.setEmail(person.getEmail());
				personaVO.setAddress(person.getAddress());
				personaVO.setAge(person.getAge());
				personaVO.setCountry(person.getCountry());
				personaVO.setBirthDate(df.format(person.getBirthDate()));
				personaVO.setBirthDay(df.format(person.getBirthday()));
				personLis.add(personaVO);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return personLis;
		
	}
    
    private PersonaVO obtenerObjetoVO(int id) {
    	PersonaVO personaVO = new PersonaVO();
    	Person person = new Person();
    	person = this.personService.getPersonById(id);
    	
    	personaVO.setId(person.getId());
    	personaVO.setName(person.getName());
    	personaVO.setLastName(person.getLastName());
    	personaVO.setEmail(person.getEmail());
    	personaVO.setAddress(person.getAddress());
    	personaVO.setAge(person.getAge());
    	personaVO.setCountry(person.getCountry());
    	personaVO.setBirthDate(df.format(person.getBirthDate()));
    	personaVO.setBirthDay(df.format(person.getBirthday()));
    	
    	return personaVO;
    }
	
}
