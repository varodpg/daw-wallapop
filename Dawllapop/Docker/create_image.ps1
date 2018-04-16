$var = $(get-item ${PWD}).parent.FullName
$pathProjectAngular = $var + "..\ng-Dawllapop"
$pathProject = $var
$pathJar = $pathProject + "\target"

#Create Angular
docker run -it --rm --name dawllapop-angular -v ${pathProjectAngular}:/otp/dawllapop -w /otp/dawllapop teracy/angular-cli ng build --base-href /new/

#Move angular files to dawllapop
rm ${pathProject}\src\main\resources\static\new\*
cp ${pathProjectAngular}\dist\* ${pathProject}\src\main\resources\static\new

#Create jar dawllapop
docker run -it --rm --name dawllapop -v ${pathProject}:/usr/src/mymaven -w /usr/src/mymaven maven mvn package

#Move jar to actual directory
mv ${pathJar}/dawllapop.jar .

#Create image
docker build -t dawllapop .