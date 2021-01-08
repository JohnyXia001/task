package task;

import java.util.Scanner;
import java.io.FileWriter; // Import the FileWriter class
import java.io.IOException;
import java.util.Random;

public class task {
	String name;
	int age;
	float weight;
	int group;
	float float_random;
	String drug;

	public task(String name, int age, float weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.float_random = calculate_random();
		this.group = calculate_group();
		this.drug = decision_making();
	}

	private int calculate_group() {
		if (age < 75) {
			if (weight < 65) {
				group = 1;
			} else {
				group = 2;
			}
		} else {
			if (weight < 65) {
				group = 2;
			} else {
				group = 3;
			}

		}
		return group;
	}

	private float calculate_random() {
		Random rand = new Random();
		float float_random = rand.nextFloat();
		return float_random;
	}

	private String decision_making() {
		switch (group) {
		case 1:
			if (float_random < 0.25) {
				drug = "Drug A";
			} else {
				drug = "Drug B";
			}
			break;
		case 2:
			if (float_random < 0.5) {
				drug = "Drug A";
			} else {
				drug = "Drug B";
			}
			break;
		case 3:
			if (float_random < 0.75) {
				drug = "Drug A";
			} else {
				drug = "Drug B";
			}
			break;
		}

		return drug;
	}

	public void output() {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age + " years");
		System.out.println("Weight: " + weight + " kg");
		System.out.println(float_random);
		System.out.println(group);
		System.out.println(drug);
		
		try {
			FileWriter myWriter = new FileWriter("log.txt",true);
			myWriter.write(name+' '+age+' '+weight+' '+
					float_random+' '+group+' '+drug+'\n');
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Enter Name:");
	    String name = myObj.nextLine();
		System.out.println("Enter Age:");
	    int age = myObj.nextInt();
	    System.out.println("Enter Weight:");
	    float weight = myObj.nextFloat();

//		String name = "Johnny";
//		int age = 15;
//		float weight = 60;

		task program = new task(name, age, weight);
		program.output();

	}

}
