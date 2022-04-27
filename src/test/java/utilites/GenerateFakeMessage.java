package utilites;

import com.github.javafaker.Faker;

public class GenerateFakeMessage {

    public static String getWorkoutTime() {
        Faker faker = new Faker();
        return faker.number().digits(4);
    }

    public static String getName(){
        Faker faker = new Faker();
        return faker.funnyName().name();
    }

    public static String getDescription(){
        Faker faker = new Faker();
        return faker.animal().name();
    }


}
