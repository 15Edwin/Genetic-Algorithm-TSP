/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ga_tsp;

 import java.io.File;
 import java.io.FileNotFoundException;
 import java.util.Scanner;
 import java.util.logging.Level;
 import java.util.logging.Logger;
 import java.util.ArrayList;
 import java.io.PrintWriter;


/**
 *
 * @author Edwin
 */
public class TSP_GA {
     public static void main(String[] args) throws FileNotFoundException {
        ExecutionTimer timer = new ExecutionTimer();
        
        //insert dataset
        String fileName = "E:\\datasets/small1.csv";
        File file = new File(fileName); // TODO: read about File Names
        try {
            Scanner input = new Scanner(file);
            //create array
            int kota = input.nextInt();
            City a[] = new City[kota];
            //get size array
            int  index=0;
            while (input.hasNext()){
                String b = input.next();
                String array1[]= b.split(",");

                a[index] = new City(index, Integer.parseInt(array1[0]),Integer.parseInt(array1[1]));
                TourManager.addCity(a[index]);
                index++;
            /*  String data = inputStream.next();
                System.out.println(data); */
            }
            input.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        // Create and add our cities
        /*City city = new City(60, 200);
        TourManager.addCity(city);
        City city2 = new City(180, 200);
        TourManager.addCity(city2);
        City city3 = new City(80, 180);
        TourManager.addCity(city3);
        City city4 = new City(140, 180);
        TourManager.addCity(city4);
        City city5 = new City(20, 160);
        TourManager.addCity(city5);
        City city6 = new City(100, 160);
        TourManager.addCity(city6);
        City city7 = new City(200, 160);
        TourManager.addCity(city7);
        City city8 = new City(140, 140);
        TourManager.addCity(city8);
        City city9 = new City(40, 120);
        TourManager.addCity(city9);
        City city10 = new City(100, 120);
        TourManager.addCity(city10);
        City city11 = new City(180, 100);
        TourManager.addCity(city11);
        City city12 = new City(60, 80);
        TourManager.addCity(city12);
        City city13 = new City(120, 80);
        TourManager.addCity(city13);
        City city14 = new City(180, 60);
        TourManager.addCity(city14);
        City city15 = new City(20, 40);
        TourManager.addCity(city15);
        City city16 = new City(100, 40);
        TourManager.addCity(city16);
        City city17 = new City(200, 40);
        TourManager.addCity(city17);
        City city18 = new City(20, 20);
        TourManager.addCity(city18);
        City city19 = new City(60, 20);
        TourManager.addCity(city19);
        City city20 = new City(160, 20);
        TourManager.addCity(city20); 
    */
            // Initialize population
            Population pop = new Population(200, true);
            System.out.println("***Genetic Algorithm***");
            System.out.println("");
            System.out.println("Initial distance: " + pop.getFittest().getDistance());

            // Evolve population for 100 generations
            pop = GA.evolvePopulation(pop);
            for (int i = 0; i < 200; i++) {
                pop = GA.evolvePopulation(pop);
                timer.end();
                while(timer.duration() >= 1000){
                    System.out.println("Final distance : " + pop.getFittest().getDistance());
                    System.out.println("Solution :");
                    System.out.println(pop.getFittest());

                    // export solution to csv
                    PrintWriter csv = new PrintWriter(new File("GA solution.csv"));
                    StringBuilder sb = new StringBuilder();
                    sb.append("***Genetic Algorithm***");
                    sb.append("\n");
                    sb.append("Sequence");
                    sb.append("\n");                
                    sb.append("\n");
                    
                    String solution = String.valueOf(pop.getFittest());
                    String[] seq = solution.split(" -> ");

                    for(int u = 0; u < seq.length; u++){
                        sb.append(seq[u]);
                        sb.append("\n");
                    }
                    
                    sb.append("\n");
                    sb.append("Total Distance : " + pop.getFittest().getDistance());
                                                            
                    csv.write(sb.toString());
                    csv.close();
                    
                    timer.end();
                    System.out.println("");
                    System.out.println("Running time : " + timer.duration() + " ms");
                    System.out.println("Last iteration : " + i);
                    System.exit(0);
                }
            }
            
            System.out.println("Final distance : " + pop.getFittest().getDistance());
            System.out.println("Best tour :");
            System.out.println(pop.getFittest());

            // export solution to csv
            PrintWriter csv = new PrintWriter(new File("GA solution.csv"));
            StringBuilder sb = new StringBuilder();
            sb.append("***Genetic Algorithm***");
            sb.append("\n");
            sb.append("Sequence");
            sb.append("\n");                
            sb.append("\n");
                    
            String solution = String.valueOf(pop.getFittest());
            String[] seq = solution.split(" -> ");

            for(int u = 0; u < seq.length; u++){
                sb.append(seq[u]);
                sb.append("\n");
            }
                    
            sb.append("\n");
            sb.append("Total Distance : " + pop.getFittest().getDistance());
                                                            
            csv.write(sb.toString());
            csv.close();
                    
            timer.end();
            System.out.println("");
            System.out.println("Running time : " + timer.duration() + " ms");
            System.exit(0);
        }
}