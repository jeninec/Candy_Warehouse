package com.revature.app;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.revature.models.Item;
import com.revature.models.Order;
import com.revature.models.Person;
import com.revature.repositories.ItemRepo;
import com.revature.repositories.OrderRepo;
import com.revature.repositories.PersonRepo;

@SpringBootApplication
@ComponentScan("com.revature")
@EntityScan("com.revature.models")
@EnableJpaRepositories("com.revature.repositories")
public class CandyCompanyApplication {

	@Autowired
	private PersonRepo pr;
	
	@Autowired
	private ItemRepo ir;
	
	@Autowired
	private OrderRepo or;

	public static void main(String[] args) {
		SpringApplication.run(CandyCompanyApplication.class, args);
	}

	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			pr.save(new Person("Karen", "Harbison", "pass", "kharb@gmail.com", "1194 Myra St", null, "Providence", "RI", "02905", "401-455-3725", "buyer", null));
			pr.save(new Person("John", "Wagner", "pass", "jwagn@gmail.com", "4426 Browning Lane", null, "Endicot", "NY", "13760", "607-785-5417", "buyer", null));
			pr.save(new Person("Kim", "Molina", "pass", "kmoli@gmail.com", "2652 Cooks Mine Road", null, "Espanola", "NM", "87532", "505-747-9747", "employee", null));
			pr.save(new Person("Shirley", "Hunt", "pass", "shunt@gmail.com", "930 Williams Lane", null, "Wichita", "KS", "67202", "316-619-3118", "employee", null));
			pr.save(new Person("Christopher", "Williams", "pass", "cwill@gmail.com", "3843 Spirit Drive", null, "Ormond Beach", "FL", "32174", "386-673-0291", "employee", null));
			pr.save(new Person("Timmy", "Lopez", "pass", "tlope@gmail.com", "4857 Diamond Cove", null, "Providence", "RI", "02908", "401-209-4183", "employee", null));
			pr.save(new Person("Lydia", "Beeson", "pass", "lbees@gmail.com", "502 Myra Street", "Apt 204", "North Kingstown", "RI", "02852", "401-465-5959", "employee", null));
			pr.save(new Person("Kristin", "Ives", "pass", "kives@gmail.com", "4534 Winding Way", "Unit 12", "Providence", "RI", "02903", "401-604-8834", "manager", null));
			pr.save(new Person("Vera", "Sheffield", "pass", "vshef@gmail.com", "4950 Bond Street", null, "Providence", "RI", "02908", "401-479-0607", "manager", null));
			pr.save(new Person("Morgan", "West", "pass", "mwest@gmail.com", "1120 Rockford Mountain Lane", null, "Princeton", "NC", "27569", "919-936-1906", "admin", null));
		
			ir.save(new Item("twix", "chocolate", 1.60, 50,  "crunchy flavorful cookie, delicious chewy caramel, and smooth creamy chocolate", "../../../assets/images/twix.jpeg", 0));
			ir.save(new Item("kitkat", "chocolate", 1.85, 50, "chocolate-covered wafer bar", "../../../assets/images/kitkat.jpeg", 0));
			ir.save(new Item("snickers", "chocolate", 2.00, 50, "nougat topped with caramel and peanuts that has been enrobed in milk chocolate", "../../../assets/images/snickers.jpeg", 0));
			ir.save(new Item("milky way", "chocolate", 1.35, 30, "creamy caramel and smooth nougat covered in rich milk chocolate", "../../../assets/images/milky_way.jpeg", 0));
			ir.save(new Item("gummy bears", "gummies", 1.70, 30, "small, fruit gum candies shaped in the form of a bear", "../../../assets/images/gummy_bears.jpeg", 0));
			ir.save(new Item("gummy worms", "gummies", 1.80, 40, "small, fruit gum candies shaped in the form of a worm", "../../../assets/images/gummy_worms.jpeg", 0));
			ir.save(new Item("candy canes", "hard candies", 1.00, 20, "cane-shaped stick candy often associated with Christmas", "../../../assets/images/candy_canes.jpeg", 0));
			ir.save(new Item("jolly ranchers", "hard candies", 1.50, 40, "sweet hard candies in an assortment of bold fruit flavors", "../../../assets/images/jolly_ranchers.jpeg", 0));
			ir.save(new Item("life savers", "hard candies", 1.05, 10, "ring-shaped hard candy", "../../../assets/images/life_savers.jpeg", 0));
			ir.save(new Item("chupa chups", "lollipops", 0.85, 10, "hard fruity lollipop", "../../../assets/images/chupa_chups.jpeg", 0));
			ir.save(new Item("blow pops", "lollipops", 0.95, 15, "delicious fruit flavored hard candy shell with a soft bubble gum center", "../../../assets/images/blow_pops.jpeg", 0));
			ir.save(new Item("twizzler", "licorice", 1.65, 15, "twisted strawberry licorice", "../../../assets/images/twizzlers.jpeg", 0));
			
			or.save(new Order(10.00, "01/21/21", "FEDEX", false, null));
			
		};
	}
}
