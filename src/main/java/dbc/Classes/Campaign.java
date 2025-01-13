package dbc.Classes;


import javafx.scene.image.Image;

import java.util.Date;

public class Campaign {
    private int campaign_id;
    private int org_id;
    private String campaign_name;
    private String campaign_description;
    private Date campaign_date;
    private float needed_budjet;
    private float raised_budjet;
    private String campaign_status;
    private byte[] campaign_image;


    public Campaign(int campaign_id, int org_id , String campaign_name, String campaign_description, Date campaign_date, float needed_budjet, float raised_budjet, String campaign_status, byte[] campaign_image) {
        this.campaign_id = campaign_id;
        this.org_id = org_id;
        this.campaign_name = campaign_description;
        this.campaign_date = campaign_date;
        this.campaign_description = campaign_description;
        this.needed_budjet = needed_budjet;
        this.raised_budjet = raised_budjet;
        this.campaign_status = campaign_status;
        this.campaign_image = campaign_image;
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

    public byte[] getCampaign_image() {
        return campaign_image;
    }

    public int getOrg_id() {
        return org_id;
    }

}
