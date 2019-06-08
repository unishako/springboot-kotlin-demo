create database demo;
CREATE TABLE users(
    id    DECIMAL NOT NULL IDENTITY(1,1) PRIMARY KEY,
    name  NVARCHAR(1000) NOT NULL
);
