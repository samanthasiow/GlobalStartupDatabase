DELIMITER $$

DROP PROCEDURE IF EXISTS GetStartupMarketByID $$

CREATE PROCEDURE GetStartupMarketByID(IN startupID INT)
BEGIN
	SELECT market
    FROM StartupMarkets
    WHERE id = startupID;
END
$$