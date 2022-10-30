package dam.af.ej2.alea.model;

import jkutkut.ByteUtils;

import java.io.Serializable;

public class CFGS implements Serializable {
    public static final int NAME_SIZE = 100;
    public static final int SORT_NAME_SIZE = 6;
    public static final int FAMILY_SIZE = 50;
    public static final int LAW_SIZE = 5;

    private final String name;
    private final String sortName;
    private final String family;
    private final String law;
    private final int length;

    public CFGS(String name, String sortName, String family, String law, int length) {
        this.name = name;
        this.sortName = sortName;
        this.family = family;
        this.law = law;
        this.length = length;
    }

    // *********** GETTERS ***********

    public String getName() {
        return name;
    }

    public String getSortName() {
        return sortName;
    }

    public String getFamily() {
        return family;
    }

    public String getLaw() {
        return law;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "CFGS{" +
                "name='" + name + '\'' +
                ", sortName='" + sortName + '\'' +
                ", family='" + family + '\'' +
                ", law='" + law + '\'' +
                ", length=" + length +
                '}';
    }

    public int sizeof() {
        return ByteUtils.sizeofString(NAME_SIZE) +
                ByteUtils.sizeofString(SORT_NAME_SIZE) +
                ByteUtils.sizeofString(FAMILY_SIZE) +
                ByteUtils.sizeofString(LAW_SIZE) +
                ByteUtils.sizeof(length); // +
//                ByteUtils.sizeofString(1); // ID
    }
}
