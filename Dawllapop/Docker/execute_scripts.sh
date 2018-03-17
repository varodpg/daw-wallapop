## all_in_one -> command to create an image from the sts project, publish the image on dockerHub and docker-compose (execute) the application


/Users/alberto/DAW2018/daw-wallapop/Dawllapop/Docker/create_image.sh
/Users/alberto/DAW2018/daw-wallapop/Dawllapop/Docker/publish_image.sh

cd /Users/alberto/DAW2018/daw-wallapop/Dawllapop/Docker/compose
docker run -e MYSQL_ROOT_PASSWORD=root -d mysql:5.7
docker-compose up