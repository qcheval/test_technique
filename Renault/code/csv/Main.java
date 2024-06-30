package code.csv;

import java.io.*;
import java.util.*;

import code.City;

public class Main {

    public static void main(String[] args) throws Exception {

        List<City> cities = new ArrayList<>();   

        /* Testing Array 

        System.out.println("the size of cities before reading the CSV file = " + cities.size());

        cities.add(new City("paris", "france", 10, 10)); //Adding an element

        System.out.println("the size of cities after adding 1 city as a test = " + cities.size());

        System.out.println(cities.get(0)); // show the first element
 
        */

        // Parsing a CSV file into Scanner class constructor 
        Scanner sc = new Scanner(new File("files\\cities.csv")); 
        sc.useDelimiter("\n"); // sets the delimiter pattern for lines

        boolean skipfirstrow = true;

        while (sc.hasNextLine()) { // returns a boolean value  

            String line = sc.nextLine();

            // Skip the header line
            if (skipfirstrow) {
                skipfirstrow = false;
                continue;
            }

            String[] row = line.split(";"); //splittin a string into different parts, for each row in the CSV file we have ";" as a delimiter 
                                                  //therfore i use it to seprate each line into 4 different parts that are the values needed to construct a new city
                cities.add(new City(row[0], row[1], Integer.parseInt(row[2]), Integer.parseInt(row[3])));
        }

        System.out.println("Cities before sorting : ");
        for (int i = 0; i < cities.size(); i++) {
            System.out.println((i+1) + " - " + cities.get(i));
        } 

        sc.close(); // closes the scanner

        System.out.println("\n");
        
        List<City> cities_sorted = new ArrayList<>();

        Scanner in = new Scanner(System.in);  
          
        System.out.print("Depending on which seeting do you want to sort the cities?" + "\n" + 
                                                                                            "1- Elevation" + "\n" + 
                                                                                            "2- Population" + "\n" + 
                                                                                            "Choose the setting number : ");  
          
        String trie = in.nextLine();  

        System.out.print("Do you want to sort in an ascending or descending way?" + "\n" + 
                                                                                        "1- Ascending" + "\n" + 
                                                                                        "2- Descending" + "\n" + 
                                                                                        "Choose the setting number : ");

        String ordre = in.nextLine();  

        if(trie.equals("1")){
            System.out.println("You chose to sort depending on Elevation"); 

            for (int j = 0; j < cities.size() + cities_sorted.size(); j++){
                City max_city = cities.get(0);
                for (int i = 0; i < cities.size(); i++) {
                    if (cities.get(i).getElevation() > max_city.getElevation()){
                        max_city = cities.get(i);
                    }
                }
                cities_sorted.add(max_city);
                cities.remove(max_city);
                }


        }else if(trie.equals("2")){
            System.out.println("You chose to sort depending on Population"); 

            for (int j = 0; j < cities.size() + cities_sorted.size(); j++){
                City max_city = cities.get(0);
                for (int i = 0; i < cities.size(); i++) {
                    if (cities.get(i).getPopulation() > max_city.getPopulation()){
                        max_city = cities.get(i);
                    }
                }
                cities_sorted.add(max_city);
                cities.remove(max_city);
                }


        }        
          

        in.close(); 


        // System.out.println("\n" + max_city); //Show the city with max population/elevation "testing"

        if (ordre.equals("1")){
        System.out.println("\n\n" + "Cities after sorting (ascending) : \n"); 
        for (int i = cities_sorted.size(); i > 0; i--) {
            System.out.println((51 - i) + " - " + cities_sorted.get(i - 1));
        }

        }else if(ordre.equals("2")){
            System.out.println("\n\n" + "Cities after sorting (descending) : \n");
            for (int i = 0; i < cities_sorted.size(); i++) {
                System.out.println((i+1) + " - " + cities_sorted.get(i));
            } 
        }

    }  
}  