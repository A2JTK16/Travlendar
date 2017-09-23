/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.model;

/**
 *
 * @author Auliya Aqma Dinillah
 */
public class DistanceMatrix {
    //deklarasi atribut
    private String [] kota = {"Bandung", "Bekasi", "Bogor",	"Ciamis", "Cianjur","Cirebon","Garut","Indramayu","Karawang","Kuningan","Majalengka", "Pangandaran","Purwakarta","Subang","Sukabumi","Sumedang","Tasikmalaya"};
    
    /**
     * REVIEW 
     * 
     * 1.   Kota_awal dan kota_tujuan Bentuk Integer Saja, Tidak Memerlukan String.
     *      Selanjutnya, Kode Kota Tersebut Diubah Menjadi Alamat Indeks Array,
     *      Lalu Kembalikan Isi Array Tersebut.
     * 2.   Kota Bisa Pakai 'enum' untuk Memudahkan
     * 3.   Diperlukan Method untuk Mengembalikan Nilai Jarak
     * 4.   Lebih Baik Teknik Mendapatkan Jarak Pakai Indeks Array Saja Langsung,
     *      Tidak Memerlukan Nested Loop Karena Kode Kota Tidak Berubah dan
     *      Memiliki Keterkaitan dengan Indeks Array 
     *      Contoh : Array jarak[1][2] Berisi Jarak Bandung - Bekasi
     */
    
    private String kota_awal; //deklarasi variabel kota_awal yang bertipe String
    private String kota_tujuan; //deklarasi variabel kota_tujuan yang bertipe String
    
    private int [] kode_kota = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17}; //deklarasi variabel kode_kota yang bertipe integer
    final double [][] jarak = {{0,	134,	177,	135,	160,	209,	149,	201,	89.4,	244,	192,	202,	53.3,	118,	90.1,	71.1,	126},
                               {132,	0,	62.2,	248,	208,	200,	199,	192,	54.2,	236,	183,	316,	78.4,	110,	173,	184,	240},
                               {212,    81.8,   0,      305,	175,    247,    319,	249,	110,	292,	239,	372,	135,	166,	140,	241,	296},
                               {125,	237,	306,	0,	233,	116,	155,	152,	214,	85.6,	95.5,	68.5,	178,	184,	310,	103,	19.6},
                               {101,	196,	176,	230,	0,	295,	123,	297,	186,	341,	288,	238,	170,	215,	119,	151,	217},
                               {229,	178,	257,	105,	345,	0,	221,	55.4,	165,	43.9,	51.5,	181,	162,	129,	276,	93.2,	111},
                               {157,	250,	318,	109,	125,	213,	0,	223,	226,	170,	182,	163,	190,	225,	213,	141,	90.1},
                               {207,	192,	247,	152,	336,	55.7,	222,	0,	155,	103,	64,	232,	153,	79.5,	358,	93.4,	149},
                               {93.2,	29.9,	106,	208,	221,	150,	222,	152,	0,	195,	142,	274,	37.8,	61.7,	217,	144,	199},
                               {252,	223,	291,	82.5,	379,	52.1,	188,	104,	19,	0,	60.8,	142,	196,	163,	402,	127,	87.9},
                               {199,	171,	238,	92.4,	327,	41.4,	181,	63.1,	146,	60.4,	0,	152,	143,	110,	349,	53.2,	91.5},
                               {193,	296,	364,	68.6,	241,	167,	163,	205,	272,	136,	146,	0,	245,	236,	329,	171,	85.6},
                               {59,	64.9,	132,	137,	187,	150,	187,	152,	40.5,	195,	143,	241,	0,	69.3,	243,	144,	165},
                               {127,	94.8,	166,	184,	255,	119,	255,	78.7,	74,	164,	111,	244,	71.4,	0,	277,	113,	184},
                               {167,	193,	139,	282,	119,	358,	214,	360,	222,	403,	350,	329,	170,	277,	0,	218,	273},
                               {71.4,	172,	239,	104,	162,	92.1,	133,	92.6,	147,	128,	53.2,	171,	108,	112,	241,	0,	95.2},
                               {119,	231,	299,	19.6,	218,	119,	140,	151,	207,	88.8,	92.4,	84.7,	171,	183,	208,	96.8,	0},
                             };
    
    public String[] getKota() {
        return kota;
    }

    //method ini belum diimplementasikan pada program
    /*public void setKota(String[] kota) { 
        this.kota = kota;
    }

    public int[] getKode_kota() { //
        return kode_kota;
    }
    
    public void setKode_kota(int[] kode_kota) {
        this.kode_kota = kode_kota;
    }

    public String getKota_awal() {
        return kota_awal;
    }

    public void setKota_awal(String kota_awal) {
        this.kota_awal = kota_awal;
    }*/
   
    //method untuk mengecek kota
   public void cek_kota (String kota_awal, String kota_tujuan)
    {
        for (int n=0; n<17; n++) //perulangan untuk kota awal
        {
            for (int m=0;m<17;m++) //perulangan untuk kota tujuan
            {
                if (kota_awal.equals(getKota()[n]) && kota_tujuan.equals(getKota()[m]) ) //pengecekan kota untuk mendapatkan kode kota agar bisa mengetahui jarak
                {
                     System.out.println(kota_awal + " - " + kota_tujuan + " = " + jarak[n][m]); //menampilkan jarak antara kota awal dan kota tujuan
                } 
            }
        }
    } 
}