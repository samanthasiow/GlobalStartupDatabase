/* Display all acquired startups */
DELIMITER $$

DROP PROCEDURE IF EXISTS ShowAcquiredStartups $$

CREATE PROCEDURE ShowAcquiredStartups()
BEGIN
	SELECT startupName as StartupName, highConcept as HighConcept, companyUrl as URL
	FROM StartupListing as S, StartupTypes as T
	WHERE S.id = T.id and T.type = 'acquired';
END
$$