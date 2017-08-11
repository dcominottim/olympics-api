INSERT INTO competitor(id, name) VALUES (nextval('seq_competitor'), 'Brasil');
INSERT INTO competitor(id, name) VALUES (nextval('seq_competitor'), 'Estados Unidos');
INSERT INTO competitor(id, name) VALUES (nextval('seq_competitor'), 'China');
INSERT INTO competitor(id, name) VALUES (nextval('seq_competitor'), 'Rússia');
INSERT INTO competitor(id, name) VALUES (nextval('seq_competitor'), 'França');
INSERT INTO competitor(id, name) VALUES (nextval('seq_competitor'), 'Alemanha');

INSERT INTO local(id, name) VALUES (nextval('seq_local'), 'Estádio 1');
INSERT INTO local(id, name) VALUES (nextval('seq_local'), 'Estádio 2');
INSERT INTO local(id, name) VALUES (nextval('seq_local'), 'Estádio 3');
INSERT INTO local(id, name) VALUES (nextval('seq_local'), 'Estádio 4');

INSERT INTO modality(id, name) VALUES (nextval('seq_modality'), 'Basquete');
INSERT INTO modality(id, name) VALUES (nextval('seq_modality'), 'Futebol');
INSERT INTO modality(id, name) VALUES (nextval('seq_modality'), 'Vôlei');

INSERT INTO step(id, name, accepts_same_competitors) VALUES (nextval('seq_step'), 'Eliminatórias', false);
INSERT INTO step(id, name, accepts_same_competitors) VALUES (nextval('seq_step'), 'Oitavas de final', false);
INSERT INTO step(id, name, accepts_same_competitors) VALUES (nextval('seq_step'), 'Quartas de final', false);
INSERT INTO step(id, name, accepts_same_competitors) VALUES (nextval('seq_step'), 'Semifinais', true);
INSERT INTO step(id, name, accepts_same_competitors) VALUES (nextval('seq_step'), 'Finais', true);

INSERT INTO schedule(id) VALUES (nextval('seq_schedule'));




