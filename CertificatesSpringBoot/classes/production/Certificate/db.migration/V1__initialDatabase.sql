ALTER SCHEMA CERTIFICATES
CREATE TABLE KLANTEN(
  ADD COLUMN KLANT_ID INT(10)  AUTO_INCREMENT PRIMARY KEY,
  ADD COLUMN NAAM VARCHAR(200) NOT NULL,
  ADD COLUMN STRAAT VARCHAR(200) NOT NULL,
  ADD COLUMN NUMMER VARCHAR(200) NOT NULL,
  ADD COLUMN POSTCODE VARCHAR(200) NOT NULL,
  ADD COLUMN STAD VARCHAR(200) NOT NULL,
  ADD FOREIGN KEY (ORDER_ID) REFERENCES ORDERS(ORDER_ID)
);

CREATE TABLE ORDERS(
  ADD COLUMN ORDER_ID INT(10)  AUTO_INCREMENT PRIMARY KEY,
  ADD COLUMN  WORK_ORDER_NUMBER  VARCHAR(200) NOT NULL,
 ADD COLUMN PURCHASE_ORDER_NUMBER  VARCHAR(200) NOT NULL,
 ADD COLUMN SPECIFICATIE VARCHAR(200) NOT Null,
 ADD COLUMN TOTAAL_GEWICHT VARCHAR(200) NOT Null,
   ADD FOREIGN KEY (CERTIFICAAT_ID) REFERENCES CERTIFICAAT(CERTIFICAAT_ID)
);

CREATE TABLE CERTIFICAAT(
  ADD COLUMN CERTIFICAAT_ID INT(10)  AUTO_INCREMENT PRIMARY KEY,
  ADD COLUMN CERTIFICAAT_NUMBER VARCHAR(200) NOT NULL,
  ADD COLUMN DATUM_CERTIFICAAT DATE NOT NULL,
  ADD COLUMN SPECIFIEK_TONNAGE INT(200)
);

