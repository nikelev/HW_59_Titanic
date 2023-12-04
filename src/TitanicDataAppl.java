import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TitanicDataAppl {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("train.csv"))) {
            String str = br.readLine();
            //  System.out.println(str);


            String[] passengers = str.split(",");
            print(passengers);


//            Задание 1
//            Подсчитайте общую стоимость проезда.
//            Задание 2
//            Подсчитайте средний тариф для 1,2,3 классов путешествия.
//            Задание 3
//            Подсчитайте общее количество выживших и погибших пассажиров.
//                    Задание 4
//            Подсчитайте общее количество выживших и погибших мужчин, женщин и детей (до 18 лет).

            double totalFare = 0;

            double fareClass1 = 0;
            double fareClass2 = 0;
            double fareClass3 = 0;

            int totalPassenger = 0;
            int passengerClass1 = 0;
            int passengerClass2 = 0;
            int passengerClass3 = 0;

            int countSurvived = 0;
            int countSurvivedMale = 0;
            int countSurvivedFemale = 0;
            int countSurvivedChild = 0;

            int countUnSurvived = 0;
            int countUnSurvivedMale = 0;
            int countUnSurvivedFemale = 0;




            str = br.readLine();
            while (str != null) {
                totalPassenger++;
                passengers = str.split(",");
                totalFare += Double.parseDouble(passengers[10]);
                if (Integer.valueOf(passengers[2]) == 1) {
                    passengerClass1++;
                    fareClass1 += Double.parseDouble(passengers[10]);
                }

                if (Integer.valueOf(passengers[2]) == 2) {
                    passengerClass2++;
                    fareClass2 += Double.parseDouble(passengers[10]);
                }

                if (Integer.valueOf(passengers[2]) == 3) {
                    passengerClass3++;
                    fareClass3 += Double.parseDouble(passengers[10]);
                }



                if (Integer.valueOf(passengers[1]) == 1) {
                    countSurvived++;
                    if (passengers[5].equalsIgnoreCase("male") && !passengers[6].isEmpty()) {
                        if (Double.valueOf(passengers[6]) >= 18) {
                            countSurvivedMale++;

                        }
                    }
                    if (!passengers[6].isEmpty()) {
                        if (Double.valueOf(passengers[6]) >= 18) {
                            countSurvivedFemale++;
                        }
                    }
                }

                if (Integer.valueOf(passengers[1]) == 0) {
                    countUnSurvived++;
                    if (passengers[5].equalsIgnoreCase("female") && !passengers[6].isEmpty()) {
                        if (Double.valueOf(passengers[6]) >= 18) {
                            countUnSurvivedFemale++;

                        }
                    }
                    if (!passengers[6].isEmpty()) {
                        if (Double.valueOf(passengers[6]) >= 18) {
                            countUnSurvivedMale++;
                        }
                    }
                }

                if (Integer.valueOf(passengers[1]) == 1) {
                    if (!passengers[6].isEmpty()) {
                        if (Double.valueOf(passengers[6]) < 18) {
                            countSurvivedChild++;
                        }
                    } else countSurvivedChild++;

                }




//                LocalDate birtthDate=LocalDate.parse(cells[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
//                age+= ChronoUnit.YEARS.between(birtthDate,  LocalDate.now());


                str = br.readLine();

            }

            System.out.println("Total fare = " + totalFare);

            System.out.println("Avg fare = " + totalFare / totalPassenger);
            System.out.println("Avg fare class1 = " + fareClass1 / passengerClass1);
            System.out.println("Avg fare class2 = " + fareClass2 / passengerClass2);
            System.out.println("Avg fare class3 = " + fareClass3 / passengerClass3);

            System.out.println("Was Survived total: " + countSurvived + " peoples");
            System.out.println("Was not Survived total: " + countUnSurvived + " peoples");

            System.out.println("Total quantity of survived  men: " + countSurvivedMale);
            System.out.println("Total quantity of survived  women: " + countSurvivedFemale);
            System.out.println("Total quantity of survived  children: " + countSurvivedChild);

            System.out.println("Total quantity of non survived  men: " + countUnSurvivedMale);
            System.out.println("Total quantity of non survived  women: " + countUnSurvivedFemale);
            System.out.println("Total quantity of non survived  children: " + ( totalPassenger - countSurvived - countUnSurvivedFemale - countUnSurvivedMale));






        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void print(String[] passengers) {
        for (String p : passengers) {
            System.out.print(p + "\t");
        }
        System.out.println();
    }

}