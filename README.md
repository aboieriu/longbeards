# longbeards

The Longbeards, were the most important clan of Dwarves. Their name comes from that of their first king, Durin I "The Deathless". They were the eldest and greatest of the seven Dwarf-clans.

They originally inhabited the Misty Mountains as a home, until they were driven out by Orcs. Their strongholds in the Misty Mountains included Khazad-dûm (Moria), their first city, and Mount Gundabad. During the Second Age, Durin's folk entered into friendship with the Noldor of Celebrimbor in Eregion. During the War of the Last Alliance, Durin's folk allied with the Elves and the Dúnedain.

#Starting up the Misty Mountains headmaster (BE)
For building the whole project you can simply run the following command in the root directory of the project
```
./gradlew build
```

For building all necessary modules and quick starting the web app, navigate to "mm-master" module and run
```
../gradlew build && java -jar build/libs/misty-mountain-master-0.0.1.jar --server.port=9090

```
#Starting up the Misty Mountains dwarfs (UI)
For building the whole project you can simply run the following command in the root directory of the project
```
bower install
```
```
npm install
```

For starting the app, just run and the access the "app" directory
```
npm start
```
