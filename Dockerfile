FROM bellsoft/liberica-native-image-kit-container:jdk-24-nik-24

RUN apk add entr

WORKDIR /app
ADD BOOT-INF/lib /app/lib
ADD META-INF /app/META-INF
ADD BOOT-INF/classes /app

ENTRYPOINT java -cp .:./lib/* com.webapp.tengine.TengineApplication