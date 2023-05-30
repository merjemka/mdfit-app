
/* if needed drop database if exists `mdfit`;*/

/* run create database before running app*/
create database if not exists `mdfit`;

/* after running app, tables will be created and then execute script below*/
use `mdfit`;

INSERT INTO users (name, email, password, address, age, gender, height, weight, fitness_goal)
VALUES ('John Doe', 'john@example.com', 'password123', '123 Street', 30, 'Male', 180, 75, 'Lose weight'),
       ('Jane Smith', 'jane@example.com', 'password456', '456 Avenue', 25, 'Female', 165, 60, 'Build muscle');

INSERT INTO fitness_diaries (user_id)
VALUES (1),
       (2);

INSERT INTO fitness_professional (name, email, password, experience, speciality)
VALUES ('Fitness Pro 1', 'pro1@example.com', 'password789', 5, 'Weightlifting'),
       ('Fitness Pro 2', 'pro2@example.com', 'passwordabc', 3, 'Yoga');	
       
INSERT INTO workouts (video_link, fitness_professional_id, description)
VALUES ('https://example.com/video1', 1, 'Full body workout'),
       ('https://example.com/video2', 2, 'Cardio workout');
       
 INSERT INTO diary_entries (log_date_name, fitness_diary_id)
VALUES ('2023-05-21 08:00:00', 1),
       ('2023-05-22 09:00:00', 2);  
       
       
 INSERT INTO activity_data (user, duration, activity_type, diary_entry_id, workout_id)
VALUES (1, 60.5, 'Running', 1, 1),
       (2, 45.0, 'Weightlifting', 2, 2);      
       
 INSERT INTO nutrition_data (food_name, calories, protein, carbs, fats, diary_entry_id)
VALUES ('Salmon', 300, 25, 0, 15, 1),
       ('Quinoa', 200, 8, 40, 3, 2),
       ('Spinach', 50, 5, 3, 1, 2),
       ('Greek yogurt', 150, 15, 8, 5, 1),
       ('Almonds', 160, 6, 6, 14, 1),
       ('Chicken breast', 250, 30, 0, 10, 1),
       ('Brown rice', 150, 5, 30, 2, 2);   
 
 INSERT INTO activity_data (user, duration, activity_type, diary_entry_id, workout_id)
VALUES (1, 30.0, 'Cycling', 1, 1),
       (2, 60.0, 'Pilates', 2, 2),
       (1, 45.0, 'Swimming', 1, 1),
       (2, 75.0, 'Yoga', 2, 2),
       (1, 60.0, 'Basketball', 1, 1),
       (1, 60.5, 'Running', 1, 1),
       (2, 45.0, 'Weightlifting', 2, 2);
 