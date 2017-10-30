package com.company;

import java.io.*;
import java.util.HashMap;

public class HashmapApp {

    public static void main(String[] args) {
	// write your code here

        HashMap<String ,String> map= new HashMap<> (  );
        map.put ( "cat","meow" );
        map.put ( "ape","Squeak" );
        map.put("dog","woof");
        map.put("bat","Squeak");


        System.out.println ("Map= "+ map );

        System.out.println ("A cat says..."+map.get("cat") );
        System.out.println ("A dog says...."+map.get("dog") );

        System.out.println ( );
        //iterating over values only

        for(String value:map.values ())
        {
            System.out.println ("Value= "+value );
        }

        System.out.println ( );

        for(String key:map.keySet ())
        {
            System.out.println ("Key= "+key );
        }

        System.out.println ( );

        System.out.println ("Iterating over keys and values" );

        for(String key: map.keySet ())
        {
            System.out.println (key +"\t" + map.get ( key ) );
        }

        System.out.println ( );


        //writing keys and values to a file

        System.out.println ("Writing keys and values to a file" );

        String filename=(System.getProperty ( "user.dir" )+ File.separatorChar +"animalNoises.txt");

        System.out.println (filename );

        PrintWriter writer= null;

        try{
            writer= new PrintWriter ( new File(filename) );
        }catch(FileNotFoundException e)
        {
            System.out.println ("File does not exist" );
        }

        //Print both the key and the value on same line
        //for each key in the key set write the key, a tab and the value

        for(String key:map.keySet ())
        {
            System.out.println ("Write this line : " +key );
            writer.println(key +"\t" + map.get(key));
        }

        writer.close();

        //read from a file

        System.out.println ("read from a file " );

        BufferedReader reader=null;
        try{
            reader= new BufferedReader( new FileReader ( filename ) );
            String line = reader.readLine ();

            while(line !=null)
            {
               // System.out.println (line );
                String[] key_value_pair =line.split ( "\t" );
                System.out.println ("KV Pair: "+key_value_pair[0] +" " +key_value_pair[1]);

                line =reader.readLine ();
            }
            reader.close ();

        }catch(IOException e)
        {
            System.out.println ("File does not exist" );
        }finally {

        }


    }
}
