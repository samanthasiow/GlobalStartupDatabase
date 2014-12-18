/* Display the number of startups per location */
DELIMITER $$

DROP PROCEDURE IF EXISTS ShowNumStartupsPerLocation $$

CREATE PROCEDURE ShowNumStartupsPerLocation()
BEGIN
	SELECT L.location, count(L.location) as NumStartups
	FROM StartupLocation as L, StartupListing as S
	WHERE L.id = S.id
	GROUP BY location
	ORDER BY NumStartups DESC;
END;
$$