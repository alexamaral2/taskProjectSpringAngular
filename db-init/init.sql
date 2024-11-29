DO $$
BEGIN
    IF NOT EXISTS (SELECT FROM pg_catalog.pg_roles WHERE rolname = 'task_user') THEN
        CREATE USER task_user WITH PASSWORD 'task_password';
    END IF;
    
    IF NOT EXISTS (SELECT FROM pg_database WHERE datname = 'task_db') THEN
        CREATE DATABASE task_db;
    END IF;

    GRANT ALL PRIVILEGES ON DATABASE task_db TO task_user;
END
$$;
