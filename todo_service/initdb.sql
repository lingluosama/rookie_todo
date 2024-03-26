create database todo;

CREATE type events AS (
                          compelet BOOLEAN,
                          content text,
                          endTime text,
                          level BIGINT,
                          startTime text,
                          title text,
                          userid INT
                      );

CREATE TABLE users (
                       id bigserial PRIMARY KEY,
                       name text,
                       password text,
                       iconurl text,
                       events events[]
);