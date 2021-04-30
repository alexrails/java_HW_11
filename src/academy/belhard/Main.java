package academy.belhard;

import academy.belhard.util.AddressConnector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static academy.belhard.util.AddressConnector.readAll;

public class Main {

    public static void main(String[] args) {
        //Creating addresses
	    Address addr1 = new Address("Minsk", "Lenina", 13, 2, 78);
	    Address addr2 = new Address("Moscow", "Nezalegnasti", 13, 6, 78);
	    Address addr3 = new Address("Kiev", "Petrova", 13, 2, 78);
	    Address addr4 = new Address("Riga", "Kirova", 25, 56, 33);
	    Address addr5 = new Address("Vilnius", "Noname", 69, 2, 78);

        List<Address> addrList = new ArrayList<>(Arrays.asList(addr1, addr2, addr3, addr4, addr5));
        AddressConnector writeToDb = new AddressConnector(addrList);

        //Push addresses to database
        writeToDb.addList();

        //Read data from database
        for(Address address : AddressConnector.readAll()){
            System.out.println(address.toString());
        }

        System.out.println("////////////---UPDATE");

        //Changing addresses
        Address changeAddr1 = AddressConnector.byId(1);
        Address changeAddr2 = AddressConnector.byId(3);
        changeAddr1.setCity("New york");
        changeAddr2.setStreet("Pushkina");
        AddressConnector.update(changeAddr1);
        AddressConnector.update(changeAddr2);

        //Read data from database
        for(Address address : AddressConnector.readAll()){
            System.out.println(address.toString());
        }

        System.out.println("////////////---DELETE");

        //DELETE addresses from db
        AddressConnector.delete(1);
        AddressConnector.delete(5);

        //Read data from database
        for(Address address : AddressConnector.readAll()){
            System.out.println(address.toString());
        }
    }
}
