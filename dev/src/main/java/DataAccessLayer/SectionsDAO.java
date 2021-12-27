package DataAccessLayer;

import DTO.SectionDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SectionsDAO extends DAOV2<String> {

    public SectionsDAO() {
        this.tableName = "Sections";
    }

    public int insert(String Ob) {
        Connection conn = Repository.getInstance().connect();
        if (Ob == null) return 0;
        String Values = String.format("(\"%s\")", Ob);
        Statement s;
        try {
            s = conn.createStatement();
            s.executeUpdate(InsertStatement(Values));
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public int update(String updatedOb) { // irrelevant for Sections
        return 0;
    }

    public String makeDTO(ResultSet RS) {
        String output = null;
        try {
            output = RS.getString(1);
        } catch (Exception e) {
            output = null;
        }
        return output;
    }

    public SectionDTO getSection(String section) {
        SectionDTO output = null;
        Connection conn = Repository.getInstance().connect();
        ResultSet RS = this.get(this.tableName, "Sections", section, conn);
        try {
            output = new SectionDTO(RS.getString(1));
        } catch (Exception e) {
            output = null;
        } finally {
            Repository.getInstance().closeConnection(conn);
        }
        return output;
    }

    public int delete(String ob) {
        Connection conn = Repository.getInstance().connect();
        if (ob == null) return 0;
        String delString = String.format("DELETE FROM Trucks WHERE \"Name\" == %s;", ob);
        Statement s;
        try {
            s = conn.createStatement();
            return s.executeUpdate(delString);
        } catch (Exception e) {
            return 0;
        }
    }
}
