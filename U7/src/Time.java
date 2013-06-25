/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
// */

import java.net.*;
import java.io.*;
/**
 *
 * @author Bianca
 */
public class Time
{
	public static void main(String args[]){
		System.out.println("Zeit: " + Time.getTime());
	}
	public static String test = " ";

	public static String getTime(){
		String output = " ";
		//	 String serverName = "ptbtime1.ptb.de";	//funktionierte gestern wohl nicht
		String serverName = "utcnist2.colorado.edu";
		try{
			InetAddress server = InetAddress.getByName(serverName);
			Socket sock = new Socket(server, 13);
			InputStream is = sock.getInputStream();
			Reader rolf = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(rolf); //getInputStream gibt InputStream zurück, benötigt: Reader

			String get = br.readLine();
			sock.close();
			while(get != null){
				output += get;
			}

		}catch(IOException e){
			output += e.getMessage();
		}
		return output;
	}
}
