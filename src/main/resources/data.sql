-- Insert countries
INSERT INTO countries (name, code) VALUES ('Ukraine', 'UKR');
INSERT INTO countries (name, code) VALUES ('Russia', 'RUS');
INSERT INTO countries (name, code) VALUES ('Israel', 'ISR');
INSERT INTO countries (name, code) VALUES ('Palestine', 'PSE');
INSERT INTO countries (name, code) VALUES ('United States', 'USA');
INSERT INTO countries (name, code) VALUES ('United Kingdom', 'GBR');
INSERT INTO countries (name, code) VALUES ('Armenia', 'ARM');
INSERT INTO countries (name, code) VALUES ('Azerbaijan', 'AZE');
INSERT INTO countries (name, code) VALUES ('Argentina', 'ARG');

-- Insert conflicts with DIFFERENT STATUSES for demo
INSERT INTO conflicts (name, start_date, status, description)
VALUES ('Russo-Ukrainian War', '2014-02-20', 'ACTIVE', 'Armed conflict between Russia and Ukraine since 2014');

INSERT INTO conflicts (name, start_date, status, description)
VALUES ('Israeli-Palestinian Conflict', '1948-05-15', 'ACTIVE', 'Ongoing conflict between Israel and Palestine');

-- ADDED: FROZEN conflict
INSERT INTO conflicts (name, start_date, status, description)
VALUES ('Nagorno-Karabakh Conflict', '1988-02-20', 'FROZEN', 'Frozen conflict between Armenia and Azerbaijan');

-- ADDED: ENDED conflict
INSERT INTO conflicts (name, start_date, status, description)
VALUES ('Falklands War', '1982-04-02', 'ENDED', 'War between Argentina and United Kingdom in 1982');

-- Associate countries with conflicts
-- Russo-Ukrainian War
INSERT INTO conflict_country (conflict_id, country_id) VALUES (1, 1); -- Ukraine
INSERT INTO conflict_country (conflict_id, country_id) VALUES (1, 2); -- Russia

-- Israeli-Palestinian Conflict
INSERT INTO conflict_country (conflict_id, country_id) VALUES (2, 3); -- Israel
INSERT INTO conflict_country (conflict_id, country_id) VALUES (2, 4); -- Palestine

-- Nagorno-Karabakh Conflict (FROZEN)
INSERT INTO conflict_country (conflict_id, country_id) VALUES (3, 7); -- Armenia
INSERT INTO conflict_country (conflict_id, country_id) VALUES (3, 8); -- Azerbaijan

-- Falklands War (ENDED)
INSERT INTO conflict_country (conflict_id, country_id) VALUES (4, 9); -- Argentina
INSERT INTO conflict_country (conflict_id, country_id) VALUES (4, 6); -- United Kingdom

-- Insert factions
-- Russo-Ukrainian War factions
INSERT INTO factions (name, conflict_id) VALUES ('Ukrainian Armed Forces', 1);
INSERT INTO factions (name, conflict_id) VALUES ('Russian Armed Forces', 1);

-- Israeli-Palestinian Conflict factions
INSERT INTO factions (name, conflict_id) VALUES ('Israeli Defense Forces', 2);
INSERT INTO factions (name, conflict_id) VALUES ('Hamas', 2);

-- Nagorno-Karabakh factions (FROZEN)
INSERT INTO factions (name, conflict_id) VALUES ('Armenian Armed Forces', 3);
INSERT INTO factions (name, conflict_id) VALUES ('Azerbaijani Armed Forces', 3);

-- Falklands War factions (ENDED)
INSERT INTO factions (name, conflict_id) VALUES ('Argentine Forces', 4);
INSERT INTO factions (name, conflict_id) VALUES ('British Task Force', 4);

-- Insert events
-- Russo-Ukrainian War events
INSERT INTO events (event_date, location, description, conflict_id)
VALUES ('2022-02-24', 'Kyiv', 'Full-scale Russian invasion begins', 1);

-- Israeli-Palestinian Conflict events
INSERT INTO events (event_date, location, description, conflict_id)
VALUES ('2023-10-07', 'Southern Israel', 'Hamas attack on Israel', 2);

-- Nagorno-Karabakh events (FROZEN)
INSERT INTO events (event_date, location, description, conflict_id)
VALUES ('2020-09-27', 'Nagorno-Karabakh', '2020 war escalation', 3);

-- Falklands War events (ENDED)
INSERT INTO events (event_date, location, description, conflict_id)
VALUES ('1982-06-14', 'Port Stanley', 'Argentine surrender', 4);