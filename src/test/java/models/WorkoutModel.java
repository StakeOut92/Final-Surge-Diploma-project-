package models;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class WorkoutModel {
    private String WorkoutTime;
    private String Name;
    private String Desc;
}
