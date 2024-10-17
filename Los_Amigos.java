/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package dimitris_pntz.los_amigos;

/**
 *
 * @author dimit
 */
public class Los_Amigos {
    public static void PrintMainRoster(String Names[]){
        System.out.println("|----------------LOS-AMIGOS-ROSTER---------------------|");
        System.out.println("| PLAYER 1   PLAYER 2   PLAYER 3   PLAYER 4   PLAYER 5 |");
        System.out.print("|");
        
        int OutputSize = 13;
        
        for(int i=0; i<5;i++){
            int NameSize = Names[i].length();
            int PaddingSize = (OutputSize - NameSize) / 2;
            
            for(int j=0;j<PaddingSize-1;j++){
                System.out.print(" ");
            }
            
            System.out.print(Names[i]);
            
            for(int j=0;j<PaddingSize-1;j++){
                System.out.print(" ");
            }            
        }
        
        System.out.print(" |");
        System.out.print("\n");
        System.out.println("|------------------------------------------------------|");
        
    }
    
    public static void PlayerStats(String Names[], int Age[], int Points[]){
        int OldestPlayer = -99;
        int YoungestPlayer = 99;
        
        float AvgPoints = 0.0f;
        float AvgAge = 0.0f;
        
        for(int i=0;i<5;i++){
            int age = Age[i];
            int points = Points[i];
            
            String Sage = Integer.toString(age);
            String Spoints = Integer.toString(points);
            
            AvgPoints += Float.parseFloat(Spoints);
            AvgAge += Float.parseFloat(Sage);
                    
            if(age > OldestPlayer){
                OldestPlayer = i;
            }
            
            if(age < YoungestPlayer){
                YoungestPlayer = i;
            }
        }
        
        AvgAge /= 5;
        AvgPoints /= 5;
        
        int range = OldestPlayer - YoungestPlayer;
        
        System.out.println("The Oldest Player is: " + Names[OldestPlayer] + " being " + Age[OldestPlayer] + ".");
        System.out.println("The Youngest Player is: " + Names[YoungestPlayer] + " being " + Age[YoungestPlayer] + ".");
       
        System.out.println("Printing the Players from youngest to oldest: ");
        int SortedAges[] = {0, 1, 2, 3, 4};
        
        //Bubble sort
        for(int i=0;i<SortedAges.length;i++){
            for(int j=0;j<SortedAges.length;j++){
                if(Age[i] < Age[j]){
                    int temp =  Age[i];
                    Age[i] = Age[j];
                    Age[j] = temp;
                }
            }
        }
        
        for(int i=0;i<SortedAges.length;i++){
            System.out.print(Names[i] + " " + Age[i] + " ");
        }
        
        System.out.println("\n");
        System.out.println("That is a Age range of: " + range);
        System.out.println("The average Age for the team is: " + AvgAge);
        System.out.println("The average points scored this season is: " + AvgPoints);  
    }
    
    public static void ReserveStats(String Reserves[], int PointReserves[], String Names[], int Age[], int Points[]){
        //Find who should be switched
        int ReserveMax = 0;
        int MainMin = 0;
        
        for(int i=0;i<5;i++){
            int ReservePoints = PointReserves[i];
            int MainPoints = Points[i];
            
            if(ReservePoints > PointReserves[ReserveMax]){
                ReserveMax = i;
            }
            
            if(MainPoints < Points[MainMin]){
                MainMin = i;
            }
        }
        
        System.out.println(Names[MainMin] + " Should be switched and replaced with " + Reserves[ReserveMax]);
        
        float NewAvg = 0.0f;
        
        for(int i=0;i<5;i++){
            float Point;
            
            if(i == MainMin){
                Point = Float.parseFloat(Integer.toString(PointReserves[ReserveMax]));
            }else{
                Point = Float.parseFloat(Integer.toString(Points[i]));
            }
            
            NewAvg += Point;
        }
        
        NewAvg /= 5;
        
        System.out.println("The new avg is: " + NewAvg);
    }
    
    public static void MakeYoungerSquad(String Reserves[], int PointReserves[], int ReserveAges[], String Names[], int Age[], int Points[]){
        float AvgStartingSquadAge = 0.0f;
        
        for(int i=0;i<5;i++){
            AvgStartingSquadAge += Float.parseFloat(Integer.toString(Age[i]));
        }
        
        AvgStartingSquadAge /= 5;
        
        
        //Sort the team
        //Bubble sort
        int BestReserves[] = {0,1,2,3,4};
        
        for(int i=0;i<5;i++){
            for(int j=i;j<5;j++){
                if(PointReserves[BestReserves[i]] < PointReserves[BestReserves[j]]){
                    int temp = BestReserves[i];
                    BestReserves[i] = BestReserves[j];
                    BestReserves[j] = temp;
                }
            }
        }
        
        int ReserveCounter = 0;
        
        String NewTeam[] =  new String[5];
        
        for(int i=0;i<5;i++){
            if(Float.parseFloat(Integer.toString(Age[i])) > AvgStartingSquadAge){
                //Get the best reserve player
                int BestReserve = BestReserves[ReserveCounter];
                ReserveCounter++;
                
                NewTeam[i] = Reserves[BestReserve];
            }else{
                NewTeam[i] = Names[i];
            }
        }
        
        System.out.println("New Younger Team Team:");
        
        for(int i=0;i<5;i++){
            System.out.print(" Player " + (i+1) + " " + NewTeam[i] + "Age: " + ReserveAges[i] + " ");
        }
    }
    
    public static void MakeSuperTeam(String Reserves[], int PointReserves[], int ReserveAges[], String Names[], int Age[], int Points[]){
        String NAMES_UNITED[] = new String[Names.length + Reserves.length];
        int AGE_UNITED[] = new int[Names.length + Reserves.length];
        int POINTS_UNITED[] = new int[Names.length + Reserves.length];
        
        int MainCounter = 0;
        int ReserveCounter = 0;
        
        for(int i=0;i<Names.length + Reserves.length;i+=2){
            NAMES_UNITED[i] = Names[MainCounter];
            NAMES_UNITED[i+1] = Reserves[ReserveCounter];
            
            AGE_UNITED[i] = Age[MainCounter];
            AGE_UNITED[i+1] = ReserveAges[ReserveCounter];
            
            POINTS_UNITED[i] = Points[MainCounter];
            POINTS_UNITED[i+1] = PointReserves[ReserveCounter];
            
            MainCounter++;
            ReserveCounter++;
        }
        
        int BestTeam[] = {0,1,2,3,4,5,6,7,8,9};
        
        for(int i=0;i<10;i++){
            for(int j=i;j<10;j++){
                if(POINTS_UNITED[BestTeam[i]] < POINTS_UNITED[BestTeam[j]]){
                    int temp = BestTeam[i];
                    BestTeam[i] = BestTeam[j];
                    BestTeam[j] = temp;
                }
            }
        }
        
        System.out.println("Super Team");
        
        for(int i=0;i<10;i++){
            System.out.print("Player " + i + ": " + NAMES_UNITED[BestTeam[i]] + " ");
        }
        
        System.out.println("\n");
    }
    
    public static void main(String[] args) {
        String Names[] = {"Boss", "Block", "Brawn", "Brayant", "Clorksan"};
        int Age[] = {30, 24 , 23, 37, 23};
        int Points[] = {473, 133, 115, 1161, 1225};
        
        System.out.println("Hello, Welcome to the Los Amigos Team Management software!");
        
        PrintMainRoster(Names);
        PlayerStats(Names, Age, Points);
        
        String Reserves[] = {"Hebbit", "Heurtas", "Kylle", "Nenca", "Rendla"};
        int ReserveAges[] = {29, 32, 25, 23, 21};
        int PointReserves[] = {481, 237, 152, 349, 919};
        
        ReserveStats(Reserves, PointReserves, Names, Age, Points);
        MakeYoungerSquad(Reserves, PointReserves, ReserveAges, Names, Age, Points);
        MakeSuperTeam(Reserves, PointReserves, ReserveAges, Names, Age, Points);
        
        String NewcomerName = "BRAYNT_JR";
        int NewcomerAge = 18;
        int NewcomerPoints = 0;
        
        
        //Binary Search
        //First sort the list
        for(int i=0;i<5;i++){
            for(int j=i;j<5;j++){
                if(Points[i] < Points[j]){
                    int temp = Points[i];
                    Points[i] = Points[j];
                    Points[j] = temp;
                    
                    temp = Age[i];
                    Age[i] = Age[j];
                    Age[j] = temp;
                    
                    String TempName = Names[i];
                    Names[i] = Names[j];
                    Names[j] = TempName;
                }
            }
        }
        
        //Find the position of BRAYNT in the list using BS
        
        int L = 0;
        int R = Points.length;
        
        int position = 0;
        
        while(true){
            int midpoint = (L + R) / 2;
            
            if(Points[midpoint] == 1161){
                position = midpoint;
                break;
            }else{
                if(Points[midpoint] < 1161){
                    R = midpoint;
                }else{
                    L = midpoint;
                }
            }
        }
        
        System.out.println("The position of BRAYNT is: " + position);
        
        //Now we can replace BRAYNTS info with his sons and resort the list to push him to the back
        Names[position] = NewcomerName;
        Age[position] = NewcomerAge;
        Points[position] = NewcomerPoints;
        
        for(int i=0;i<5;i++){
            for(int j=i;j<5;j++){
                if(Points[i] < Points[j]){
                    int temp = Points[i];
                    Points[i] = Points[j];
                    Points[j] = temp;
                    
                    temp = Age[i];
                    Age[i] = Age[j];
                    Age[j] = temp;
                    
                    String TempName = Names[i];
                    Names[i] = Names[j];
                    Names[j] = TempName;
                }
            }
        }
        
        for(int i=0;i<5;i++){
            System.out.println("Player " + i+1 + ": " + Names[i] + " Points: " + Points[i] + " Age: " + Age[i]);
        }
        
        
        
    }
    
    
}
