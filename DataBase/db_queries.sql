CREATE DATABASE IF NOT EXISTS  campaigns_manager;

CREATE TABLE organization (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    name_oganization VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    descreption TEXT,
    email VARCHAR(255) NOT NULL UNIQUE,
    phone VARCHAR(20),
    facebook VARCHAR(255),
    instagram VARCHAR(255),
    twitter VARCHAR(255),
    logo LONGBLOB
);

CREATE TABLE campaign (
                          campaign_id INT AUTO_INCREMENT PRIMARY KEY,
                          org_id INT NOT NULL,
                          campaign_name VARCHAR(255) NOT NULL,
                          campaign_description TEXT NOT NULL,
                          campaign_date DATE NOT NULL,
                          needed_budjet FLOAT NOT NULL,
                          raised_budjet FLOAT NOT NULL,
                          campaign_status VARCHAR(50) NOT NULL,
                          campaign_image LongBLOB,
                          FOREIGN KEY (org_id) REFERENCES organization(ID)
);

CREATE TABLE note (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      description TEXT NOT NULL,
                      date DATE NOT NULL,
                      color VARCHAR(50),
                      org_id INT NOT NULL,
                      cam_id INT NOT NULL ,
                      FOREIGN KEY (org_id) REFERENCES organization(ID),
                      FOREIGN KEY (cam_id) REFERENCES campaign(campaign_id)
);


CREATE TABLE ressourses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price FLOAT NOT NULL,
    quantity INT NOT NULL,
    org_id INT NOT NULL,
    cam_id INT NOT NULL ,
    FOREIGN KEY (org_id) REFERENCES organization(ID),
    FOREIGN KEY (cam_id) REFERENCES campaign(campaign_id)
);

CREATE TABLE ToDoList (
    id INT AUTO_INCREMENT PRIMARY KEY,
    content TEXT NOT NULL,
    completed BOOLEAN NOT NULL,
    color VARCHAR(50),
    org_id INT NOT NULL,
    cam_id INT NOT NULL ,
    FOREIGN KEY (org_id) REFERENCES organization(ID),
    FOREIGN KEY (cam_id) REFERENCES campaign(campaign_id)
);



-- Organization Inserts
INSERT INTO organization (name_oganization, password, descreption, email, phone, facebook, instagram, twitter, logo)
VALUES
('Moroccan Earthquake Relief', SHA2('earthquakeHelp123', 256), 
'A dedicated non-profit organization focused on providing immediate and long-term aid to communities affected by earthquakes across Morocco.',
'info@earthquakerelief.ma', '0520-123456', 'facebook.com/earthquakerelief', 'instagram.com/earthquakerelief', 'twitter.com/earthquakerelief', NULL),

('Flood Recovery Morocco', SHA2('floodSupport456', 256), 
'Flood Recovery Morocco is a non-profit organization committed to providing relief to the thousands of Moroccans affected by seasonal and unexpected flooding. Our approach goes beyond immediate disaster relief; we engage in extensive recovery programs that rebuild homes, restore lost livelihoods, and strengthen communities’ resistance to future flooding risks. The organization collaborates with local governments, engineers, and environmental experts to develop sustainable infrastructure that can withstand the increasing threat of floods due to climate change. We also provide education on flood prevention, support agricultural recovery, and deliver essential services like clean water and healthcare to those in need.', 
'contact@floodrecovery.ma', '0520-654321', 'facebook.com/floodrecovery', 'instagram.com/floodrecovery', 'twitter.com/floodrecovery', NULL),

('Moroccan Wildfire Fighters', SHA2('wildfireResponse789', 256), 
'Moroccan Wildfire Fighters is a collective effort by individuals, communities, and organizations aimed at providing rapid response and recovery to areas affected by wildfires. Wildfires have become an increasing threat in Morocco, and our organization stands at the forefront of combating this devastation. We not only provide emergency aid such as firefighting resources, medical assistance, and evacuation support, but also work on the restoration of affected ecosystems and the livelihoods of those who have lost their homes. Through a combination of preventive measures, awareness campaigns, and collaboration with local firefighting teams, our mission is to mitigate the impact of wildfires and promote environmental recovery in the aftermath of a disaster.', 
'info@wildfirefighters.ma', '0520-987654', 'facebook.com/wildfirefighters', 'instagram.com/wildfirefighters', 'twitter.com/wildfirefighters', NULL),

('Moroccan Drought Aid', SHA2('droughtSupport012', 256), 
'Moroccan Drought Aid is an organization dedicated to addressing the severe impacts of drought in Morocco. Our focus is on providing immediate relief to communities suffering from water scarcity, food insecurity, and economic hardship caused by prolonged dry spells. We offer essential supplies such as food, clean water, and hygiene kits to the most affected regions, while also working on long-term projects to help restore water sources, improve irrigation techniques, and support sustainable agriculture. By collaborating with local authorities, scientists, and community leaders, we aim to empower people to adapt to the challenges posed by droughts and strengthen their resilience against future climate risks.',
'contact@droughtaid.ma', '0520-234567', 'facebook.com/droughtaid', 'instagram.com/droughtaid', 'twitter.com/droughtaid', NULL);


-- Campaign Inserts for Moroccan Earthquake Relief
INSERT INTO campaign (org_id, campaign_name, campaign_description, campaign_date, needed_budjet, raised_budjet, campaign_status, campaign_image)
VALUES
(1, 'Rebuilding Earthquake-affected Homes', 'This project focuses on providing new homes for families who lost everything in the earthquake. It aims to create safe and stable housing, allowing these families to start over. Currently, the project is progressing as planned.', '2025-01-01', 1000000.00, 300000.00, 'In progress', NULL),
(1, 'Medical Assistance for Earthquake Victims', 'This initiative involves sending vital medical supplies, including medications and equipment, to areas impacted by the earthquake. The goal is to provide urgent medical care and prevent disease outbreaks. The operation is ongoing.', '2025-02-01', 500000.00, 150000.00, 'Coming', NULL),
(1, 'Search and Rescue Operations', 'Teams are being deployed to search for survivors in collapsed buildings, using specialized equipment like sniffer dogs and sensors. This mission has now been completed successfully.', '2025-03-01', 800000.00, 400000.00, 'Completed', NULL);

INSERT INTO note (description, date, color, org_id , cam_id)
VALUES
('Coordinate emergency relief efforts in flood-affected regions.', '2025-02-10', '#FF6347', 1,2),
('Ensure timely distribution of food and water to earthquake survivors.', '2025-02-12', '#4682B4', 1,2),
('Organize a fundraising event for fire victims in the south.', '2025-02-15', '#8A2BE2', 1,2);


INSERT INTO ressourses (name, price, quantity, org_id, cam_id)
VALUES
('Portable Water Filters', 25.00, 1000, 1,2),
('First Aid Kits', 30.00, 1500, 1,2),
('Shelter Tents', 100.00, 500, 1,2);


INSERT INTO ToDoList (content, completed, color, org_id,cam_id)
VALUES
('Organize an emergency response plan for flood victims.', FALSE, '#8A2BE2', 1,2),
('Set up an emergency food distribution network for earthquake survivors.', TRUE, '#32CD32', 1,2),
('Recruit volunteers to help with search-and-rescue operations.', FALSE, '#FFD700', 1,2);


