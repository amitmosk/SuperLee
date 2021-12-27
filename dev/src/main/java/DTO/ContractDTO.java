package DTO;

import BusinessLayer.SuppliersModule.Contract;

import java.util.Map;

public class ContractDTO {
    public int storeID;
    public int catalogueID;
    public double pricePerUnit;
    public String productName;
    public int supplierID;
    public Map<Integer,Integer> discountByQuantity;//for loading from db

    public ContractDTO(Contract c,int supplierID) {
        storeID=c.getProduct().getId();
        productName=c.getProduct().getName();
        pricePerUnit=c.getPricePerUnit();
        catalogueID=c.getCatalogueIDBySupplier();
        this.supplierID=supplierID;
        this.discountByQuantity=c.getDiscountByQuantity();
    }

    public ContractDTO( double pricePerUnit , int catalogueID , int storeID , Map<Integer,Integer> discountByQuantity,int supplierID){
            this.pricePerUnit=pricePerUnit;
            this.catalogueID=catalogueID;
            this.storeID=storeID;
            this.discountByQuantity=discountByQuantity;
            this.supplierID=supplierID;
    }

    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();
        builder.append("Product name: " + productName);
        builder.append("\nProduct id in store: " + storeID);
        builder.append("\nProduct id in supplier's catalogue: " + catalogueID);
        builder.append("\nPrice per unit " + pricePerUnit);
        return builder.toString();
    }
}