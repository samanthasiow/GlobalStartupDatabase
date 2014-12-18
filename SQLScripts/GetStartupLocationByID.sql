DELIMITER $$

DROP PROCEDURE IF EXISTS GetStartupLocationByID $$

CREATE PROCEDURE GetStartupLocationByID(IN startupID INT)
BEGIN
	SELECT location
    FROM StartupLocation
    WHERE id = startupID;
END
$$