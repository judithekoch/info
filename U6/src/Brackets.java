import static java.lang.System.out;
import static java.util.Arrays.asList;
import java.util.*;

/**
   Die Objekte dieser Klasse bearbeiten jeweils einen Klammerausdruck 
   bzw. String, der auf korrekte Klammerung zu prüfen ist.
 */
class Brackets
{
	/**
	   Liste der Symbole (Zeichen)
	 */
	private char[] symbole;
	/**
	   Index in Symbolliste während der Verarbeitung
	 */
	private int symbi;

	/**
	   @param s Zeichenfolge, die auf Klammerung zu prüfen ist
	 */
	public
	Brackets(String s)
	{
		symbole = s.toCharArray();
		symbi = -1;
		weiter();
	}


	/**
	   Endemarkierung für Analyse
	 */
	private final char ENDE = '\000';
	/**
	   Aktuelle zu untersuchendes Zeichen im Laufe der Analyse
	 */
	private char aktuelles = ENDE;

	/**
	   Weglesen eines Symbols, das nächste bereitstellen
	 */
	private void weiter()
	{
		symbi ++;
		if (symbi < symbole.length)
			aktuelles = symbole[symbi];
		else
			aktuelles = ENDE;
	}


	/**
	   Prüfe, ob eine Klammer vorliegt
	   @param c zu prüfendes Zeichen
	 */
	private
	boolean istKlammer(char c)
	{
		return "()[]{}".indexOf(c) >= 0;
	}

	/**
	   Prüfe, ob eine öffnende Klammer vorliegt
	   @param c zu prüfendes Zeichen
	 */
	private
	boolean istÖffnendeKlammer(char c)
	{
		return "([{".indexOf(c) >= 0;
	}

	/**
	   Lese klammerlosen Text (zwischen den Klammern)
	 */
	private
	void überspringeText()
	{
		while (aktuelles != ENDE && ! istKlammer(aktuelles)) {
			weiter();
		}
	}


	/**
	   Analyse: Liegt das gewünschte Zeichen vor?
	   @param c im Laufe der Analyse erwartetes (korrektes) Zeichen
	   @return c == aktuelles Zeichen (welches dann weggelesen wird)
	 */
	private
	boolean prüfeZeichen(char c)
	{
		if (aktuelles == c) {
			weiter();
			return true;
		} else {
			return false;
		}
	}

	/**
	   Prüfe, ob ein hier beginnender Klammerausdruck 
	   korrekt abgeschlossen wird.
	   Zwischendurch werden geschachtelte Klammerausdrücke 
	   rekursiv analysiert, Nichtklammer-Ausdrücke weggelesen.
	 */
	private
	boolean prüfeKlammerausdruck()
	{
		if (aktuelles == '(') {
			weiter();
			if (prüfeKlammerfolge())
				return prüfeZeichen(')');
			else
				return false;
		} else if (aktuelles == '[') {
			weiter();
			if (prüfeKlammerfolge())
				return prüfeZeichen(']');
			else
				return false;
		} else if (aktuelles == '{') {
			weiter();
			if (prüfeKlammerfolge())
				return prüfeZeichen('}');
			else
				return false;
		} else {
			return false;
		}
	}

	/**
	   Prüfe, ob eine Folge von Klammerausdrücken (und 
	   Zwischentexten) vorliegt.
	 */
	private
	boolean prüfeKlammerfolge()
	{
		überspringeText();
		while (istÖffnendeKlammer(aktuelles)) {
			if (prüfeKlammerausdruck())
				überspringeText();
			else
				return false;
		}
		return true;
	}

	/**
	   Prüfe, ob der zu analysierende Text dieses Objekts 
	   korrekt geklammert ist.
	 */
	public
	boolean prüfeKlammerung()
	{
		if (prüfeKlammerfolge())
			return aktuelles == ENDE;
		else
			return false;
	}
}


/**
   Hauptprogramm: Prüfe, ob alle Parameter des Programms korrekt 
   geklammert sind. Falls keine da sind, werden einige Testtexte geprüft.
 */
class Klammerungen
{
	private static
	void test()
	{
		main (new String[] {
			"(())",
			"a(b[c]d) x(y)z",
			"(ab()cd((ef)gh(ij)))k",
			"",
			")",
			"(ab) )cd("
		});
	}

	public static
	void main(String[] params)
	{
		if (params.length == 0)
			test();
		else
			for (String s: params) {
				out.println ("" + new Brackets(s).prüfeKlammerung() + ": " + s);
			}
	}
}