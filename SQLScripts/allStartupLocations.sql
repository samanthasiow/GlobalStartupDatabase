DELIMITER $$

DROP PROCEDURE IF EXISTS AllStartupLocations $$

CREATE PROCEDURE AllStartupLocations()
BEGIN
	SELECT startupName as StartupName, location as Location
    FROM StartupListing as S, StartupLocation as L
    WHERE S.id = L.id;
END
$$