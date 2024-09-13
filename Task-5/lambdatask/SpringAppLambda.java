package ir.freeland.springboot.lambdatask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SpringAppLambda {
	
	    public static void main(String[] args) {
	    	Person person1 = new Person("ali", "karami", 22, new Address("iran", "kerman", "shahrak", 101));
	    	Person person2 = new Person("sara", "mohammadi", 19, new Address("iran", "isfahan", "golestan", 45));
	    	Person person3 = new Person("reza", "ahmadi", 30, new Address("iran", "tehran", "valiasr", 88));
	    	Person person4 = new Person("niloofar", "sharifi", 28, new Address("iran", "tabriz", "shahrak", 200));
	    	Person person5 = new Person("farid", "zare", 35, new Address("iran", "yazd", "mohammad", 150));
	    	Person person6 = new Person("mahnaz", "ghasemi", 40, new Address("iran", "tehran", "sadr", 33));
	    	Person person7 = new Person("kamran", "taheri", 27, new Address("iran", "tehran", "saadatabad", 75));
	    	Person person8 = new Person("sima", "jafari", 32, new Address("iran", "tehran", "shahrak", 90));
	    	Person person9 = new Person("amir", "ghorbani", 29, new Address("iran", "tehran", "keshavarz", 120));
	    	Person person10 = new Person("zahra", "mohsenian", 26, new Address("iran", "ahvaz", "khalij", 55));
	        List<Person> people = new ArrayList<>();
	        Collections.addAll(people, person1, person2, person3, person4, person5, person6, person7, person8, person9, person10);


	        System.out.println("Sorting results - first method: ");
	        Collections.sort(people, new Comparator<Person>() {
	            @Override
	            public int compare(Person first, Person second) {
	                return first.getAddress().getCity().compareTo(second.getAddress().getCity());
	            }
	        });
	        people.forEach(System.out::println);
	     
	        System.out.println("Sorting results - second method: ");
	        List<Person> sortedPeople = people.stream()
	                .sorted(Comparator.comparing(p -> p.getAddress().getCity()))
	                .collect(Collectors.toList());
	        sortedPeople.forEach(System.out::println);


	        System.out.println("Average age result: ");
	        double averageAge = people.stream()
	                .mapToDouble(Person::getAge)
	                .average()
	                .orElse(0.0);
	        System.out.println(averageAge); 
	        
	        

	        System.out.println("Partitioning results: ");
	        sortedPeople.stream()
	                .collect(Collectors.partitioningBy(p -> p.getAge() > 18))
	                .forEach((isAdult, group) -> {
	                    String ageCategory = isAdult ? "Adults" : "Minors";
	                    System.out.println(ageCategory);
	                    group.forEach(System.out::println);
	                    System.out.println();
	                });

	        System.out.println("Grouping results: ");
	        Map<String, List<Person>> groupedByCity = sortedPeople.stream()
	                .collect(Collectors.groupingBy(p -> p.getAddress().getCity()));
	        System.out.println(groupedByCity);


	        
	    
	}

}
