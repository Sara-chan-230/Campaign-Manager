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
    ID INT PRIMARY KEY,
    name_oganization VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    descreption TEXT,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(50),
    facebook VARCHAR(255),
    instagram VARCHAR(255),
    twitter VARCHAR(255),
    logo BLOB
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






INSERT INTO Campaign (
    campaign_id, 
    org_id, 
    campaign_name, 
    campaign_description, 
    campaign_date, 
    needed_budjet, 
    raised_budjet, 
    campaign_status, 
    campaign_image
) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);

INSERT INTO Note (
    id, 
    description, 
    date, 
    color, 
    org_id
) VALUES (?, ?, ?, ?, ?);

INSERT INTO Organization (
    ID,
    name_oganization,
    password,
    descreption,
    email,
    phone,
    facebook,
    instagram,
    twitter,
    logo
) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);

INSERT INTO Ressourses (
    id,
    name,
    price,
    quantity,
    id_or
) VALUES (?, ?, ?, ?, ?);

INSERT INTO ToDoList (
    id,
    content,
    completed,
    color,
    iD_O
) VALUES (?, ?, ?, ?, ?);

