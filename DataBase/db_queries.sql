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
('Earthquake Relief', SHA2('earthquakeHelp123', 256), 
'A dedicated non-profit organization focused on providing immediate and long-term aid to communities affected by earthquakes across Morocco.',
'info@earthquakerelief.ma', '0520-123456', 'facebook.com/earthquakerelief', 'instagram.com/earthquakerelief', 'twitter.com/earthquakerelief', NULL),

('Flood Recovery ', SHA2('floodSupport456', 256), 
'Flood Recovery Morocco is a non-profit organization committed to providing relief to the thousands of Moroccans affected by seasonal and unexpected flooding. Our approach goes beyond immediate disaster relief; we engage in extensive recovery programs that rebuild homes, restore lost livelihoods, and strengthen communities’ resistance to future flooding risks. The organization collaborates with local governments, engineers, and environmental experts to develop sustainable infrastructure that can withstand the increasing threat of floods due to climate change. We also provide education on flood prevention, support agricultural recovery, and deliver essential services like clean water and healthcare to those in need.', 
'contact@floodrecovery.ma', '0520-654321', 'facebook.com/floodrecovery', 'instagram.com/floodrecovery', 'twitter.com/floodrecovery', NULL),

('Wildfire Fighters', SHA2('wildfireResponse789', 256), 
'Moroccan Wildfire Fighters is a collective effort by individuals, communities, and organizations aimed at providing rapid response and recovery to areas affected by wildfires. Wildfires have become an increasing threat in Morocco, and our organization stands at the forefront of combating this devastation. We not only provide emergency aid such as firefighting resources, medical assistance, and evacuation support, but also work on the restoration of affected ecosystems and the livelihoods of those who have lost their homes. Through a combination of preventive measures, awareness campaigns, and collaboration with local firefighting teams, our mission is to mitigate the impact of wildfires and promote environmental recovery in the aftermath of a disaster.', 
'info@wildfirefighters.ma', '0520-987654', 'facebook.com/wildfirefighters', 'instagram.com/wildfirefighters', 'twitter.com/wildfirefighters', NULL),

('Drought Aid', SHA2('droughtSupport012', 256), 
'Moroccan Drought Aid is an organization dedicated to addressing the severe impacts of drought in Morocco. Our focus is on providing immediate relief to communities suffering from water scarcity, food insecurity, and economic hardship caused by prolonged dry spells. We offer essential supplies such as food, clean water, and hygiene kits to the most affected regions, while also working on long-term projects to help restore water sources, improve irrigation techniques, and support sustainable agriculture. By collaborating with local authorities, scientists, and community leaders, we aim to empower people to adapt to the challenges posed by droughts and strengthen their resilience against future climate risks.',
'contact@droughtaid.ma', '0520-234567', 'facebook.com/droughtaid', 'instagram.com/droughtaid', 'twitter.com/droughtaid', NULL);




-- Campaign Inserts 
INSERT INTO campaign (org_id, campaign_name, campaign_description, campaign_date, needed_budjet, raised_budjet, campaign_status, campaign_image)
VALUES
(1, 'Rebuilding Earthquake-affected Homes', 'This project focuses on providing new homes for families who lost everything in the earthquake. It aims to create safe and stable housing, allowing these families to start over. Currently, the project is progressing as planned.', '2025-01-01', 1000000.00, 300000.00, 'In progress', NULL),
(1, 'Medical Assistance for Earthquake Victims', 'This initiative involves sending vital medical supplies, including medications and equipment, to areas impacted by the earthquake. The goal is to provide urgent medical care and prevent disease outbreaks. The operation is ongoing.', '2025-02-01', 500000.00, 300000.00, 'In progress', NULL),
(1, 'Search and Rescue Operations', 'Teams are being deployed to search for survivors in collapsed buildings, using specialized equipment like sniffer dogs and sensors. This mission has now been completed successfully.', '2025-03-01', 800000.00, 800000.00, 'Completed', NULL),
(1,'Distribution compaign', 'This project ensures that food and water are provided to the affected communities. It’s designed to help people survive in the immediate aftermath of the disaster. The distribution is still ongoing.', '2025-04-01', 250000.00, 100000.00, 'In progress', NULL),
(1, 'Temporary Shelters for Displaced Families', 'Temporary shelters are being set up for families who lost their homes, offering them a safe place to stay while more permanent solutions are planned. The project is currently in the planning phase.', '2025-05-01', 300000.00, 00.00, 'Coming', NULL),
(1, 'Rehabilitation of Damaged Infrastructure', 'This project focuses on repairing roads, bridges, and critical infrastructure. The goal is to restore essential services and help communities get back to normal. The rehabilitation efforts are set to begin soon.', '2025-06-01', 1500000.00, 00.00, 'Coming', NULL),
(1, 'Earthquake Awareness Campaign', 'The campaign aims to raise awareness about earthquake preparedness, teaching communities how to protect themselves in case of future earthquakes. It is currently active and ongoing.', '2025-07-01', 100000.00, 50000.00, 'In progress', NULL),
(1, 'Counseling for Earthquake Survivors', 'This program offers psychological support to survivors, helping them deal with the trauma and stress caused by the disaster. The counseling efforts are ongoing to ensure survivors. mental health needs are met.', '2025-08-01', 200000.00, 50000.00, 'In progress', NULL),
(1, 'Restoring Local Schools and Hospitals', 'This initiative focuses on repairing schools and hospitals, vital institutions that support both education and healthcare. The restoration work has been completed, and these facilities are now operational again.', '2025-09-01', 600000.00, 600000.00, 'Completed', NULL),
(1, 'Rebuilding Earthquake-hit Villages', 'This project focuses on rebuilding entire villages that were devastated by the earthquake. It includes restoring homes and community buildings. The planning stage is underway, with construction set to begin soon.', '2025-10-01', 800000.00, 00.00, 'Coming', NULL);


(2, 'Emergency Flood Relief', 'This project focuses on delivering a variety of emergency supplies, including food, clean water, clothing, hygiene kits, and essential medical supplies, to flood-affected communities in Morocco. The aim is to provide immediate relief to those who have lost everything, ensuring that the most urgent needs are met as quickly as possible. The project is actively being carried out and is currently in progress.', '2025-01-01', 500000.00, 150000.00, 'In progress', NULL),
(2, 'Rescue Operations for Flood Victims', 'This operation aims to rescue individuals stranded due to severe flooding, using boats, helicopters, and specialized teams. In addition to rescuing people, the operation includes providing immediate medical care to those in need, as well as evacuating them from dangerous areas. The rescue mission has been successfully completed, with all targeted individuals rescued and provided with aid.', '2025-02-01', 600000.00, 600000.00, 'Campleted', NULL),
(2, 'Reconstruction of Flooded Areas', 'This large-scale project focuses on the rebuilding and restoration of homes, schools, roads, bridges, and other essential infrastructure that were severely damaged or destroyed by the floods. The primary goal is to restore the affected areas to their pre-flood conditions, helping displaced families return to their homes and resume normal life. The reconstruction efforts are ongoing and continue to make significant progress.', '2025-03-01', 1000000.00, 00.00, 'Coming', NULL),
(2, 'Clean Water Supply for Flood Victims', 'This critical initiative focuses on providing safe, clean drinking water to communities impacted by the flooding, as floodwaters often contaminate local water sources. The project aims to prevent the spread of waterborne diseases and ensure that the affected population has access to a reliable and safe water supply during the recovery period. The project is currently in progress and making strides in improving water access.', '2025-04-01', 200000.00, 100000.00, 'In progress', NULL),
(2, 'Flood Prevention Education Campaign', 'This campaign is designed to raise awareness about flood risks and prevention measures among communities living in flood-prone areas. It includes organizing workshops, distributing educational materials, and conducting outreach activities to teach people how to prepare for floods, protect their property, and respond to future flood events. The project is in the planning phase, with activities set to begin soon.', '2025-05-01', 100000.00, 00.00, 'Coming', NULL),
(2, 'Restoring Agricultural Land', 'This project aims to help farmers restore agricultural land that has been damaged by floodwaters, which often leave soil eroded and crops destroyed. It involves providing farmers with necessary resources, such as seeds, fertilizers, tools, and access to training on flood recovery practices. The goal is to quickly restore food production in affected areas, ensuring that farmers can return to their livelihood and local markets can thrive. The project is currently ongoing with support being provided to affected farmers.', '2025-06-01', 300000.00, 00.00, 'Coming', NULL),
(2, 'Temporary Shelters for Flood Victims', 'Temporary shelters are being constructed to provide safe and secure accommodation for families displaced by the flooding. These shelters are equipped with basic amenities such as bedding, food, and clean water to ensure the well-being of those affected. The shelters offer a temporary solution while more permanent housing arrangements are made. This project has been successfully completed, providing shelter to thousands of displaced individuals.', '2025-07-01', 400000.00, 400000.00, 'Campleted', NULL),
(2, 'Support for Businesses Affected by Floods', 'This project provides financial aid and resources to businesses that have been impacted by the floods, helping them to recover from losses, repair damaged assets, and restart operations. The goal is to support the local economy and ensure that businesses can continue operating, providing jobs and services to the community. The project is in progress and continues to provide vital support to affected businesses.', '2025-08-01', 200000.00, 80000.00, 'In progress', NULL),
(2, 'Food Distribution for Flood Survivors', 'This initiative focuses on distributing food supplies to survivors of the floods, ensuring that those who have lost their homes and livelihoods have access to nutritious meals. It includes the distribution of emergency food packages containing essential staples such as rice, flour, and canned goods, as well as fresh produce and proteins. The food distribution project is in the planning stage, with coordination efforts underway to begin distribution as soon as possible.', '2025-09-01', 150000.00, 00.00, 'Coming', NULL),
(2, 'Restoration of Schools in Flooded Regions', 'This project involves the rebuilding and refurbishing of schools that were heavily damaged or destroyed by the floods. The goal is to restore educational services to the affected regions, ensuring that children can return to their studies in safe, functional environments. This includes repairs to buildings, the replacement of furniture, and the restoration of essential teaching materials. The project is currently not started but is a priority for the recovery efforts.', '2025-10-01', 300000.00, 300000.00, 'Campleted', NULL);



(3, 'Firefighting Equipment for Wildfires', 'This project involves the provision of essential firefighting equipment, including hoses, protective gear, fire trucks, and other specialized tools to aid in the fight against wildfires in Morocco. The goal is to ensure that firefighting teams have the resources they need to effectively combat and contain wildfires, reducing damage and saving lives. The project is currently in progress, with equipment being distributed to key locations affected by wildfires.', '2025-01-01', 300000.00, 100000.00, 'In progress', NULL),
(3, 'Rehabilitation of Fire-affected Forests', 'This initiative focuses on replanting trees and restoring ecosystems that have been severely damaged by wildfires in Morocco. It involves planting native tree species, rehabilitating soil, and rebuilding biodiversity in areas affected by fires. The goal is to help restore the natural balance and ensure the long-term health of the ecosystem. The project is ongoing and continues to make significant strides in rehabilitating fire-affected areas.', '2025-02-01', 500000.00, 00.00, 'Coming', NULL),
(3, 'Rescue Operations During Wildfires', 'This project mobilizes specialized rescue teams to evacuate individuals who are trapped in wildfire-affected areas, ensuring their safety and providing them with medical aid as needed. The teams are equipped with fire-resistant gear, rescue tools, and emergency supplies to navigate dangerous areas. This operation has been successfully completed, with all targeted individuals rescued and relocated to safe areas.', '2025-03-01', 400000.00, 400000.00, 'Campleted', NULL),
(3, 'Evacuation of Wildfire Victims', 'This operation focuses on evacuating residents from areas that are under threat from rapidly spreading wildfires, ensuring their safety and providing temporary shelter. It includes organizing transportation, establishing safe evacuation routes, and setting up emergency shelters to accommodate displaced individuals. The evacuation project is currently in progress, with efforts to move residents to safer areas ongoing.', '2025-04-01', 600000.00, 250000.00, 'In progress', NULL),
(3, 'Fire Awareness Campaign', 'This campaign aims to educate local communities about wildfire prevention techniques, fire safety measures, and emergency response plans. It includes organizing workshops, distributing informational pamphlets, and running awareness programs in fire-prone regions. The goal is to reduce the risk of wildfires by empowering communities with the knowledge they need to prevent and respond to fire emergencies. The project is in the planning stage and will begin soon.', '2025-05-01', 100000.00, 00.00, 'Coming', NULL),
(3, 'Rehabilitation of Wildfire-hit Villages', 'This project focuses on helping communities affected by wildfires rebuild their homes, businesses, and infrastructure. It involves providing financial and material support to families who lost their homes, as well as restoring community spaces such as schools and markets. The project also aims to assist local businesses in getting back on their feet. The project is in the planning stage and is set to begin in the coming months.', '2025-06-01', 400000.00, 00.00, 'Coming', NULL),
(3, 'Wildfire Relief for Livestock Owners', 'This initiative provides feed, water, and veterinary care to livestock owners whose animals were affected by wildfires. The goal is to help farmers and ranchers recover from the damage caused by the fires, ensuring the survival and health of their animals. The project also provides support for rebuilding fences and other infrastructure necessary for livestock care. The project has been completed, with support provided to affected livestock owners.', '2025-07-01', 150000.00, 150000.00, 'Campleted', NULL),
(3, 'Fire Safety Training for Local Communities', 'This project offers fire safety training programs for residents in wildfire-prone areas, teaching them how to prepare for wildfires, evacuate safely, and prevent fires from spreading. The training also covers emergency response techniques, including first aid and firefighting basics, to ensure communities can respond effectively during wildfire events. The training program is ongoing and continues to benefit communities in high-risk areas.', '2025-08-01', 200000.00, 00.00, 'Coming', NULL),
(3, 'Psychological Support for Wildfire Victims', 'This initiative focuses on providing counseling and psychological support to individuals and families who have been traumatized by the destruction caused by wildfires. It offers both individual and group therapy sessions, as well as support groups to help people cope with the emotional and psychological effects of losing their homes, loved ones, or livelihood. The project is currently not started but will begin shortly.', '2025-09-01', 100000.00, 00.00, 'Coming', NULL),
(3, 'Building Fire-resistant Housing', 'This project involves constructing homes using fire-resistant materials and techniques in areas prone to wildfires. The homes are designed to withstand high temperatures, preventing the spread of fire and minimizing the damage to property. The project also includes educating homeowners about fire-resistant landscaping and maintenance practices. The project is in progress and continues to work towards building safer communities in wildfire-prone regions.', '2025-10-01', 800000.00, 200000.00, 'In progress', NULL);


(4, 'Water Distribution for Drought Victims', 'This project involves providing essential water supplies to communities suffering from severe drought conditions in Morocco. The distribution focuses on areas where access to clean and safe drinking water is limited, and includes the setup of water collection points, tankers, and emergency water stations. The project is currently in progress, with teams working on the ground to ensure that affected communities have reliable access to water.', '2025-01-01', 400000.00, 100000.00, 'In progress', NULL),
(4, 'Agricultural Assistance for Farmers', 'This initiative supports farmers in drought-stricken regions by providing drought-resistant seeds, improved irrigation systems, and technical training on sustainable farming practices. The goal is to help farmers adapt to changing climate conditions and continue their agricultural activities despite water shortages. The project is ongoing, with continuous support provided to farmers throughout the region.', '2025-02-01', 500000.00, 00.00, 'Coming', NULL),
(4, 'Food Aid for Drought Victims', 'This project focuses on distributing food aid to families impacted by the severe drought in Morocco. The food packages include staples such as grains, legumes, and other non-perishable items to help affected communities meet their nutritional needs. The project has been completed, with food delivered to the most vulnerable households in drought-impacted regions.', '2025-03-01', 250000.00, 250000.00, 'Campleted', NULL),
(4, 'Drought Awareness Campaign', 'This campaign aims to raise awareness about the dangers of drought and the importance of water conservation. It includes educational workshops, public service announcements, and community outreach activities to teach residents how to save water, reduce consumption, and prepare for future droughts. The campaign is currently in progress, with ongoing efforts to reach as many people as possible.', '2025-04-01', 100000.00, 25000.00, 'In progress', NULL),
(4, 'Relief for Drought-affected Livestock', 'This initiative provides essential feed, water, and veterinary care for livestock suffering from the effects of the drought. It aims to prevent the loss of livestock, which is a critical resource for many rural communities. The project also offers guidance on managing livestock health during drought conditions. The project is ongoing, with ongoing support provided to affected livestock owners.', '2025-05-01', 150000.00, 00.00, 'Coming', NULL),
(4, 'Rehabilitation of Water Sources', 'This project focuses on restoring and repairing damaged wells, boreholes, and other water sources that have been impacted by the drought. The goal is to ensure a sustainable and long-term supply of water for communities that depend on these sources for drinking water and irrigation. The project has not started yet but is planned to begin soon in affected regions.', '2025-06-01', 200000.00, 00.00, 'Coming', NULL),
(4, 'Psychological Support for Drought Victims', 'This project offers mental health services to individuals and families suffering from the psychological impact of the drought, including stress, anxiety, and depression. Counseling services are provided to help people cope with the emotional toll of losing crops, livestock, and their livelihoods. The project has been completed, with mental health support offered to those in need.', '2025-07-01', 100000.00, 100000.00, 'Campleted', NULL),
(4, 'Food Security for Rural Areas', 'This initiative aims to ensure that rural communities maintain food security despite the ongoing drought. The project focuses on providing food aid, supporting local food production, and improving agricultural practices to adapt to the changing climate. The project is still in the planning stage and is set to launch soon in collaboration with local organizations.', '2025-08-01', 300000.00, 00.00, 'Coming', NULL),
(4, 'Drinking Water Storage Solutions', 'This project involves creating sustainable and reliable drinking water storage systems for communities affected by the drought. It includes the construction of water reservoirs, water tanks, and rainwater harvesting systems to ensure that communities can store water for future use. The project has not started yet but is scheduled to begin in the upcoming months.', '2025-09-01', 150000.00, 00.00, 'Coming', NULL),
(4, 'Supporting Education During Drought', 'This initiative ensures that children in drought-affected regions can continue their education despite the challenges posed by the water shortage. It includes providing educational materials, access to clean water in schools, and creating safe spaces for learning. The project is ongoing, with efforts to ensure that children’s education is not disrupted during the drought.', '2025-10-01', 200000.00, 00.00, 'Coming', NULL);


INSERT INTO note (description, date, color, org_id, cam_id)
VALUES
('Coordinate emergency relief efforts in flood-affected regions.', '2025-02-10', '#FF6347', 1, 1),
('Ensure timely distribution of food and water to earthquake survivors.', '2025-02-12', '#4682B4', 1, 3),
('Organize a fundraising event for fire victims in the south.', '2025-02-15', '#8A2BE2', 1, 5),
('Create awareness about earthquake preparedness in rural areas.', '2025-02-18', '#FFD700', 1, 8),
('Ensure delivery of medical supplies to disaster-stricken zones.', '2025-02-20', '#32CD32', 2, 11),
('Start collecting donations for victims of the recent hurricane.', '2025-03-02', '#FF4500', 2, 19),
('Host a volunteer recruitment event for flood relief operations.', '2025-03-05', '#ADFF2F', 2, 13),
('Prepare emergency kits for families affected by drought.', '2025-03-07', '#9ACD32', 3, 24),
('Coordinate with local authorities for disaster response training.', '2025-03-10', '#B0C4DE', 3, 26),
('Organize a donation drive for wildfire victims in the north.', '2025-03-15', '#D2691E', 3, 21),
('Coordinate emergency cleanup operations after oil spill in northern coast.', '2025-03-01', '#D2691E', 4, 31),
('Ensure marine life rehabilitation efforts are on schedule.', '2025-03-05', '#20B2AA', 4, 36),
('Develop a public awareness campaign on the importance of coral reefs.', '2025-03-07', '#FF6347', 4, 40),
('Organize a fundraiser to support ocean conservation projects.', '2025-03-10', '#87CEEB', 4, 34),
('Collaborate with local authorities to prevent illegal fishing in protected areas.', '2025-03-12', '#A9A9A9', 4, 35),
('Monitor water quality in coastal regions affected by pollution.', '2025-03-15', '#2E8B57', 4, 31);


INSERT INTO ressourses (name, price, quantity, org_id, cam_id)
VALUES
('Portable Water Filters', 25.00, 1000, 1, 2),
('First Aid Kits', 30.00, 1500, 1, 5),
('Shelter Tents', 100.00, 500, 1, 8),
('Canned Food', 2.00, 5000, 2, 15),
('Emergency Blankets', 10.00, 2000, 2, 13),
('Flashlights', 15.00, 1000, 2, 18),
('Fire Extinguishers', 50.00, 200, 3, 24),
('Solar-Powered Generators', 200.00, 50, 3, 26),
('Water Tankers', 1500.00, 10, 3, 21),
('Portable Toilets', 100.00, 50, 4, 32),
('Medical Supplies', 200.00, 300, 4, 36),
('Drought-Resistant Seeds', 5.00, 3000, 4, 31),
('Fireproof Clothing', 75.00, 200, 4, 40);


INSERT INTO ToDoList (content, completed, color, org_id, cam_id)
VALUES
('Organize an emergency response plan for flood victims.', FALSE, '#8A2BE2', 1, 1),
('Set up an emergency food distribution network for earthquake survivors.', TRUE, '#32CD32', 1, 2),
('Recruit volunteers to help with search-and-rescue operations.', FALSE, '#FFD700', 1, 4),
('Coordinate with local authorities to ensure safety in affected areas.', TRUE, '#FF6347', 2, 11),
('Prepare medical tents and resources for disaster-stricken regions.', FALSE, '#FF4500', 2, 14),
('Ensure transport logistics for rapid delivery of relief items.', TRUE, '#DC143C', 2, 18),
('Collect donations for drought-affected areas in the south.', FALSE, '#ADFF2F', 3, 24),
('Coordinate water delivery to rural regions during drought seasons.', TRUE, '#98FB98', 3, 21),
('Launch a fundraising campaign to combat wildfires in northern Morocco.', FALSE, '#D2691E', 3, 26),
('Work with local agencies to prevent disaster-related illnesses.', TRUE, '#A9A9A9', 4, 31),
('Provide psycho-social support services to disaster survivors.', FALSE, '#8B0000', 4, 32),
('Organize training on disaster preparedness and response for communities.', TRUE, '#B0E0E6', 4, 40);

