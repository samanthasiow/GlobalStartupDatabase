/* Display all startups in a given market */
DELIMITER $$

DROP PROCEDURE IF EXISTS ShowStartupByMarket $$

CREATE PROCEDURE ShowStartupByMarket(IN marketName VARCHAR(255))
BEGIN
	IF EXISTS (SELECT market FROM StartupMarkets WHERE marketName = market)
		THEN 
			SELECT startupName as StartupName, highConcept as HighConcept, companyUrl as URL
			FROM StartupListing as S, StartupMarkets as M
            WHERE S.id = M.id and M.market = marketName;
	ELSE
		SELECT 'No Startups found in that Market.' AS  'Error Message';
	END IF;
END
$$