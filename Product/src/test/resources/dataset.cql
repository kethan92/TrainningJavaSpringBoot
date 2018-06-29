

CREATE TABLE IF NOT EXISTS mykeyspace.location (
    location_id UUID PRIMARY KEY,
    city text,
    country text,
    create_at timestamp,
    modified_at timestamp,
);


