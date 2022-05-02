package testdata;

import models.AddShoeModel;
import utilites.GenerateFakeMessage;

public class GetNewShoesAccountModel {

    public static AddShoeModel getShoeFields(){
        return AddShoeModel.builder()
                .shoeName(GenerateFakeMessage.getName())
                .shoeBrand("adidas")
                .shoeModel(GenerateFakeMessage.getShoeModel())
                .shoeCost(GenerateFakeMessage.getShoeCost())
                .datePurchased("04/22/2021")
                .startingDistance(GenerateFakeMessage.getDistance())
                .distanceAlert(GenerateFakeMessage.getDistanceAlert())
                .notes(GenerateFakeMessage.getNotesMessage())
                .build();
    }
}
