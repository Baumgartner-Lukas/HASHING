package com.baumgartner.Interfaces;

public interface MyHashSet {
    // Liefert die Anzahl der gespeicherten Schlüssel (diese müssen eindeutig sein!).
    public int size();

    // Fügt den Schlüssel key ein und liefert true wenn er
    // einfügt wurde. Sollte der Key bereits vorhanden sein, so wird
    // der Neue nicht eingefügt und false zurückgegeben.
    public boolean insert(Integer key, String data) throws IllegalArgumentException;

    // Liefert true wenn der Schlüssel key in der Menge enthalten
    // ist, ansonsten false.
    public boolean contains(Integer key) throws IllegalArgumentException;

    // Entfernt den Schlüssel key von der Menge und liefert true wenn
    // er entfernt wurde, ansonsten false.
    public boolean remove(Integer key) throws IllegalArgumentException;

    // Liefert eine String-Repräsentation der data Elements mit
    //Angabe der Arrayindizes der Hashtabelle (die enthaltene Struktur muss erkennbar sein).
    public String toString();

    // Entfernt alle Elemente aus der Menge.
    public void clear();
}
