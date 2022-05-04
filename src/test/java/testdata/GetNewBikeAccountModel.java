package testdata;

import models.AddBikeModel;
import utilites.GenerateFakeMessage;

public class GetNewBikeAccountModel {

    public static AddBikeModel getBikeFields(){
        return AddBikeModel.builder()
                .bikeName(GenerateFakeMessage.getName())
                .bikeBrand("Cannondale")
                .bikeModel(GenerateFakeMessage.getShoeModel())
                .bikeCost(GenerateFakeMessage.getShoeCost().concat(".00"))
                .datePurchased("2/15/2020")
                .startingDistance("3,000")
                .frontTireStartingDistance("5,000")
                .rearTireStartingDistance("8,000")
                .distanceAlert(GenerateFakeMessage.getDistanceAlert())
                .notes(GenerateFakeMessage.getNotesMessage())
                .build();
    }
}
