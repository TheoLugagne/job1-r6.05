package statement;

import objects.Client;
import objects.Location;

import java.util.List;

public abstract class Statement {

    public abstract String situation(Client client);
    public abstract String getSituationLocation(List<Location> locations);
}
