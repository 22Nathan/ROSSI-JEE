package com.awa.rentcar;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RentMyCarApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(RentMyCarApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(PersonRepository personRepository,DatesRepository datesRepository) 
	{
		return (args) -> {

			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

			Person person1 = new Person();
			person1.setAge(20);
			person1.setNom("Nathan");

			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			
			Person person2 = new Person();
			person2.setAge(17);
			person2.setNom("Sham");

			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			
			String pattern = "yyyy-MM-dd";
		    SimpleDateFormat simpleDateFormat = new SimpleDateFormat( pattern );

			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

		    Date dateDebut1 = simpleDateFormat.parse("2018-09-09");
		    Date dateFin1 = simpleDateFormat.parse("2018-09-12");

			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		     
		    Date dateDebut2 = simpleDateFormat.parse("2020-09-02");
		    Date dateFin2 = simpleDateFormat.parse("2021-12-01");

			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			    
			Dates date1 = new Dates();		
			date1.setBegin(dateDebut1);
			date1.setEnd(dateFin1);
		
			Dates date2 = new Dates();
			date2.setBegin(dateDebut2);
			date2.setEnd(dateFin2);
			
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
			Van van1 = new Van();
			van1.setPlateNumber("45B23");
			van1.setRented(false);
			van1.setBrand("BMW");
			van1.setPrice(2313132);
			van1.setMaxWeight(400);

			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			
			Car car1 = new Car();
			car1.setPlateNumber("89A32");
			car1.setRented(false);
			car1.setBrand("Renault");
			car1.setPrice(23400);
			car1.setnumberOfSeats(4);

			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			
			person1.addDates(date1);
			person2.addDates(date2);
		 
			van1.setDates(date2);
			car1.setDates(date1);
			
			date1.setPerson(person1);
			date2.setPerson(person2);
			
			date2.setVehicule(van1);
			
			date1.setVehicule(car1);
		
			datesRepository.save(date1);
			datesRepository.save(date2);

			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

		};
	}
	


}