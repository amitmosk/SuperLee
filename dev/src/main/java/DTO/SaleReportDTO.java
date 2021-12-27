package DTO;

import BusinessLayer.InventoryModule.Sale;
import BusinessLayer.InventoryModule.SaleReport;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SaleReportDTO extends ReportDTO {
    private List<SaleDTO> sales;
    public List<Integer> saleIDS;
    public SaleReportDTO(int id, LocalDate start,LocalDate end,List<Integer> saleIDS){
        super(id,start,end,null);
        this.saleIDS=saleIDS;
        sales=new ArrayList<>();
    }
    public SaleReportDTO(SaleReport report) {
        super(report);
        this.sales = new ArrayList<>();
        saleIDS=new ArrayList<>();
        for(Sale sale : report.getSales()){
            this.sales.add(new SaleDTO(sale));
            saleIDS.add(sale.getSaleID());
        }
    }

    @Override
    public String toString() {
        StringBuilder builder =  new StringBuilder();
        builder.append("Report ID: "+ this.reportID + "\n");
        builder.append("Report Start Date: "+ this.startDate.format(DateTimeFormatter.ISO_LOCAL_DATE) + "\n");
        builder.append("Report End Date: "+ this.endDate.format(DateTimeFormatter.ISO_LOCAL_DATE) + "\n");
        builder.append("Report Sales: \n");
        for(SaleDTO s : sales)
        {
            builder.append(s.toString());
        }
        return builder.toString();


    }
}
