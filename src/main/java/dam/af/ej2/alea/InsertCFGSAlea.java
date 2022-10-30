package dam.af.ej2.alea;

import dam.af.ej2.alea.model.CFGS;
import jkutkut.ByteUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class InsertCFGSAlea {
    private static final String FILENAME = "res/alea/cfgs.bin";

    public static void main(String[] args) {
        CFGS[] data = loadData();

        System.out.println("Saving CFGS in " + FILENAME);

        RandomAccessFile f;
        try {
            f = new RandomAccessFile(FILENAME, "rw");
//            f.seek(0); // reset
            f.seek(f.length()); // append
            for (CFGS cfgs : data) {
                writeCFGS(f, cfgs);
            }
            f.close();
        }
        catch (FileNotFoundException e) {
            System.err.println("Not able to open " + FILENAME);
            return;
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return;
        }
        System.out.println();
        System.out.println("Reading file:");
        try {
            f = new RandomAccessFile(FILENAME, "r");
            f.seek(0);
            CFGS cfgs;
            while (f.getFilePointer() < f.length()) {
                cfgs = readCFGS(f);
                System.out.println(cfgs);
            }
            f.close();
        } catch (FileNotFoundException e) {
            System.err.println("Not able to open " + FILENAME);
            return;
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return;
        }
    }

    private static CFGS readCFGS(RandomAccessFile f) throws IOException {
        System.out.printf("CFSF %d\n  ", f.readInt());
        return new CFGS(
            readString(f, CFGS.NAME_SIZE),
            readString(f, CFGS.SORT_NAME_SIZE),
            readString(f, CFGS.FAMILY_SIZE),
            readString(f, CFGS.LAW_SIZE),
            f.readInt()
        );
    }

    // ********* READ *********

    private static String readString(RandomAccessFile f, int size) throws IOException {
        int byteSize = size * ByteUtils.sizeof('a');
        byte[] s = new byte[byteSize];
        f.readFully(s, 0, byteSize);
        return ByteUtils.toString(s).trim();
    }

    // ********* WRITE *********

    private static int id = 0;
    private static void writeCFGS(RandomAccessFile f, CFGS cfgs) throws IOException {
        System.out.print(".");
        f.writeInt(id);
        writeString(f, cfgs.getName(), CFGS.NAME_SIZE);
        writeString(f, cfgs.getSortName(), CFGS.SORT_NAME_SIZE);
        writeString(f, cfgs.getFamily(), CFGS.FAMILY_SIZE);
        writeString(f, cfgs.getLaw(), CFGS.LAW_SIZE);
        f.writeInt(cfgs.getLength());
        id++;
    }

    private static void writeString(RandomAccessFile f, String s, int size) throws IOException {
        StringBuffer sb = new StringBuffer(s);
        sb.setLength(size);
        f.writeChars(sb.toString());
    }

    // ********* DATA *********

    private static CFGS[] loadData() {
        return new CFGS[]{
                new CFGS("name1", "sort1", "fam1", "law1", 1),
                new CFGS("name2", "sort2", "fam2", "law2", 2),
                new CFGS("name3", "sort3", "fam3", "law3", 3),
                new CFGS("name4", "sort4", "fam4", "law4", 4),
                new CFGS("name5", "sort5", "fam5", "law5", 5),
                new CFGS("name6", "sort6", "fam6", "law6", 6),
                new CFGS("name7", "sort7", "fam7", "law7", 7),
                new CFGS("name8", "sort8", "fam8", "law8", 8),
                new CFGS("name9", "sort9", "fam9", "law9", 9)
        };
    }
}
