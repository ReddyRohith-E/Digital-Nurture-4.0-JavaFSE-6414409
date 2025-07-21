-- MySQL Database setup script
-- Run this script in MySQL Workbench or command line

-- Create database
CREATE DATABASE IF NOT EXISTS ormlearn
CHARACTER SET utf8mb4 
COLLATE utf8mb4_unicode_ci;

-- Use the database
USE ormlearn;

-- Create country table
CREATE TABLE IF NOT EXISTS country (
    co_code VARCHAR(3) PRIMARY KEY COMMENT 'Country code (ISO 3166-1 alpha-2/3)',
    co_name VARCHAR(100) NOT NULL COMMENT 'Country name'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Insert sample data
INSERT INTO country (co_code, co_name) VALUES
('IN', 'India'),
('US', 'United States of America'),
('UK', 'United Kingdom'),
('CA', 'Canada'),
('AU', 'Australia'),
('DE', 'Germany'),
('FR', 'France'),
('JP', 'Japan'),
('CN', 'China'),
('BR', 'Brazil')
ON DUPLICATE KEY UPDATE co_name = VALUES(co_name);

-- Verify data
SELECT 'Database setup completed successfully!' as status;
SELECT COUNT(*) as total_countries FROM country;
SELECT * FROM country ORDER BY co_code;
