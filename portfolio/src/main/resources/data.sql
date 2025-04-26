CREATE TABLE project (
    id INT AUTO_INCREMENT PRIMARY KEY,  -- Unique identifier for each project
    name VARCHAR(255) NOT NULL,         -- Name of the project
    description TEXT NOT NULL,          -- Description of the project
    image_url VARCHAR(255),             -- URL of the image associated with the project
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP  -- Optional: To track creation time
);

INSERT INTO project (name, description, image_url) VALUES
('Project 1', 'Description of Project 1', 'project1.jpg'),
('Project 2', 'Description of Project 2', 'project2.jpg');

CREATE TABLE Customer (
    id INT NOT NULL,
    name VARCHAR(255),
    PRIMARY KEY (id)
);

INSERT INTO Customer (id, name) VALUES
('123', 'aman'),
('456', 'Ajay');
