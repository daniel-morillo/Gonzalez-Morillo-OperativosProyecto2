/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto2so;

import java.util.Random;

/**
 *
 * @author Daniel Morillo
 */
public class Proyecto2SO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //esto es para crear los personajes son esos nombres e imagenes fijas
        String RSNames[] = {"Mordecai","Rigby","Skips","Musculoso","Fantasmin","Benson","Thomas","Papaleta","Muerte","AntiPapaleta","Margarita","CJ","Aylin"};
        
        String RSPhotos[] = {"src/resources/mordecai.png","src/resources/rigby.png","src/resources/skips.png","src/resources/musculoso.png","src/resources/fantasmin.png","src/resources/benson.png","src/resources/thomas.png","src/resources/papaleta.png","src/resources/death.png","src/resources/antipops.png","src/resources/margarita.png","src/resources/cj.png","src/resources/aylin.png"};
        
        String AVNames[] = {"Aang", "Katara", "Sokka", "Toph", "Zuko", "Iroh", "Appa", "Momo", "Suki", "Azula", "Ozai", "Ty Lee", "Bumi"};
        
        String AVPhotos[] = {"src/resources/Aang.PNG","src/resources/Katara.png","src/resources/Sokka.PNG", "src/resources/Toph.PNG", "src/resources/Zuko.PNG", "src/resources/Iroh.png", "src/resources/Appa.PNG", "src/resources/Momo.PNG", "src/resources/Suki.PNG", "src/resources/Azula.PNG" , "src/resources/Ozai.PNG" , "src/resources/Ty-Lee.PNG", "src/resources/Bumi.PNG"};
        
        Company RSCompany = new Company( '@', RSNames, RSPhotos);
        Company AVCompany = new Company('@', AVNames, AVPhotos);
        
        RSCompany.CreateCharacter();
        
        Integer prueba = RSCompany.getNumCharacter();
        
        Random random = new Random();
        int result = random.nextInt(2) + 1;
        
        System.out.println(result);
        
        
}
}
