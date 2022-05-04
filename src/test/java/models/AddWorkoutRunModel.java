package models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class AddWorkoutRunModel {
    private String timeOfDay;
    private String workoutName;
    private String workoutDescription;
    private String distance;
    private String duration;
    private String minHR;
    private String avgHR;
    private String maxHR;
    private String caloriesBurned;

}
