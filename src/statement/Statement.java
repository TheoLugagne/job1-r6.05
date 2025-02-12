package statement;

import objects.Client;
import objects.Location;

import java.util.List;

public abstract class Statement {

    public String situation(Client client) {
        String ch = getHeader(client);
        for (Location each : client.getLocations()) {
            ch += getSituationLocation(each);
        }
        ch += getFooter(client);
        return ch;
    }
    public abstract String getSituationLocation(Location locations);
    public abstract String getHeader(Client client);
    public abstract String getFooter(Client client);
}
