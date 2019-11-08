FROM openjdk:13-alpine

ARG GROUP_ID="com.netflix"
ARG VERSION="0.0.1-SNAPSHOT"
ARG ARTIFACT_ID="microservice1"

ENV ARTIFACT_ID="$ARTIFACT_ID"
ENV VERSION="$VERSION"
ENV JAVA_OPTS=""
ENV MAIN_DIR /opt/microservice1
ENV APP_DIR /opt/microservice1/app

ADD start.sh $MAIN_DIR/start.sh

RUN apk -q update && apk -q add bash && apk -q add --update curl \
    # Add user microservice1
    && adduser -D microservice1 \
    # Create folders
    && mkdir -p $APP_DIR && chown -R microservice1:microservice1 $MAIN_DIR \
    # Permissions 
    && chmod +x $MAIN_DIR/start.sh

WORKDIR $APP_DIR

COPY target/${ARTIFACT_ID}-${VERSION}.jar ${APP_DIR}/${ARTIFACT_ID}-${VERSION}.jar

WORKDIR $MAIN_DIR

USER microservice1

ENTRYPOINT [ "sh", "-c", "./start.sh" ]
