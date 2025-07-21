-- SQL Server Database setup script
-- Run this script in SQL Server Management Studio (SSMS) or sqlcmd

-- Create database
IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'ormlearn')
BEGIN
    CREATE DATABASE ormlearn
    COLLATE SQL_Latin1_General_CP1_CI_AS;
END
GO

-- Use the database
USE ormlearn;
GO

-- Create country table
IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='country' AND xtype='U')
BEGIN
    CREATE TABLE country (
        co_code NVARCHAR(3) PRIMARY KEY,
        co_name NVARCHAR(100) NOT NULL
    );
END
GO

-- Insert sample data (using MERGE to avoid duplicates)
MERGE country AS target
USING (VALUES 
    ('IN', 'India'),
    ('US', 'United States of America'),
    ('UK', 'United Kingdom'),
    ('CA', 'Canada'),
    ('AU', 'Australia'),
    ('DE', 'Germany'),
    ('FR', 'France'),
    ('JP', 'Japan'),
    ('CN', 'China'),
    ('BR', 'Brazil'),
    ('RU', 'Russia'),
    ('IT', 'Italy'),
    ('ES', 'Spain'),
    ('NL', 'Netherlands'),
    ('SE', 'Sweden')
) AS source (co_code, co_name)
ON target.co_code = source.co_code
WHEN MATCHED THEN
    UPDATE SET co_name = source.co_name
WHEN NOT MATCHED THEN
    INSERT (co_code, co_name) VALUES (source.co_code, source.co_name);
GO

-- Create an application user (optional but recommended for production)
-- Uncomment and modify these lines if you want a dedicated application user
/*
IF NOT EXISTS (SELECT * FROM sys.server_principals WHERE name = 'ormlearn_user')
BEGIN
    CREATE LOGIN ormlearn_user WITH PASSWORD = 'OrmLearn@2025!';
END

USE ormlearn;
IF NOT EXISTS (SELECT * FROM sys.database_principals WHERE name = 'ormlearn_user')
BEGIN
    CREATE USER ormlearn_user FOR LOGIN ormlearn_user;
    ALTER ROLE db_datareader ADD MEMBER ormlearn_user;
    ALTER ROLE db_datawriter ADD MEMBER ormlearn_user;
END
*/

-- Verify data
SELECT 'Database setup completed successfully!' as status;
SELECT COUNT(*) as total_countries FROM country;
SELECT * FROM country ORDER BY co_code;
GO
