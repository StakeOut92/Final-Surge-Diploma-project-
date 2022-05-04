package testdata;

import models.AddWorkoutRunModel;
import utilites.GenerateFakeMessage;

public class GetNewWorkoutRunModel {
    public static AddWorkoutRunModel getRunFields(){
        return AddWorkoutRunModel.builder()
                .timeOfDay("1200")
                .workoutName(GenerateFakeMessage.getName())
                .workoutDescription(GenerateFakeMessage.getDescription())
                .distance(GenerateFakeMessage.getDistance())
                .duration("10000")
                .minHR(GenerateFakeMessage.getMinHr())
                .avgHR(GenerateFakeMessage.getAvgHr())
                .maxHR(GenerateFakeMessage.getMaxHr())
                .caloriesBurned(GenerateFakeMessage.getCaloriesBurned())
                .build();
    }
}
