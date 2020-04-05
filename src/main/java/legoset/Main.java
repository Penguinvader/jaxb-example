package legoset;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Year;
import java.util.*;

import jaxb.JAXBHelper;

import javax.xml.bind.JAXBException;

public class Main {
    public static void main(String[] args) throws MalformedURLException, JAXBException, FileNotFoundException {
        LegoSet legoszett = new LegoSet();
        legoszett.setNumber("75211");
        legoszett.setName("Imperial TIE Fighter");
        legoszett.setTheme("Star Wars");
        legoszett.setSubtheme("Solo");
        legoszett.setYear(Year.of(2018));
        legoszett.setPieces(519);

        Set<String> tags = new LinkedHashSet<String>();
        tags.add("Starfighter");
        tags.add("Stormtrooper");
        tags.add("Star Wars");
        tags.add("Solo");

        legoszett.setTags(tags);

        List<Minifig> minifigs = new ArrayList<Minifig>();
        minifigs.add(new Minifig("Imperial Mudtrooper", 2));
        minifigs.add(new Minifig("Imperial Pilot", 1));
        minifigs.add(new Minifig("Mimban Stormtrooper", 1));

        legoszett.setMinifigs(minifigs);
        legoszett.setWeight(new Weight(0.89, "kg"));
        legoszett.setUrl(new URL("https://brickset.com/sets/75211-1/Imperial-TIE-Fighter"));

        JAXBHelper.toXML(legoszett, System.out);

        JAXBHelper.toXML(legoszett, new FileOutputStream("legoset.xml"));
        System.out.println(JAXBHelper.fromXML(LegoSet.class, new FileInputStream("legoset.xml")));

    }
}