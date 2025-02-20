package ch.hslu.ad.sw01;

import java.util.Objects;

public class Wagen {

    private final String kennzeichnung;
    private final int plaetze;
    private Wagen nachfolger = null;

    public Wagen(String kennzeichnung, int plaezte) {
        this.kennzeichnung = kennzeichnung;
        this.plaetze = plaezte;
    }

    public void setNachfolger(final Wagen nachfolger) {
        this.nachfolger = nachfolger;
    }

    public Wagen getNachfolger() {
        return nachfolger;
    }

    public String getKennzeichnung() {
        return kennzeichnung;
    }

    public int getPlaetze() {
        return plaetze;
    }

    @Override
    public String toString() {
        return kennzeichnung + ": " + plaetze + "\n";
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Wagen wagen)) return false;
        return this.kennzeichnung.equals(wagen.getKennzeichnung());
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(this.kennzeichnung);
    }
}
