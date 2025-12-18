-- Insert countries
INSERT INTO countries (name, code) VALUES ('Ukraine', 'UKR');
INSERT INTO countries (name, code) VALUES ('Russia', 'RUS');
INSERT INTO countries (name, code) VALUES ('Israel', 'ISR');
INSERT INTO countries (name, code) VALUES ('Palestine', 'PSE');
INSERT INTO countries (name, code) VALUES ('United States', 'USA');
INSERT INTO countries (name, code) VALUES ('United Kingdom', 'GBR');

-- Insert conflicts
INSERT INTO conflicts (name, start_date, status, description)
VALUES ('Russo-Ukrainian War', '2014-02-20', 'ACTIVE', 'Armed conflict between Russia and Ukraine since 2014');

INSERT INTO conflicts (name, start_date, status, description)
VALUES ('Israeli-Palestinian Conflict', '1948-05-15', 'ACTIVE', 'Ongoing conflict between Israel and Palestine');

-- Associate countries with conflicts
INSERT INTO conflict_country (conflict_id, country_id)
VALUES (1, 1);

INSERT INTO conflict_country (conflict_id, country_id)
VALUES (1, 2);

INSERT INTO conflict_country (conflict_id, country_id)
VALUES (2, 3);

INSERT INTO conflict_country (conflict_id, country_id)
VALUES (2, 4);

-- Insert factions
INSERT INTO factions (name, conflict_id)
VALUES ('Ukrainian Armed Forces', 1);

INSERT INTO factions (name, conflict_id)
VALUES ('Russian Armed Forces', 1);

INSERT INTO factions (name, conflict_id)
VALUES ('Israeli Defense Forces', 2);

INSERT INTO factions (name, conflict_id)
VALUES ('Hamas', 2);

-- Insert events
INSERT INTO events (event_date, location, description, conflict_id)
VALUES ('2022-02-24', 'Kyiv', 'Full-scale Russian invasion begins', 1);

INSERT INTO events (event_date, location, description, conflict_id)
VALUES ('2023-10-07', 'Southern Israel', 'Hamas attack on Israel', 2);