# Longbeards

The Longbeards, were the most important clan of Dwarves. Their name comes from that of their first king, Durin I "The Deathless". They were the eldest and greatest of the seven Dwarf-clans.

They originally inhabited the Misty Mountains as a home, until they were driven out by Orcs. Their strongholds in the Misty Mountains included Khazad-dûm (Moria), their first city, and Mount Gundabad. During the Second Age, Durin's folk entered into friendship with the Noldor of Celebrimbor in Eregion. During the War of the Last Alliance, Durin's folk allied with the Elves and the Dúnedain.

#Misty Mountains project
This project is a sandbox for experimenting with service workers. Although not necessary, it uses a java based REST service (which serves as the background for a future project) and 2 Angular apps

##Starting up the Misty Mountains backend support
The REST service uses a mysql database. For setting up the db, use the script from https://github.com/aboieriu/longbeards/blob/master/mm-master/db/misty_mountains.sql

For building the whole project you can simply run the following command in the root directory of the project
```
./gradlew build
```

For building all necessary modules and quick starting the web app, navigate to "mm-master" module and run
```
../gradlew build && java -jar build/libs/misty-mountain-master-0.0.1.jar --server.port=9090
```
##Starting up the Misty Mountains dwarves (UI)
For building the whole project you can simply run the following command in the root directory (misty-mountains) of the project
```
bower install
```
```
npm install
```

For starting the app, just run and the access the "app" directory
```
node local-server.js
```

For the UI, there are 2 angular applications
- /app (mm-dwarves) used for testing caching capabilities of service workers
- /headmaster (Headmaster) used for testing push notifications

##Architecture
![alt tag](http://content.screencast.com/users/alex-boieriu/folders/Jing/media/aa09d3b6-04dc-4b96-87b7-6dea3493e032/00000377.png)
