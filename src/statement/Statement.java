package statement;

import objects.Client;
import objects.Location;


public abstract class Statement {

    public String situation(Client client) {
        StringBuilder ch = new StringBuilder(getHeader(client));
        for (Location each : client.getLocations()) {
            ch.append(getSituationLocation(each));
        }
        ch.append(getFooter(client));
        return ch.toString();
    }
    public abstract String getSituationLocation(Location locations);
    public abstract String getHeader(Client client);
    public abstract String getFooter(Client client);
}
