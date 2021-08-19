package core;

import Entity.Localization;
import Entity.Result;
import com.sun.xml.bind.v2.TODO;
import hibernate_core.DatabaseCommunication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Launcher {

    static List<Localization> localizations = DatabaseCommunication.getLocalizationList();
    static List<Localization> tmpLocalizations;
    static List<Result> resultsLists = new ArrayList<>();


    public static void start (){
        boolean finish = false;
        while (!finish) {
            switch (choice()) {
                case 1:
                    newLocalization();
                    break;
                case 2:
                    Result tmpResult = localizationChoice();
                    if (tmpResult != null) {
                        resultsLists.add(tmpResult);
                    }
                    break;
                case 3:
                    finish = true;
                    break;
                default:
                    System.out.println("Nie rozpoznano komendy");
            }
        }
        if (!tmpLocalizations.isEmpty()) {
            DatabaseCommunication.saveLocation(tmpLocalizations);
        }
        if (!resultsLists.isEmpty()) {
            DatabaseCommunication.saveResults(resultsLists);
        }
    }

    private static void newLocalization() {
        if(tmpLocalizations == null) {
            tmpLocalizations = new ArrayList<>();
        }
        Scanner scanner =  new Scanner(System.in);
        System.out.println("Podaj miasto");
        String city = scanner.nextLine();
        System.out.println("Podaj skrót literowy kraju");
        String country = scanner.nextLine();
        Localization tmpLoc = new Localization(city, country);
        if (tmpLoc.getID() != null) {
            localizations.add(tmpLoc);
            tmpLocalizations.add(tmpLoc);
        }
    }

    private static Result localizationChoice() {
        Scanner scanner = new Scanner(System.in);
        int count = 1;
        for (Localization localization : localizations) {
            System.out.println("" + (count++) + " " + localization);
        }
        System.out.println("Wybierz numer lokalizacji dla której wyświetlić pogodę\n" +
                "Albo 0 by wrócić do menu głównego");
        int answer = scanner.nextInt();
        scanner.nextLine();

        if (answer == 0) {
            return null;
        } else if (answer >localizations.size() || answer < 0) {
            System.out.println("Wybrano nieistniejący numer, spróbuj ponownie");
            localizationChoice();
        } else {
            answer--;
            Result result = new Result(localizations.get(answer));
            System.out.println(result.getAverageWeather());
            return result;
        }
        return null;
    }

    private static int choice(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz opcje:\n" +
                "1. Dodaj lokalizację\n" +
                "2. Wyświetl listę lokalizacji\n" +
                "3. Zakończ program");
        int answer = scanner.nextInt();
        scanner.nextLine();
        return answer;
    }

}
