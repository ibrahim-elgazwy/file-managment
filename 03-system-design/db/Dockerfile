FROM postgres as db
VOLUME /tmp
WORKDIR /db
COPY ./scripts/db/init.sh /docker-entrypoint-initdb.d
COPY ./scripts/db/dump.sql ./scripts/db/dump.sql