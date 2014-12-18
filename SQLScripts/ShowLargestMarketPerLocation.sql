/* Display the most popular startup market by location */
DELIMITER $$

DROP PROCEDURE IF EXISTS ShowLargestMarketPerLocation $$

CREATE PROCEDURE ShowLargestMarketPerLocation(IN locationName VARCHAR(255))
BEGIN

CREATE OR REPLACE VIEW NumStartupsPerLocation AS 
	SELECT *
    FROM (SELECT M.market as Market, count(market) as NumStartups
		FROM StartupLocation as L, StartupMarkets as M
		WHERE L.id = M.id and L.location = locationName
		GROUP BY market
		ORDER BY NumStartups DESC) as M
	WHERE M.NumStartups >= ALL (SELECT count(market) as NumStartups
								FROM StartupLocation as L, StartupMarkets as M
								WHERE L.id = M.id and L.location = locationName
								GROUP BY market
								ORDER BY NumStartups DESC);
END;
$$