# VideoTube2

Si consideri la classe VideoTube, che modella una piattaforma di streaming video. La classe ha una
hashmap con coppia chiave/valore Canale/LinkedList<Video> e VideoPlayer, che è la classe
usata per la riproduzione dei video. VideoTube permette di aggiungere e rimuovere nuovi canali
all’hasmap e di aggiungere e rimuovere video da un canale. Se il canale o il video da rimuovere non
esiste, viene lanciata un’eccezione. Il metodo playVideo seleziona il video da riprodurre tramite il
player. Infine, la classe VideoTube prevede, tramite il metodo toString, di stampare a video la lista
di video pubblicati da ogni canale.
La classe Video è dotata dei seguenti attributi:
• durata, ossia il numero di minuti da cui è caratterizzato il video;
• visualizzazioni, cioè il numero di visualizzazioni che il video ha ricevuto;
• risoluzione;
• sottotitoli.
La classe LiveVideo estende Video e ha due attributi aggiuntivi: data e ora della diretta.
La classe VideoPlayer permette di attivare o disattivare i sottotitoli per il video da riprodurre (attributo
della classe): se esso ne è sprovvisto, lancia un’eccezione. Ha i metodi play, stop e pausa (che
stampano semplicemente a video l’opzione relativa) e i metodi aumentaVolume e
diminuisciVolume che modificano opportunamente il valore dell’attributo volume.
  
Acquisisci inoltre da file una lista di video e una lista di canali da utilizzare nel main.
