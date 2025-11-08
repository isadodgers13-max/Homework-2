INSERT INTO students (id, first_name, last_name, email) VALUES (1,'Alice','Smith','alice@example.com');
INSERT INTO students (id, first_name, last_name, email) VALUES (2,'Bob','Jones','bob@example.com');

INSERT INTO classes (id, name, level, day_of_week, time) VALUES (1,'Swim Basics','Beginner','Monday','09:00');
INSERT INTO classes (id, name, level, day_of_week, time) VALUES (2,'Stroke Improvement','Intermediate','Wednesday','17:00');

-- enrollments: join table (class_id, student_id)
INSERT INTO enrollments (class_id, student_id) VALUES (1,1);
