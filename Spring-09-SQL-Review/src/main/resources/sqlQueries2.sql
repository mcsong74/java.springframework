CREATE TABLE Towns
(
    id      SERIAL UNIQUE NOT NULL,
    code    VARCHAR(10)   NOT NULL, -- not unique
    article TEXT,
    name    TEXT          NOT NULL  -- not unique
);
-- below generat random 1000000 data into the towns table
insert into towns (code, article, name)
select left(md5(i::text), 10),
       md5(random()::text),
       md5(random()::text)
from generate_series(1, 1000000) s(i);

EXPLAIN ANALYZE
select *
from towns
where name = 'a00629c664832fcc0be492406d8d5c21'
  AND article = 'a063811a7824c01300b5a4a08917f46f';


CREATE INDEX idx_towns_name ON towns (name); -- create index for the name column with index namd as idx_towns_name

DROP INDEX IF EXISTS idx_towns_name;

EXPLAIN ANALYZE
select *
from towns
where id = '999996';

SELECT tablename,
       indexname,
       indexdef
FROM pg_indexes
WHERE schemaname = 'public'
ORDER BY tablename, indexname;















