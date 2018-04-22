#!/bin/sh

## build angular project

docker run -it --rm --name dawllapop-angular -v /Users/alberto/DAW2018/daw-wallapop/ng-Dawllapop:/otp/dawllapop -w /otp/dawllapop teracy/angular-cli ng build --base-href /new/


##copy angular project into java project

rm /Users/alberto/DAW2018/daw-wallapop/Dawllapop/src/main/resources/static/new/*
cp /Users/alberto/DAW2018/daw-wallapop/ng-Dawllapop/dist/* /Users/alberto/DAW2018/daw-wallapop/Dawllapop/src/main/resources/static/new

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