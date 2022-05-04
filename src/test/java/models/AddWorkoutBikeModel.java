package models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class AddWorkoutBikeModel {
    private String timeOfDay;
    private String workoutName;
    private String workoutDescription;
    private String distance;
    private String duration;
    private String elevationGain;
    private String elevationLoss;
    private String avgPower;
    private String maxPower;
    private String avgCadence;
    private String maxCadence;
    private String minHr;
    private String avgHr;
    private String maxHr;
    private String caloriesBurned;
}
