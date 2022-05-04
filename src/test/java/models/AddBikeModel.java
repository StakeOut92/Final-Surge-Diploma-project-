package models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class AddBikeModel {
    private String bikeName;
    private String bikeBrand;
    private String bikeModel;
    private String bikeCost;
    private String datePurchased;
    private String startingDistance;
    private String frontTireStartingDistance;
    private String rearTireStartingDistance;
    private String distanceAlert;
    private String notes;
}
