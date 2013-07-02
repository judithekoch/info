import java.net.*;
import java.io.*;
import java.util.*;
import javax.script.*;
import listStackChainNode.*;

public class HTTPServer
{
	
    public static
    void main (String argv[])
    throws IOException
    {
        if (argv.length > 0) {
            ServerSocket ss = new ServerSocket (80);	//Integer.parseInt (argv [0])
            System.out.println("running on port: " + ss.getLocalPort());
            while (true) {
                // bearbeite die Verbindung asynchron
                new HTTPConnection (ss.accept ());
            }
        } else {
            System.out.println ("Which port?");
        }
    }
}


class HTTPConnection
extends Thread
{
    Socket sock;

    HTTPConnection (Socket s)
    {
    	
        sock = s;
        setPriority (NORM_PRIORITY - 1);
        // starte run() als neuen Thread
        start ();
    }

    public
    void run ()
    {
        try {
            // hole die Input- und Output-Streams der Verbindung
            InputStream httpin = sock.getInputStream ();
            OutputStream httpout = sock.getOutputStream ();
            // ein Text-Leser für den Request zum bequemeren Lesen
            BufferedReader httpreader = 
                new BufferedReader (new InputStreamReader (httpin));
            // ein Text-Schreiber für die Antwort zum Schreiben der Header
            PrintWriter httpwriter = new PrintWriter (httpout);

            try {
                // lies die erste Zeile des Requests
                // Format: "GET /xy.html HTTP/1.0"
                String request = httpreader.readLine ();
                System.out.println ("HTTP: " + request);
                // zerlege Request-Zeile in Worte
                StringTokenizer tokens = new StringTokenizer (request);
                String method = tokens.nextToken ();

                if (method.equals ("GET") || method.equals ("POST")) {
                    String URI = tokens.nextToken ();
                    String URIparams = "";
                    String HTTP_version = tokens.nextToken ();

                    // ein paar Aktionen auf der URI:
                    //	- Abtrennen von Parametern (hinter "?")
                    //	- Anhänger von "index.html", wenn sie auf "/" endet
                    //	- Entfernen führendes "/", um relativen Pfad zu bilden
                    //	- Unterbinden von ".." (Sicherheitsmaßnahme)
                    // Achtung: ggf. noch zu behandeln:
                    // URI (einschließlich Parameter!) kommen i.A. in 
                    // Escape-Notation an, z.B. 
                    // wird ein Leerzeichen als "%20" geschickt...
                    int toquest = URI.indexOf ('?');
                    if (toquest >= 0) {
                        URIparams = URI.substring (toquest + 1);
                        URI = URI.substring (0, toquest);
                    }
                    if (URI.endsWith ("/"))
                        URI = URI + "index.html";
                    if(URI.contains("/time")){
                    	Date date = new Date();
                    	String outputString = "Current time is: " + date.toString();
                    	writeToPage(outputString, httpout);
                    }
                    if(URI.contains("result")){
                    	String outputString = "<form method=get action=/result><input type=text name=ausdruck><input type=submit value=Berechnen></form>";
//                    	MyParser parser = new MyParser(new MyScanner(""));
//                    	TreeNode parentNode = parser.parse();
                    	String term = URIparams.substring(9);
                    	term = term.replace("%2B", "+");
                    	
                    	MyParser parser = new MyParser(new MyScanner(term));
                    	parser.parse();
                    	String termString = parser.postOrder(parser.getParentNode()); 
                    	
                    	Calculator calculator = new Calculator(termString);
                    	
                    	String result = "" + calculator.getResult();	//"unbekannt";
                		String resultString = "<p> Das Ergebnis von: " + term + "</p><p>Ist gleich: " + result + "</p>";
                		writeToPage(outputString, resultString, httpout);
                    } 
                    if(URI.contains("/calculator")){
                    	String outputString = "<form method=get action=/result><input type=text name=ausdruck><input type=submit value=Berechnen></form>";
                    	writeToPage(outputString, httpout);
                    }
                    if (URI.startsWith ("/"))
                        URI = URI.substring (1);
                    if (URI.contains (".."))
                        URI = "";	// einfache Maßnahme: Request ganz sabotieren
                    System.out.println ("URI: " + URI);
                    System.out.println ("URI-Parameter: " + URIparams);

                    boolean has_content = false;
                    boolean has_length = false;
                    boolean has_body = false;
                    int expected_length = 0;

                    // lies die Headerzeilen und analysiere sie
                    // Format: "Content-Length: 456"
                    int tocolon;
                    do {
                        request = httpreader.readLine ();
                        tocolon = request.indexOf (':');
                        if (tocolon > 0) {
                            String headername = request.substring (0, tocolon);
                            String headerparams = request.substring (tocolon + 1);
                            System.out.println ("HTTP-Header: " + headername + ":" + headerparams);
                            // für erweiterte Bearbeitungsmöglichkeiten wäre 
                            // Eintrag der Headerzeile in eine Map nützlich:
                            //headers.put (headername, headerparams);

                            if (headername.equalsIgnoreCase ("Content-Type")) {
                                has_content = true;
                            } else if (headername.equalsIgnoreCase ("Content-Length")) {
                                has_length = true;
                                expected_length = Integer.parseInt (headerparams.trim ());
                            } else if (headername.equalsIgnoreCase ("Transfer-Encoding")) {
                                has_body = true;
                            //} else ... {
                            //    ...
                            }
                        }
                    } while (tocolon > 0);

                    if (has_content || has_body) {
                        // lies Body (kann z.B. bei POST Parameter enthalten)
                    }

                    // bearbeite den Request

                    // unterscheide nach einem Server-spezifischen Kriterium
                    // verschiedene Ressourcentypen, hier:
                    //	- Dateien (HTML-Seiten), wenn URI "." enthält
                    //	- dynamische Server-Funktionen
                    if (URI.contains (".")) {
                        try {
                            // lies die Datei
                            FileInputStream fis = new FileInputStream (URI);
                            System.out.println ("DATEI " + URI + " wird abgeliefert");
                            // lies einfach alles auf einmal
                            byte [] data = new byte [fis.available ()];
                            fis.read (data);
                            // liefere Response zurück
                            httpwriter.println ("HTTP/1.0 200 OK");
                            httpwriter.println ("");
                            httpwriter.flush ();
                            // schreibe Dateiinhalt in Response-Body
                            // (binär, daher nicht über den Writer, 
                            // sondern den darunterliegenden OutputStream)
                            httpout.write (data); //
                            httpout.close ();
                        } catch (FileNotFoundException e) {
                            httpwriter.println ("HTTP/1.0 404 Not Found");
                            System.out.println ("DATEI " + URI + " nicht gefunden");
                        } catch (IOException e) {
                            httpwriter.println ("HTTP/1.0 500 Internal Server Error");
                            System.out.println ("DATEI " + URI + " Lesefehler");
                        }
                    } else {
                        if (URI.equals ("parse")) {
                            // parse den Ausdruck URIparams
                            // gib Ergebnis zurück (oder Fehlermeldung)
                            // (eingepackt in elementare Webseite)
                            httpwriter.println ("HTTP/1.0 200 OK");
                            httpwriter.println ("");
                            httpwriter.flush ();
                        //} else ... {
                        //    ...
                        }
                    }

                } else {
                    httpwriter.println ("HTTP/1.0 405 Method Not Allowed");
                    System.out.println ("HTTP Method abgelehnt: " + method);
                }

                sock.close ();
            } catch (NoSuchElementException e) {
                // keine Tokens im Request
                httpwriter.println ("HTTP/1.0 400 Bad Request");
                System.out.println ("Bad Request");
            } catch (IOException e) {
                httpwriter.println ("HTTP/1.0 500 Internal Server Error");
                System.out.println ("I/O error " + e);
            }
        } catch (IOException e) {
            // falls hier schon eine Exception auftrat, besteht keine 
            // Möglichkeit, eine Antwort zu übergeben
            System.out.println ("I/O error am Anfang " + e);
        }
    }
    
    private void writeToPage(String outputOne, String outputTwo, OutputStream out){
    	String websiteStart = "<!doctype html><html><head></head><body>";
    	String websiteEnd = "</body></html>";
    	String outputString = websiteStart + outputOne + outputTwo + websiteEnd;
    	byte[] output = outputString.getBytes();
    	try{
    	out.write(output);
    	out.close();
    	} catch (IOException e){
    		//...
    	}
    }
    
    private void writeToPage(String outputOne, OutputStream out){
    	String websiteStart = "<!doctype html><html><head></head><body>";
    	String websiteEnd = "</body></html>";
    	String outputString = websiteStart + outputOne + websiteEnd;
    	byte[] output = outputString.getBytes();
    	try{
    	out.write(output);
    	out.close();
    	} catch (IOException e){
    		System.out.println(e);
    	}
    }
    
}