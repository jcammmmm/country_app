CREATE TABLE
    country
    (
        cid INTEGER DEFAULT nextval('country_cid_seq'::regclass) NOT NULL,
        countryname CHARACTER VARYING(50),
        population INTEGER,
        extension DOUBLE PRECISION,
        govtype CHARACTER VARYING(50),
        wars CHARACTER VARYING(200),
        CONSTRAINT country_pk PRIMARY KEY (cid)
    );