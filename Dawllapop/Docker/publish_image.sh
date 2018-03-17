#!/bin/sh

##script to publish an image to DockerHub

echo publishing image

docker tag dawllapop alberalgo/dawllapop
docker push alberalgo/dawllapop