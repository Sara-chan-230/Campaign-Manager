CREATE DATABASE  campaigns_manager;

CREATE TABLE Campaign (
    campaign_id INT PRIMARY KEY,          
    campaign_name VARCHAR(255) NOT NULL,  
    campaign_description TEXT NOT NULL,   
    campaign_date DATE NOT NULL,          
    needed_budjet FLOAT NOT NULL,         
    raised_budjet FLOAT NOT NULL,         
    campaign_status VARCHAR(50) NOT NULL, 
    campaign_image BLOB                   
);

CREATE TABLE Note (
    id INT PRIMARY KEY,
    description TEXT NOT NULL,
    date DATE NOT NULL,
    color VARCHAR(50),
    org_id INT NOT NULL
);

CREATE TABLE Organization (
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

CREATE TABLE Ressourses (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price FLOAT NOT NULL,
    quantity INT NOT NULL,
    id_or INT NOT NULL,
    FOREIGN KEY (id_or) REFERENCES Organization(ID)
);

CREATE TABLE ToDoList (
    id INT PRIMARY KEY,
    content TEXT NOT NULL,
    completed BOOLEAN NOT NULL,
    color VARCHAR(50),
    iD_O INT NOT NULL,
    FOREIGN KEY (iD_O) REFERENCES Organization(ID)
);


INSERT INTO Organization (name_oganization, password, descreption, email, phone, facebook, instagram, twitter, logo)
VALUES
('EcoFuture Initiative', SHA2('securePassword123', 256), 'An organization dedicated to promoting environmental sustainability.', 
'info@ecofuture.org', '555-9876543', 'facebook.com/ecofuture', 'instagram.com/ecofuture', 'twitter.com/ecofuture', NULL);

INSERT INTO Campaign (org_id, campaign_name, campaign_description, campaign_date, needed_budjet, raised_budjet, campaign_status, campaign_image)
VALUES
(1, 'Plant A Million Trees', 
'An initiative to plant one million trees worldwide to combat climate change.', 
'2025-01-01', 50000.00, 20000.00, 'Active', LOAD_FILE('C:/Users/Ibtissam/Downloads/your_image_name.png'));

INSERT INTO Note (description, date, color, org_id)
VALUES
('Coordinate with local schools for planting events.', '2025-01-02', '#FF5733', 1),
('Ensure saplings are delivered to all regions on time.', '2025-01-03', '#33FF57', 1);


INSERT INTO Ressourses (name, price, quantity, id_or)
VALUES
('Tree Saplings', 3.50, 10000, 1),
('Shovels', 15.00, 500, 1),
('Watering Cans', 7.00, 300, 1);

INSERT INTO ToDoList (content, completed, color, iD_O)
VALUES
('Contact media outlets for coverage.', FALSE, '#FFD700', 1),
('Finalize locations for planting events.', FALSE, '#87CEEB', 1),
('Recruit volunteers for tree planting.', TRUE, '#FF4500', 1);








