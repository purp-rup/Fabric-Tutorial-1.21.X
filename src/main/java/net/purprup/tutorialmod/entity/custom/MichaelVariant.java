package net.purprup.tutorialmod.entity.custom;

import java.util.Arrays;
import java.util.Comparator;

public enum MichaelVariant {
    DEFAULT(0),
    ORCHID(1);

    private static final MichaelVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(MichaelVariant::getId)).toArray(MichaelVariant[]::new);
    private final int id;

    MichaelVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static MichaelVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}