package dbc;

import dbc.Classes.*;
import org.w3c.dom.ls.LSOutput;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Data_base_function {
    static Connection con = DBConnection.getConnection();
    public static List<Note> fetch_notes(int organization_id){
        List<Note> notes = new ArrayList<Note>();
        String query = "select * from note where org_id = "+organization_id;
        try(PreparedStatement ps = con.prepareStatement(query)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String desc = rs.getString("description");
                Date date = rs.getDate("date");
                String color = rs.getString("color");
                int org_id = rs.getInt("org_id");
                notes.add(new Note(id, desc, date, color, org_id));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return notes;
    }

    public static List<ToDoList> fetch_In_prgress_task(int organization_id){
        List<ToDoList> task = new ArrayList<>();
        String query = "Select * From ToDoList where iD_O = ? AND completed = ?";
        try(PreparedStatement ps = con.prepareStatement(query);){
            ps.setInt(1,organization_id);
            ps.setBoolean(2,false);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String content = rs.getString("content");
                String color = rs.getString("color");
                Boolean complted = rs.getBoolean("completed");
                int o_id = rs.getInt("iD_O");
                task.add(new ToDoList(id,content,complted,color,o_id));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return task;
    }

    public static List<ToDoList> fetch_campleted_task(int organization_id){
        List<ToDoList> task = new ArrayList<>();
        String query = "Select * From ToDoList where iD_O = ? AND completed = ?";
        try(PreparedStatement ps = con.prepareStatement(query);){
            ps.setInt(1,organization_id);
            ps.setBoolean(2,true);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String content = rs.getString("content");
                String color = rs.getString("color");
                Boolean complted = rs.getBoolean("completed");
                int o_id = rs.getInt("iD_O");
                task.add(new ToDoList(id,content,complted,color,o_id));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return task;
    }

    public static void preparation(String q){
        try(PreparedStatement ps = con.prepareStatement(q)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id_cam = rs.getInt("campaign_id");
                String title = rs.getString("scampaign_name");
                String desc = rs.getString("campaign_description");
                Date date = rs.getDate("campaign_date");
                float n_budget = rs.getFloat("needed_budjet");
                float r_budget = rs.getFloat("raised_budjet");
                String status = rs.getString("campaign_status");
                byte[] image = rs.getBytes("campaign_image");
                int org_id = rs.getInt("org_id");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static List<Campaign> fetch_in_progess_campaigns(int organization_id){
        ArrayList<Campaign> list_campaign = new ArrayList<>();
        String query = "SELECT * FROM campaign WHERE org_id = " + organization_id + " AND campaign_status = 'In progress'";
        preparation(query);
        return list_campaign;
    }

    public static List<Campaign> fetch_comming_campaigns(int organization_id){
        ArrayList<Campaign> list_campaign = new ArrayList<>();
        String query = "SELECT * FROM campaign WHERE org_id = " + organization_id + " AND campaign_status = 'Camming'";
        preparation(query);
        return list_campaign;
    }

    public static List<Campaign> fetch_completed_campaigns(int organization_id){
        ArrayList<Campaign> list_campaign = new ArrayList<>();
        String query = "SELECT * FROM campaign WHERE org_id = " + organization_id + " AND campaign_status = 'Completed'";
        preparation(query);
        return list_campaign;
    }

    public static int count_in_progress_campaigns(int organization_id){
        int count = 0;
        String query ="Select count(campaign_id) From Campaign campaign WHERE campaign_status = 'In progress' AND org_id = ? ";
        try (PreparedStatement ps = con.prepareStatement(query);) {
            ps.setInt(1, organization_id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return count;
    }

    public static int count_camming_campaign(int organization_id){
        int count = 0;
        String query ="Select count(campaign_id) From Campaign campaign WHERE campaign_status = 'Camming' AND org_id = ? ";
        try (PreparedStatement ps = con.prepareStatement(query);) {
            ps.setInt(1, organization_id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return count;

    }

    public static int count_Completed_campaign(int organization_id){
        int count = 0;
        String query ="Select count(campaign_id) From Campaign campaign WHERE campaign_status = 'Campleted' AND org_id = ? ";
        try (PreparedStatement ps = con.prepareStatement(query);) {
            ps.setInt(1, organization_id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return count;

    }

    public static Organization fetch_organization(int organization_id){
        System.out.println(con);
        if(con!=null){
            String query = "SELECT * FROM organization WHERE ID = ?";
            Organization organization = null;
            try(PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1,organization_id);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    int id = rs.getInt("ID");
                    String name = rs.getString("name_oganization");
                    String password = rs.getString("password");
                    String description = rs.getString("description");
                    String email = rs.getString("email");
                    String phone  = rs.getString("phone");
                    String facebook = rs.getString("facebook");
                    String instagram = rs.getString("instagram");
                    String twitter = rs.getString("twitter");
                    byte[] logo = rs.getBytes("logo");
                    organization = new Organization(name,id,password,description,email,phone,facebook,instagram,twitter,logo);

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return organization;


        }
        return null;

    }

    public static List<Ressourses> fetch_ressourses(int organization_id){
        ArrayList<Ressourses> list_ressourses = new ArrayList<>();
        String query = "SELECT * FROM ressourses WHERE id_org = ?";
        try(PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1,organization_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                list_ressourses.add(new Ressourses(id,name,price,quantity,organization_id));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list_ressourses;
    }
    public static void remove_resourses(Ressourses ressourses) throws SQLException {
        String query = "DELETE FROM ressourses WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,ressourses.getId());
        ps.executeUpdate();
    }

    public static float total_resourses(int organization_id){
        float total = 0;
        String query = "SELECT SUM(price*quantity) FROM ressourses WHERE id_org = ?";
        try(PreparedStatement ps = con.prepareStatement(query);){
            ps.setInt(1,organization_id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                total = rs.getFloat(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return total;
    }




}
