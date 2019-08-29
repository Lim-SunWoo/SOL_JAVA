package mymain;

import myutil.Animal;
import myutil.Cat;
import myutil.Dog;
import myutil.Pig;

public class MyMain_Animal {

	static void animal_cry(Animal [] animal_array) {
		for(Animal animal: animal_array)
			animal.cry();
	}
	
	static void animal_eat(Animal [] animal_array) {
		for(Animal animal: animal_array)
			animal.eat();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Animal [] animal_array = {
				new Dog(),
				new Cat(),
				new Pig()
		};
		
		//울어라
		animal_cry(animal_array);
		
		//먹어라
		animal_eat(animal_array);
		
		
	}

}
