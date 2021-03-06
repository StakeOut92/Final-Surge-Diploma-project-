package utilites;

import com.github.javafaker.Faker;

public class GenerateFakeMessage {

    public static String getName() {
        Faker faker = new Faker();
        return faker.funnyName().name();
    }

    public static String getDescription() {
        Faker faker = new Faker();
        return faker.animal().name();
    }

    public static String getDistance() {
        Faker faker = new Faker();
        return faker.number().digit();
    }

    public static String getCaloriesBurned() {
        Faker faker = new Faker();
        return faker.number().digits(3);
    }

    public static String getRandomEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public static String getRandomPassword() {
        Faker faker = new Faker();
        return faker.internet().password();
    }

    public static String getElevation(){
        Faker faker = new Faker();
        return faker.number().digits(2);
    }

    public static String getAverage(){
        Faker faker = new Faker();
        return faker.number().digits(2);
    }


    public static String getShoeModel(){
        Faker faker = new Faker();
        return faker.ancient().titan();
    }

    public static String getShoeCost(){
        Faker faker = new Faker();
        return String.valueOf(faker.number().numberBetween(1,9));
    }

    public static String getDistanceAlert(){
        Faker faker = new Faker();
        return faker.number().digits(1);
    }

    public static String getNotesMessage(){
        Faker faker = new Faker();
        return faker.lordOfTheRings().character();
    }

    public static String getMinHr(){
        Faker faker = new Faker();
        return faker.number().digits(2);
    }

    public static String getAvgHr(){
        Faker faker = new Faker();
        return faker.number().digits(2);
    }

    public static String getMaxHr(){
        Faker faker = new Faker();
        return faker.number().digits(2);
    }
}
