CREATE TABLE Pilot1
(
    pilotNumber INT         NOT NULL,
    pilotName   VARCHAR(10) NOT NULL,
    grade       INT         NOT NULL,
    age         FLOAT       NOT NULL,

    PRIMARY KEY (pilotNumber)
);

CREATE TABLE AirCraft
(
    airCraftNumber INT         NOT NULL,
    airCraftName   VARCHAR(20) NOT NULL,
    airCraftType   VARCHAR(20) NOT NULL,

    PRIMARY KEY (airCraftNumber)
);

CREATE TABLE Flight
(
    pilotNumber    INT  NOT NULL,
    airCraftNumber INT  NOT NULL,
    flightDate     DATE NOT NULL,
    FOREIGN KEY (pilotNumber) REFERENCES Pilot1 (pilotNumber),
    FOREIGN KEY (airCraftNumber) REFERENCES AirCraft (airCraftNumber)
);

INSERT INTO Pilot1
VALUES (13, '홍길동', 1, 44);
INSERT INTO Pilot1
VALUES (32, '이순신', 10, 44);
INSERT INTO Pilot1
VALUES (44, '안중근', 7, 32);

INSERT INTO AirCraft
VALUES (101, '에놀라게이', '폭격기');
INSERT INTO AirCraft
VALUES (102, '톰캣', '전투기');
INSERT INTO AirCraft
VALUES (103, '블랙버드', '정찰기');

INSERT INTO Flight
VALUES (13, 101, '2022-10-09');
INSERT INTO Flight
VALUES (44, 102, '2022-11-23');

SELECT *
FROM Pilot1;
SELECT *
FROM AirCraft;
SELECT *
FROM Flight;

SELECT pilotName
FROM Pilot1 AS P
         JOIN Flight AS F on P.pilotNumber = F.pilotNumber
WHERE F.airCraftNumber = 101;

SELECT pilotName
FROM Pilot1 AS P
         JOIN Flight F on P.pilotNumber = F.pilotNumber
         JOIN AirCraft AC on F.airCraftNumber = AC.airCraftNumber
WHERE airCraftType = '전투기';

SELECT airCraftType
FROM Flight AS F
         JOIN AirCraft AS A ON F.airCraftNumber = A.airCraftNumber
         JOIN Pilot1 AS P ON P.pilotNumber = F.pilotNumber
WHERE pilotName = '이순신';

SELECT *
FROM Pilot1 AS P LEFT OUTER JOIN Flight AS F ON P.pilotNumber = F.pilotNumber;
# SELECT pilotName
             # FROM Pilot1 AS P LEFT OUTER JOIN Flight AS F ON P.pilotNumber = F.pilotNumber
      # WHERE airCraftNumber IS NULL