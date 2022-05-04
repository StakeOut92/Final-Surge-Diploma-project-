package testdata;

import models.AddWorkoutBikeModel;
import utilites.GenerateFakeMessage;

public class GetNewWorkoutBikeModel {
    public static AddWorkoutBikeModel getBikeFields(){
        return AddWorkoutBikeModel.builder()
                .timeOfDay("1400")
                .workoutName(GenerateFakeMessage.getName())
                .workoutDescription(GenerateFakeMessage.getDescription())
                .distance(GenerateFakeMessage.getDistance())
                .duration("11000")
                .elevationGain(GenerateFakeMessage.getElevation())
                .elevationLoss(GenerateFakeMessage.getElevation())
                .avgPower(GenerateFakeMessage.getAverage())
                .maxPower(GenerateFakeMessage.getAverage())
                .avgCadence(GenerateFakeMessage.getAverage())
                .maxCadence(GenerateFakeMessage.getAverage())
                .minHr("80")
                .avgHr("100")
                .maxHr("120")
                .caloriesBurned(GenerateFakeMessage.getCaloriesBurned())
                .build();
    }
}
