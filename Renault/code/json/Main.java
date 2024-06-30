package code.json;

import java.io.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.*; 

import code.City;

public class Main { 

    public static void main(String[] args) throws Exception {

        List<City> cities = new ArrayList<>();   

         JSONParser parser = new JSONParser();

         FileReader reader = new FileReader("files\\cities.json");
            
        JSONObject jsonObject = (JSONObject) parser.parse(reader);
        
        JSONArray capitalsArray = (JSONArray) jsonObject.get("capitals");

        //construct cities from JSON
        for (Object obj : capitalsArray) {
            JSONObject cityObject = (JSONObject) obj;
            String city = (String) cityObject.get("city");
            String country = (String) cityObject.get("country");
            int elevation = ((Long) cityObject.get("elevation")).intValue();
            int population = ((Long) cityObject.get("population")).intValue();
            cities.add(new City(city, country, elevation, population));
        }

        System.out.println("Cities before sorting : ");
        for (int i = 0; i < cities.size(); i++) {
            System.out.println((i + 1) + " - " + cities.get(i));
        }        

        
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
            System.out.println((37 - i) + " - " + cities_sorted.get(i - 1));
        }

        }else if(ordre.equals("2")){
            System.out.println("\n\n" + "Cities after sorting (descending) : \n");
            for (int i = 0; i < cities_sorted.size(); i++) {
                System.out.println((i+1) + " - " + cities_sorted.get(i));
            } 
        }
            

    }  
}  