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
                          org_id INT,
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
                      FOREIGN KEY (org_id) REFERENCES organization(ID)
);


CREATE TABLE ressourses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price FLOAT NOT NULL,
    quantity INT NOT NULL,
    id_or INT NOT NULL,
    FOREIGN KEY (id_or) REFERENCES organization(ID)
);

CREATE TABLE ToDoList (
    id INT AUTO_INCREMENT PRIMARY KEY,
    content TEXT NOT NULL,
    completed BOOLEAN NOT NULL,
    color VARCHAR(50),
    iD_O INT NOT NULL,
    FOREIGN KEY (iD_O) REFERENCES organization(ID)
);


-- Organization Inserts
INSERT INTO organization (name_oganization, password, descreption, email, phone, facebook, instagram, twitter, logo)
VALUES
('EcoFuture Initiative', SHA2('securePassword123', 256), 
'An organization dedicated to promoting environmental sustainability.', 
'info@ecofuture.org', '555-9876543', 'facebook.com/ecofuture', 'instagram.com/ecofuture', 'twitter.com/ecofuture', NULL),

('Global Health Alliance', SHA2('health12345!', 256), 
'A non-profit organization focused on improving global health through innovative solutions, education, and essential medical supplies.', 
'contact@gha.org', '555-2223333', 'facebook.com/globalhealthalliance', 'instagram.com/globalhealthalliance', 'twitter.com/gha', NULL),

('Bright Future Foundation', SHA2('futureSecure456', 256), 
'A philanthropic organization empowering underprivileged youth by providing access to education, mentorship programs, and career guidance.', 
'info@brightfuture.org', '555-1112222', 'facebook.com/brightfuture', 'instagram.com/brightfuture', 'twitter.com/brightfuture', NULL),

('Green Earth Collective', SHA2('greenerFuture@2025', 256), 
'A global environmental organization working to combat climate change, restore biodiversity, and promote sustainable living.', 
'info@greenearth.org', '555-3334444', 'facebook.com/greenearthcollective', 'instagram.com/greenearth', 'twitter.com/greenearth', NULL),

('Save The Oceans Initiative', SHA2('oceans123!', 256), 
'An international organization committed to protecting and preserving marine ecosystems.', 
'contact@savetheoceans.org', '555-4445555', 'facebook.com/savetheoceans', 'instagram.com/savetheoceans', 'twitter.com/savetheoceans', NULL);

-- Campaign Inserts
INSERT INTO campaign (org_id, campaign_name, campaign_description, campaign_date, needed_budjet, raised_budjet, campaign_status, campaign_image)
VALUES
(1, 'Plant A Million Trees', 
'An initiative to plant one million trees worldwide to combat climate change.', 
'2025-01-01', 50000.00, 20000.00, 'In progress', NULL),

(2, 'Global Vaccination Drive', 
'A comprehensive campaign aimed at eradicating preventable diseases such as polio and measles by providing free vaccines.', 
'2025-02-15', 150000.00, 50000.00, 'Planning', NULL),

(2, 'Clean Water for All', 
'Building water purification systems in rural areas where clean drinking water is scarce.', 
'2025-03-10', 200000.00, 75000.00, 'Ongoing', NULL),

(3, 'Rewilding the Forests', 
'Reintroducing native wildlife species to degraded forest ecosystems through reforestation.', 
'2025-04-01', 100000.00, 60000.00, 'In progress', NULL),

(3, 'Solar Power Villages', 
'Installing solar panels in remote villages to provide sustainable energy solutions.', 
'2025-05-01', 300000.00, 120000.00, 'Not started', NULL),

(4, 'Save the Coral Reefs', 
'Protecting and restoring coral reefs affected by climate change and human activity.', 
'2025-06-15', 250000.00, 80000.00, 'Planning', NULL),

(4, 'Plastic-Free Oceans', 
'Removing plastic waste from oceans through cleanup drives and recycling programs.', 
'2025-07-20', 500000.00, 150000.00, 'Ongoing', NULL),

(4, 'Sustainable Fishing Practices', 
'Promoting sustainable fishing practices to preserve marine biodiversity and support communities.', 
'2025-08-05', 120000.00, 45000.00, 'In progress', NULL),

(1, 'Urban Green Spaces Initiative', 
'Transforming underutilized urban areas into green spaces to improve air quality and biodiversity.', 
'2025-09-10', 400000.00, 250000.00, 'Ongoing', NULL);

-- Note Inserts
INSERT INTO note (description, date, color, org_id)
VALUES
('Coordinate with local schools for planting events.', '2025-01-02', '#FF5733', 1),
('Ensure saplings are delivered to all regions on time.', '2025-01-03', '#33FF57', 1),
('Schedule a meeting with local authorities to discuss campaign permits.', '2025-01-05', '#6A5ACD', 1),
('Prepare presentation materials for potential donors.', '2025-01-07', '#FFA07A', 1);

-- Ressourses Inserts
INSERT INTO ressourses (name, price, quantity, id_or)
VALUES
('Tree Saplings', 3.50, 10000, 1),
('Shovels', 15.00, 500, 1),
('Watering Cans', 7.00, 300, 1),
('Vaccines', 10.00, 5000, 2),
('Water Purifiers', 250.00, 100, 2),
('Solar Panels', 500.00, 50, 3),
('Coral Planting Kits', 30.00, 200, 4);

-- ToDoList Inserts
INSERT INTO ToDoList (content, completed, color, iD_O)
VALUES
('Contact media outlets for coverage.', FALSE, '#FFD700', 1),
('Finalize locations for planting events.', FALSE, '#87CEEB', 1),
('Recruit volunteers for tree planting.', TRUE, '#FF4500', 1),
('Order supplies for water purification systems.', FALSE, '#8A2BE2', 2),
('Schedule training for local healthcare workers.', TRUE, '#98FB98', 2),
('Organize a seminar on sustainable fishing practices.', FALSE, '#4682B4', 4),
('Launch a social media campaign for coral reef awareness.', TRUE, '#DC143C', 4);
