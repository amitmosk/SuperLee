package DataAccessLayer;

import DTO.TruckDTO;

import java.sql.*;
import java.sql.ResultSet;

public class TrucksDAO extends DAOV2<TruckDTO> {
    public TrucksDAO() {
        this.tableName = "Trucks";
    }

    public int insert(TruckDTO Ob) {
        Connection conn = Repository.getInstance().connect();
        if (Ob == null) return 0;
        String Values = String.format("(\"%s\",%s,%s,\"%s\",\"%s\")", Ob.plateNum, Ob.factoryWeight, Ob.maxWeight, Ob.model, Ob.type);
        Statement s;
        try {
            s = conn.createStatement();
            s.executeUpdate(InsertStatement(Values));
            return 1;
        } catch (Exception e) {
            return 0;
        } finally {
            Repository.getInstance().closeConnection(conn);
        }
    }

    public int update(TruckDTO updatedOb) {
        Connection conn = Repository.getInstance().connect();
        if (updatedOb == null) return 0;
        String updateString = String.format("UPDATE %s" +
                        " SET \"Plate Num\"= \"%s\", \"Factory Weight\"= %s, \"Max Weight\"= %s , \"Model\"=\"%s\", \"Type\"=\"%s\" " +
                        "WHERE \"Plate Num\" == \"%s\";",
                tableName, updatedOb.plateNum, updatedOb.factoryWeight, updatedOb.maxWeight, updatedOb.model, updatedOb.model, updatedOb.plateNum);
        Statement s;
        try {
            s = conn.createStatement();
            return s.executeUpdate(updateString);
        } catch (Exception e) {
            return 0;
        } finally {
            Repository.getInstance().closeConnection(conn);
        }
    }

    public TruckDTO getTruck(String PlateNum){
        TruckDTO output = null;
        Connection conn = Repository.getInstance().connect();
        ResultSet RS = this.get(this.tableName,"Plate Num",PlateNum,conn);
        try{
            output = new TruckDTO(RS.getString(1), RS.getString(4), RS.getInt(3), RS.getString(5), RS.getInt(2));
        }
        catch (Exception e){

        } finally {
            Repository.getInstance().closeConnection(conn);
        }
        return output;
    }

    public TruckDTO makeDTO(ResultSet RS) { //int plateNum, String model, int maxWeight, String type, int factoryWeight
        TruckDTO output = null;
        try {
            output = new TruckDTO(RS.getString(1), RS.getString(4), RS.getInt(3), RS.getString(5), RS.getInt(2));
        } catch (Exception e) {
            output = null;
        }
        return output;
    }

    public int delete(TruckDTO ob) {
        Connection conn = Repository.getInstance().connect();
        if (ob == null) return 0;
        String delString = String.format("DELETE FROM Trucks WHERE \"Plate Num\" == %s;", ob.plateNum);
        Statement s;
        try {
            s = conn.createStatement();
            return s.executeUpdate(delString);
        } catch (Exception e) {
            return 0;
        } finally {
            Repository.getInstance().closeConnection(conn);
        }
    }
}
