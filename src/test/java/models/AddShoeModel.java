package models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class AddShoeModel {
    private String shoeName;
    private String shoeBrand;
    private String shoeModel;
    private String shoeCost;
    private String datePurchased;
    private String startingDistance;
    private String distanceAlert;
    private String notes;
}
