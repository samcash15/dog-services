-- DOG_BREED inserts
INSERT INTO DOG_BREED (breed, approx_weight, size, adapt_rating, friendliness_rating, groom_rating, train_rating, phys_need_rating, create_date, update_date)
VALUES ('German Shepherd', '30-40kg', 'Large', 4, 3, 2, 5, 4, '2022-01-01', '2022-01-01');

INSERT INTO DOG_BREED (breed, approx_weight, size, adapt_rating, friendliness_rating, groom_rating, train_rating, phys_need_rating, create_date, update_date)
VALUES ('Pitbull', '20-30kg', 'Medium', 3, 4, 3, 4, 5, '2022-01-02', '2022-01-02');

INSERT INTO DOG_BREED (breed, approx_weight, size, adapt_rating, friendliness_rating, groom_rating, train_rating, phys_need_rating, create_date, update_date)
VALUES ('English Shepherd', '25-35kg', 'Medium', 4, 4, 3, 4, 4, '2022-01-03', '2022-01-03');

-- ADAPTABILITY inserts
INSERT INTO ADAPTABILITY (dog_id, adpts_well_to_aprtmnt_lvng, good_for_novice_ownrs, sensitivity_lvl, tol_being_alone, tol_cold_weather, tol_hot_weather, create_date)
VALUES (1, 4, 5, 3, 2, 4, 3, '2021-01-01');

INSERT INTO ADAPTABILITY (dog_id, adpts_well_to_aprtmnt_lvng, good_for_novice_ownrs, sensitivity_lvl, tol_being_alone, tol_cold_weather, tol_hot_weather, create_date)
VALUES (2, 3, 4, 2, 5, 3, 2, '2021-01-02');

INSERT INTO ADAPTABILITY (dog_id, adpts_well_to_aprtmnt_lvng, good_for_novice_ownrs, sensitivity_lvl, tol_being_alone, tol_cold_weather, tol_hot_weather, create_date)
VALUES (3, 3, 4, 2, 5, 3, 2, '2021-01-02');

-- FRIENDLINESS inserts
INSERT INTO FRIENDLINESS (dog_id, affectionate_with_fam, kid_friendly, dog_friendly, friendly_toward_strangers, create_date)
VALUES (1, 5, 4, 4, 5, '2022-01-01');

INSERT INTO FRIENDLINESS (dog_id, affectionate_with_fam, kid_friendly, dog_friendly, friendly_toward_strangers, create_date)
VALUES (2, 4, 5, 3, 4, '2022-01-02');

INSERT INTO FRIENDLINESS (dog_id, affectionate_with_fam, kid_friendly, dog_friendly, friendly_toward_strangers, create_date)
VALUES (3, 3, 3, 5, 4, '2022-01-03');

-- HEALTH_AND_GROOMING_NEEDS inserts
INSERT INTO HEALTH_AND_GROOMING_NEEDS (dog_id, amount_of_shedding, drooling_potential, easy_to_groom, general_health, potential_for_weight_gain, size, create_date)
VALUES (1, 4, 2, 3, 4, 3, 4, '2022-01-01');

INSERT INTO HEALTH_AND_GROOMING_NEEDS (dog_id, amount_of_shedding, drooling_potential, easy_to_groom, general_health, potential_for_weight_gain, size, create_date)
VALUES (2, 3, 5, 2, 5, 4, 3, '2022-01-02');

INSERT INTO HEALTH_AND_GROOMING_NEEDS (dog_id, amount_of_shedding, drooling_potential, easy_to_groom, general_health, potential_for_weight_gain, size, create_date)
VALUES (3, 2, 3, 5, 3, 2, 5, '2022-01-03');

-- PHYSICAL_NEEDS
INSERT INTO PHYSICAL_NEEDS (dog_id, energy_level, intensity, exercise_needs, potential_for_playfulness, create_date)
VALUES (1, 4, 4, 5, 5, '2022-01-01');

INSERT INTO PHYSICAL_NEEDS (dog_id, energy_level, intensity, exercise_needs, potential_for_playfulness, create_date)
VALUES (2, 3, 3, 4, 4, '2022-01-02');

INSERT INTO PHYSICAL_NEEDS (dog_id, energy_level, intensity, exercise_needs, potential_for_playfulness, create_date)
VALUES (3, 2, 2, 3, 3, '2022-01-03');

-- TRAINABILITY inserts
INSERT INTO TRAINABILITY (dog_id, easy_to_train, intelligence, potential_for_mouthiness, prey_drive, tendency_to_bark_or_howl, wanderlust_potential, create_date)
VALUES (1, 5, 4, 3, 4, 2, 3, '2022-01-01');

INSERT INTO TRAINABILITY (dog_id, easy_to_train, intelligence, potential_for_mouthiness, prey_drive, tendency_to_bark_or_howl, wanderlust_potential, create_date)
VALUES (2, 4, 3, 4, 3, 3, 2, '2022-01-02');

INSERT INTO TRAINABILITY (dog_id, easy_to_train, intelligence, potential_for_mouthiness, prey_drive, tendency_to_bark_or_howl, wanderlust_potential, create_date)
VALUES (3, 3, 4, 2, 5, 4, 4, '2022-01-03');

