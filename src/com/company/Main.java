package com.company;

import java.io.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.company.patternstrategy.*;

public class Main {
/*

 */
    public static void main(String[] args) {
        /*
        TP_CelciusInFahrenheit();
        return;
        */

        //write_file_objectInputStream();
        lambda_Thread();

        /*


        Reproduction.description();

        Personnage[] tPers = {new Guerrier(), new Civil(), new Medecin()};
        Personnage p = tPers[1];
        p.setEspritCombatif(new CombatPistolet());
        p = tPers[2];
        p.setEspritCombatif(new CombatCouteau());


        for(int i = 0; i < tPers.length; i++){
            System.out.println("\nInstance de " + tPers[i].getClass().getName());
            System.out.println("*****************************************");
            tPers[i].combattre();
            tPers[i].seDeplacer();
            tPers[i].soigner();
        }

         */
    }

    public static void lambda_Thread(){
        //Thread th = new Thread(()-> System.out.print("Lambda Hello World inside new Thread"));
        //th.run();

/*
        List<String> list = new ArrayList<>();
        list.add("Mahesh");
        list.add( "Ram");
        list.add("Krishna");
        Consumer<String> style = (String p) -> System.out.println(p);
        System.out.println("---Before delete---");
        list.forEach(style);

        Predicate<String> personPredicate = p -> p.charAt(2) != 'M';
        list.removeIf(personPredicate);
        System.out.println("---After delete---");
        list.forEach(style);
*/

        //List<String> l = Arrays.asList("lulu", "toto", "pupu",  "citi", "mutu");
        List<String> l = new ArrayList<String>(Arrays.asList("lulu", "toto", "pupu",  "citi", "mutu"));
        //l.add("Mahesh");
        //l.add( "Ram");
        //l.add("Krishna");
        List<String> l2 = Arrays.asList("lulu", "toto", "pupu",  "citi", "mutu");

        //ArrayList<String> l2 = new ArrayList<String>();
        //l.forEach(s -> l2.add(s));

        /*
        System.out.println("Lambda 1 ------------- \n");
        l.sort((s, t1) -> {
            System.out.println(s + "----" + t1);
            //s.compareTo(t1);
            return s.compareTo(t1);
        });
        System.out.println("Lambda 2 ------------- \n");
        l.forEach(s -> {
            System.out.println(s);
        });
        */

        System.out.println("Lambda 3 ------------- \n");
        Predicate<String> personPredicate = p -> p.charAt(1) != 'u';
        //l.removeIf(personPredicate);


        /*
        l2.removeIf(s -> {
            //System.out.println(s.charAt(3) != 'u');
            Boolean res = s.charAt(3) != 'u';
            return true;
        });
        */

        /*
        l.forEach(s -> {
            System.out.println(s);
        });
        l.foreach (System.out::Println); //Méthode référence
        */


        l.stream()
                .filter(s -> s.charAt(1) != 'u')
                .sorted((s, t1) -> s.compareTo(t1))
                .forEach(s -> System.out.println(s));

    }

    public static void test(){
        List l = new LinkedList();
        l.add(12);
        l.add("toto ! !");
        l.add(12.20f);

        for(int i = 0; i < l.size(); i++)
            System.out.println("Élément à l'index " + i + " = " + l.get(i));

        System.out.println("\n \tParcours avec un itérateur ");
        System.out.println("-----------------------------------");
        ListIterator li = l.listIterator();

        while(li.hasNext())
            System.out.println(li.next());
    }

    public static void lecture_file(){
        //Création de l'objet File
        File f = new File("test.txt");
        System.out.println("Chemin absolu du fichier : " + f.getAbsolutePath());
        System.out.println("Nom du fichier : " + f.getName());
        System.out.println("Est-ce qu'il existe ? " + f.exists());
        System.out.println("Est-ce un répertoire ? " + f.isDirectory());
        System.out.println("Est-ce un fichier ? " + f.isFile());

        System.out.println("Affichage des lecteurs à la racine du PC : ");
        for(File file : f.listRoots())
        {
            System.out.println(file.getAbsolutePath());
            try {
                int i = 1;
                //On parcourt la liste des fichiers et répertoires
                for(File nom : file.listFiles()){
                    //S'il s'agit d'un dossier, on ajoute un "/"
                    System.out.print("\t\t" + ((nom.isDirectory()) ? nom.getName()+"/" : nom.getName()));

                    if((i%4) == 0){
                        System.out.print("\n");
                    }
                    i++;
                }
                System.out.println("\n");
            } catch (NullPointerException e) {
                //L'instruction peut générer une NullPointerException
                //s'il n'y a pas de sous-fichier !
            }
        }
    }

    public static void lecture_otherfile(){


        //Nous déclarons nos objets en dehors du bloc try/catch
        FileInputStream fis;
        BufferedInputStream bis;
        try {
            fis = new FileInputStream(new File("Dictionnaire.txt"));
            bis = new BufferedInputStream(new FileInputStream(new File("Dictionnaire.txt")));
            byte[] buf = new byte[200];

            //On récupère le temps du système
            long startTime = System.currentTimeMillis();
            //Inutile d'effectuer des traitements dans notre boucle
            while(fis.read(buf) != -1);
            //On affiche le temps d'exécution
            System.out.println("Temps de lecture avec FileInputStream : " + (System.currentTimeMillis() - startTime));

            //On réinitialise
            startTime = System.currentTimeMillis();
            //Inutile d'effectuer des traitements dans notre boucle
            while(bis.read(buf) != -1);
            //On réaffiche
            long endTime = System.currentTimeMillis() - startTime;
            System.out.println("Temps de lecture avec BufferedInputStream : " + endTime);


            //On ferme nos flux de données
            fis.close();
            bis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void write_file_objectInputStream(){
        //Nous déclarons nos objets en dehors du bloc try/catch
        ObjectInputStream ois;
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(
                                    new File("game.txt"))));

            //Nous allons écrire chaque objet Game dans le fichier
            oos.writeObject(new Game("Assassin Creed", "Aventure", 45.69));
            oos.writeObject(new Game("Tomb Raider", "Plateforme", 23.45));
            oos.writeObject(new Game("Tetris", "Stratégie", 2.50));
            //Ne pas oublier de fermer le flux !
            oos.close();

            //On récupère maintenant les données !
            ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(
                                    new File("game.txt"))));

            try {
                System.out.println("Affichage des jeux :");
                System.out.println("*************************\n");
                System.out.println(((Game)ois.readObject()).toString());
                System.out.println(((Game)ois.readObject()).toString());
                System.out.println(((Game)ois.readObject()).toString());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            ois.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void file_reader_file_writer(){
        File file = new File("testFileWriter.txt");
        FileWriter fw;
        FileReader fr;

        try {
            //Création de l'objet
            fw = new FileWriter(file);
            String str = "Bonjour à tous, amis Zéros !\n";
            str += "\tComment allez-vous ? \n";
            //On écrit la chaîne
            fw.write(str);
            //On ferme le flux
            fw.close();

            //Création de l'objet de lecture
            fr = new FileReader(file);
            str = "";
            int i = 0;
            //Lecture des données
            while((i = fr.read()) != -1)
                str += (char)i;

            //Affichage
            System.out.println(str);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void TP_CelciusInFahrenheit() {

        int i;
        Scanner sc = new Scanner(System.in);
        String nextChoice="N";
        do{
            System.out.println( "CONVERTISSEUR DEGRES CELCIUS ET DEGRES FAHRENHEIT \n" +
                    "--------------------------------------------------\n" +
                    "Choisissez le mode de conversion :\n" +
                    "1 - Convertisseur Celcius -> Fahrenheit\n" +
                    "2 - Convertisseur Fahrenheit -> Celcius");

            i = sc.nextInt();
            double degre;
            double resultat;

            System.out.println("Température à convertir : ");
            degre = sc.nextDouble();

            switch (i) {
                case 1:
                    resultat = celciusToFahrenheit(degre);
                    System.out.println(degre + "° C correspond à une valeur de " + resultat +  "° F \n");
                    break;
                case 2:
                    resultat = FahrenheitToCelcius(degre);
                    System.out.println(degre + "° F correspond à une valeur de " + resultat+ "° C \n");
                    break;
            }

            System.out.println("Souhaitez vous convertir une autre température ?(O/N) \n");
            nextChoice = sc.nextLine();
            nextChoice = sc.nextLine();

            if (nextChoice.toString().charAt(0) == 'N'){
                System.out.println("Au revoir \n");
            }

        }while((i == 1 || i ==2) && (nextChoice.toString().charAt(0) == 'O'));


    }

    private static double celciusToFahrenheit(double degreCelcius){
        return ((9 / 5) * degreCelcius + 32);
    }

    private static double FahrenheitToCelcius(double degreFahrenheit){
        return (((degreFahrenheit - 32) * 5) / 9);
    }



    private static void oldStuff(){

        // write your code here
        System.out.println("very first new prog" + Main.class.getName());
        int nbre1, nbre2, nbre3;    //Déclaration des variables
        nbre1 = nbre2 = nbre3 = 0;  //Initialisation

        nbre1 = nbre1 + 1;     //nbre1 = lui-même, donc 0 + 1 => nbre1 = 1
        nbre1 = nbre1 + 1;     //nbre1 = 1 (cf. ci-dessus), maintenant, nbre1 = 1 + 1 = 2
        nbre2 = nbre1;         //nbre2 = nbre1 = 2
        nbre2 = nbre2 * 2;     //nbre2 = 2 => nbre2 = 2 * 2 = 4
        nbre3 = nbre2;         //nbre3 = nbre2 = 4
        nbre3 = nbre3 / nbre3; //nbre3 = 4 / 4 = 1
        nbre1 = nbre3;         //nbre1 = nbre3 = 1
        nbre1 = nbre1 - 1;     //nbre1 = 1 - 1 = 0


        double nombre = 1000000000000d; // cast en d
        //Peut s'écrire ainsi
        double nombre2 = 1____000____000___000_000d; // cast en d
        //Le nombre d'underscore n'a pas d'importance

        //Voici quelques autres exemple d'utilisation
        int entier = 32_000;
        double monDouble = 12_34_56_78_89_10d; // cast en d
        double monDouble2 = 1234_5678_8910d;   // cast en d
/*
        Scanner sc = new Scanner(System.in);
        System.out.println("Saisissez un entier : ");
        int i = sc.nextInt();
        System.out.println("Saisissez une chaîne : ");
        String str = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println(Integer.toString(i)  + str2 +  "FIN ! ");
 */

//Une variable vide
        String prenom;
//On initialise celle-ci à O pour oui
        char reponse = 'O';
//Notre objet Scanner, n'oubliez pas l'import de java.util.Scanner !
        Scanner sc = new Scanner(System.in);
//Tant que la réponse donnée est égale à oui…
        while (reponse == 'O')
        {
            //On affiche une instruction
            System.out.println("Donnez un prénom : ");
            //On récupère le prénom saisi
            prenom = sc.nextLine();
            //On affiche notre phrase avec le prénom
            System.out.println("Bonjour " +prenom+ ", comment vas-tu ?");
            //On demande si la personne veut faire un autre essai
            System.out.println("Voulez-vous réessayer ? (O/N)");
            //On récupère la réponse de l'utilisateur
            reponse = sc.nextLine().charAt(0);

            while (reponse != 'O' && reponse != 'N' )
            {
                System.out.println("Voulez devez saisir : O ou N ");
                reponse = sc.nextLine().charAt(0);
            }

        }

        System.out.println("Au revoir…");
//Fin de la boucle
    }

}
