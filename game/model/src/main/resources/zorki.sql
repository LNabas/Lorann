DROP PROCEDURE recup_map;
DELIMITER |
CREATE PROCEDURE recup_map(p_id INT)
BEGIN
    SELECT *
    FROM Level
	WHERE id=p_id;
END|
CREATE PROCEDURE nb_map()
BEGIN
    SELECT COUNT(*)
	AS nb
    FROM Level;
END|
DELIMITER ;