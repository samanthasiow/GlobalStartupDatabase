/* Given a market type, display the % of startups of that market in all locations */
DELIMITER $$

DROP PROCEDURE IF EXISTS ShowPercentageMarketPerLocation $$

CREATE PROCEDURE ShowPercentageMarketPerLocation(IN marketType VARCHAR(255))
BEGIN

CREATE OR REPLACE VIEW NumStartupsPerLocation AS 
	SELECT DISTINCT  L.location, count(L.location) as numPerCity
	FROM StartupMarkets as M, StartupListing as S, StartupLocation as L
	WHERE M.id = S.id and S.id = L.id
	GROUP BY L.location;
    
    SELECT DISTINCT M.location, (M.numPerCity/N.numPerCity)*100 as PercentageMobile
	FROM NumStartupsPerLocation as N,
		(SELECT DISTINCT L.id, L.location, count(L.location) as numPerCity
		FROM StartupMarkets as M, StartupListing as S, StartupLocation as L
		WHERE M.id = S.id and S.id = L.id and M.market = marketType
		GROUP BY L.location) as M
	WHERE M.location = N.location
    ORDER BY PercentageMobile DESC;

END;
$$