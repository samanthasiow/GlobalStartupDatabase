/* Display an ordered list of the percentage startups acquired by location */
DELIMITER $$

DROP PROCEDURE IF EXISTS ShowPercentageAcquiredPerLocation $$

CREATE PROCEDURE ShowPercentageAcquiredPerLocation()
BEGIN

CREATE OR REPLACE VIEW NumStartupsPerLocation AS 
	SELECT DISTINCT  L.location, count(L.location) as numPerCity
	FROM StartupMarkets as M, StartupLocation as L
	WHERE M.id = L.id
	GROUP BY L.location;

SELECT DISTINCT A.location, (A.numAcquired/N.numPerCity)*100 as PercentageAcquired
FROM NumStartupsPerLocation as N,
	(SELECT DISTINCT L.location, count(location) as numAcquired
	FROM StartupTypes as T, StartupLocation as L
	WHERE T.id = L.id and T.type = 'acquired'
	GROUP BY L.Location) as A
WHERE A.location = N.location
ORDER BY PercentageAcquired DESC;

END;
$$