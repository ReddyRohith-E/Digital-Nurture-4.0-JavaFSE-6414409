-- Schema creation for H2 database
CREATE TABLE IF NOT EXISTS country (
    co_code VARCHAR(3) PRIMARY KEY,
    co_name VARCHAR(100) NOT NULL
);
