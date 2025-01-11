package dbc.Classes;


import javafx.scene.image.Image;

import java.util.Date;

public class Campaign {
    private int campaign_id;
    private String campaign_name;
    private String campaign_description;
    private Date campaign_date;
    private float needed_budjet;
    private float raised_budjet;
    private String campaign_status;
    private Image campaign_image;

    public Campaign() {
    }

    public int getCampaign_id() {
        return campaign_id;
    }

    public String getCampaign_name() {
        return campaign_name;
    }

    public String getCampaign_description() {
        return campaign_description;
    }

    public Date getCampaign_date() {
        return campaign_date;
    }

    public float getNeeded_budjet() {
        return needed_budjet;
    }

    public float getRaised_budjet() {
        return raised_budjet;
    }

    public String getCampaign_status() {
        return campaign_status;
    }

    public Image getCampaign_image() {
        return campaign_image;
    }
}
