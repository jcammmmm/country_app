CREATE TABLE
    war
    (
        wid INTEGER DEFAULT nextval('war_wid_seq'::regclass) NOT NULL,
        warname CHARACTER VARYING(60),
        cid_country INTEGER,
        CONSTRAINT war_pk PRIMARY KEY (wid),
        CONSTRAINT country_fk FOREIGN KEY (cid_country) REFERENCES country (cid) ON
    DELETE
        SET NULL
    ON
    UPDATE
        CASCADE
    );