package core;

import Entity.Localization;
import Entity.Result;
import java.util.List;
import java.util.Scanner;

public class Launcher {
    static boolean finish = false;
    static List<Localization> localizations = Localization.getList();
    public static void start (){
        while (!finish) {
            switch (choice()) {
                case 1:
                    newLocalization();
                    break;
                case 2:
                    localizationChoice();
                    break;
                case 3:
                    finish = true;
                    break;
                default:
                    System.out.println("Nie rozpoznano komendy");
            }
        }
    }

    private static void newLocalization() {
        Scanner scanner =  new Scanner(System.in);
        System.out.println("Podaj miasto");
        String city = scanner.nextLine();
        System.out.println("Podaj skrót literowy kraju");
        String country = scanner.nextLine();
        localizations.add(new Localization(city, country));
    }

    private static void localizationChoice() {
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
            return;
        } else if (answer >localizations.size() || answer < 0) {
            System.out.println("Wybrano nieistniejący numer, spróbuj ponownie");
            localizationChoice();
        } else {
            answer--;
            Result result = new Result(localizations.get(answer));
            System.out.println(result.getAverageWeather());
        }

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
