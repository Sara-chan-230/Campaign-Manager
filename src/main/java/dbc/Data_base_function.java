package dbc;
import dbc.Classes.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Data_base_function {
    static Connection con = DBConnection.getConnection();
    public static List<Note> fetch_notes(int organization_id,int cam_id){
        List<Note> notes = new ArrayList<Note>();
        String query = "select * from note where org_id = ? and cam_id = ? ";
        try(PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1, organization_id);
            ps.setInt(2, cam_id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String desc = rs.getString("description");
                Date date = rs.getDate("date");
                String color = rs.getString("color");
                int org_id = rs.getInt("org_id");
                notes.add(new Note(id, desc, date, color, org_id,cam_id));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return notes;
    }

    public static List<ToDoList> fetch_In_prgress_task(int organization_id,int cam_id){
        List<ToDoList> task = new ArrayList<>();
        String query = "Select * From ToDoList where org_id = ? AND cam_id = ? AND completed = ?";
        try(PreparedStatement ps = con.prepareStatement(query);){
            ps.setInt(1,organization_id);
            ps.setInt(2, cam_id);
            ps.setBoolean(3,false);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String content = rs.getString("content");
                String color = rs.getString("color");
                Boolean complted = rs.getBoolean("completed");
                int o_id = rs.getInt("org_id");
                task.add(new ToDoList(id,content,complted,color,o_id,cam_id));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return task;
    }

    public static List<ToDoList> fetch_campleted_task(int organization_id, int cam_id){
        List<ToDoList> task = new ArrayList<>();
        String query = "Select * From ToDoList where org_id = ? AND cam_id = ? AND completed = ?";
        try(PreparedStatement ps = con.prepareStatement(query);){
            ps.setInt(1,organization_id);
            ps.setInt(2,cam_id);
            ps.setBoolean(3,true);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String content = rs.getString("content");
                String color = rs.getString("color");
                Boolean complted = rs.getBoolean("completed");
                int o_id = rs.getInt("org_id");
                task.add(new ToDoList(id,content,complted,color,o_id,cam_id));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return task;
    }

    public static List<Campaign> preparation(String q)  {
        List<Campaign> campaigns = new ArrayList<>();

        try(PreparedStatement ps = con.prepareStatement(q)) {
            System.out.println(con);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id_cam = rs.getInt("campaign_id");
                String title = rs.getString("campaign_name");
                String desc = rs.getString("campaign_description");
                Date date = rs.getDate("campaign_date");
                float n_budget = rs.getFloat("needed_budjet");
                float r_budget = rs.getFloat("raised_budjet");
                String status = rs.getString("campaign_status");
                byte[] image = rs.getBytes("campaign_image");
                int org_id = rs.getInt("org_id");
                campaigns.add(new Campaign(id_cam,org_id,title,desc,date,n_budget,r_budget,status,image));
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return campaigns;
    }

    public static List<Campaign> fetch_in_progess_campaigns(int organization_id){
        ArrayList<Campaign> list_campaign = new ArrayList<>();
        String query = "SELECT * FROM campaign WHERE org_id = " + organization_id + " AND campaign_status = 'In progress'";
        list_campaign.addAll(preparation(query));
        System.out.println(list_campaign);
        return list_campaign;
    }

    public static List<Campaign> fetch_comming_campaigns(int organization_id){
        ArrayList<Campaign> list_campaign = new ArrayList<>();
        String query = "SELECT * FROM campaign WHERE org_id = " + organization_id + " AND campaign_status = 'Coming'";
        list_campaign.addAll(preparation(query));
        return list_campaign;
    }

    public static List<Campaign> fetch_completed_campaigns(int organization_id){
        ArrayList<Campaign> list_campaign = new ArrayList<>();
        String query = "SELECT * FROM campaign WHERE org_id = " + organization_id + " AND campaign_status = 'Completed'";
        list_campaign.addAll(preparation(query));
        return list_campaign;
    }

    public static int count_in_progress_campaigns(int organization_id){
        int count = 0;
        String query ="Select count(campaign_id) From campaign WHERE campaign_status = 'In progress' AND org_id = ? ";
        try (PreparedStatement ps = con.prepareStatement(query);) {
            ps.setInt(1, organization_id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        System.out.println(count);

        return count;
    }

    public static int count_camming_campaign(int organization_id){
        int count = 0;
        String query ="Select count(campaign_id) From campaign WHERE campaign_status = 'Coming' AND org_id = ? ";
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
        String query ="Select count(campaign_id) From campaign WHERE campaign_status = 'Completed' AND org_id = ? ";
        try (PreparedStatement ps = con.prepareStatement(query)){
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
                    String description = rs.getString("descreption");
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

    public static List<Ressourses> fetch_ressourses(int organization_id, int cam_id){
        ArrayList<Ressourses> list_ressourses = new ArrayList<>();
        String query = "SELECT * FROM ressourses WHERE org_id = ? AND cam_id = ?";
        try(PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1,organization_id);
            ps.setInt(2,cam_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                list_ressourses.add(new Ressourses(id,name,price,quantity,organization_id, cam_id));
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

    public static float total_resourses(int organization_id , int cam_id){
        float total = 0;
        String query = "SELECT SUM(price*quantity) FROM ressourses WHERE org_id = ? AND  cam_id = ?";
        try(PreparedStatement ps = con.prepareStatement(query);){
            ps.setInt(1,organization_id);
            ps.setInt(2,cam_id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                total = rs.getFloat(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return total;
    }

    public static void pullNote(Note note) {
        String query = "INSERT INTO note (description, date, color, org_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps =  con.prepareStatement(query)) {

            ps.setString(1, note.getDescription());

            // Formatage de la date au format SQL (yyyy-MM-dd)
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = dateFormat.format(note.getDate());
            ps.setString(2, formattedDate);

            ps.setString(3, note.getColor());
            ps.setInt(4, note.getOrg_id());

            // Exécuter la requête
            int rowsInserted = ps.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("La note a été insérée avec succès !");
            } else {
                System.out.println("Aucune note n'a été insérée.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de l'insertion de la note : " + e.getMessage(), e);
        }
    }
    public static boolean signIn(String email, String password) {
        String query = "SELECT * FROM organization WHERE email = ? AND password = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            // Assigner les paramètres
            ps.setString(1, email);
            ps.setString(2, password);

            // Exécuter la requête
            ResultSet rs = ps.executeQuery();

            // Si un résultat existe, les identifiants sont valides
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de la connexion : " + e.getMessage());
}
    }





}
