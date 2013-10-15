/**************************************************
* Installation
**************************************************/

1. Dateien des DownloadCenter.zip in einen �ffentichen Ordner auf dem Fileserver entpacken
2. config.php Datei anhand der Kommentare anpassen
3. (optional) Template unter /template/status.html anpassen
4. Pr�fen ob die Ordner /secure und /session �ber htaccess gesch�tzt sind. Bei aufruf sollte ein HTTP 500 Fehler auftreten
5. Download der Testdaten �ber http://www.vogella.de/download.php?file=test2.txt starten und den Status �ber http://meinedomain.de/status.php �berpr�fen 


/**************************************************
* Datei hinzuf�gen
**************************************************/
1. Dateien die zum Download angeboten werden sollen, in den Ordner secure legen
2. Dateien mit zugeh�rigem Alias in der config.php eintragen

/**************************************************
* Download Z�hler zur�cksetzen
**************************************************/
1. Parameter RESET_PASSWORD in der config.php angeben
2. Folgende URL mit den angepassten Parametern aufrufen http://meinedomain.de/status.php?action=reset&password=bla


Copyright 2009 Hendrik Still