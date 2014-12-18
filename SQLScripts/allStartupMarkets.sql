DELIMITER $$

DROP PROCEDURE IF EXISTS AllStartupMarkets $$

CREATE PROCEDURE AllStartupMarkets()
BEGIN
	SELECT startupName as StartupName, market as MarketType
    FROM StartupListing as S, StartupMarkets as M
    WHERE S.id = M.id;
END
$$