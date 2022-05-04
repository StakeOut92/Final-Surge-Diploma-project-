package testdata;

import models.AddShoeModel;
import utilites.GenerateFakeMessage;

public class GetNewShoesAccountModel {

    public static AddShoeModel getShoeFields(){
        return AddShoeModel.builder()
                .shoeName(GenerateFakeMessage.getName())
                .shoeBrand("adidas")
                .shoeModel(GenerateFakeMessage.getShoeModel())
                .shoeCost(GenerateFakeMessage.getShoeCost().concat(".00"))
                .datePurchased("4/22/2021")
                .startingDistance("9,000")
                .distanceAlert(GenerateFakeMessage.getDistanceAlert())
                .notes(GenerateFakeMessage.getNotesMessage())
                .build();
    }
}
