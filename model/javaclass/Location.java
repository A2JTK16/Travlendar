/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travlendara2;

/**
 *
 * @author ASUS
 */
public class Location {
    //atribute
    private int kode_lokasi;
    private String nama_lokasi;

    /**
     * @return the kode_lokasi
     */
    public int getKode_lokasi() {
        return kode_lokasi;
    }

    /**
     * @param kode_lokasi the kode_lokasi to set
     */
    public void setKode_lokasi(int kode_lokasi) {
        this.kode_lokasi = kode_lokasi;
    }

    /**
     * @return the nama_lokasi
     */
    public String getNama_lokasi() {
        return nama_lokasi;
    }

    /**
     * @param nama_lokasi the nama_lokasi to set
     */
    public void setNama_lokasi(String nama_lokasi) {
        this.nama_lokasi = nama_lokasi;
    }
    public static void main(String[] args) {
        Location lok_1 = new Location();
        lok_1.setKode_lokasi(10001);
        lok_1.setNama_lokasi("Rumah");
        
        Location lok_2 = new Location();
        lok_2.setKode_lokasi(10002);
        lok_2.setNama_lokasi("Kantor DPRD Bangka Tengah");
        
        Location lok_3 = new Location();
        lok_3.setKode_lokasi(10003);
        lok_3.setNama_lokasi("Bandara Depati Amir");
        
        Location lok_4 = new Location();
        lok_4.setKode_lokasi(20001);
        lok_4.setNama_lokasi("Bandara Soekarno Hatta");
        
        Location lok_5 = new Location();
        lok_5.setKode_lokasi(20002);
        lok_5.setNama_lokasi("Kantor DPRD Jakarta");
        
        Location lok_6 = new Location();
        lok_6.setKode_lokasi(30001);
        lok_6.setNama_lokasi("Tangerang");
        
        Location lok_7 = new Location();
        lok_7.setKode_lokasi(20001);
        lok_7.setNama_lokasi("Bandara Soekarno Hatta");
        
        Location lok_8 = new Location();
        lok_8.setKode_lokasi(10002);
        lok_8.setNama_lokasi("Kantor DPRD Bangka Tengah");
        
        Location lok_9 = new Location();
        lok_9.setKode_lokasi(10001);
        lok_9.setNama_lokasi("Rumah");
        
        System.out.print(lok_1.getNama_lokasi() + " -> ");
        System.out.print(lok_2.getNama_lokasi() + " -> ");
        System.out.print(lok_3.getNama_lokasi() + " -> ");
        System.out.print(lok_4.getNama_lokasi() + " -> ");
        System.out.print(lok_5.getNama_lokasi() + " -> ");
        System.out.print(lok_6.getNama_lokasi() + " -> ");
        System.out.print(lok_7.getNama_lokasi() + " -> ");
        System.out.print(lok_8.getNama_lokasi() + " -> ");
        System.out.print(lok_9.getNama_lokasi());
    }
}
