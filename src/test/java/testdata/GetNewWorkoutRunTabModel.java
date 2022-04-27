package testdata;

import models.WorkoutModel;
import utilites.GenerateFakeMessage;

public class GetNewWorkoutRunTabModel {
    public static WorkoutModel getRunWorkoutWithAllFields(){
return WorkoutModel.builder()
        .WorkoutTime(GenerateFakeMessage.getWorkoutTime())
        .Name(GenerateFakeMessage.getName())
        .Desc(GenerateFakeMessage.getDescription())
        .build();
    }
}
