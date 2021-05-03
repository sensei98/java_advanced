package nl.inholland.assignment1api;

import nl.inholland.assignment1api.model.Games;
import nl.inholland.assignment1api.service.GamesService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.xml.bind.SchemaOutputResolver;
import java.util.*;
import java.util.function.*;

@SpringBootApplication
public class Assignment1ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Assignment1ApiApplication.class, args);
		Function<Integer, Integer> multiply = null;
		System.out.println("Options: \n1: multiply 10 by 2\n2: multiply 10 by 4\nYour option: ");
		String option = new Scanner(System.in).nextLine();
		switch (option){
			case "1" : multiply = i -> i * 2; break;
			case "2" : multiply = i -> i * 4; break;
			default: System.exit(0);
		}
		System.out.println(calculate(10,multiply));

	}
	public static Integer calculate(int a,Function<Integer, Integer> m){
		return m.apply(a);
	}
	public void StringToLength(){
		Function<String, Integer> stringToLength = a -> a.length();
		System.out.println(stringToLength.apply("Only when the cotton is high")); //counts the length of string
	}
	public void StringToAllCaps(){
		Function<String, String> toAllCaps = a -> a.toUpperCase(Locale.ROOT);
		System.out.println(toAllCaps.apply("Only when the cotton is high")); //converts string to uppercase
										//OR
		UnaryOperator<String>toCaps = a -> a.toUpperCase(Locale.ROOT);
		System.out.println(toCaps.apply("Only when the cotton is high"));//converts string to uppercase
	}
	public void PredicatesBiFunctionBinaryConsumerSupplier(GamesService service){ //for predicates //bifunction //consumer //supplier
		Predicate<String> p = a -> a.startsWith("A");
		System.out.println(p.test("Alphabet")); //returns true
		System.out.println(p.test("Beta studies")); //returns false

		//bifunction
		BiFunction<String,String,String> biFunction = (a,b) -> a.concat(b);
		System.out.println(biFunction.apply("hello", "World!")); //returns Hello World!
									//OR
		BinaryOperator<String> biFunction1 = (a,b) -> a.concat(b);
		System.out.println(biFunction1.apply("hello", "World!")); //returns hello world!\
						///using strings with integers
		BiFunction<String,Integer,String> stringWInt = (a,b) -> a+b;
		System.out.println(stringWInt.apply("hello", 1));

							//Consumer //method reference
		Consumer<String> printMe = System.out::println;
		printMe.accept("Hello world through consumer"); //prints that

							//OR
		Consumer<String> printMe1 = Assignment1ApiApplication::printString;
		printMe1.accept("Hello world through consumer"); //prints hello world through consumer

							//supplier
		Supplier<List<Games>> supplier = () -> service.getGames(); //returns all games
		supplier.get().forEach(System.out::println);

	}
	public static void printString(String s){
		System.out.println(s);
	}

		//different ways to do sorting based on highest price (1)
//		@Bean
//		public CommandLineRunner runner(GamesService service){ //sorting out the highest price to the lowest price
//			return args -> {
//				List<Games> games = service.getGames();
//				System.out.println(games);
//				Comparator<Games> comparator = new Comparator<Games>() {
//					@Override
//					public int compare(Games o1, Games o2) {
//						return o1.getPrice() - o2.getPrice();
//					}
//				};
//				Collections.sort(games,comparator);
//				System.out.println(games);
//			};
//		}

	 //				(2)
//	@Bean
//	public CommandLineRunner runner(GamesService service){ //sorting out the highest price to the lowest price
//		return args -> {
//			List<Games> games = service.getGames();
//			System.out.println(games);
//
//			Collections.sort(games,(g1, g2) -> g1.getPrice() - g2.getPrice());
////			Collections.sort(games,Comparator.comparingInt(Games::getPrice)); //same as line 46
//			System.out.println(games);
//		};
//	}
}
