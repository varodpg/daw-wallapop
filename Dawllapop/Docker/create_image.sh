#!/bin/sh

## create_image
## mount the route from app where POM is located. In this case: (/Users/alberto/DAW2018/daw-wallapop/Dawllapop)

docker run -it --rm --name dawllapop -v /Users/alberto/DAW2018/daw-wallapop/Dawllapop:/usr/src/mymaven -w /usr/src/mymaven maven mvn package

##move the .jar generated to Docker directory where DockerFile is located
##The DockerFile include the information to generate the image

sleep 2
echo Compress finished, building the image 
sleep 2

mv /Users/alberto/DAW2018/daw-wallapop/Dawllapop/target/dawllapop.jar /Users/alberto/DAW2018/daw-wallapop/Dawllapop/Docker
docker build -t dawllapop /Users/alberto/DAW2018/daw-wallapop/Dawllapop/Docker/.