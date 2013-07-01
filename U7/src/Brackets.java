import static java.lang.System.out;
import static java.util.Arrays.asList;
import java.util.*;

/**
   Die Objekte dieser Klasse bearbeiten jeweils einen Klammerausdruck 
   bzw. String, der auf korrekte Klammerung zu pr��fen ist.
 */
class Brackets
{
	/**
	   Liste der Symbole (Zeichen)
	 */
	private char[] symbole;
	/**
	   Index in Symbolliste w��hrend der Verarbeitung
	 */
	private int symbi;

	/**
	   @param s Zeichenfolge, die auf Klammerung zu pr��fen ist
	 */
	public
	Brackets(String s)
	{
		symbole = s.toCharArray();
		symbi = -1;
		weiter();
	}


	/**
	   Endemarkierung f��r Analyse
	 */
	private final char ENDE = '\000';
	/**
	   Aktuelle zu untersuchendes Zeichen im Laufe der Analyse
	 */
	private char aktuelles = ENDE;

	/**
	   Weglesen eines Symbols, das n��chste bereitstellen
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
	   Pr��fe, ob eine Klammer vorliegt
	   @param c zu pr��fendes Zeichen
	 */
	private
	boolean istKlammer(char c)
	{
		return "()[]{}".indexOf(c) >= 0;
	}

	/**
	   Pr��fe, ob eine ��ffnende Klammer vorliegt
	   @param c zu pr��fendes Zeichen
	 */
	private
	boolean istOeffnendeKlammer(char c)
	{
		return "([{".indexOf(c) >= 0;
	}

	/**
	   Lese klammerlosen Text (zwischen den Klammern)
	 */
	private
	void ueberspringeText()
	{
		while (aktuelles != ENDE && ! istKlammer(aktuelles)) {
			weiter();
		}
	}


	/**
	   Analyse: Liegt das gew��nschte Zeichen vor?
	   @param c im Laufe der Analyse erwartetes (korrektes) Zeichen
	   @return c == aktuelles Zeichen (welches dann weggelesen wird)
	 */
	private
	boolean pruefeZeichen(char c)
	{
		if (aktuelles == c) {
			weiter();
			return true;
		} else {
			return false;
		}
	}

	/**
	   Pr��fe, ob ein hier beginnender Klammerausdruck 
	   korrekt abgeschlossen wird.
	   Zwischendurch werden geschachtelte Klammerausdr��cke 
	   rekursiv analysiert, Nichtklammer-Ausdr��cke weggelesen.
	 */
	private
	boolean pruefeKlammerausdruck()
	{
		if (aktuelles == '(') {
			weiter();
			if (pruefeKlammerfolge())
				return pruefeZeichen(')');
			else
				return false;
		} else if (aktuelles == '[') {
			weiter();
			if (pruefeKlammerfolge())
				return pruefeZeichen(']');
			else
				return false;
		} else if (aktuelles == '{') {
			weiter();
			if (pruefeKlammerfolge())
				return pruefeZeichen('}');
			else
				return false;
		} else {
			return false;
		}
	}

	/**
	   Pr��fe, ob eine Folge von Klammerausdr��cken (und 
	   Zwischentexten) vorliegt.
	 */
	private
	boolean pruefeKlammerfolge()
	{
		ueberspringeText();
		while (istOeffnendeKlammer(aktuelles)) {
			if (pruefeKlammerausdruck())
				ueberspringeText();
			else
				return false;
		}
		return true;
	}

	/**
	   Pr��fe, ob der zu analysierende Text dieses Objekts 
	   korrekt geklammert ist.
	 */
	public
	boolean pruefeKlammerung()
	{
		if (pruefeKlammerfolge())
			return aktuelles == ENDE;
		else
			return false;
	}
}


/**
   Hauptprogramm: Pr��fe, ob alle Parameter des Programms korrekt 
   geklammert sind. Falls keine da sind, werden einige Testtexte gepr��ft.
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
				out.println ("" + new Brackets(s).pruefeKlammerung() + ": " + s);
			}
	}
}